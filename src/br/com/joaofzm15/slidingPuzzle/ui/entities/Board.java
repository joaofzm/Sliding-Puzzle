package br.com.joaofzm15.slidingPuzzle.ui.entities;

import java.awt.Color;

import javax.swing.JLabel;


public class Board {
	
	private JLabel jLabel;
	public JLabel getJLabel() {
		return jLabel;
	}
	
	public Board() {
		jLabel = new JLabel();
		fillBoard();
		jLabel.setBounds(500,500,500,500);
		jLabel.setBackground(Color.pink);
		jLabel.setVisible(true);
		jLabel.setText("penis");
	}
	
	public void addPiece(int x, int y, String imageURL) {
		jLabel.add(new Piece(x,y,imageURL).getJButton());
	}
	
	public void fillBoard() {
		int x = 0;
		int y = 0;
		for (int i = 1; i <= 15; i++) {
			String imageURL = String.valueOf(i)+".png";
			addPiece(x, y, imageURL);
			if (i%4==0) {
				y+=125;
				x=0;
			} else {
				x+=125;
			}
		}
	}

}
