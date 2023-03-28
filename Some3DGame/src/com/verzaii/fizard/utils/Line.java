package com.verzaii.fizard.utils;

public class Line {
	
	public Vector3 a;
	public Vector3 b;
	
	public Line(Vector3 a, Vector3 b) {
		this.a = a;
		this.b = b;
	}
	
	public void rotateZ(float angle) {
		float sin = (float)Math.sin(angle);
		float cos = (float)Math.cos(angle);
		
		{
			Debug.Log(a.x);
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
