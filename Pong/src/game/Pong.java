package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Pong implements ActionListener, KeyListener{

	private static boolean w, s, up, down;

	public static Pong pong;
	public int width = 1000, height = 1000;
	public Renderer renderer;
	public Paddle player1;
	public Paddle player2;
	public Ball ball;

	public Pong(){
		// Prepare to initialize JFrame and Tick System
		Timer timer = new Timer(20, this);
		JFrame jframe = new JFrame("t3ch's Pong");
		renderer = new Renderer();

		// JFrame settings and Start JFrame
		jframe.addKeyListener(this);
		jframe.setSize(width, height);
		jframe.setVisible(true);
		jframe.setResizable(false);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(renderer);

		// Initialize Variables
		w = false;
		s = false;
		up = false;
		down = false;

		// Initialize other objects.
		startUp();


		// Begin Ticking
		timer.start();
	}

	private void startUp() {
		player1 = new Paddle(this, 1);
		player2 = new Paddle(this, 2);
		ball = new Ball(this);
	}

	public void update(){
		if(w){
			player1.move(true);
		}
		if(s){
			player1.move(false);
		}
		if(up){
			player2.move(true);
		}
		if(down){
			player2.move(false);
		}
		
		ball.update();
	}

	public void render(Graphics2D g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.WHITE);
		g.setStroke(new BasicStroke(5f));
		g.drawLine(width/2, 0, width/2, height);
		g.drawArc(width/2-100, height/2-100, 200, 200, 0, 360);
		
		ball.render(g);
		player1.render(g);
		player2.render(g);
	}

	public static void main(String[] args) {
		pong = new Pong();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyId = e.getKeyCode();
		if(keyId == KeyEvent.VK_W){
			w = true;
		}
		if(keyId == KeyEvent.VK_S){
			s = true;
		}
		if(keyId == KeyEvent.VK_UP){
			up = true;
		}
		if(keyId == KeyEvent.VK_DOWN){
			down = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyId = e.getKeyCode();
		if(keyId == KeyEvent.VK_W){
			w = false;
		}
		if(keyId == KeyEvent.VK_S){
			s = false;
		}
		if(keyId == KeyEvent.VK_UP){
			up = false;
		}
		if(keyId == KeyEvent.VK_DOWN){
			down = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		renderer.repaint();

	}


}
