package model;

public class SardineModel extends FishModel{
	
	private final int DEATH_AGE = 20;
	private final int REPRODUCTION_RATE = 10;
	
	public final int YOUNG_AGE = 10;
	public final int ADULT_AGE = 20;
	
	
	public SardineModel(int pX, int pY, SeaModel sea) {
		super(pX, pY, sea);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Sardine"+super.toString(); 
	}

	@Override
	public void liveCycle(GameOfLifeModel gameOfLife) {
		setAge(getAge() + 1);
		
		if(getAge() > DEATH_AGE){
			this.destroy();
		} else if(getAge() % REPRODUCTION_RATE == 0){
			reproduction(this);
		} else {
			this.move();
		}

	}
}
