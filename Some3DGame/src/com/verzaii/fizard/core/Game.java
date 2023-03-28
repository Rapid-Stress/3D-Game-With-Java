package com.verzaii.fizard.core;

import com.verzaii.fizard.graphics.*;
import com.verzaii.fizard.utils.Line;
import com.verzaii.fizard.utils.Vector3;

public class Game {
	
	private String gameTitle;
	private int windowWidth, windowHeight;
	private boolean running;
	
	private static Display display;
	private static Renderer renderer;
	
	private Mesh testingMesh;
	
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
		
		//TODO: Remove this testing code!
		
		Vector3 a = new Vector3(-100f, -100f, 0f);
		Vector3 b = new Vector3(100f, -100f, 0f);
		Vector3 c = new Vector3(-100f, 100f, 0f);
		Vector3 d = new Vector3(100f, 100f, 0f);
		
		Line[] lines = new Line[] {
			new Line(a, b),
		};
		
		testingMesh = new Mesh(lines);
		testingMesh.rotateZ(50f);
		testingMesh.rotateZ(50f);
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
		renderer.addDrawCall(testingMesh);
		renderer.renderScreen();
	}
}
