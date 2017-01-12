package model.state;

import model.FishModel;

/**
 * @author Bastien Sebire & Corentin Chupin
 * Pattern State qui va permettre de définir les comportements.
 */
public abstract class BehaviorState 
{
	/**
	 * @param fish
	 * Va permettre au poisson d'effectuer un mouvement.
	 */
	public abstract void move(FishModel fish);

}
