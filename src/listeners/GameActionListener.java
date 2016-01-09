package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import services.GameService;
import view.GamePanel;

public class GameActionListener implements ActionListener {
	private GameService service;
	private GamePanel panel;

	public GameActionListener(GameService service, GamePanel panel) {
		this.service = service;
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		panel.repaint();
		service.setScore(service.getScore() + 1);
		service.getCar().setX(service.getCar().getX() + service.getCar().getxVelocity());
		service.checkCarPosition();
		service.getRoad().setY(service.getRoad().getY() + service.getRoad().getyVelocity());
		service.getObstacle().setY(service.getObstacle().getY() + service.getObstacle().getyVelocity());
		service.moveRoad();
		service.moveObstacle();
		service.checkCollision();

	}

}
