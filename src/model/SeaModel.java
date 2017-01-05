package model;

import java.util.Arrays;

import model.FishModel;

public class SeaModel {

	protected int sharksCount;
	protected int sardinesCount;
	protected int width = 5;
	protected int height = 5;
	protected FishModel cells[][];
	
	public SeaModel() {
		this.sharksCount = 1;
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

	@Override
	public String toString() {
		return "Sea [sharksCount=" + sharksCount + ", sardinesCount=" + sardinesCount + ", width=" + width + ", height="
				+ height + ", cells=" + Arrays.toString(cells) + "]";
	}
	
	
	
	
	
	
}
