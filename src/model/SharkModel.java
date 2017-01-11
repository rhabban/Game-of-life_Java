package model;
import model.state.*;

public class SharkModel extends FishModel{

	private final int DEATH_AGE = 35;
	private final int REPRODUCTION_RATE = 18;
	private final int CYCLE_WITHOUT_EAT_TO_DIE = 20;
	private int countSinceLastMeal = 0;
	
	public SharkModel(int pX, int pY, SeaModel sea) {
		super(pX, pY, sea);
		setBehavior(new YoungState());
	}
	
	public int getCountSinceLastMeal() {
		return countSinceLastMeal;
	}

	public void setCountSinceLastMeal(int countSinceLastMeal) {
		this.countSinceLastMeal = countSinceLastMeal;
	}

	@Override
	public String toString() {
		return "Shark"+super.toString(); 
	}

	@Override
	public void liveCycle(GameOfLifeModel gameOfLife) {
		setAge(getAge() + 1);
		
		if(getAge() > DEATH_AGE || getCountSinceLastMeal() > CYCLE_WITHOUT_EAT_TO_DIE)
			this.destroy();
		
		else if(getAge() % REPRODUCTION_RATE == 0)
			reproduction(this);
		
		else
		{
			this.move();
			setCountSinceLastMeal(getCountSinceLastMeal()+1);
		}
			
		
	}

}
