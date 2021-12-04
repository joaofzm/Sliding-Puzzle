package br.com.joaofzm15.slidingPuzzle.main;

import br.com.joaofzm15.slidingPuzzle.SFX.BackgroundMusic;
import br.com.joaofzm15.slidingPuzzle.ui.screens.GameScreen;

public class SlidingPuzzle {
	
	public static void main(String[] args) {
		new Thread(new BackgroundMusic()).start();;
		new GameScreen();
	}

}
