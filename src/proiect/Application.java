package proiect;

import javax.swing.SwingUtilities;

import view.Frame;
import view.GamePanel;

public class Application {
	public static void show() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Frame();
				Frame.getFrame().add(new GamePanel());
			}

		});
	}
}
