package model;

public abstract class FishModel {
	private int age;
	private boolean isDead;
	private int pX;
	private int pY;
	
<<<<<<< HEAD:src/model/Fish.java
	// Nombre de cycle nécessaire à la reproduction
	private int reproduction_period;
	
	public Fish(int age, boolean isDead, int pX, int pY) {
		//super();
=======
	public FishModel(int age, boolean isDead, int pX, int pY) {
		super();
>>>>>>> 817981aac96e91c4bf5d51a5bd45b6b650e7a63f:src/model/FishModel.java
		this.age = age;
		this.isDead = isDead;
		this.pX = pX;
		this.pY = pY;
		
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

	@Override
	public String toString() {
		return "Fish [age=" + age + ", isDead=" + isDead + ", pX=" + pX + ", pY=" + pY + "]";
	}
	
	
}
