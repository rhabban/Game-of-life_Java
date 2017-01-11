package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import model.FishModel;
import model.SardineModel;
import model.SeaModel;
import model.SharkModel;

public class GameOfLifeController {

	SeaModel sea;
	ArrayList<FishModel> fishes = new ArrayList<>();
	
	public GameOfLifeController() {
		super();
		this.sea = new SeaModel();
	}
	
	public void initGameOfLife()
	{
		for(int i=0; i < this.sea.getSardinesCount(); i++)
		{
			SardineModel sardine = new SardineModel(0,false, (int) (Math.random() * (sea.getWidth())), (int) (Math.random() * (sea.getHeight())), sea);
			fishes.add(sardine);
		}
		
		for(int i=0; i < this.sea.getSharksCount(); i++)
		{
			SharkModel shark = new SharkModel(0,false, (int) (Math.random() * (sea.getWidth())), (int) (Math.random() * (sea.getHeight())), sea);
			fishes.add(shark);
		}
		
		sea.setFishes(fishes);
	}

	public void startTime() 
	{
		setFishes(new ArrayList<>());
		initGameOfLife();
	}
	
	public void startTime(int cyclesCount) {
		
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
