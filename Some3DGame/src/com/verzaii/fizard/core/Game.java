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
		
		//TODO: Remove this testing code!
		
		Vector3 a = new Vector3(-100f, -100f, 0f);
		Vector3 b = new Vector3(100f, -100f, 0f);
		Vector3 c = new Vector3(-100f, 100f, 0f);
		Vector3 d = new Vector3(100f, 100f, 0f);
		
		Line[] lines = new Line[] {
			new Line(a, b),
			new Line(b, d),
			new Line(d, c),
			new Line(c, a),
		};
		
		Mesh mesh = new Mesh(lines);
		
		mesh.rotateZ(100f);
		
		renderer.addDrawCall(mesh);
		renderer.renderScreen();
	}
}
