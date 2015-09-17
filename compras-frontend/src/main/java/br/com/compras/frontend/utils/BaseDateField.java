package br.com.compras.frontend.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.vaadin.data.Property;
import com.vaadin.data.util.converter.Converter.ConversionException;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.DateField;

public class BaseDateField extends DateField {
	boolean time = false;
	
	public BaseDateField() {
		this(true);
	}
	
	public BaseDateField(boolean time) {
		this(null, time);
	}
	
	public BaseDateField(String caption) {
		this(caption, false);
	}
	
	public BaseDateField(String caption, Date value) {
		this(caption, value, false);
	}
	
	public BaseDateField(String caption, boolean time) {
		this(caption, null, time);
	}
	
	public BaseDateField(String caption, Date value, boolean time) {
		super(caption, value);
		setTime(time);
		setParseErrorMessage("Data inválida");
		setImmediate(true);
		addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = -9079280098156747244L;

			@SuppressWarnings("unchecked")
			@Override
			public void valueChange(Property.ValueChangeEvent event) {
				if (event.getProperty().getValue() != null) {
					Calendar cal = Calendar.getInstance();
					cal.setTime((Date)event.getProperty().getValue());
					int dateYear = cal.get(Calendar.YEAR);
					if (dateYear < 100) {
						int actualYear = Calendar.getInstance().get(Calendar.YEAR);
						int seculo = actualYear / 100;
						
						if (((seculo * 100) + dateYear) <= (actualYear + 20)) {
							cal.set(Calendar.YEAR, (seculo * 100) + dateYear);
						} else  {
							cal.set(Calendar.YEAR, ((seculo -1) * 100) + dateYear);
						}
					}
					event.getProperty().setValue(cal.getTime());
				}
			}
		});
	}
	
	@Override
	protected Date handleUnparsableDateString(String dateString)
			throws ConversionException {

		String[] formatos = {"dd/MM/yyyy", "d/MM/yyyy", "dd/M/yyyy", "d/M/yyyy",
				"dd/MM/yy", "d/MM/yy", "dd/M/yy", "d/M/yy",
				"dd/MM/y", "d/MM/y", "dd/M/y", "d/M/y",
				"ddMMyy", "ddMMyyyy"};
		String[] formatosTime = {"HH:mm", "HH:m", "H:mm", "H:m", "HHmm"};

		dateString = dateString.trim();

		for (String formato : formatos) {
			if (time) {
				for (String formatoTime : formatosTime) {
					Date data = toDate(dateString, formato + " " + formatoTime);
					if (data != null)
						return data;
					
					data = toDate(dateString, formato + formatoTime);
					if (data != null)
						return data;
				}
			}
			Date data = toDate(dateString, formato);
			if (data != null) {
				return data;
			}
		}

		super.handleUnparsableDateString(dateString);
		return null;
	}
	
	@Override
	public void setValue(Date newValue) throws Property.ReadOnlyException, ConversionException {

		if (newValue != null) {
			Calendar cal = Calendar.getInstance();
			int anoCorte = Calendar.getInstance().get(Calendar.YEAR) + 20;
			cal.setTime((Date) newValue);

			if (cal.get(Calendar.YEAR) < 100)
				cal.set(Calendar.YEAR, (cal.get(Calendar.YEAR) <= anoCorte % 100 ? (anoCorte / 100) * 100
						: (((anoCorte / 100) - 1) * 100)) + cal.get(Calendar.YEAR));

			newValue = cal.getTime();
		}
		super.setValue(newValue);
	}
	
	/**
	 * 
	 * Define o tamanho do campo e o formato usando tempo HH:mm
	 * 
	 * @param time
	 */
	public void setTime(boolean time) {
		this.time = time;
		if (time) {
			setDateFormat("dd/MM/yyyy HH:mm");
			setWidth("150px");
			setResolution(Resolution.MINUTE);
		} else {
			setDateFormat("dd/MM/yyyy");
			setWidth("100px");
			setResolution(Resolution.DAY);
		}
	}
	
	private Date toDate(String str, String format) {
		DateFormat df = new SimpleDateFormat(format);

		if (str == null)
			return null;

		try {
			return df.parse(str);
		} catch (ParseException e) {
			return null;
		}
	}
}
