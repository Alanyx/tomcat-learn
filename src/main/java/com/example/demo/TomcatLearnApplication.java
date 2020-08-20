package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.designMode.*"})
@ServletComponentScan
public class TomcatLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(TomcatLearnApplication.class, args);
	}

}
