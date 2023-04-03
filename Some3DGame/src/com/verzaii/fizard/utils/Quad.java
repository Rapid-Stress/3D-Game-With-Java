package com.verzaii.fizard.utils;

import com.verzaii.fizard.graphics.*;

public class Quad implements Drawable {

	private Mesh mesh;
	
	public Quad() {
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
		
		mesh = new Mesh(lines);
	}

	public Mesh getMesh() {
		return mesh;
	}
	public void rotateZ(float angle) {
		mesh.rotateZ(angle);
	}
	public void move(Vector3 amt) {
		mesh.move(amt);
	}
}
