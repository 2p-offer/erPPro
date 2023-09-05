package com.warship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class ForeignProApplication {

	public static void main(String[] args) {
		System.out.println("12321312");
		SpringApplication.run(ForeignProApplication.class, args);
		System.out.println("SUCCESS.....");
	}

}
