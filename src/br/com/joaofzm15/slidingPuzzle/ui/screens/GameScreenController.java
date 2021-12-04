package br.com.joaofzm15.slidingPuzzle.ui.screens;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;

import br.com.joaofzm15.slidingPuzzle.SFX.SoundEffect;
import br.com.joaofzm15.slidingPuzzle.ui.entities.Piece;

public class GameScreenController {
	
	private GameScreen gs;
	public  GameScreenController(GameScreen gameScreen) {
		gs = gameScreen;
	}

	public boolean movePiece(Piece piece) {
		int indexOfEmpty = gs.board.getPieces().indexOf(gs.board.getEmptyPieceReference());
		Piece emptyTile = gs.board.getPieces().get(indexOfEmpty);
		int indexOfPieceToBeMoved = gs.board.getPieces().indexOf(piece);
		
		try {
			if (gs.board.getPieces().get(indexOfPieceToBeMoved + 1) == emptyTile
					&& indexOfEmpty != 4 && indexOfEmpty != 8 &&indexOfEmpty != 12 ) {
				gs.board.switchPieces(piece, emptyTile);
				return true;
			}	
		} catch (IndexOutOfBoundsException e) {
		
		}
		try {
			if (gs.board.getPieces().get(indexOfPieceToBeMoved - 1) == emptyTile
					&& indexOfEmpty != 3 && indexOfEmpty != 7 &&indexOfEmpty != 11 ) {
				gs.board.switchPieces(piece, emptyTile);
				return true;
			}	
		} catch (IndexOutOfBoundsException e) {
		
		}
		try {
			if (gs.board.getPieces().get(indexOfPieceToBeMoved + 4) == emptyTile) {
				gs.board.switchPieces(piece, emptyTile);
				return true;
			}	
		} catch (IndexOutOfBoundsException e) {
		
		}
		try {
			if (gs.board.getPieces().get(indexOfPieceToBeMoved - 4) == emptyTile) {
				gs.board.switchPieces(piece, emptyTile);
				return true;
			}	
		} catch (IndexOutOfBoundsException e) {
		
		}
		return false;
	}
	
	public ArrayList<Piece> createSolvedList(){
		Piece emptyPieceReference;
		ArrayList<Piece> solvedList = new ArrayList<>();
		for (int i = 1; i <= 15; i++) {
			solvedList.add(new Piece(i, gs));
		}
		emptyPieceReference = new Piece();
		solvedList.add(emptyPieceReference);
		return solvedList;
	}
	
	public boolean checkVictory() {
		ArrayList<Piece> solvedList = createSolvedList();
		if (gs.board.getPieces().equals(solvedList)) {
			return true;
		}
		return false;
		
	}

	public void exit() {
		new Thread(new SoundEffect("/clickSound.wav")).start();
		try {
			Thread.sleep(900);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.exit(0);
	}
	
	public void resetBoard() {
		new Thread(new SoundEffect("/clickSound.wav")).start();
		gs.instructionsLabel.makeInvisible();
		gs.solved=false;
		gs.board.reset();
		gs.moveCounter.resetCounter();
		gs.congratulationsMessage.makeInvisible();
	}

	public void victoryWarning() {
		gs.congratulationsMessage.makeVisible();
		gs.solved=true;
		gs.bestLabel.setBest(gs.moveCounter.getMoves());
		new Thread(new SoundEffect("/victory.wav")).start();
	}
	
	public void makeMove(JButton source) {
		if (!gs.solved) {
			Piece piece = gs.board.getPieceFromItsButton(source);
			boolean moved = movePiece(piece);
			if (moved) {
				gs.moveCounter.increaseCounter();
				new Thread(new SoundEffect("/movePieceSound.wav")).start();
			}
			boolean won = checkVictory();
			if (won) {
				victoryWarning();
			}
		}
	}
}

