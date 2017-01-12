package model.state;

import java.util.ArrayList;

import model.FishModel;

/**
 * @author bastiensebire
 * Permet de définir le comportement d'un requin lorsqu'il est enfant. Il va ici se déplacer de
 * manière aléatoire et mangera les sardines qu'il rencontrera.
 */
public class ChildState extends BehaviorState 
{
	/* (non-Javadoc)
	 * @see model.state.BehaviorState#move(model.FishModel)
	 */
	public void move(FishModel fish)
	{
		ArrayList<String> emptyCells = fish.getCellsNextToHim(true);
		ArrayList<String> sardinesCells = fish.getCellsNextToHim(false);
		
		ArrayList<String> cells = new ArrayList<>();
		cells.addAll(emptyCells);
		cells.addAll(sardinesCells);
		
		int random = (int)(Math.random() * cells.size()) + 0;
		String newPosition = cells.get(random);
		
		FishModel target = fish.getSea().getFish(newPosition);
		if(target instanceof FishModel){
			target.destroy();
		}
	
		String[] newXY = newPosition.split("-");
		int x = Integer.parseInt(newXY[0]);
		int y = Integer.parseInt(newXY[1]);
		
		fish.setpX(x);
		fish.setpY(y);
	}
}
