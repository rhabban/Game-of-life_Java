package controller;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.SeaModel;

public class WorldController extends JPanel{

	public WorldController(SeaModel sea) {	
		super();
		this.setLayout(new GridLayout(sea.getWidth(), sea.getHeight()));
		for(int i = 0 ;i<sea.getWidth() * sea.getHeight() ; i++) {
			JButton btn = new JButton();
			btn.setSize(200,200);
			btn.setIcon(new ImageIcon(WorldController.class.getResource("/res/carre.png")));
            this.add(btn);
		}
	}
}
