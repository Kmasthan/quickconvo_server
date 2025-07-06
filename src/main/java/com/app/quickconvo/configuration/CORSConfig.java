//package com.app.quickconvo.configuration;
//
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//public class CORSConfig implements WebMvcConfigurer {
//
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//        .allowedOrigins("*")
//        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") // Allowed methods
//        .allowedHeaders("*") // Allowing all headers
//        .allowCredentials(true) // Allowing credentials
//        .maxAge(3600); 
//	}
//	
//}
