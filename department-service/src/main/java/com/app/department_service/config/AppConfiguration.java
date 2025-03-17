package com.app.department_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfiguration {
	
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
