package br.com.joaofzm15.slidingPuzzle.ui.entities;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Board {

	private JLabel jLabel;

	public JLabel getJLabel() {
		return jLabel;
	}

	private ArrayList<Piece> pieces;

	public ArrayList<Piece> getPieces() {
		return pieces;
	}
	
	public Board(ActionListener actionListener) {
		pieces = new ArrayList<>();
		jLabel = new JLabel();
		jLabel.setLayout(null);
		fillBoard(actionListener);
		jLabel.setBounds(700, 110, 500, 500);
		jLabel.setVisible(true);
//		Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
//		jLabel.setBorder(border);
	}

	public void addPieceToBoardAndList(int x, int y, String imageURL, ActionListener actionListener) {
		Piece piece = new Piece(x, y, imageURL, actionListener);
		jLabel.add(piece.getJButton());
		pieces.add(piece);
	}
	
	public Piece getPieceFromItsButton(JButton jButton) {
		return null;
	}

	public void fillBoard(ActionListener actionListener) {
		int x = 0;
		int y = 0;
		for (int i = 1; i <= 15; i++) {
			String imageURL = String.valueOf(i) + ".png";
			addPieceToBoardAndList(x, y, imageURL, actionListener);
			if (i % 4 == 0) {
				y += 125;
				x = 0;
			} else {
				x += 125;
			}
		}
	}

	public void refreshButtons() {
		for (Piece piece : pieces) {
			piece.getJButton().requestFocus();
		}
	}

}
