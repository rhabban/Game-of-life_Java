package model;

/**
 * @author bastiensebire
 * Une classe SardineModel dérivant du FishModel.
 */
public class SardineModel extends FishModel
{
	private final int DEATH_AGE = 20;
	private final int REPRODUCTION_RATE = 10;
	
	public final int YOUNG_AGE = 10;
	public final int ADULT_AGE = 20;
	
	/**
	 * @param pX
	 * @param pY
	 * @param sea
	 */
	public SardineModel(int pX, int pY, SeaModel sea) 
	{	
		super(pX, pY, sea);
	}

	@Override
	public String toString() 
	{
		return "Sardine"+super.toString(); 
	}

	/* (non-Javadoc)
	 * @see model.FishModel#liveCycle(model.GameOfLifeModel)
	 * Exécute un cycle. Soit le poisson meurt de vieillesse, soit il se reproduit, soit il se déplace.
	 */
	@Override
	public void liveCycle(GameOfLifeModel gameOfLife) 
	{
		setAge(getAge() + 1);
		
		if(getAge() > DEATH_AGE)
			this.destroy();
		
		else if(getAge() % REPRODUCTION_RATE == 0)
			reproduction(this);
		
		else
			this.move();
	}
}
