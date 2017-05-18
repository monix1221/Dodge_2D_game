package GraDodge;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends Entity {

	private Rectangle hitbox;
	private boolean dead = false;
	// private int ix, iy;

	private double ix, iy;
	private Dodge instance;

	public Enemy(Dodge instance, double x, double y) {
		super(x, y);
		this.instance = instance;

		hitbox = new Rectangle((int) x, (int) y, 28, 28);
		ix = 0;
		iy = 0.5;
	}

	private void move() {
		if (instance.getStage().isCollided(hitbox)) {
			iy = 0;
			dead = true;
		}

		if (hitbox.y < 3) {

			hitbox.x += ix * 0.6;

			hitbox.y += iy + 0.5;
		} else if (hitbox.y >= 3) {
			hitbox.x += ix;

			hitbox.y += iy + 0.5;
		}

	}

	public boolean isDead() {
		return dead;
	}

	public Rectangle getHitbox() {
		return hitbox;
	}

	public void draw(Graphics g) {
		move();
		g.setColor(Color.CYAN);
		g.fillRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
	}
}