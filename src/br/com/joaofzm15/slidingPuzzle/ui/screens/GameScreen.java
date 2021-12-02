package br.com.joaofzm15.slidingPuzzle.ui.screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.joaofzm15.slidingPuzzle.ui.entities.Board;
import br.com.joaofzm15.slidingPuzzle.ui.entities.Frame;
import br.com.joaofzm15.slidingPuzzle.ui.entities.Piece;

public class GameScreen implements ActionListener {

	private Frame frame;
	private Board board;
	
	public GameScreen() {
		frame = new Frame("background.png");
		board = new Board(this);
		addBoardToFrame(board);
		board.refreshButtons();
	}
	
	public void addBoardToFrame (Board board) {
		frame.getJFrame().add(board.getJLabel());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		Piece piece = board.getPieceFromItsButton(source);
		board.highlightPiece(piece);
		System.out.println(board.getPieces().indexOf(piece));
	}
	
	

}
