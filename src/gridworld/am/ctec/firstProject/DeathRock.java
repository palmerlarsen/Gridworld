package gridworld.am.ctec.firstProject;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * extending the rock class from death rock
 * @author plar4927
 *
 */
public class DeathRock extends Rock
{
	/**
	 * create the constructor
	 */
  public DeathRock()
  {
	  
  }
  
  /**
   * act method for death Rock 
   * create arraylist of actors and call process actors
   */
  public void act()
  {
	  ArrayList<Actor> neighbors = getNeighbors();
	  processActors(neighbors);
  }
  /**
   * creating arraylist of neightbors and getting their location
   * @return
   */
  public ArrayList<Actor> getNeighbors()
  {
	  return getGrid(). getNeighbors(getLocation());
  }
  
  /**
   * calling process actors
   * @param actors
   */
  public void processActors (ArrayList<Actor> actors)
  {
	  for  (Actor currentActor : actors)
	  {
		  currentActor.removeSelfFromGrid();
	  }
  }
  
}
		
	  


