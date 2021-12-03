package br.com.joaofzm15.slidingPuzzle.logic;

import br.com.joaofzm15.slidingPuzzle.ui.entities.Piece;
import br.com.joaofzm15.slidingPuzzle.ui.screens.GameScreen;

public class GameScreenController {

	public void movePiece(Piece piece, GameScreen gs) {
		int indexOfEmpty = gs.getBoard().getPieces().indexOf(gs.getBoard().getEmptyPieceReference());
		Piece emptyTile = gs.getBoard().getPieces().get(indexOfEmpty);
		int indexOfPieceToBeMoved = gs.getBoard().getPieces().indexOf(piece);
		
		try {
			if (gs.getBoard().getPieces().get(indexOfPieceToBeMoved + 1) == emptyTile) {
				gs.getBoard().switchPieces(piece, emptyTile);
			}	
		} catch (IndexOutOfBoundsException e) {
		
		}
		try {
			if (gs.getBoard().getPieces().get(indexOfPieceToBeMoved - 1) == emptyTile) {
				gs.getBoard().switchPieces(piece, emptyTile);
			}	
		} catch (IndexOutOfBoundsException e) {
		
		}
		try {
			if (gs.getBoard().getPieces().get(indexOfPieceToBeMoved + 4) == emptyTile) {
				gs.getBoard().switchPieces(piece, emptyTile);
			}	
		} catch (IndexOutOfBoundsException e) {
		
		}
		try {
			if (gs.getBoard().getPieces().get(indexOfPieceToBeMoved - 4) == emptyTile) {
				gs.getBoard().switchPieces(piece, emptyTile);
			}	
		} catch (IndexOutOfBoundsException e) {
		
		}

	}
}
