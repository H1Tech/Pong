package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
public class Paddle {
	
	public int paddleNum;
	public int score;
	private Font font;
	
	public int x, y, width = 15, height = 100;
	
	public Paddle(Pong pong, int paddleNum){
		this.paddleNum = paddleNum;
		
		if (paddleNum == 1){
			x = 0;
		}
		else if(paddleNum == 2){
			x = pong.width - width - 5;
		}
		y = pong.height / 2 - height/2;
		score = 0;
		font = new Font("Arial", Font.PLAIN, 30);
	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		int x,y=100;
		if(paddleNum == 2) x = (Pong.pong.width/2)+(Pong.pong.width/4); else x=Pong.pong.width/4;
		g.setFont(font);
		g.drawString(Integer.toString(score), x, y);
	}

	public void move(boolean b) {
		int speed = 15;
		if(b){
			if(y - speed > -15){
				y -= speed;
			}
		}else{
			if(y + height + speed < Pong.pong.height - 15 ){
				y += speed;
			}
		}
		
	}

}
