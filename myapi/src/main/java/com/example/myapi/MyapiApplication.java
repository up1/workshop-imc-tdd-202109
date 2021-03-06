package com.example.myapi;

import com.example.myapi.product.Product;
import com.example.myapi.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;


@SpringBootApplication
public class MyapiApplication {

	@Bean
	public RestTemplate xyz() {
		// Builder pattern
		return new RestTemplateBuilder().build();
	}

//	@Autowired ProductRepository productRepository;
//
//	@PostConstruct
//	public void initialData() {
//		Product newProduct = new Product();
//		newProduct.setName("พัดลม");
//		newProduct.setPrice(1200);
//		productRepository.save(newProduct);
//	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MyapiApplication.class, args);
		String[] names = context.getBeanDefinitionNames();
		Arrays.stream(names).forEach(System.out::println);

		int count = context.getBeanDefinitionCount();
		System.out.println("All beans = " + count);
	}

}
