package GraDodge;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyManager {

	private int amonut;
	private List<Enemy> enemies = new ArrayList<Enemy>();
	private Dodge instance;
	public EnemyManager(Dodge instance, int a) {
		this.amonut = a;
		this.instance = instance;
		spawn();

	}

	private void spawn() {
		Random random = new Random();
		int ss = enemies.size();

		if (ss < amonut) {
			for (int i = 0; i < amonut - ss; i++) {
				enemies.add(new Enemy(instance, random.nextInt(778), random.nextInt(100) + 1));
			}
		} else if (ss > amonut) {
			for (int i = 0; i < ss - amonut; i++) {
				enemies.remove(i);
			}
		}
	}

	public void draw(Graphics g) {
		update();
		for (Enemy e : enemies)
			e.draw(g);
	}

	private void update() {
		boolean re = false;

		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).isDead()) {
				enemies.remove(i);
				re = true;
			}
		}

		if (re)
			spawn();
	}

	public boolean isColliding(Rectangle hitbox) {

		boolean c = false;

		for (int i = 0; i < enemies.size(); i++) {

			if (hitbox.intersects(enemies.get(i).getHitbox()))
				c = true;
		}
		return c;
	}
}
