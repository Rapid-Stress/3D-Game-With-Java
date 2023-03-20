package com.verzaii.fizard.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.verzaii.fizard.graphics.*;

public class Game {
	
	private String gameTitle;
	private int windowWidth, windowHeight;
	private boolean running;
	
	private Display display;
	
	//TODO: Refactor this!
	private BufferStrategy bs;
	private Graphics g;
	
	public Game(String gameTitle, int windowWidth, int windowHeight) {
		this.gameTitle = gameTitle;
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
	}
	
	public void start() {
		running = true;
		
		init();
		run();
	}
	
	private void init() {
		display = new Display(gameTitle, windowWidth, windowHeight);
	}
	
	private void run() {
		while(running) {
			update();
			render();
		}
	}
	
	private void update() {
		
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, windowWidth, windowHeight);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, windowWidth, windowHeight);
		
		bs.show();
		g.dispose();
	}
}
