package br.com.joaofzm15.slidingPuzzle.ui.entities;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;


public class InstructionsLabel {
	private JLabel instructionsLabel1;
	public JLabel getInstructionsLabel1() {
		return instructionsLabel1;
	}
	
	private JLabel instructionsLabel2;
	public JLabel getInstructionsLabel2() {
		return instructionsLabel2;
	}

	public InstructionsLabel() {
		instructionsLabel1 = new JLabel();
		instructionsLabel1.setBounds(682,-310,1280,720);
		instructionsLabel1.setLayout(null);
		instructionsLabel1.setText("Arrange the pieces in numerical order!");
		instructionsLabel1.setFont(new Font("Impact",Font.BOLD, 32));
		instructionsLabel1.setForeground(new Color(255,187,0));
		instructionsLabel1.setVisible(false);
		
		instructionsLabel2 = new JLabel();
		instructionsLabel2.setBounds(640,315,1280,720);
		instructionsLabel2.setLayout(null);
		instructionsLabel2.setText("Like the example above! Click 'shuffle' to start!");
		instructionsLabel2.setFont(new Font("Impact",Font.BOLD, 31));
		instructionsLabel2.setForeground(new Color(255,187,0));
		instructionsLabel2.setVisible(false);
	}
	
	public void makeVisible() {
		instructionsLabel1.setVisible(true);
		instructionsLabel2.setVisible(true);
	}
	
	public void makeInvisible() {
		instructionsLabel1.setVisible(false);
		instructionsLabel2.setVisible(false);
	}
	
}
