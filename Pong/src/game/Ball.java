package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Ball {
	public int x, y, velX, velY, diameter;
	public final int SPEED = 10;
	public final double MAX_ANGLE = 5*Math.PI;
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
		g.fillOval(x-diameter/2, y-diameter/2, diameter, diameter);
	}
	public void update(){
		x += velX;
		y += velY;
		testWall();
	}
	private void testWall() {
		if((y <= 0) || (y + 2*diameter >= Pong.pong.height)){
			velY = velY * -1;
		}
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
	public int getDiameter(){
		return diameter;
	}
	public void setVel(long velX, long velY) {
		this.velX = (int) velX;
		this.velY = (int) velY;
		
	}
}
