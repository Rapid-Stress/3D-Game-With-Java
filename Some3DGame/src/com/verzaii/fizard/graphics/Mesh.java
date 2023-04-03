package com.verzaii.fizard.graphics;

import com.verzaii.fizard.utils.*;

public class Mesh {
	
	private Line[] lines;
	
	public Mesh(Line[] lines) {
		this.lines = lines;
	}
	
	public Line[] getLines() {
		return lines;
	}
	
	public void rotateZ(float angle) {
		for(Line line : lines) {
			line.rotateZ(angle);
		}
	}
	
	public void move(Vector3 amt) {
		for(Line line : lines) {
			line.move(amt);
		}
	}
}
