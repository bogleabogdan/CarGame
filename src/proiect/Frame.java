package proiect;

import javax.swing.JFrame;

public class Frame {
	private JFrame frame;

	public Frame() {
		frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(854, 480);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("Car Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

	public JFrame getFrame() {
		return frame;
	}

}
