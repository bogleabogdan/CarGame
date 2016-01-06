package proiect;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Window {
	public static void main(String[] args){
		JFrame f = new JFrame();
		Test t = new Test();
		f.add(t);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(854, 480);
	}
}
	