package br.com.joaofzm15.slidingPuzzle.logic;

import java.util.ArrayList;
import java.util.Collections;

import br.com.joaofzm15.slidingPuzzle.ui.entities.Piece;
import br.com.joaofzm15.slidingPuzzle.ui.screens.GameScreen;

public class GameScreenController {
	
	private GameScreen gs;
	public  GameScreenController(GameScreen gameScreen) {
		gs = gameScreen;
	}

	public boolean movePiece(Piece piece) {
		int indexOfEmpty = gs.getBoard().getPieces().indexOf(gs.getBoard().getEmptyPieceReference());
		Piece emptyTile = gs.getBoard().getPieces().get(indexOfEmpty);
		int indexOfPieceToBeMoved = gs.getBoard().getPieces().indexOf(piece);
		
		try {
			if (gs.getBoard().getPieces().get(indexOfPieceToBeMoved + 1) == emptyTile
					&& indexOfEmpty != 4 && indexOfEmpty != 8 &&indexOfEmpty != 12 ) {
				gs.getBoard().switchPieces(piece, emptyTile);
				return true;
			}	
		} catch (IndexOutOfBoundsException e) {
		
		}
		try {
			if (gs.getBoard().getPieces().get(indexOfPieceToBeMoved - 1) == emptyTile
					&& indexOfEmpty != 3 && indexOfEmpty != 7 &&indexOfEmpty != 11 ) {
				gs.getBoard().switchPieces(piece, emptyTile);
				return true;
			}	
		} catch (IndexOutOfBoundsException e) {
		
		}
		try {
			if (gs.getBoard().getPieces().get(indexOfPieceToBeMoved + 4) == emptyTile) {
				gs.getBoard().switchPieces(piece, emptyTile);
				return true;
			}	
		} catch (IndexOutOfBoundsException e) {
		
		}
		try {
			if (gs.getBoard().getPieces().get(indexOfPieceToBeMoved - 4) == emptyTile) {
				gs.getBoard().switchPieces(piece, emptyTile);
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
		emptyPieceReference = new Piece("16.png", gs);
		solvedList.add(emptyPieceReference);
		return solvedList;
	}
	
	public boolean checkVictory() {
		ArrayList<Piece> solvedList = createSolvedList();
		if (gs.getBoard().getPieces().equals(solvedList)) {
			return true;
		}
		return false;
		
	}
}
