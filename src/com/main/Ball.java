package com.main;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	public static final int SIZE = 16;
	
	private int x, y;
	private int xVel, yVel; // Vel = velocity, value either 1 or -1
	private int speed = 5;
	
	public Ball() {
		reset();
	}
	
	public void reset() {
		// initial position set to centered
		x = Game.WIDTH/2 - SIZE/2;
		y = Game.HEIGHT/2 - SIZE/2;
		
		// initial random velocities(direction)
		xVel = Game.sign(Math.random()*2.0 - 1);
		yVel = Game.sign(Math.random()*2.0 - 1);
	
	}
	
	// Proprietary functions that changes the velocity
	public void changeXDir() {
		xVel *= -1;
	}
	public void changeYDir() {
		yVel *= -1;
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, SIZE, SIZE);
		
	}

	public void update(Paddle p1, Paddle p2) {
		// update movement
		x += xVel * speed;
		y += yVel * speed;
		
		
		// collides with paddles
		if (y + SIZE >= Game.HEIGHT || y <= 0)
			changeYDir();
		
		// collides with wall, meaning the ball has gone pass the paddle
		if (x + SIZE >= Game.WIDTH) {
			p1.addPoint();
			reset();
		}
		if (x <= 0) {
			p2.addPoint();
			reset();
		}
		
	}

	// ----- GETTERS -----
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
