package br.com.joaofzm15.slidingPuzzle.SFX;


public class BackgroundMusic implements Runnable {
	
	private SoundEffectConverter soundEffectConverter = new SoundEffectConverter();

	String soundPath = "/bgmusic.wav";

	/*
	 * The Thread runs a infinity loop that sleeps for 194000 milliseconds, which is
	 * the exact duration of the song, this way the song will run indefinitely,
	 * restarting every time it ends.
	 */
	@Override
	public void run() {
		while (true) {
			soundEffectConverter.setFile(soundPath);
			soundEffectConverter.play();
			try {
				Thread.sleep(194000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
