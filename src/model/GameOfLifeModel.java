package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

public class GameOfLifeModel {

	private SeaModel sea;
	private ArrayList<FishModel> fishes = new ArrayList<>();
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
			SardineModel sardine = new SardineModel((int) (Math.random() * (sea.getWidth())), (int) (Math.random() * (sea.getHeight())), sea);
			fishes.add(sardine);
		}
		
		for(int i=0; i < this.sea.getSharksCount(); i++)
		{
			SharkModel shark = new SharkModel((int) (Math.random() * (sea.getWidth())), (int) (Math.random() * (sea.getHeight())), sea);
			fishes.add(shark);
		}
		
		sea.setFishes(fishes);
	}

	public void startTime() 
	{
		this.cycleCount += 1;
		
		for(FishModel fish : this.fishes)
		{
			fish.liveCycle(this);
		}
		
		updateSea();
	}
	
	public void updateSea()
	{
		this.getSea().removeDeadFishes();
		if(fishes.isEmpty())
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

	public ArrayList<FishModel> getFishes() {
		return fishes;
	}

	public void setFishes(ArrayList<FishModel> fishes) {
		this.fishes = fishes;
	}

	@Override
	public String toString() {
		return "GameOfLifeController [sea=" + sea + ", fishes=" + fishes + "]";
	}
	
	
	
}
