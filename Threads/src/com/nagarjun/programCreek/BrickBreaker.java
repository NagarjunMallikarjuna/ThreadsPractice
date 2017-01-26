/*package com.nagarjun.programCreek;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BrickBreaker extends JPanel implements KeyListener,ActionListener,Runnable{

	static boolean right = false;
	static boolean left = false;
	
	int ballx = 160;
	int bally = 218;
	
	int batx = 160;
	int baty = 245;
	
	int brickx = 70;
	int bricky = 50;
	
	Rectangle Ball =  new Rectangle(ballx, bally, 5,5);
	//Rectangle Bat = new Rectangle(batx,baty,40,5);
	
	Rectangle[] Brick = new Rectangle[12];
	
	BrickBreaker(){
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		BrickBreaker game = new BrickBreaker();
		JButton button = new JButton("restart");
		frame.setSize(350, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.add(button, BorderLayout.SOUTH);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		button.addActionListener(game);
		
		game.addKeyListener(game);
		game.setFocusable(true);
		Thread t = new Thread(game);
		t.start();
	}
	
	public void paint(Graphics g){
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 350, 450);
		g.setColor(Color.blue);
		g.fillOval(Ball.x, Ball.y, Ball.width, Ball.height);
		g.setColor(Color.GRAY);
		g.fillRect(0, 251, 450, 200);
		g.setColor(Color.red);
		g.drawRect(0, 0, 343, 250);
		
		for(int i=0; i<Brick.length; i++){
			if(Brick[i]!=null){
				g.fill3DRect(Brick[i]x, Brick[i].y, Brick[i].width, Brick[i].height, true);
			}
		}
		
		if(ballFallDown==true || bricksOver == true){
			Font f = new Font("Arial", Font.BOLD,20);
			g.setFont(f);
			g.drawString(status, 70, 120);
			ballFallDown = false;
			bricksOver = false;
		}
		
		
	}
}
*/