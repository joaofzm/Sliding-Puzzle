package br.com.joaofzm15.slidingPuzzle.ui.entities;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;


public class BestLabel {
	private JLabel jLabel;
	public JLabel getJLabel() {
		return jLabel;
	}
	
	private int best = Integer.MAX_VALUE;

	public BestLabel() {
		jLabel = new JLabel();
		jLabel.setBounds(250,270,1000,300);
		jLabel.setLayout(null);
		jLabel.setText("Best : -");
		jLabel.setFont(new Font("Impact",Font.BOLD, 40));
		jLabel.setForeground(new Color(255,187,0));
		jLabel.setVisible(true);
	}
	
	public void refreshLabel() {
		jLabel.requestFocus();
	}

	public void requestFocus() {
		jLabel.requestFocus();
	}
	
	public void setBest(int value) {
		if (value<best) {
			best = value;
			jLabel.setText("Best : "+best);
		}
	}

}
