package com.gbwdy.vegetable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@SpringBootApplication
public class VegetableApplication {

	@Bean
	public Converter<String, Date> addNewConvert() {

		return new Converter<String, Date>() {
			@Override
			public Date convert(String source) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = null;
				try {
					date = sdf.parse( source);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return date;
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VegetableApplication.class, args);
	}
}
