package GraDodge;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Entity {

	private int xd, yd;
	private Dodge instance;
	private Rectangle hitbox;
	private int life = 15;

	public Player(Dodge instance, int x, int y) {
		super(x, y);
		this.instance = instance;
		w = 16;
		h = 16;

		hitbox = new Rectangle(x, y, w, h);
	}

	public void draw(Graphics g) {
		move();
		// collision detection:
		g.setColor(Color.ORANGE);
		g.fillOval(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
		g.setColor(Color.WHITE);
		g.drawString("Life/Lives: " + life, 20, 20);
	}

	// smooth movements, no need to hold the button:
	private void move() {
		if (!(instance.getStage().isCollided(hitbox))) {
			yd = 1;
		} else
			yd = 0;
		hitbox.x += xd;
		hitbox.y += yd;

		if (instance.getEnemyManager().isColliding(hitbox)) {
			if (life > 0) {
				life--;
				hitbox.x = 800 / 2 - w / 2;
				y = 390;
			} else {
				instance.setGameOver(true);
			}
		}
	}

	public void setXD(int value) {
		this.xd = value;
	}

	public void setYD(int value) {
		this.yd = value;
	}

	public static void main(String[] args) {

	}
}
