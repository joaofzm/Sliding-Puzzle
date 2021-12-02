package br.com.joaofzm15.slidingPuzzle.ui.entities;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Piece {
	
	private JButton jButton;
	public JButton getJButton() {
		return jButton;
	}
	
	public Piece(int x, int y, String imageURL) {
		jButton = new JButton();
		jButton.setBounds(x, y, 125 , 125);
//		jButton.setSize(125,125);
		jButton.setForeground(Color.white);
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(imageURL));
		jButton.setIcon(icon);
//		jButton.setBorder(BorderFactory.createLineBorder(Color.white));
//		jButton.setFocusable(true);
	}

}
