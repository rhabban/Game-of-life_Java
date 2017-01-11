package controller;

import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.FishModel;
import model.SardineModel;
import model.SeaModel;
import model.SharkModel;

public class WorldController extends JPanel{

	public WorldController(SeaModel sea) {	
		super();
		this.setLayout(new GridLayout(sea.getWidth(), sea.getHeight()));
		for(int i = 0; i < sea.getWidth() * sea.getHeight(); i++) 
		{
			JButton gridCase = new JButton();
			gridCase.setSize(200,200);
		
			Iterator<FishModel> it = sea.getFishes().iterator();
			while(it.hasNext()) 
			{
				FishModel fish = it.next();
				if(fish.getpX()*fish.getpY() == i)
				{
					if (fish instanceof SardineModel)
					{
						
						gridCase.setIcon(new ImageIcon(WorldController.class.getResource("/res/green-square.png")));
						break;
					}
					
					else if (fish instanceof SharkModel)
					{
						gridCase.setIcon(new ImageIcon(WorldController.class.getResource("/res/red-square.png")));
						break;
					}
				}
				
				else
				{
					gridCase.setIcon(new ImageIcon(WorldController.class.getResource("/res/blue-square.png")));
				}
			}
			
			if(sea.getFishes().isEmpty())
				gridCase.setIcon(new ImageIcon(WorldController.class.getResource("/res/blue-square.png")));
			
            this.add(gridCase);
		}
	}
}
