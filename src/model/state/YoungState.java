package model.state;

import java.util.ArrayList;

import model.FishModel;

public class YoungState extends BehaviorState {
	
	public void move(FishModel fish){

		ArrayList<String> emptyCells = fish.getCellsNextToHim(false);
		ArrayList<String> fullCells = fish.getCellsNextToHim(true);
		
		String newPosition;
		int random;
		if(fullCells.size()>0){
			random = (int)(Math.random() * fullCells.size()) + 0;
			newPosition = fullCells.get(random);
		} else {
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
