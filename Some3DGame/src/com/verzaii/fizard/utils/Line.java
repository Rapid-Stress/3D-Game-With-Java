package com.verzaii.fizard.utils;

public class Line {
	
	public Vector3 a;
	public Vector3 b;
	
	private Vector3 angle = Vector3.ZERO();
	
	public Line(Vector3 a, Vector3 b) {
		this.a = a.copy();
		this.b = b.copy();
	}
	
	public void rotate(Vector3 amt) {
		angle.add(amt);
		
		transformX();
		transformY();
		transformZ();
	}
	
	public void move(Vector3 amt) {
		a.add(amt);
		b.add(amt);
	}
	
	private void transformX() {
		float sin = (float)Math.sin(angle.x);
		float cos = (float)Math.cos(angle.x);
		
		{
			float newX =  1 * a.x + 0   * a.y + 0   * a.z;
			float newY =  0 * a.x + cos * a.y - sin * a.z;
			float newZ =  0 * a.x + sin * a.y + cos * a.z;
			
			a.x = newX;
			a.y = newY;
			a.z = newZ;
		}
		
		{
			float newX =  1 * b.x + 0   * b.y + 0   * b.z;
			float newY =  0 * b.x + cos * b.y - sin * b.z;
			float newZ =  0 * b.x + sin * b.y + cos * b.z;
			
			b.x = newX;
			b.y = newY;
			b.z = newZ;
		}
	}

	private void transformY() {
		float sin = (float)Math.sin(angle.y);
		float cos = (float)Math.cos(angle.y);
		
		{
			float newX =  cos  * a.x + 0 * a.y + sin * a.z;
			float newY =  0    * a.x + 1 * a.y + 0   * a.z;
			float newZ =  -sin * a.x + 0 * a.y + cos * a.z;
			
			a.x = newX;
			a.y = newY;
			a.z = newZ;
		}
		
		{
			float newX =  cos  * b.x + 0 * b.y + sin * b.z;
			float newY =  0    * b.x + 1 * b.y + 0   * b.z;
			float newZ =  -sin * b.x + 0 * b.y + cos * b.z;
			
			b.x = newX;
			b.y = newY;
			b.z = newZ;
		}
	}
	
	private void transformZ() {
		float sin = (float)Math.sin(angle.z);
		float cos = (float)Math.cos(angle.z);
		
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
