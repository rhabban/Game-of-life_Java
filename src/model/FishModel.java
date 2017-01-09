package model;

import model.state.*;

public abstract class FishModel {
	private int age;
	private boolean isDead;
	private int pX;
	private int pY;
	
	private BehaviorState behavior;
	private SeaModel sea;
	
	// Nombre de cycles nécessaire à la reproduction
	private int reproduction_period;
	
	public FishModel(int age, boolean isDead, int pX, int pY, SeaModel sea) {
		this.age = age;
		this.isDead = isDead;
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

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
		pX = -1;
		pY = -1;
		// La mer doit être au courant qu'un enfant est mort, le retirer de sa liste d'affichage et d'actions
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
	
	public void live(){
		age+= 1;
		behavior.move(this);
		
		if(age % reproduction_period == 0){
			reproduction();
		}
		
		if(age > 3){
			setDead(true);
		}
		
	}
	
	public void reproduction(){
		// si l'une des cases voisinante est vide alors créer un nouveau poisson
	}

	@Override
	public String toString() {
		return "Fish [age=" + age + ", isDead=" + isDead + ", pX=" + pX + ", pY=" + pY + "]";
	}
	
	public void getPossibleMouvements(){
		//
	}
	
	
}
