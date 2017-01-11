package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.Timer;

public class GameOfLifeModel {

	private SeaModel sea;
	private int cycleCount;
	
	public GameOfLifeModel() {
		super();
		this.cycleCount = 0;
		this.sea = new SeaModel();
	}
	
	public void initGameOfLife()
	{
		for(int i=0; i < this.sea.getSardinesCount(); i++)
		{
			while(true){
				int x = ThreadLocalRandom.current().nextInt(0,sea.getWidth()-1);
				int y = ThreadLocalRandom.current().nextInt(0,sea.getWidth()-1);
				FishModel fish = sea.getFish(x,y);

				if(!(fish instanceof FishModel)){
					SardineModel sardine = new SardineModel(x,y, sea);
					sea.addFish(sardine);
					break;
				}

				System.out.println(x);
				System.out.println(y);
			}
		}
		
		for(int i=0; i < this.sea.getSharksCount(); i++)
		{
			SharkModel shark = new SharkModel((int) (Math.random() * (sea.getWidth())), (int) (Math.random() * (sea.getHeight())), sea);
			sea.addFish(shark);
		}
	}

	public void startTime() 
	{

		System.out.println(sea);
		this.cycleCount += 1;
		
		ConcurrentHashMap<String, FishModel> fishesX = new ConcurrentHashMap<String, FishModel>(sea.getFishes());
		
		for (Map.Entry<String, FishModel> entry : fishesX.entrySet()) {
			FishModel fish = entry.getValue();
		    fish.liveCycle(this);
		}

		updateSea();
	}
	
	public void updateSea()
	{
		if(sea.getFishes().isEmpty()){
			System.out.println("empty");
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
