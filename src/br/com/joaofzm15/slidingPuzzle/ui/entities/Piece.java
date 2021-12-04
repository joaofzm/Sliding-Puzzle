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

	public Piece() {
		jButton = new JButton();
		jButton.setVisible(false);
	}
	
	public Piece(int number, ActionListener actionListener) {
		jButton = new JButton();
		jButton.addActionListener(actionListener);
		jButton.setText(String.valueOf(number));
		jButton.setFont(new Font("Impact",Font.BOLD, 50));
		jButton.setForeground(new Color(0,0,200));
		jButton.setBackground(new Color(255, 125, 30));
		jButton.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
		jButton.setFocusable(true);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj==null) {
			return false;
		}
		if(obj.getClass()!=this.getClass()) {
			return false;
		}

		Piece objParsedToPiece = (Piece) obj;
		if(objParsedToPiece.getJButton().getText().equals(this.getJButton().getText())) {
			return true;
		}
		return false;
	}
	
}
