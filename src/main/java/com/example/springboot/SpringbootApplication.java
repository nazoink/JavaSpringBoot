package com.example.springboot;

import com.example.springboot.service.ExampleService;
import com.example.springboot.service.IExampleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
	// Used to add swagger to all controllers and endpoints
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.example.springboot")).build();
	}
	// Makes the ExampleService injectable
	// Can also be configured into a configuration class to reduce scope of needed services to each controller
	@Bean
	public IExampleService exampleService() {
		return new ExampleService();
	}

}
