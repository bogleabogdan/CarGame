package proiect;

import javax.swing.SwingUtilities;

public class Application {
	public static void show() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Frame frame = new Frame();
				frame.getFrame().add(new GamePanel());
			}

		});
	}
}
