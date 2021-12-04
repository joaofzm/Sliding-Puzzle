package br.com.joaofzm15.slidingPuzzle.ui.screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.joaofzm15.slidingPuzzle.SFX.SoundEffect;
import br.com.joaofzm15.slidingPuzzle.logic.GameScreenController;
import br.com.joaofzm15.slidingPuzzle.ui.entities.BestLabel;
import br.com.joaofzm15.slidingPuzzle.ui.entities.Board;
import br.com.joaofzm15.slidingPuzzle.ui.entities.Button;
import br.com.joaofzm15.slidingPuzzle.ui.entities.CongratulationsMessage;
import br.com.joaofzm15.slidingPuzzle.ui.entities.Frame;
import br.com.joaofzm15.slidingPuzzle.ui.entities.MoveCounter;
import br.com.joaofzm15.slidingPuzzle.ui.entities.Piece;

public class GameScreen implements ActionListener {

	private Frame frame;
	private Board board;
	private MoveCounter moveCounter;
	private BestLabel bestLabel;
	private Button shuffleButton;	
	private Button exitButton;	
	private boolean solved;
	private CongratulationsMessage congratulationsMessage;
	private GameScreenController controller;


	public Board getBoard() {
		return board;
	}

	public GameScreen() {
		frame = new Frame("background.png");
		
		congratulationsMessage = new CongratulationsMessage();
		frame.getJFrame().add(congratulationsMessage.getCongratulationsLabel());
		frame.getJFrame().add(congratulationsMessage.getClickShufflLabel());
		
		shuffleButton = new Button(225, 500, 180, 60, "S H U F F L E", 0, 0, 130, 26,this);
		frame.getJFrame().add(shuffleButton.getJButton());
		
		exitButton = new Button(240, 600, 150, 60, "E X I T", 100, 0, 0, 22,this);
		frame.getJFrame().add(exitButton.getJButton());
		
		bestLabel = new BestLabel();
		frame.getJFrame().add(bestLabel.getJLabel());

		moveCounter = new MoveCounter();
		frame.getJFrame().add(moveCounter.getJLabel());
		
		board = new Board(this);
		frame.getJFrame().add(board.getJLabel());

		controller = new GameScreenController(this);

		refreshComponents();
	}
	
	public void refreshComponents() {
		moveCounter.increaseCounter();
		try {Thread.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
		moveCounter.resetCounter();
		
		bestLabel.setBest(10000000);
		try {Thread.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
		bestLabel.getJLabel().setText("Best : -");
		
		try {Thread.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
		shuffleButton.refreshButton();
		try {Thread.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
		exitButton.refreshButton();
		
		try {Thread.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
		board.refreshButtons();
		try {Thread.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
		board.makeButtonsUnfocusable();
		try {Thread.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
		shuffleButton.makeButtonsUnfocusable();
		exitButton.makeButtonsUnfocusable();
	}
	
	public void resetBoard() {
		solved=false;
		board.reset();
		moveCounter.resetCounter();
		congratulationsMessage.makeInvisible();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == exitButton.getJButton()) {
			new Thread(new SoundEffect("/clickSound.wav")).start();
			try {
				Thread.sleep(900);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.exit(0);
		}
		
		if (e.getSource()==shuffleButton.getJButton()) {
			new Thread(new SoundEffect("/clickSound.wav")).start();
			resetBoard();
			return;
		}
		
		if (!solved) {
			JButton source = (JButton) e.getSource();
			Piece piece = board.getPieceFromItsButton(source);
			boolean moved = controller.movePiece(piece);
			if (moved) {
				moveCounter.increaseCounter();
				new Thread(new SoundEffect("/movePieceSound.wav")).start();
			}
			boolean won = controller.checkVictory();
			if (won) {
				congratulationsMessage.makeVisible();
				solved=true;
				bestLabel.setBest(moveCounter.getMoves());
				new Thread(new SoundEffect("/victory.wav")).start();
			}
		}
		
	}

}
