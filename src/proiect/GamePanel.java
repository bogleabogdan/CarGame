package proiect;

import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private final GameService service;
	private JLabel score;
	private JLabel gameOver;

	public GamePanel() {
		service = new GameService();
		score = new JLabel("Score");
		gameOver = new JLabel("Game Over");

		this.setSize(854, 480);
		this.setLayout(null);

		score.setBounds(0, 0, 120, 50);

		this.add(score);

		service.createRoad(0.0, 0.0, "C:/Users/blackghost/Desktop/labpoo/proiect/road.png");
		service.createCar(0.0, 0.0, "C:/Users/blackghost/Desktop/labpoo/proiect/2.png");
		service.createObstacle(0.0, 0.0, "C:/Users/blackghost/Desktop/labpoo/proiect/rock.png");
		// add others
	}

	public void paintComponent(Graphics g) {
		if (service.isPlaying()) {
			super.paintComponent(g);
			g.drawImage(service.getRoad().getRoadImage(), 305, service.getRoad().getY().intValue(), this);
		}
	}
}
