package model;

public class SardineModel extends FishModel{
	
	public SardineModel(int age, boolean isDead, int pX, int pY, SeaModel sea) {
		super(age, isDead, pX, pY, sea);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Sardine []";
	}
}
