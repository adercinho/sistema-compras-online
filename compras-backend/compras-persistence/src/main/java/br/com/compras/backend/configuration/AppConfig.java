package br.com.compras.backend.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration 
@ComponentScan("br.com.compras.backend")
@EnableWebMvc   
public class AppConfig extends JpaConfig{

    
} 