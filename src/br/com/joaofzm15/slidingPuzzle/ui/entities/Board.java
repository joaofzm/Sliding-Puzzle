package br.com.joaofzm15.slidingPuzzle.ui.entities;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

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
		printJLabelWithPiecesFromList(pieces);
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

	// Pieces originated from this method still lack the setBounds property.
	// Also shuffles the list in the end.
	public void fillListWithPieces(ActionListener actionListener) {
		for (int i = 1; i <= 16; i++) {
			String imageURL = String.valueOf(i) + ".png";
			pieces.add(new Piece(imageURL, actionListener));
		}
//		Collections.shuffle(pieces);
	}
	
	// Sets the bounds for the pieces from the list, and adds them to the label.
	public void printJLabelWithPiecesFromList(ArrayList<Piece> pieces) {
		int x = 0;
		int y = 0;
		for (int i = 0; i<pieces.size();i++) {
			pieces.get(i).getJButton().setBounds(x,y,125,125);
			jLabel.add(pieces.get(i).getJButton());
			System.out.println("Piece added at: "+x+" / "+y);
			if (i == 3 || i == 7 || i == 11) {
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
	
	public void switchPieces(Piece piece1, Piece piece2) {
		int piece1X = piece1.getJButton().getX();
		int piece1Y = piece1.getJButton().getY();
		piece1.getJButton().setBounds(piece2.getJButton().getX(),piece2.getJButton().getY(),125,125);
		piece2.getJButton().setBounds(piece1X,piece1Y,125,125);
	}

}
