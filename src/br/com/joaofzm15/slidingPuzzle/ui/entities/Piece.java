package br.com.joaofzm15.slidingPuzzle.ui.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Piece {

	private JButton jButton;
	public JButton getJButton() {
		return jButton;
	}

	public Piece(String imageURL, ActionListener actionListener) {
		jButton = new JButton();
		jButton.setForeground(Color.white);
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(imageURL));
		jButton.setIcon(icon);
		jButton.addActionListener(actionListener);

		jButton.setBorder(BorderFactory.createLineBorder(Color.white));
		jButton.setFocusable(true);
	}
	
	public Piece(int number, ActionListener actionListener) {
		jButton = new JButton();
		jButton.setForeground(Color.white);
		jButton.addActionListener(actionListener);
		jButton.setBackground(Color.orange);
		jButton.setText(String.valueOf(number));
		jButton.setFont(new Font("Impact",Font.BOLD, 40));
		jButton.setForeground(Color.white);
		jButton.setBackground(new Color(30, 30, 30));
		jButton.setBorder(BorderFactory.createLineBorder(Color.white));
		jButton.setFocusable(true);
	}
	
}
