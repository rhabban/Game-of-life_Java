package model;
import model.state.*;

public class SharkModel extends FishModel{

	private final int DEATH_AGE = 2;
	
	public SharkModel(int pX, int pY, SeaModel sea) {
		super(pX, pY, sea);
		setBehavior(new YoungState());
	}

	@Override
	public String toString() {
		return "Shark"+super.toString(); 
	}

	@Override
	public void liveCycle(GameOfLifeModel gameOfLife) {
		setAge(getAge() + 1);
		
		if(getAge() > DEATH_AGE){
			this.destroy();
		} else {
			this.move();
		}
		
	}

}
