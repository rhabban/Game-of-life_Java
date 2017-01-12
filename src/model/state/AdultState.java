package model.state;

import java.util.ArrayList;

import model.FishModel;

public class AdultState extends BehaviorState {
	
	public void move(FishModel fish){

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
