package com.verzaii.fizard.utils;

import com.verzaii.fizard.core.Game;

public class Launcher {
	
	public static final String GAME_TITLE = "3D Game";
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	public static void main(String[] args) {
		Game game = new Game(GAME_TITLE, WIDTH, HEIGHT);
		game.start();
	}
}
