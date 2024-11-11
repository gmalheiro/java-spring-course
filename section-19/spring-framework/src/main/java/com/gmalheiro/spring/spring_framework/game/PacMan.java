package com.gmalheiro.spring.spring_framework.game;

import org.springframework.stereotype.Component;

@Component
public class PacMan implements GamingConsole {

	@Override
	public void up() {
		System.out.println("PacMan game up");
	}

	@Override
	public void down() {
		System.out.println("PacMan game down");
	}

	@Override
	public void right() {
		System.out.println("PacMan game right");
	}

	@Override
	public void left() {
		System.out.println("PacMan game left");
	}

}
