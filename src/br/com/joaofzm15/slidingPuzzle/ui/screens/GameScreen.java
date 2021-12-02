package br.com.joaofzm15.slidingPuzzle.ui.screens;

import br.com.joaofzm15.slidingPuzzle.ui.entities.Board;
import br.com.joaofzm15.slidingPuzzle.ui.entities.Frame;

public class GameScreen {

	private Frame frame;
	private Board board;
	
	public GameScreen() {
		frame = new Frame("background.png");
		board = new Board();
		addBoardToFrame(board);
	}
	
	public void addBoardToFrame (Board board) {
		frame.getJFrame().add(board.getJLabel());
	}
	
	

}
