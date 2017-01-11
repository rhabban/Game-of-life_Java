package model.state;

import java.util.ArrayList;

import model.FishModel;

public class YoungState extends BehaviorState {
	
	public void move(FishModel fish){

		ArrayList<String> emptyCells = fish.getCellsNextToHim(true);
		ArrayList<String> fullCells = fish.getCellsNextToHim(false);
		System.out.println("fullcells-"+fullCells);
		
		String newPosition;
		int random;
		if(fullCells.size()>0){
			random = (int)(Math.random() * fullCells.size()) + 0;
			newPosition = fullCells.get(random);
			FishModel target = fish.getSea().getFish(newPosition);
			target.destroy();
			System.out.println("Je mange"+target);
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
