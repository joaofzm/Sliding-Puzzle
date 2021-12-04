package br.com.joaofzm15.slidingPuzzle.ui.entities;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;


public class CongratulationsMessage {
	private JLabel congratulationsLabel;
	public JLabel getCongratulationsLabel() {
		return congratulationsLabel;
	}
	private JLabel clickShufflLabel;
	public JLabel getClickShufflLabel() {
		return clickShufflLabel;
	}

	public CongratulationsMessage() {
		congratulationsLabel = new JLabel();
		congratulationsLabel.setBounds(760,-310,1280,720);
		congratulationsLabel.setLayout(null);
		congratulationsLabel.setText("Congratulations!");
		congratulationsLabel.setFont(new Font("Impact",Font.BOLD, 50));
		congratulationsLabel.setForeground(new Color(255,187,0));
		congratulationsLabel.setVisible(false);
		
		clickShufflLabel = new JLabel();
		clickShufflLabel.setBounds(715,315,1280,720);		clickShufflLabel.setLayout(null);
		clickShufflLabel.setText("Click 'shuffle' to play again!");
		clickShufflLabel.setFont(new Font("Impact",Font.BOLD, 40));
		clickShufflLabel.setForeground(new Color(255,187,0));
		clickShufflLabel.setVisible(false);
	}
	
	public void makeVisible() {
		congratulationsLabel.setVisible(true);
		clickShufflLabel.setVisible(true);
	}
	
	public void makeInvisible() {
		congratulationsLabel.setVisible(false);
		clickShufflLabel.setVisible(false);
	}
	
	public void refreshLabel() {
		
	}

}
