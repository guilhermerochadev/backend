package br.com.desafio.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("API REST - Usuarios e perfis")
						.version("v1")
						.description("API REST a gestão de usuários e controle de perfis")
						.license(new License()
								.name("springdoc")
								.url("https://springdoc.org")
						)
			    );			
	}
}
