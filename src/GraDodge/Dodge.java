package GraDodge;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dodge extends JPanel implements KeyListener {
	// 2. JPanel - do wyœwietlania

	private Player player;
	private Stage stage;

	private boolean isGameOver = false;

	private EnemyManager manager;

	// private int x=5, y=5;
	public Dodge() {

		setSize(new Dimension(800, 600));
		setPreferredSize(new Dimension(800, 600));

		setFocusable(true);
		addKeyListener(this);

		stage = new Stage();
		player = new Player(this, 200, 200);
		manager = new EnemyManager(this, 8);

	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	// wbudowana metoda w swingu:
	public void paint(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		stage.draw(g);
		if (!isGameOver) {
			player.draw(g);
			manager.draw(g);
		} else {
			g.setFont(new Font("Century Gothic", Font.BOLD, 24));
			g.drawString("Game Over!", 350, 200);
		}
		g.dispose();
		repaint();
	}

	public Stage getStage() {
		return stage;
	}

	public EnemyManager getEnemyManager() {
		return manager;
	}

	public static void main(String[] args) {

		Dodge game = new Dodge();

		// 1. Tworzymy JFrame - szkielet
		JFrame frame = new JFrame();
		frame.setTitle("Dodge the Rectangles");
		frame.add(game);
		frame.pack();
		/*
		 * powoduje, ¿e okno dopasowuje siê do odpowiedniego rozmiaru (np.
		 * powiêksza siê gdy potrzebuje - bo dodajemy nowe rzeczy do niego)
		 */
		frame.setResizable(false);
		// czy u¿ytkownik mo¿e sam zmieniaæ wys/szer okna

		frame.setSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * bez tego, po zamkniêciu programu, programu by nie by³o widaæ, ale by
		 * ca³y czas pracowa³; to jest tylko informacja dla Javy ¿e ma skoñczyæ
		 * pracê
		 */

		frame.setLocationRelativeTo(null);
		/*
		 * aby okno by³o na œrodku ekranu; bez tego by³oby w lewym górnym rogu
		 * 
		 */
		frame.setVisible(true);
		frame.addFocusListener(null);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if (c == KeyEvent.VK_W) {
			// player.setYD(-1);
		}

		if (c == KeyEvent.VK_A) {
			player.setXD(-1);
		}
		if (c == KeyEvent.VK_S) {
			// player.setYD(1);
		}

		if (c == KeyEvent.VK_D) {
			player.setXD(1);
		}

	}

	public void setGameOver(boolean flag) {
		isGameOver = flag;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// ¿eby po zwolnienia klawisza kuleczka siê zatrzyma³a
		player.setXD(0);

		player.setYD(0);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
