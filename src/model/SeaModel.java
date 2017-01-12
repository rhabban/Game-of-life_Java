package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;



/**
 * @author Bastien Sebire & Corentin Chupin
 * SeaModel permet de créer une mer avec des sardines et des requins. On précise le nombre de poissons
 * ainsi que la taille de la grille.
 */
public class SeaModel {
	
	
	protected int sharksCount;
	protected int sardinesCount;
	protected int width = 10;
	protected int height = 10;
	
	protected ArrayList<FishModel> fishesX;

	protected ConcurrentHashMap<String, FishModel> fishes = new ConcurrentHashMap<>();
	
	public SeaModel() {
		this.sharksCount = 1;
		this.sardinesCount = 4;
	}

	/**
	 * Récupère toutes les cases autour d'un poisson.
	 * @param sharksCount
	 * @param sardinesCount
	 * @param width
	 * @param height
	 */
	public SeaModel(int sharksCount, int sardinesCount, int width, int height) {
		super();
		this.sharksCount = sharksCount;
		this.sardinesCount = sardinesCount;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Permet de récupérer les cellules autour d'un poisson.
	 * @param fish
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getCellsNextTo(FishModel fish){
		int x = fish.getpX();
		int y = fish.getpY();
		
		return getCellsNextTo(x,y);
	}
	
	/**
	 * Permet de récupérer les cellules autour d'un x et y
	 * @param x
	 * @param y
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getCellsNextTo(int x, int y){
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
	
	/**
	 * Permet de récupérer les cellules autour d'une position
	 * @param xy
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getCellsNextTo(String xy){
		int x = Integer.parseInt(xy.split("-")[0]);
		int y = Integer.parseInt(xy.split("-")[1]);
		
		return getCellsNextTo(x,y);
	}
	
	
	/**
	 * Permet de récupérer les cellules autour d'un poisson. Le paramètre empty permet de 
	 * préciser si on veut uniquement les cellules vides ou non.
	 * @param fish
	 * @param empty
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getCellsNextToFish(FishModel fish, boolean empty){
		ArrayList<String> cells = getCellsNextTo(fish);
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
	
	/**
	 * Retourne une liste de position contenant les sardines les plus proche du poisson passé en paramètre.
	 * @param fish
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getNearestSardineNextToFish(FishModel fish){
		int x = fish.getpX();
		int y = fish.getpY();
		ArrayList<String> cells = new ArrayList<>();
		
		boolean found = false;
		
		ArrayList<String> cellsDone = new ArrayList<>();
		ArrayList<String> cellsToDo = new ArrayList<>();
		cellsToDo.add(x+"-"+y);
		
		ArrayList<String> tmpCells = new ArrayList<>();
		while(true){
			String cellToDo = cellsToDo.get(0);
			
		    ArrayList<String> sardinesCells = getSardineNextToCell(cellToDo);
		    
		    // Si la cellule dispose de sardines dans les cases voisines
		    if(sardinesCells.size() > 0){
		    	cells.addAll(sardinesCells);
		    	found = true;
		    } else {
		    	// Sinon on récupère la liste des cases vides pour les tester plus tard
		    	ArrayList<String> emptyCells = getCellsNextTo(cellToDo);
		    	
		    	for(String cell : emptyCells){
		    		if(!tmpCells.contains(cell) && !cellsDone.contains(cell)){
		    			// Cellule non traversée
		    			tmpCells.add(cell);
		    		}
		    	}
		    }
		    
		    // Ajout de la cellule dans la listes des cellules traversées
		    cellsDone.add(cellToDo);
		    cellsToDo.remove(0);
		    
		    if (cellsToDo.size()<1){
		    	if(found)
		    		break;
		    	else {
		    		// Alimentation de l'itérateur par les nouvelles cellules voisines vides
		    		if(tmpCells.size() == 0)
		    			break;
		    		cellsToDo = new ArrayList<>(tmpCells);
		    		tmpCells = new ArrayList<>();
		    	}		    		
		    }
		}
		
		ArrayList<String> unique_cells = new ArrayList<String>(new HashSet<String>(cells));
		return unique_cells;
	}
	
	/**
	 * Retourne une liste de sardines présentes dans les cases adjacente à x,y
	 * @param x
	 * @param y
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getSardineNextToCell(int x, int y){
		ArrayList<String> cells = getCellsNextTo(x,y);
		ArrayList<String> SardinesCells = new ArrayList<>();
		for(String cell : cells){
			FishModel fishOnCell = getFish(cell);
				if(fishOnCell instanceof SardineModel){
					SardinesCells.add(cell);
			}
		}
		return SardinesCells;
	}
	
	/**
	 * @param xy
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getSardineNextToCell(String xy){
		String[] pos = xy.split("-");
		return getSardineNextToCell(Integer.parseInt(pos[0]),Integer.parseInt(pos[1]));
	}
	
	public FishModel getFish(int x, int y){
		return getFish(x+"-"+y);
	}
	
	public FishModel getFish(String xy){
		return this.fishes.get(xy);
	}
	
	/**
	 * Ajouter un poisson à la grille.
	 * @param fish
	 */
	public void addFish(FishModel fish){
		String position = fish.getpXY();
		this.fishes.put(position, fish);
	}
	
	/**
	 * Définir la nouvelle position d'un poisson.
	 * @param newPosition
	 * @param oldPosition
	 */
	public void setFishPosition(String newPosition, String oldPosition){
		FishModel fish = fishes.get(oldPosition);
		fishes.remove(oldPosition);
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
