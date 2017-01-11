package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
			SardineModel sardine = new SardineModel(ThreadLocalRandom.current().nextInt(0,sea.getWidth()-1),ThreadLocalRandom.current().nextInt(0,sea.getWidth()-1), sea);
			sea.addFish(sardine);
		}
		
		for(int i=0; i < this.sea.getSharksCount(); i++)
		{
			SharkModel shark = new SharkModel((int) (Math.random() * (sea.getWidth())), (int) (Math.random() * (sea.getHeight())), sea);
			sea.addFish(shark);
		}
	}

	public void startTime() 
	{
		this.cycleCount += 1;
		
		for (Map.Entry<String, FishModel> entry : sea.getFishes().entrySet()) {
			FishModel fish = entry.getValue();
		    fish.liveCycle(this);
		}
		
		System.out.println(sea);
		
		//updateSea();
	}
	
	public void updateSea()
	{
		if(sea.getFishes().isEmpty())
			initGameOfLife();
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
