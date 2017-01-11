package model;

import model.state.*;

public abstract class FishModel {
	private int age;
	private int pX;
	private int pY;
	
	private BehaviorState behavior;
	private SeaModel sea;
	
	// Nombre de cycles n�cessaire � la reproduction
	private int reproduction_period;
	
	public FishModel(int age, boolean isDead, int pX, int pY, SeaModel sea) {
		this.age = age;
		this.pX = pX;
		this.pY = pY;
		this.behavior = new RandomState();
		this.sea = sea;
				
		this.reproduction_period = 1;
	}

	public int getAge() {
		return age;
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
	
	public void liveCycle(GameOfLifeModel gameOfLife){
		age += 1;
		
		if(age > 3){
			gameOfLife.getSea().removeFish(this);
		}
		
		/*else if(age % reproduction_period == 0)
			reproduction();
		
		else
			behavior.move(this);*/
	}
	
	public void reproduction(){
		// si l'une des cases voisinante est vide alors cr�er un nouveau poisson
	}

	@Override
	public String toString() {
		return "Fish [age=" + age + ", pX=" + pX + ", pY=" + pY + "]";
	}
	
	public void getPossibleMouvements(){
		//
	}
	
	
}
