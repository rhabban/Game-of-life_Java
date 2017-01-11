package model.state;

import java.util.ArrayList;

import model.FishModel;

public class RandomState extends BehaviorState {
	
	public void move(FishModel fish){
		
		int oldX = fish.getpX();
		int oldY = fish.getpY();

		ArrayList<String> cells = fish.getCellsNextToHim(true);
		
		int value = (int)(Math.random() * cells.size()) + 0;
		String newPosition = cells.get(value);
		String[] newXY = newPosition.split("-");
		int x = Integer.parseInt(newXY[0]);
		int y = Integer.parseInt(newXY[1]);
		
		fish.setpX(x);
		fish.setpY(y);
	}
}
