package br.com.joaofzm15.slidingPuzzle.ui.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Button {

	JButton jButton;

	public JButton getJButton() {
		return jButton;
	}

	public Button(int x, int y, int xSize, int ySize, String text, int red, int green, int blue, int fontSize,ActionListener actionListener) {
		jButton = new JButton();
		jButton.setBounds(x, y, xSize, ySize);
		jButton.setText(text);
		jButton.addActionListener(actionListener);
		jButton.setFont(new Font("Impact", Font.BOLD, fontSize));
		jButton.setForeground(Color.white);
		jButton.setBackground(new Color(red, green, blue));
		jButton.setBorder(BorderFactory.createLineBorder(Color.white));
		jButton.setFocusable(true);
	}

	public void requestFocus() {
		jButton.requestFocus();
	}

	public void makeButtonsUnfocusable() {
		jButton.setFocusable(false);
	}

	public void setVisible(boolean value) {
		jButton.setVisible(value);
	}
}
