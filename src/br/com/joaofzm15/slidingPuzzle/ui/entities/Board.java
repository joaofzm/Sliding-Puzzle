package br.com.joaofzm15.slidingPuzzle.ui.entities;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Board {
	
	private JPanel jLabel;
	public JPanel getJLabel() {
		return jLabel;
	}
	
	public Board() {
		jLabel = new JPanel();
		jLabel.setLayout(null);
		fillBoard();
		jLabel.setBounds(700,110,500,500);
		jLabel.setVisible(true);
        Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
		jLabel.setBorder(border);
	}
	
	public void addPiece(int x, int y, String imageURL) {
		jLabel.add(new Piece(x,y,imageURL).getJButton());
//		System.out.println("Piece added at: "+x+" / "+y);
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
