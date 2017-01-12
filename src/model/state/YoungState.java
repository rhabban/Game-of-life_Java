package model.state;

import java.util.ArrayList;

import model.FishModel;
import model.SharkModel;

/**
 * @author bastiensebire
 * Le requin adolescent va commencer à cibler des sardines à proximité.
 */
public class YoungState extends BehaviorState 
{
	/* (non-Javadoc)
	 * @see model.state.BehaviorState#move(model.FishModel)
	 */
	public void move(FishModel fish)
	{
		ArrayList<String> emptyCells = fish.getCellsNextToHim(true);
		ArrayList<String> sardinesCells = fish.getCellsNextToHim(false);
		
		String newPosition;
		int random;
		
		if(sardinesCells.size()>0)
		{
			random = (int)(Math.random() * sardinesCells.size()) + 0;
			newPosition = sardinesCells.get(random);
			FishModel target = fish.getSea().getFish(newPosition);
			target.destroy();
			SharkModel shark = (SharkModel) fish;
			shark.setCountSinceLastMeal(0);

			System.out.println("Un requin a mangé une sardine.");
		} 
		
		else 
		{
			random = (int)(Math.random() * emptyCells.size()) + 0;
			newPosition = emptyCells.get(random);
		}
		
		String[] newXY = newPosition.split("-");
		int x = Integer.parseInt(newXY[0]);
		int y = Integer.parseInt(newXY[1]);
		
		fish.setpX(x);
		fish.setpY(y);
	}
}
