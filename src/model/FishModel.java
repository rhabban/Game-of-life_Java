package model;

import java.util.ArrayList;

import model.state.*;

/**
 * @author Bastien Sebire & Corentin Chupin
 * Classe abstraite d'un poisson. 
 */
public abstract class FishModel 
{
	private int age;
	private int pX;
	private int pY;
	private boolean isDead;
	
	private BehaviorState behavior;
	private SeaModel sea;
	
	/**
	 * @param pX
	 * @param pY
	 * @param sea
	 */
	public FishModel(int pX, int pY, SeaModel sea) 
	{
		this.age = 0;
		this.isDead = false;
		this.pX = pX;
		this.pY = pY;
		this.behavior = new RandomState();
		this.sea = sea;
	}
	
	
	/**
	 * Permet de retirer un poisson mort de la grille.
	 */
	public void destroy()
	{
		this.setDead(true);
		this.getSea().removeFish(this);
	}
	
	/**
	 * @param empty
	 * @return
	 * Récupère les cases adjacentes à un poisson. Le paramètre empty précise si on souhaite
	 * récupérer uniquement des cases disponibles ou non.
	 */
	public ArrayList<String> getCellsNextToHim(boolean empty)
	{
		return this.sea.getCellsNextToFish(this, empty);
	}
	

	public ArrayList<String> getNearestSardine(){
		return this.sea.getNearestSardineNextToFish(this);
	}
	
	/**
	 * @param gameOfLife
	 */
	public abstract void liveCycle(GameOfLifeModel gameOfLife);
	
	/**
	 * Déplace un poisson en fonction de son comportement.
	 */
	public void move()
	{
		String oldPosition = this.getpXY();
		this.behavior.move(this);
		String newPosition = this.getpXY();
		this.sea.setFishPosition(newPosition, oldPosition);
	}
	
	/**
	 * @param fish
	 * Si possible, le poisson va donner naissance sur une case voisine.
	 */
	public void reproduction(FishModel fish)
	{
		ArrayList<String> availableCells = this.getCellsNextToHim(true);
		
		if(availableCells.size()>0){
			int value = (int)(Math.random() * availableCells.size()) + 0;
			String newPosition = availableCells.get(value);
			String[] newXY = newPosition.split("-");
			int x = Integer.parseInt(newXY[0]);
			int y = Integer.parseInt(newXY[1]);
			
			if(fish instanceof SharkModel)
			{
				System.out.println("Un requin s'est reproduit");
				sea.addFish(new SharkModel(x,y,sea));
			}
				
			else
			{
				System.out.println("Une sardine s'est reproduit.");
				sea.addFish(new SardineModel(x,y,sea));
			}
				
		}
	}

	public int getAge() {
		return age;
	}
	
	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getpX() {
		return pX;
	}

	public void setpX(int pX) {
		this.pX = pX;
	}

	public int getpY() {
		return pY;
	}
	
	public String getpXY(){
		String position = Integer.toString(pX)+'-'+Integer.toString(pY);
		return position;
	}

	public void setpY(int pY) {
		this.pY = pY;
	}
	
	public BehaviorState getBehavior(){
		return this.behavior;
	}
	
	public void setBehavior(BehaviorState behavior){
		this.behavior = behavior;
	}
	
	public SeaModel getSea(){
		return sea;
	}
	
	public void setSea(SeaModel sea){
		this.sea = sea;
	}
	
	@Override
	public String toString() {
		return "[age=" + age + ", pX=" + pX + ", pY=" + pY + "]";
	}
	
	
}
