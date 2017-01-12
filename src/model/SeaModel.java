package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author bastiensebire
 * SeaModel permet de créer une mer avec des sardines et des requins. On précise le nombre de poissons
 * ainsi que la taille de la grille.
 */
public class SeaModel 
{
	protected int sharksCount;
	protected int sardinesCount;
	protected int width = 10;
	protected int height = 10;
	
	protected ArrayList<FishModel> fishesX;
	protected ConcurrentHashMap<String, FishModel> fishes = new ConcurrentHashMap<>();
	
	public SeaModel() 
	{
		
		this.sharksCount = 1;
		this.sardinesCount = 2;
	}

	/**
	 * @param sharksCount
	 * @param sardinesCount
	 * @param width
	 * @param height
	 */
	public SeaModel(int sharksCount, int sardinesCount, int width, int height) 
	{
		super();
		this.sharksCount = sharksCount;
		this.sardinesCount = sardinesCount;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * @param fish
	 * @return
	 * Récupère toutes les cases autour d'un poisson.
	 */
	public ArrayList<String> getCellsNextToFish(FishModel fish)
	{
		int x = fish.getpX();
		int y = fish.getpY();
		ArrayList<String> cells = new ArrayList<>();
		
		if(x > 0)
			cells.add((x-1)+"-"+y);
		if(x < this.width-1)
			cells.add((x+1)+"-"+y);
		if(y > 0)
			cells.add(x+"-"+(y-1));
		if(y < this.height-1)
			cells.add(x+"-"+(y+1));
		return cells;
	}
	
	/**
	 * @param fish
	 * @param empty
	 * @return
	 * Permet de récupérer les cellules autour d'un poisson. Le paramètre empty permet de 
	 * préciser si on veut uniquement les cellules vides ou non.
	 */
	public ArrayList<String> getCellsNextToFish(FishModel fish, boolean empty)
	{
		ArrayList<String> cells = getCellsNextToFish(fish);
		ArrayList<String> calculatedCells = new ArrayList<>();
		for(String cell : cells)
		{
			FishModel fishOnCell = getFish(cell);
			if(empty)
			{
				if(!(fishOnCell instanceof FishModel))
					calculatedCells.add(cell);
			} 
			
			else 
			{
				if(fishOnCell instanceof SardineModel)
					calculatedCells.add(cell);
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
	
	/**
	 * @param fish
	 * Ajouter un poisson à la grille.
	 */
	public void addFish(FishModel fish)
	{
		String position = fish.getpXY();
		this.fishes.put(position, fish);
	}
	
	/**
	 * @param newPosition
	 * @param oldPosition
	 * Définir la nouvelle position d'un poisson.
	 */
	public void setFishPosition(String newPosition, String oldPosition)
	{
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
