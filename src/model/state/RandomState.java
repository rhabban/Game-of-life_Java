package model.state;

import model.FishModel;

public class RandomState extends BehaviorState {
	
	public void move(FishModel fish){
		
		int value = (int)(Math.random() * 4) + 0;
		switch(value){
			case 0:
				//action
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
		}
	}
}
