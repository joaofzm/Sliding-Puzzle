package br.com.joaofzm15.slidingPuzzle.ui.screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.joaofzm15.slidingPuzzle.logic.GameScreenController;
import br.com.joaofzm15.slidingPuzzle.ui.entities.Board;
import br.com.joaofzm15.slidingPuzzle.ui.entities.Frame;
import br.com.joaofzm15.slidingPuzzle.ui.entities.MoveCounter;
import br.com.joaofzm15.slidingPuzzle.ui.entities.Piece;

public class GameScreen implements ActionListener {

	private Frame frame;
	private Board board;
	private MoveCounter moveCounter;
	private GameScreenController controller;

	public Board getBoard() {
		return board;
	}

	public GameScreen() {
		frame = new Frame("background.png");

		moveCounter = new MoveCounter();
		frame.getJFrame().add(moveCounter.getJLabel());

		board = new Board(this);
		frame.getJFrame().add(board.getJLabel());

		controller = new GameScreenController();

		board.refreshButtons();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		board.makeButtonsUnfocusable();
		moveCounter.requestFocus();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		Piece piece = board.getPieceFromItsButton(source);
		boolean moved = controller.movePiece(piece, this);
		if (moved) {
			moveCounter.increaseCounter();
		}
	}

}
