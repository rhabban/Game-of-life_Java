package model;

public class SardineModel extends FishModel{
	
	private final int DEATH_AGE = 3;
	
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
		}
		
		/*else if(age % reproduction_period == 0)
			reproduction();
		
		else
			behavior.move(this);*/
		
	}
}
