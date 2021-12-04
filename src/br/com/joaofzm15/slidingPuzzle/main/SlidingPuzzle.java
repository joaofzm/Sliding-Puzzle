package br.com.joaofzm15.slidingPuzzle.main;

import br.com.joaofzm15.slidingPuzzle.SFX.BackgroundMusic;
import br.com.joaofzm15.slidingPuzzle.ui.screens.GameScreen;

public class SlidingPuzzle {
	
	public static void main(String[] args) {
		Thread bgMusic = new Thread(new BackgroundMusic());
		bgMusic.start();
		new GameScreen();
	}

}
