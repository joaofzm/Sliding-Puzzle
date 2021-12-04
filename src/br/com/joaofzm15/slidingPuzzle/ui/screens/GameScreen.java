package br.com.joaofzm15.slidingPuzzle.ui.screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.joaofzm15.slidingPuzzle.ui.entities.BestLabel;
import br.com.joaofzm15.slidingPuzzle.ui.entities.Board;
import br.com.joaofzm15.slidingPuzzle.ui.entities.Button;
import br.com.joaofzm15.slidingPuzzle.ui.entities.CongratulationsLabel;
import br.com.joaofzm15.slidingPuzzle.ui.entities.Frame;
import br.com.joaofzm15.slidingPuzzle.ui.entities.InstructionsLabel;
import br.com.joaofzm15.slidingPuzzle.ui.entities.MoveCounter;

public class GameScreen implements ActionListener {
	
	protected GameScreenController controller;

	protected Frame frame;
	protected Board board;
	protected MoveCounter moveCounter;
	protected BestLabel bestLabel;
	protected Button shuffleButton;
	protected Button exitButton;
	protected boolean solved;
	protected CongratulationsLabel congratulationsMessage;
	protected InstructionsLabel instructionsLabel;

	public GameScreen() {

		controller = new GameScreenController(this);
		
		solved = true;
		frame = new Frame("background.png");

		congratulationsMessage = new CongratulationsLabel();
		frame.getJFrame().add(congratulationsMessage.getCongratulationsLabel());
		frame.getJFrame().add(congratulationsMessage.getClickShufflLabel());

		instructionsLabel = new InstructionsLabel();
		frame.getJFrame().add(instructionsLabel.getInstructionsLabel1());
		frame.getJFrame().add(instructionsLabel.getInstructionsLabel2());

		shuffleButton = new Button(225, 500, 180, 60, "S H U F F L E", 0, 0, 130, 26, this);
		frame.getJFrame().add(shuffleButton.getJButton());

		exitButton = new Button(240, 600, 150, 60, "E X I T", 100, 0, 0, 22, this);
		frame.getJFrame().add(exitButton.getJButton());

		bestLabel = new BestLabel();
		frame.getJFrame().add(bestLabel.getJLabel());

		moveCounter = new MoveCounter();
		frame.getJFrame().add(moveCounter.getJLabel());

		board = new Board(this);
		frame.getJFrame().add(board.getJLabel());

		refreshComponents();
	}

	
	public void threadSleep20() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	This method is required as a workaround interaction for java swing no properly showing the
	components when the program loads.
	By doing one action on all the components, such as updating it's text or just commanding it to
	request focus, we can guarantee all components will be shown.
	*/
	public void refreshComponents() {
		moveCounter.increaseCounter();
		threadSleep20();
		moveCounter.resetCounter();
		
		bestLabel.setBest(Integer.MAX_VALUE);
		threadSleep20();
		bestLabel.getJLabel().setText("Best : -");
		
		threadSleep20();
		shuffleButton.requestFocus();
		threadSleep20();
		exitButton.requestFocus();
		threadSleep20();
		shuffleButton.makeButtonsUnfocusable();
		exitButton.makeButtonsUnfocusable();
		
		threadSleep20();
		instructionsLabel.makeVisible();
		
		threadSleep20();
		board.refreshButtons();
		threadSleep20();
		board.makeButtonsUnfocusable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == exitButton.getJButton()) {
			controller.exit();
			return;
		}

		if (e.getSource() == shuffleButton.getJButton()) {
			controller.resetBoard();
			return;
		}

		if (!solved) {
			JButton source = (JButton) e.getSource();
			controller.makeMove(source);
		}
	}

}
