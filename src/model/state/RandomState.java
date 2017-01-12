package model.state;

import java.util.ArrayList;

import model.FishModel;

/**
 * @author Bastien Sebire & Corentin Chupin
 * Permet de d√©finir un comportement de d√©placement al√©atoire.
 */
public class RandomState extends BehaviorState 
{
	/**
	 * @param fish
	 * DÈplace le poisson alÈatoirement vers une case vide adjacente
	 */
	public void move(FishModel fish)
	{
		ArrayList<String> cells = fish.getCellsNextToHim(true);
		
		if(cells.size()>0)
		{
			int value = (int)(Math.random() * cells.size()) + 0;
			String newPosition = cells.get(value);
			String[] newXY = newPosition.split("-");
			int x = Integer.parseInt(newXY[0]);
			int y = Integer.parseInt(newXY[1]);
			
			fish.setpX(x);
			fish.setpY(y);
		}
	}
}
