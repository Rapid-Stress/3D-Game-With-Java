package com.verzaii.fizard.utils;

import com.verzaii.fizard.core.Game;

public class Vector3 {
	
	public float x, y, z;
	
	public Vector3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	//Constants
	public static final Vector3 ZERO = new Vector3(0, 0, 0);
	public static final Vector3 ONE = new Vector3(1, 1, 1);
	public static final Vector3 UP = new Vector3(0, -1, 0);
	public static final Vector3 DOWN = new Vector3(0, 1, 0);
	public static final Vector3 RIGHT = new Vector3(1, 0, 0);
	public static final Vector3 LEFT = new Vector3(-1, 0, 0);
	public static final Vector3 FRONT = new Vector3(0, 0, 1);
	public static final Vector3 BACK = new Vector3(0, 0, -1);
	
	//Member functions
	public Vector3 copy() {
		return new Vector3(x, y, z);
	}
	
	public void add(Vector3 other) {
		x += other.x;
		y += other.y;
		z += other.z;
	}
	
	public void sub(Vector3 other) {
		x -= other.x;
		y -= other.y;
		z -= other.z;
	}
	
	public void mult(float factor) {
		x *= factor;
		y *= factor;
		z *= factor;
	}
	
	public void div(float factor) {
		x /= factor;
		y /= factor;
		z /= factor;
	}

	//Static functions
	public static Vector3 Add(Vector3 a, Vector3 b) {
		return new Vector3(a.x + b.x, a.y + b.y, a.z + b.z);
	}
	
	public static Vector3 Sub(Vector3 a, Vector3 b) {
		return new Vector3(a.x - b.x, a.y - b.y, a.z - b.z);
	}
	
	public static Vector3 Mult(Vector3 a, float f) {
		return new Vector3(a.x * f, a.y * f, a.z * f);
	}
	
	public static Vector3 Div(Vector3 a, float f) {
		return new Vector3(a.x / f, a.y / f, a.z / f);
	}

	//Render specific functions
	public int getScreenX() {
		return (int) (x + Game.GetActiveDisplay().getWidth() / 2f);
	}
	
	public int getScreenY() {
		return (int) (y + Game.GetActiveDisplay().getHeight() / 2f);
	}
}
