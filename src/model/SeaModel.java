package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class SeaModel {

	protected int sharksCount;
	protected int sardinesCount;
	protected int width = 10;
	protected int height = 10;
	
	protected ArrayList<FishModel> fishesX;

	protected ConcurrentHashMap<String, FishModel> fishes = new ConcurrentHashMap<>();
	
	public SeaModel() {
		this.sharksCount = 1;
		this.sardinesCount = 2;
	}

	public SeaModel(int sharksCount, int sardinesCount, int width, int height) {
		super();
		this.sharksCount = sharksCount;
		this.sardinesCount = sardinesCount;
		this.width = width;
		this.height = height;
	}
	
	public ArrayList<String> getCellsNextToFish(FishModel fish){
		int x = fish.getpX();
		int y = fish.getpY();
		ArrayList<String> cells = new ArrayList<>();
		
		if(x > 0){
			cells.add((x-1)+"-"+y);
		}
		if(x < this.width-1){
			cells.add((x+1)+"-"+y);
		}
		if(y > 0){
			cells.add(x+"-"+(y-1));
		}
		if(y < this.height-1){
			cells.add(x+"-"+(y+1));
		}
		return cells;
	}
	
	public ArrayList<String> getCellsNextToFish(FishModel fish, boolean empty){
		ArrayList<String> cells = getCellsNextToFish(fish);
		ArrayList<String> calculatedCells = new ArrayList<>();
		for(String cell : cells){
			FishModel fishOnCell = getFish(cell);
			if(empty){
				if(!(fishOnCell instanceof FishModel)){
					calculatedCells.add(cell);
				}
			} else {
				if(fishOnCell instanceof SardineModel){
					calculatedCells.add(cell);
				}
			}
		}
		return calculatedCells;
	}
	
	public FishModel getFish(int x, int y){
		return getFish(x+"-"+y);
	}
	
	public FishModel getFish(String xy){
		return this.fishes.get(xy);
	}
	
	public void addFish(FishModel fish){
		String position = fish.getpXY();
		this.fishes.put(position, fish);
	}
	
	public void setFishPosition(String newPosition, String oldPosition){
		FishModel fish = fishes.get(oldPosition);
		fishes.remove(oldPosition);
		FishModel fish2 = fishes.get(newPosition);
		fishes.put(newPosition, fish);
	}
	
	public void removeFish(FishModel fish){
		fishes.remove(fish.getpXY());
	}
	
	public ArrayList<FishModel> getFishesX() {
		return fishesX;
	}

	public void setFishesX(ArrayList<FishModel> fishesX) {
		this.fishesX = fishesX;
	}

	public int getSharksCount() {
		return sharksCount;
	}

	public void setSharksCount(int sharksCount) {
		this.sharksCount = sharksCount;
	}

	public int getSardinesCount() {
		return sardinesCount;
	}

	public void setSardinesCount(int sardinesCount) {
		this.sardinesCount = sardinesCount;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ConcurrentHashMap<String, FishModel> getFishes() {
		return fishes;
	}

	public void setFishes(ArrayList<FishModel> fishes) {
		for(FishModel fish: fishes){
			addFish(fish);
		}
	}

	@Override
	public String toString() {
		return "Sea [sharksCount=" + sharksCount + ", sardinesCount=" + sardinesCount + ", width=" + width + ", height="
				+ height + ", fishes=" + fishes + "]";
	}
	
}
