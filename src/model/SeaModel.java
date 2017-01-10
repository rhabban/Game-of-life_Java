package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SeaModel {

	protected int sharksCount;
	protected int sardinesCount;
	protected int width = 10;
	protected int height = 10;
	protected FishModel cells[][];
	protected ArrayList<FishModel> fishes = new ArrayList<>();

	protected HashMap<String, FishModel> fishesX = new HashMap<>();
	
	
	public SeaModel() {
		this.sharksCount = 2;
		this.sardinesCount = 3;
		this.cells = new FishModel [this.width][this.height];
	}

	public SeaModel(int sharksCount, int sardinesCount, int width, int height) {
		super();
		this.sharksCount = sharksCount;
		this.sardinesCount = sardinesCount;
		this.width = width;
		this.height = height;
		this.cells = new FishModel [width][height];
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

	public FishModel[][] getCells() {
		return cells;
	}

	public void setCells(FishModel[][] cells) {
		this.cells = cells;
	}

	public ArrayList<FishModel> getFishes() {
		return fishes;
	}

	public void setFishes(ArrayList<FishModel> fishes) {
		this.fishes = fishes;
	}

	@Override
	public String toString() {
		return "Sea [sharksCount=" + sharksCount + ", sardinesCount=" + sardinesCount + ", width=" + width + ", height="
				+ height + ", cells=" + Arrays.toString(cells) + "]";
	}
	
	
	
	
	
	
}
