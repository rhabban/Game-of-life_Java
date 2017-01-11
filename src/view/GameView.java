package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

import model.FishModel;
import model.SeaModel;
import controller.GameOfLifeController;
import controller.WorldController;

public class GameView extends JFrame{
	private GameOfLifeController gameOfLife;
	private WorldController world;
	private Container container;
	public static void main(String[] args) {
		GameView frame = new GameView();
	}
	
	public GameView() {
		this.setTitle("Game Of Life");
		this.setSize(500, 350);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		gameOfLife = new GameOfLifeController();
		gameOfLife.initGameOfLife();
		
		world = new WorldController(gameOfLife.getSea());
		container = this.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(world,BorderLayout.CENTER);
		
		this.setVisible(true);
		
		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				gameOfLife.startTime();
				world = new WorldController(gameOfLife.getSea());
				container.add(world,BorderLayout.CENTER);
				container.repaint();
				setVisible(true);
				
			}
        };
        
		Timer timer = new Timer(2000 ,taskPerformer);
        timer.start();
	}
	
}
