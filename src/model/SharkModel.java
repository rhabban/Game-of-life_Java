package model;
import model.state.*;

public class SharkModel extends FishModel{

	private final int DEATH_AGE = 35;
	private final int REPRODUCTION_RATE = 18;
	
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
		
		if(getAge() > DEATH_AGE)
			this.destroy();
		
		else if(getAge() % REPRODUCTION_RATE == 0)
			reproduction(this);
		
		else
			this.move();
		
	}

}
