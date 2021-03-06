package br.com.joaofzm15.slidingPuzzle.ui.entities;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;


public class MoveCounter {
	private JLabel jLabel;
	private int moves = 0;
	
	public JLabel getJLabel() {
		return jLabel;
	}
	
	public int getMoves() {
		return moves;
	}

	public MoveCounter() {
		jLabel = new JLabel();
		jLabel.setBounds(200,170,1000,300);
		jLabel.setLayout(null);
		jLabel.setText("Moves: "+moves);
		jLabel.setFont(new Font("Impact",Font.BOLD, 60));
		jLabel.setForeground(new Color(255,187,0));
		jLabel.setVisible(true);
	}
	
	public void refreshLabel() {
		jLabel.requestFocus();
	}

	public void resetCounter() {
		moves = 0;
		jLabel.setText("Moves: "+moves);
	}

	public void requestFocus() {
		jLabel.requestFocus();
	}
	
	public void increaseCounter() {
		moves++;
		jLabel.setText("Moves: "+moves);
	}

}
