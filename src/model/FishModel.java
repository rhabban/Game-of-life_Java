package model;

import java.util.ArrayList;

import model.state.*;

public abstract class FishModel {
	private int age;
	private int pX;
	private int pY;
	private boolean isDead;
	
	private BehaviorState behavior;
	private SeaModel sea;
	
	// Nombre de cycles n�cessaire � la reproduction
	private int reproduction_period;
	
	public FishModel(int pX, int pY, SeaModel sea) {
		this.age = 0;
		this.isDead = false;
		this.pX = pX;
		this.pY = pY;
		this.behavior = new RandomState();
		this.sea = sea;
				
		this.reproduction_period = 1;
	}
	
	public void destroy(){
		this.setDead(true);
		this.getSea().removeFish(this);
	}
	
	public ArrayList<String> getCellsNextToHim(boolean empty){
		return this.sea.getCellsNextToFish(this, empty);
	}
	
	public abstract void liveCycle(GameOfLifeModel gameOfLife);
	
	public void move(){
		String oldPosition = this.getpXY();
		this.behavior.move(this);
		String newPosition = this.getpXY();
		this.sea.setFishPosition(newPosition, oldPosition);
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
