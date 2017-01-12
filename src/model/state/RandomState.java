package model.state;

import java.util.ArrayList;

import model.FishModel;

/**
 * @author bastiensebire
 * Permet de définir un comportement de déplacement aléatoire.
 */
public class RandomState extends BehaviorState 
{
	/* (non-Javadoc)
	 * @see model.state.BehaviorState#move(model.FishModel)
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
