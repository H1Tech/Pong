package game;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class Renderer extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Pong.pong.render((Graphics2D)g);
	}

}
