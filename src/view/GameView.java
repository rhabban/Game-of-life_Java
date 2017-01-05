package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import model.FishModel;
import controller.GameOfLifeController;

public class GameView extends JFrame{
	
	public static void main(String[] args) {
		GameView frame = new GameView();
	}
	
	
	public GameView() {
		this.setTitle("Game Of Life");
		this.setSize(500, 350);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		Container cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		this.setVisible(true);
	}
	
}
