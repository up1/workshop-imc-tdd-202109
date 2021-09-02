package com.example.myapi;

import com.example.myapi.product.Product;
import com.example.myapi.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import java.util.Arrays;


@SpringBootApplication
public class MyapiApplication {

	@Autowired ProductRepository productRepository;

	@PostConstruct
	public void initialData() {
		Product newProduct = new Product();
		newProduct.setName("พัดลม");
		newProduct.setPrice(1200);
		productRepository.save(newProduct);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MyapiApplication.class, args);
		String[] names = context.getBeanDefinitionNames();
		Arrays.stream(names).forEach(System.out::println);

		int count = context.getBeanDefinitionCount();
		System.out.println("All beans = " + count);
	}

}
