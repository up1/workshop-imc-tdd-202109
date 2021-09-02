package com.example.myapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;


@SpringBootApplication
public class MyapiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MyapiApplication.class, args);
		String[] names = context.getBeanDefinitionNames();
		Arrays.stream(names).forEach(System.out::println);

		int count = context.getBeanDefinitionCount();
		System.out.println("All beans = " + count);
	}

}
