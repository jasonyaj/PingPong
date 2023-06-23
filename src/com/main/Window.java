package com.main;

import javax.swing.JFrame;

public class Window {

		public Window(String title, Game game) {
			JFrame frame = new JFrame(title);
			
			//when "x" is pressed it exits game
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//makes size of window not resizable by player/user
			frame.setResizable(false);
			// "game" will be a component object
			frame.add(game);
			// pack into all the components???
			frame.pack();
			// game appears center
			frame.setLocationRelativeTo(null);
			// 
			frame.setVisible(true);
			
		}
}
