package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import model.FishModel;
import model.SeaModel;
import controller.GameOfLifeController;
import controller.WorldController;

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
		
		SeaModel sea = new SeaModel();
		GameOfLifeController gameOfLife = new GameOfLifeController(sea);
		gameOfLife.initGameOfLife();
		
		WorldController world = new WorldController(gameOfLife.getSea());
		Container cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(world,BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
}
