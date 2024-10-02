package com.gmalheiro.spring.spring_framework.game;

public class SuperContra implements GamingConsole{

	@Override
	public void up() {
		System.out.println("SuperContra up");
	}

	@Override
	public void down() {
		System.out.println("SuperContra down");
	}

	@Override
	public void right() {
		System.out.println("SuperContra right");
	}

	@Override
	public void left() {
		System.out.println("SuperContra left");
	}

}
