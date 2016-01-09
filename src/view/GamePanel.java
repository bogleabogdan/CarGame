package view;

import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import listeners.ControlKeysListener;
import listeners.GameActionListener;
import services.GameService;

public class GamePanel extends JPanel {
	private final GameService service;
	private JLabel score;
	private JLabel gameOver;
	private JLabel playAgain;

	public GamePanel() {
		service = new GameService();
		score = new JLabel("Score");
		gameOver = new JLabel("Game Over");
		playAgain = new JLabel("Play Again");

		this.setSize(854, 480);
		this.setLayout(null);
		this.setFocusable(true);

		service.createRoad(0.0, 0.0, "images/road.png");
		service.createCar(427.0, 0.0, "images/2.png");
		service.createObstacle(345.0, 0.0, 0.0, "images/rock.png");

		createTimer().start();
		this.addKeyListener(new ControlKeysListener(service));
	}

	private Timer createTimer() {
		Timer t = new Timer(5, new GameActionListener(service, this));
		return t;
	}

	public void paintComponent(Graphics g) {
		if (service.isPlaying()) {
			score.setBounds(0, 0, 120, 50);
			this.add(score);
			super.paintComponent(g);
			Integer finalScore = service.getScore() / 10;
			score.setText("Score" + " " + finalScore.toString());
			g.drawImage(service.getRoad().getRoadImage(), 305,
					service.getRoad().getY().intValue() - service.getRoad().getRoadImage().getHeight() + 480, this);
			g.drawImage(service.getCar().getCarImage(), service.getCar().getX().intValue(), 380, this);
			g.drawImage(service.getObstacle().getObstacleImage(), service.getObstacle().getX().intValue(),
					service.getObstacle().getY().intValue(), this);
		} else {
			super.paintComponent(g);
			score.setBounds(400, 170, 120, 40);
			this.add(gameOver);
			this.add(playAgain);
			playAgain.setBounds(400, 240, 120, 40);
			playAgain.setText("Play Again Y/N?");
			gameOver.setBounds(400, 200, 120, 40);
			gameOver.setText("Game Over");
		}
	}
}
