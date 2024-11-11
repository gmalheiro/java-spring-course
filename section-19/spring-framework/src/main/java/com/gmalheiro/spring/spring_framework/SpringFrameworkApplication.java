package com.gmalheiro.spring.spring_framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.gmalheiro.spring.spring_framework.enterprise.example.web.MyWebController;
import com.gmalheiro.spring.spring_framework.game.GameRunner;

@SpringBootApplication
public class SpringFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context 
			= SpringApplication.run(SpringFrameworkApplication.class, args);
		GameRunner runner = context.getBean(GameRunner.class);
		
		runner.run();
		
		MyWebController controller = context.getBean(MyWebController.class);
		System.out.println(controller.returnValueFromBusinessService());
	}

}
