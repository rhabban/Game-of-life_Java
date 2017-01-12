package model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;


/**
 * @author bastiensebire
 * Classe permettant de régir le jeu. Elle génère une mer, créé des poissons et déclenche leurs 
 * diverses actions.
 */
public class GameOfLifeModel 
{
	private SeaModel sea;
	private int cycleCount;
	
	/**
	 * 
	 */
	public GameOfLifeModel() 
	{
		super();
		this.cycleCount = 0;
		this.sea = new SeaModel();
	}
	
	/**
	 * Cette méthode est appelée lors de l'exécution du programme. Elle permet de générer
	 * des sardines ainsi que des requins et de les placer de manière aléatoire sur la grille.
	 * Nous nous assurons de ne pas créer de poisson sur le même emplacement qu'un autre.
	 */
	public void initGameOfLife()
	{
		for(int i=0; i < this.sea.getSardinesCount(); i++)
		{
			while(true)
			{
				int x = ThreadLocalRandom.current().nextInt(0,sea.getWidth()-1);
				int y = ThreadLocalRandom.current().nextInt(0,sea.getWidth()-1);
				FishModel fish = sea.getFish(x,y);

				if(!(fish instanceof FishModel))
				{
					SardineModel sardine = new SardineModel(x,y, sea);
					sea.addFish(sardine);
					break;
				}
			}
		}
		
		for(int i=0; i < this.sea.getSharksCount(); i++)
		{
			SharkModel shark = new SharkModel((int) (Math.random() * (sea.getWidth())), (int) (Math.random() * (sea.getHeight())), sea);
			sea.addFish(shark);
		}
	}

	/**
	 * Cette méthode est appelée à chaque cycle. Elle déclenche le comportement de chaque poisson.
	 */
	public void startTime() 
	{
		this.cycleCount += 1;
		
		ConcurrentHashMap<String, FishModel> fishesX = new ConcurrentHashMap<String, FishModel>(sea.getFishes());
		
		for (Map.Entry<String, FishModel> entry : fishesX.entrySet()) 
		{
			FishModel fish = entry.getValue();
			if(!fish.isDead())
				fish.liveCycle(this);
		}

		updateSea();
	}
	
	/**
	 * S'il n'y a plus de poisson, on relance initGameOfLife.
	 */
	public void updateSea()
	{
		if(sea.getFishes().isEmpty())
		{
			initGameOfLife();
		}
	}
	
	public void startTime(int cyclesCount) {
		
	}

	public int getCycleCount() {
		return cycleCount;
	}

	public void setCycleCount(int cycleCount) {
		this.cycleCount = cycleCount;
	}

	public SeaModel getSea() {
		return sea;
	}

	public void setSea(SeaModel sea) {
		this.sea = sea;
	}

	@Override
	public String toString() {
		return "GameOfLifeController [sea=" + sea + ", fishes=" + sea.getFishes() + "]";
	}
	
	
	
}
