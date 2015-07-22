package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Ball {
	private int x, y, velX, velY, diameter;
	private Random random;
	public Ball(Pong pong){
		diameter = 20;
		x = pong.width/2 - diameter/2;
		y = pong.height/2 - diameter/2;
		random = new Random();
		startUp(pong);
	}
	private void startUp(Pong pong){
		x = pong.width/2 - diameter/2;
		y = pong.height/2 - diameter/2;
		int rx = random.nextInt((4-(-4))+1)-4;
		if(rx == 0) rx = 1;
		velX=rx;
		int ry = random.nextInt((4-(-4))+1)-4;
		if(ry == 0) rx = 1;
		velY=ry;
	}
	public void render(Graphics2D g){
		g.setColor(Color.WHITE);
		g.fillOval(x, y, diameter, diameter);
	}
	public void update(){
		x += velX;
		y += velY;
	}
	public void reset(){
		startUp(Pong.pong);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}
