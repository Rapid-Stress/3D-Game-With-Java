package com.verzaii.fizard.utils;

import com.verzaii.fizard.graphics.*;

public class Quad implements Drawable {

	private Mesh mesh;
	
	public Quad(Vector3 pos, Vector3 size) {
		Vector3 a = new Vector3(-size.x/2 , -size.y/2 , 0f);
		Vector3 b = new Vector3( size.x/2 , -size.y/2 , 0f);
		Vector3 c = new Vector3(-size.x/2 ,  size.y/2 , 0f);
		Vector3 d = new Vector3( size.x/2 ,  size.y/2 , 0f);
		
		a.add(pos);
		b.add(pos);
		c.add(pos);
		d.add(pos);
		
		Line[] lines = new Line[] {
			new Line(a, b),
			new Line(b, d),
			new Line(d, c),
			new Line(c, a),
		};
		
		mesh = new Mesh(lines);
	}
	
	public void rotate(Vector3 amt) {
		mesh.rotate(amt);
	}
	
	public void move(Vector3 amt) {
		mesh.move(amt);
	}
	
	public Mesh getMesh() {
		return mesh;
	}
}
