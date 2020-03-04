package com.springReact.warehouse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springReact.warehouse.ProductRepository.ProductRepository;
import com.springReact.warehouse.product.ProductModel;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SpringAppWarehouseApplication {

	@Bean
	public CommandLineRunner demo(ProductRepository productRepository) {
		return (args) -> {
			productRepository.save(new ProductModel("A234","House1", 12));
			productRepository.save(new ProductModel("C234","House3", 56));
			productRepository.save(new ProductModel("D3453","House4", 72));
			
		};
	}

	
	@Bean
	public Docket swaggerDocket() {

		return new Docket(DocumentationType.SWAGGER_2)

				.apiInfo(apiInfo()).select()

				.apis(RequestHandlerSelectors.basePackage("com.springReact.warehouse"))

				.build();

	}

	private ApiInfo apiInfo() {

		return new ApiInfoBuilder().title("Warehouse").version("0.0.1-SNAPSHOT").build();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAppWarehouseApplication.class, args);
	}

}
