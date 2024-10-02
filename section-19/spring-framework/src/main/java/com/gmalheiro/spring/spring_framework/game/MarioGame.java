package com.gmalheiro.spring.spring_framework.game;

public class MarioGame implements GamingConsole{
	
	@Override
	public void up () {
		System.out.println("Mario game up");
	}
	
	@Override
	public void down () {
		System.out.println("Mario game down");
	}
	
	@Override
	public void right () {
		System.out.println("Mario game right");
	}
	
	@Override
	public void left () {
		System.out.println("Mario game left");
	}
}
