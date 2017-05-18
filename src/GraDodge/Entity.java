package GraDodge;

import java.awt.Graphics;

public abstract class Entity {

	protected double x, y;
	protected int w, h;
	protected boolean removed = false;

	public Entity(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g) {

	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}
}