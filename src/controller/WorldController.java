package controller;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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
		
			Iterator<Map.Entry<String, FishModel>> it = sea.getFishes().entrySet().iterator();
			while(it.hasNext()) 
			{
				Entry<String, FishModel> pair = it.next();
				FishModel fish = pair.getValue();
				if(fish.getpX()*fish.getpY() == i)
				{
					if (fish instanceof SardineModel)
					{
						ImageIcon imageIcon = new ImageIcon(WorldController.class.getResource("/res/sardine-adult-square.png")); // load the image to a imageIcon
						Image image = imageIcon.getImage();
						Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
						imageIcon = new ImageIcon(newimg);
						gridCase.setIcon(imageIcon);
						break;
					}
					
					else if (fish instanceof SharkModel)
					{
						ImageIcon imageIcon = new ImageIcon(WorldController.class.getResource("/res/shark-adult-square.png")); // load the image to a imageIcon
						Image image = imageIcon.getImage();
						Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
						imageIcon = new ImageIcon(newimg);
						gridCase.setIcon(imageIcon);
						break;
					}
				}
				
				else
				{
					gridCase.setIcon(new ImageIcon(WorldController.class.getResource("/res/sea-square.png")));
				}
			}
			
			if(sea.getFishes().isEmpty())
				gridCase.setIcon(new ImageIcon(WorldController.class.getResource("/res/sea-square.png")));
			
            this.add(gridCase);
		}
	}
}
