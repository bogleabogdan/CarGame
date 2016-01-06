package proiect;

import javax.swing.JFrame;

public class Frame {
	private JFrame frame;

	public Frame() {
		super();
		this.frame = new JFrame();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
