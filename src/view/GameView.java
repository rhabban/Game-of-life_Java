package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import model.FishModel;
import model.GameOfLifeModel;
import model.SeaModel;
import controller.WorldController;

public class GameView extends JFrame{
	private GameOfLifeModel gameOfLife;
	private WorldController world;
	private Container container;
	private JLabel countLabel;
	public static void main(String[] args) {
		GameView frame = new GameView();
	}
	
	public GameView() {
		this.setTitle("Game Of Life");
		this.setSize(1000, 650);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		gameOfLife = new GameOfLifeModel();
		gameOfLife.initGameOfLife();
		
		world = new WorldController(gameOfLife.getSea());
		container = this.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(world,BorderLayout.CENTER);
		
		countLabel = new JLabel();
		countLabel.setText("Cycle : " + String.valueOf(gameOfLife.getCycleCount()));
		container.add(countLabel, BorderLayout.SOUTH);
		
		this.setVisible(true);
		
		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				gameOfLife.startTime();
				world = new WorldController(gameOfLife.getSea());
				container.add(world,BorderLayout.CENTER);
				countLabel.setText("Cycle : " + String.valueOf(gameOfLife.getCycleCount()));
				container.add(countLabel, BorderLayout.SOUTH);
				container.repaint();
				setVisible(true);
				
			}
        };
        
		Timer timer = new Timer(700 ,taskPerformer);
        timer.start();
	}
	
}
