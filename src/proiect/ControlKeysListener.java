package proiect;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlKeysListener implements KeyListener {

	private GameService service;

	public ControlKeysListener(GameService service) {
		this.service = service;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_LEFT) {
			service.moveCar(Direction.LEFT);
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			service.moveCar(Direction.RIGHT);
		}
		if (keyCode == KeyEvent.VK_Y) {
			if (!service.isPlaying()) {
				Frame.getFrame().removeAll();
				Application.show();
			}
		}
		if (keyCode == KeyEvent.VK_N) {
			if (!service.isPlaying()) {
				System.exit(0);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
