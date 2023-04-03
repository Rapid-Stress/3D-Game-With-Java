package com.verzaii.fizard.utils;

public class Line {
	
	public Vector3 a;
	public Vector3 b;
	
	private float angle;
	
	public Line(Vector3 a, Vector3 b) {
		this.a = a.copy();
		this.b = b.copy();
	}
	
	public void rotateZ(float angle) {
		this.angle += angle;
		transformZ();
	}
	public void move(Vector3 amt) {
		a.add(amt);
		b.add(amt);
	}

	private void transformZ() {
		float sin = (float)Math.sin(angle);
		float cos = (float)Math.cos(angle);
		
		{
			float newX = -cos * a.x + sin * a.y + 0 * a.z;
			float newY =  sin * a.x + cos * a.y + 0 * a.z;
			float newZ =  0   * a.x + 0   * a.y + 1 * a.z;
			
			a.x = newX;
			a.y = newY;
			a.z = newZ;
		}
		
		{
			float newX = -cos * b.x + sin * b.y + 0 * b.z;
			float newY =  sin * b.x + cos * b.y + 0 * b.z;
			float newZ =  0   * b.x + 0   * b.y + 1 * b.z;
			
			b.x = newX;
			b.y = newY;
			b.z = newZ;
		}
	}
}
