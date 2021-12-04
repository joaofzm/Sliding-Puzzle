package br.com.joaofzm15.slidingPuzzle.ui.screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.joaofzm15.slidingPuzzle.logic.GameScreenController;
import br.com.joaofzm15.slidingPuzzle.ui.entities.Board;
import br.com.joaofzm15.slidingPuzzle.ui.entities.Button;
import br.com.joaofzm15.slidingPuzzle.ui.entities.Frame;
import br.com.joaofzm15.slidingPuzzle.ui.entities.MoveCounter;
import br.com.joaofzm15.slidingPuzzle.ui.entities.Piece;

public class GameScreen implements ActionListener {

	private Frame frame;
	private Board board;
	private MoveCounter moveCounter;
	private Button resetButton;	
	private Button exitButton;	
	private GameScreenController controller;

	public Board getBoard() {
		return board;
	}

	public GameScreen() {
		frame = new Frame("background.png");
		
		resetButton = new Button(225, 400, 180, 60, "R E S E T", 0, 0, 0, 22,this);
		frame.getJFrame().add(resetButton.getJButton());
		
		exitButton = new Button(240, 500, 150, 60, "E X I T", 0, 0, 0, 22,this);
		frame.getJFrame().add(exitButton.getJButton());

		moveCounter = new MoveCounter();
		frame.getJFrame().add(moveCounter.getJLabel());
		
		board = new Board(this);
		frame.getJFrame().add(board.getJLabel());

		controller = new GameScreenController();

		refreshComponents();
	}
	
	public void refreshComponents() {
		moveCounter.increaseCounter();
		try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
		moveCounter.resetCounter();
		
		try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
		resetButton.refreshButton();
		try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
		exitButton.refreshButton();
		
		try {Thread.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
		board.refreshButtons();
		try {Thread.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
		board.makeButtonsUnfocusable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==exitButton.getJButton()) {
			frame.dispose();
			return;
		}
		
		JButton source = (JButton) e.getSource();
		Piece piece = board.getPieceFromItsButton(source);
		boolean moved = controller.movePiece(piece, this);
		if (moved) {
			moveCounter.increaseCounter();
		}
		
	}

}
