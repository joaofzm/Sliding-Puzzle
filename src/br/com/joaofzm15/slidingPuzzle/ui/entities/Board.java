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
		fillListWithPieces(actionListener);
		addPieceJLabelFromList(pieces);
		jLabel.setBounds(700, 110, 500, 500);
		jLabel.setVisible(true);
//		Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
//		jLabel.setBorder(border);
	}

	public void highlightPiece(Piece piece) {
		for (Piece p : pieces) {
			p.unHighlightPiece();
		}
		piece.highlightPiece();
	}
	
	public Piece getPieceFromItsButton(JButton jButton) {
		for (Piece piece : pieces) {
			if (piece.getJButton()==jButton) {
				return piece;
			}
		}
		return null;
	}


	public void addPieceJLabelFromList(ArrayList<Piece> pieces) {
		for (Piece piece : pieces) {
			jLabel.add(piece.getJButton());
		}
	}
	
	public void fillListWithPieces(ActionListener actionListener) {
		int x = 0;
		int y = 0;
		for (int i = 1; i <= 15; i++) {
			String imageURL = String.valueOf(i) + ".png";
			pieces.add(new Piece(x, y, imageURL, actionListener));
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
	
	public void movePieceUp(Piece piece) {
		JButton button = piece.getJButton();
		button.setBounds(button.getX(),button.getY()-125,125,125);
	}
	
	public void movePieceDown(Piece piece) {
		JButton button = piece.getJButton();
		button.setBounds(button.getX(),button.getY()+125,125,125);
	}
	
	public void movePieceRight(Piece piece) {
		JButton button = piece.getJButton();
		button.setBounds(button.getX()+125,button.getY(),125,125);
	}
	
	public void movePieceLeft(Piece piece) {
		JButton button = piece.getJButton();
		button.setBounds(button.getX()-125,button.getY(),125,125);
	}

}
