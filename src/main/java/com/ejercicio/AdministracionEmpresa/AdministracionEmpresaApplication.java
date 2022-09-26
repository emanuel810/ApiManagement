package com.ejercicio.AdministracionEmpresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AdministracionEmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdministracionEmpresaApplication.class, args);
	}
	
	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ejercicio.AdministracionEmpresa"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder()
				.title("Api de una administracion de una empresa")
				.description("la api controla lo que son 3 microcrontoladores")
				.build() ;
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:8080");
			}
		};
	}

}
