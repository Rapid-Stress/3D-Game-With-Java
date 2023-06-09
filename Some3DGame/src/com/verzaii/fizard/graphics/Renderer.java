package com.verzaii.fizard.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import com.verzaii.fizard.utils.Line;

public class Renderer {
	
	private Display target;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private ArrayList<Drawable> drawQueue = new ArrayList<Drawable>();
	
	public Renderer(Display target) {
		this.target = target;
	}
	
	public void addDrawCall(Drawable object) {
		drawQueue.add(object);
	}
	
	public void renderScreen() {
		if(!initScreen()) return;
		
		clearScreen();
		drawBackground();
		
		g.setColor(Color.WHITE);
		for(Drawable object : drawQueue) {
			for(Line line : object.getMesh().getLines()) {
				g.drawLine(line.a.getScreenX(), line.a.getScreenY(), line.b.getScreenX(), line.b.getScreenY());
			}
		}
		
		showScreen();
		clearQueue();
	}
	
	private boolean initScreen() {
		bs = target.getCanvas().getBufferStrategy();
		
		if(bs == null) {
			target.getCanvas().createBufferStrategy(3);
			return false;
		}
		
		g = bs.getDrawGraphics();
		
		return true;
	}

	private void clearScreen() {
		g.clearRect(0, 0, target.getWidth(), target.getHeight());
	}
	
	private void drawBackground() {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, target.getWidth(),	target.getHeight());
	}
	
	private void showScreen() {
		bs.show();
		g.dispose();
	}

	private void clearQueue() {
		drawQueue.clear();
	}
}
