package proiect;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Test extends JPanel implements ActionListener, KeyListener{
	private BufferedImage car=null; // imaginile pt masina, drum, obstacole
	private BufferedImage road=null;
	private BufferedImage rock=null;
	
	Timer t = new Timer(5, this); // la fiecare 5 ms are loc actionPerformed
	
	double x=417, y=-596, velx=0, vely=0, y2,vely2=0; //coordonatele si viteza de miscare
	double score=0; //scor
	int randomObstacle=0; //decide pe ce parte a drumului vor aparea obstacolele
	boolean inGame=true; //true - jocul continua , false - jocul se opreste
	
	public Test(){      // constructor pt clasa test
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(Graphics g){ 
		try{
			car=ImageIO.read(new File("C:/Users/blackghost/Desktop/labpoo/proiect/2.png"));
			road=ImageIO.read(new File("C:/Users/blackghost/Desktop/labpoo/proiect/road.png"));
			rock=ImageIO.read(new File("C:/Users/blackghost/Desktop/labpoo/proiect/rock.png"));
			}
			catch(IOException e)
			   {
			    
			   }
		if (inGame){
		super.paintComponent(g);
		
		Font f=new Font("arial",Font.BOLD,19);
	    g.setFont(f);
	    g.setColor(Color.black);
	    g.drawString("SCORE="+(int)score/10, 10, 45);
		
		
	    
		if(y>-17){  // e folosit pt ca imaginea drumului sa para in miscare tot timpul
			y=-596;
		}
		
		if(y2>420){ // e folosit pentru ca obstacolele sa apara de mai multe ori
			y2=-150;
			Random i = new Random();
			randomObstacle=i.nextInt(3);
			
		}
		g.drawImage(road, 305, (int)y, this);
		
		g.drawImage(car, (int)x, 380, this);
		
		
		
		
		
		up();  // miscarea drumului
		down(g, randomObstacle); // miscarea obstacolelor
		
		if (x<=345){  //masina sa nu depaseasca partea stanga a drumului
			x=345;
			
		}
		if(x>=483){		//masina sa nu depaseasca partea dreapta a drumului
			x=483;
		}
		
		if (y2>355){
		switch(randomObstacle){
		case 0: {
			if (x>=345 && x<391) inGame=false;
			break;
		}
		case 1: {
			if (x>391 && x<431) inGame=false;
			break;
		}
		case 2: {
			if (x>437 && x<=483) inGame=false;
			break;
		}
		}
		}
		
	}
	else {
		 Font f=new Font("arial",Font.BOLD,28);
		 g.setFont(f);
		 g.drawString("GAME OVER", 340, 200);
		 g.drawString("SCORE="+(int)score/10, 340, 240);
		 Font f1=new Font("arial",Font.BOLD,20);
		 g.setFont(f1);
		 g.drawString("PLAY AGAIN? Y/N", 600, 45);
		 t.stop();
	}
	}
	public void actionPerformed(ActionEvent e){  // ce se intampla la fiecare timer
		repaint();
		x+=velx;
		y+=vely;
		y2+=vely2;
		score++;
	}
	
	public void up(){
		vely=1.4+score/2000;
		//velx=0;
	}
	
	public void down(Graphics g, int k){
		
		vely2=1.4+score/2000;
		//velx=0;
		switch(k){
		case 0: {
			g.drawImage(rock, 347, (int)y2, this);
			break;
		}
		case 1: {
			g.drawImage(rock, 411, (int)y2, this);
			break;
		}
		case 2: {
			g.drawImage(rock, 475, (int)y2, this);
			break;
		}
		}
		}
		
	
	
	public void left(){
		vely=0;
		velx=-0.7;
	}
	
	public void right(){
		vely=0;
		velx=0.7;
	}

	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		 String[] arguments = new String[] {"123"};
		
		/*if (code == KeyEvent.VK_UP){
			up();
		}*/
		/*if (code == KeyEvent.VK_DOWN){
			down();
		}*/
		if (code == KeyEvent.VK_LEFT){
			left();
		}
		if (code == KeyEvent.VK_RIGHT){
			right();
		}
		if (code == KeyEvent.VK_Y){
			// inchidere fereastra anterioara
			WindowClass.main(arguments);
			
		}
		if(code == KeyEvent.VK_N){
			System.exit(0);
		}
	}

	
	public void keyReleased(KeyEvent e) {
		//velx=0;
	}

	
	public void keyTyped(KeyEvent e) {
		
	}
	
	
}