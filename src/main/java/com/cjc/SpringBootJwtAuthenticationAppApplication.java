package com.cjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJwtAuthenticationAppApplication {
	
	int x = 100;
	
	public void m1()
	{
		System.out.println("m1--Method");	
	}

       public void m2()
       {
        System.out.println("m2--Method Added");
       }

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtAuthenticationAppApplication.class, args);
	}

}
