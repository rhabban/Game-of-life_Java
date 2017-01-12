package controller;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.FishModel;
import model.SardineModel;
import model.SeaModel;
import model.SharkModel;

/**
 * @author Bastien Sebire & Corentin Chupin
 * WorldController permet de générer la grille sur laquelle seront affichés les entités du game of life.
 * Elle prend en paramètre un SeaModel, à partir duquel elle va itérer sur l'ensemble des cases de la 
 * grille afin de créer des sardines, des requins et des cases vides.
 * Elle vérifie l'age des poissons afin d'afficher l'image correspondant à leur état. 
 *
 */
public class WorldController extends JPanel
{

	/**
	 * @param sea
	 */
	public WorldController(SeaModel sea) 
	{	
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
				if(fish.getpX()+fish.getpY()*sea.getWidth() == i)
				{
					if (fish instanceof SardineModel)
					{
						
						SardineModel sardine = (SardineModel) fish;
						String imagePath = null;
						if(sardine.getAge() >= sardine.ADULT_AGE)
							imagePath = "/res/sardine-adult-square.png";
						
						else if(sardine.getAge() <= sardine.YOUNG_AGE)
							imagePath = "/res/sardine-baby-square.png";
						
						else
							imagePath = "/res/sardine-teen-square.png";
						
						ImageIcon imageIcon = new ImageIcon(WorldController.class.getResource(imagePath));
						Image image = imageIcon.getImage();
						Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);  
						imageIcon = new ImageIcon(newimg);
						gridCase.setIcon(imageIcon);
						break;
					}
					
					else if (fish instanceof SharkModel)
					{
						SharkModel shark = (SharkModel) fish;
						String imagePath = null;
						if(shark.getAge() >= shark.ADULT_AGE)
							imagePath = "/res/shark-adult-square.png";
						
						else if(shark.getAge() <= shark.YOUNG_AGE)
							imagePath = "/res/shark-baby-square.png";
						
						else
							imagePath = "/res/shark-teen-square.png";
						
						ImageIcon imageIcon = new ImageIcon(WorldController.class.getResource(imagePath));
						Image image = imageIcon.getImage();
						Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);  
						imageIcon = new ImageIcon(newimg);
						gridCase.setIcon(imageIcon);
						break;
					}
				}
				
				else
					gridCase.setIcon(new ImageIcon(WorldController.class.getResource("/res/sea-square.png")));
			}
			
			if(sea.getFishes().isEmpty())
				gridCase.setIcon(new ImageIcon(WorldController.class.getResource("/res/sea-square.png")));
			
            this.add(gridCase);
		}
	}
}
