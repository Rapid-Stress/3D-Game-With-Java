package com.verzaii.fizard.graphics;

import java.awt.*;

import javax.swing.JFrame;

public class Display {
	
	private int width, height;
	private String title;
	
	private JFrame frame;
	private Canvas canvas;
	
	public Display(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		
		createDisplay();
	}
	
	private void createDisplay() {
		frame = new JFrame(title);
		
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		
		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
