package br.com.compras.backend.exception;


public class BusinessException extends Exception {

    private static final long serialVersionUID = 1L;

    private String msgErro;

    public BusinessException() {

    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String msgErro) {
        super(msgErro);
    }

    public String getMsgErro() {
        return msgErro;
    }

    public void setMsgErro(String msgErro) {
        this.msgErro = msgErro;
    }

}