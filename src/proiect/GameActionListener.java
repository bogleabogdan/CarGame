package proiect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		service.getCar().setX(service.getCar().getX() + service.getCar().getxVelocity());
		service.getRoad().setY(service.getRoad().getY() + service.getRoad().getyVelocity());
		service.getObstacle().setY(service.getObstacle().getY() + service.getObstacle().getyVelocity());
		service.setScore(service.getScore() + 1);
	}

}
