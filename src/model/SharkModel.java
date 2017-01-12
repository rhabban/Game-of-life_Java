package model;
import model.state.*;

/**
 * @author Bastien Sebire & Corentin Chupin
 * Une classe SharkModel dérivant du FishModel.
 */
public class SharkModel extends FishModel
{
	private final int DEATH_AGE = 40;
	private final int REPRODUCTION_RATE = 15;
	private final int CYCLE_WITHOUT_EAT_TO_DIE = 20;
	private int countSinceLastMeal = 0;
	
	public final int YOUNG_AGE = 12;
	public final int ADULT_AGE = 28;
	
	/**
	 * @param pX
	 * @param pY
	 * @param sea
	 */
	public SharkModel(int pX, int pY, SeaModel sea) 
	{
		super(pX, pY, sea);
		setBehavior(new ChildState());
	}
	
	/* (non-Javadoc)
	 * @see model.FishModel#liveCycle(model.GameOfLifeModel)
	 * Exécute un cycle. Soit le poisson meurt de vieillesse, soit il se reproduit, soit il se déplace.
	 * Le requin meurt s'il n'a pas mangé depuis un temps défini.
	 * Le comportement du requin est défini en fonction de son âge.
	 */
	@Override
	public void liveCycle(GameOfLifeModel gameOfLife) 
	{
		setAge(getAge() + 1);
		
		if(getAge() == YOUNG_AGE){
			setBehavior(new YoungState());
			System.out.println("Un requin devient jeune adulte");
		}
		
		if(getAge() > DEATH_AGE || getCountSinceLastMeal() > CYCLE_WITHOUT_EAT_TO_DIE)
		{
			System.out.println("Un requin est mort de faim.");
			this.destroy();
		}
			
		else if(getAge() % REPRODUCTION_RATE == 0)
			reproduction(this);
		
		else
		{
			this.move();
			setCountSinceLastMeal(getCountSinceLastMeal()+1);
		}
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
}
