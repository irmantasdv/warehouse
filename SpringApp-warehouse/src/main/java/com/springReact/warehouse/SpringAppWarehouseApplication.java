package com.springReact.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springReact.warehouse.model.Category;
import com.springReact.warehouse.model.ProductModel;
import com.springReact.warehouse.repository.CategoryRepository;
import com.springReact.warehouse.repository.ProductRepository;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SpringAppWarehouseApplication {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			Category furniture = new Category("Furniture", "Furniture and Furniture");
			Category book = new Category("Book", "bookstore and library products");
			categoryRepository.save(furniture);
			categoryRepository.save(book);
			productRepository.save(new ProductModel("A234","House1", 12, furniture));
			productRepository.save(new ProductModel("C234","House3", 56,furniture));
			productRepository.save(new ProductModel("D3453","Home Food", 72, book));
			
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
