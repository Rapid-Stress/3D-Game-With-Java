package com.verzaii.fizard.core;

import com.verzaii.fizard.graphics.*;
import com.verzaii.fizard.utils.*;

public class Game {
	
	private String gameTitle;
	private int windowWidth, windowHeight;
	private boolean running;
	
	private static Display display;
	private static Renderer renderer;
	
	private Quad testingQuad;
	
	public Game(String gameTitle, int windowWidth, int windowHeight) {
		this.gameTitle = gameTitle;
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
	}
	
	public static Renderer GetContextRenderer() {
		return renderer;
	}
	
	public static Display GetActiveDisplay() {
		return display;
	}
	
	public void start() {
		running = true;
		
		init();
		run();
	}
	
	private void init() {
		display = new Display(gameTitle, windowWidth, windowHeight);
		renderer = new Renderer(display);
		
		testingQuad = new Quad(new Vector3(0, 0, 0), new Vector3(50, 100, 0));
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
		renderer.addDrawCall(testingQuad);
		renderer.renderScreen();
	}
}
