package com.gmalheiro.spring.spring_framework;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gmalheiro.spring.spring_framework.game.GameRunner;
import com.gmalheiro.spring.spring_framework.game.MarioGame;

@SpringBootApplication
public class SpringFrameworkApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringFrameworkApplication.class, args);
		MarioGame game = new MarioGame();
		GameRunner runner = new GameRunner(game);
		runner.run();
	}

}
