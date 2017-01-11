package model;

public class SharkModel extends FishModel{

	private final int DEATH_AGE = 5;
	
	public SharkModel(int pX, int pY, SeaModel sea) {
		super(pX, pY, sea);
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
		}
		
		/*else if(age % reproduction_period == 0)
			reproduction();
		
		else
			behavior.move(this);*/
		
	}

}
