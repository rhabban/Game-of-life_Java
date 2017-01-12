package model.state;

import java.util.ArrayList;

import model.FishModel;

/**
 * @author Bastien Sebire & Corentin Chupin
 * Permet de définir le comportement d'un requin lorsqu'il est adulte. Il va se déplacer vers les sardines proches.
 */
public class AdultState extends BehaviorState { 
	/**
	 * @param fish
	 * Déplace le poisson vers l'une des sardines les plus proches.
	 */
	public void move(FishModel fish){

		ArrayList<String> sardineCells = fish.getNearestSardine();
		
		String newPosition;
		int random;
		
		if(sardineCells.size()>0){
			random = (int)(Math.random() * sardineCells.size()) + 0;
			String targetCell = sardineCells.get(random);
			int x = Integer.parseInt(targetCell.split("-")[0]);
			int y = Integer.parseInt(targetCell.split("-")[1]);
			
			boolean x_possibility = true;
			int new_x = 0;
			boolean y_possibility = true;
			int new_y = 0;
			
			
			if(x == fish.getpX()){
				x_possibility = false;
			} else {
				if (x > fish.getpX()){
					new_x = fish.getpX()+1;
				} else {
					new_x = fish.getpX()-1;
				}
			}
			
			if(y == fish.getpY())
				y_possibility = false;
			else {
				if (y > fish.getpY()){
					new_y = fish.getpY()+1;
				} else {
					new_y = fish.getpY()-1;
				}
			}
			
			if(x_possibility && y_possibility){
				int random2 = (int)(Math.random() * 2);
				if(random2 == 0){
					newPosition = Integer.toString(new_x)+"-"+fish.getpY();
				} else {
					newPosition = fish.getpX()+"-"+Integer.toString(new_y);
				}
			} else if (x_possibility){
				newPosition = Integer.toString(new_x)+"-"+fish.getpY();
			} else {
				newPosition = fish.getpX()+"-"+Integer.toString(new_y);
			}
				
			FishModel target = fish.getSea().getFish(newPosition);
			if(target instanceof FishModel){
				target.destroy();
			}
		} else {
			ArrayList<String> emptyCells = fish.getCellsNextToHim(true);
			random = (int)(Math.random() * emptyCells.size()) + 0;
			newPosition = emptyCells.get(random);
		}		
	
		String[] newXY = newPosition.split("-");
		int x = Integer.parseInt(newXY[0]);
		int y = Integer.parseInt(newXY[1]);
		
		fish.setpX(x);
		fish.setpY(y);
	}
}
