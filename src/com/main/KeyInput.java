package com.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	private Paddle p1;
	private boolean up1 = false;
	private boolean down1 = false;
	
	private Paddle p2;
	private boolean up2 = false;
	private boolean down2 = false;
	
	// bring in the players(Paddle class) and define them
	public KeyInput(Paddle pd1, Paddle pd2) {
		p1 = pd1;
		p2 = pd2;
	}
	
	// ----- KEY EVENTS -----
	// setting key events so as to reduce lag in input
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		// PLAYER 1(LEFT) controls
		if (key == KeyEvent.VK_W) {
			p1.switchDirection(-1); // pass in argument to change velocity
			up1 = true;
		}
		if (key == KeyEvent.VK_S) {
			p1.switchDirection(1);
			down1 = true;
		}
		// PLAYER 2(RIGHT) controls
		if (key == KeyEvent.VK_UP) {
			p2.switchDirection(-1);
			up2 = true;
		}
		if (key == KeyEvent.VK_DOWN) {
			p2.switchDirection(1);
			down2 = true;		
		}
		
		// press Esc to close window
		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		
		if (key == KeyEvent.VK_ENTER) {
			
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		// PLAYER 1(LEFT)
		if (key == KeyEvent.VK_W) {
			up1 = false;
		}
		if (key == KeyEvent.VK_S) {
			down1 = false;
		}
		// PLAYER 2(RIGHT)
		if (key == KeyEvent.VK_UP) {
			up2 = false;
		}
		if (key == KeyEvent.VK_DOWN) {
			down2 = false;		
		}
		
		if(!up1 && !down1)
			p1.stop();
		
		if(!up2 && !down2)
			p2.stop();
		
	}
	

}
