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

/**
 * @author bastiensebire
 * Il s'agit de la vue du game of life, qui hérite d'une JFrame. Elle va permettre d'afficher l'ensemble
 * des cases. Nous utilisons un objet de type Timer afin de mettre à jour les déplacement et la grille.
 */

public class GameView extends JFrame
{
	private GameOfLifeModel gameOfLife;
	private WorldController world;
	private Container container;
	private JLabel countLabel;
	
	public static void main(String[] args) 
	{
		GameView frame = new GameView();
	}
	
	public GameView() 
	{
		this.setTitle("Game Of Life");
		this.setSize(1000, 650);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		gameOfLife = new GameOfLifeModel();
		gameOfLife.initGameOfLife();
		System.out.println("Le jeu commence.");
		
		world = new WorldController(gameOfLife.getSea());
		container = this.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(world,BorderLayout.CENTER);
		
		countLabel = new JLabel();
		countLabel.setText("Cycle : " + String.valueOf(gameOfLife.getCycleCount()));
		container.add(countLabel, BorderLayout.SOUTH);
		
		this.setVisible(true);
		
		// Mise à jour de la grille du game of life.
		ActionListener taskPerformer = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
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
