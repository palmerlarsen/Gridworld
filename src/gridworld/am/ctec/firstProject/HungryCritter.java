package gridworld.am.ctec.firstProject;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class HungryCritter extends Critter
{

	
	 public void act() 
	 { 
	 if (getGrid() == null)
	 {
		 return;
	 }
	 
	 ArrayList<Actor> actors = getActors(); 
	 processActors(actors); 
	 ArrayList<Location> moveLocs = getMoveLocations(); 
	 Location loc = selectMoveLocation(moveLocs); 
	 makeMove(loc);
	 }
	 
	 public ArrayList<Actor> getActors() 
	 { 
		 return getGrid().getNeighbors(getLocation()); 
	 }
	 
	 public void processActors(ArrayList<Actor> actors) 
	 { 
		 for (Actor a : actors) 
		 { 
			 if (!(a instanceof Critter)) 
				 a.removeSelfFromGrid(); 
		 } 
	 }
	 
	 public ArrayList<Location> getMoveLocations()
	    {
	        ArrayList<Location> locs = new ArrayList<Location>();
	        int[] dirs =
	            { Location.WEST, Location.EAST , Location.NORTH, Location.SOUTH};
	        for (Location loc : getLocationsInDirections(dirs))
	            if (getGrid().get(loc) == null)
	                locs.add(loc);

	        return locs;
	    }
	 
	 public void makeMove(Location loc)
	    {
	        if (loc.equals(getLocation()))
	        {
	            double r = Math.random();
	            int angle;
	            if (r < 0.5)
	                angle = Location.LEFT;
	            else
	                angle = Location.RIGHT;
	            setDirection(getDirection() + angle);
	        }
	        else
	            super.makeMove(loc);
	    }
	 
	 public ArrayList<Location> getLocationsInDirections(int[] directions)
	    {
	        ArrayList<Location> locs = new ArrayList<Location>();
	        Grid gr = getGrid();
	        Location loc = getLocation();
	    
	        for (int d : directions)
	        {
	            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
	            if (gr.isValid(neighborLoc))
	                locs.add(neighborLoc);
	        }
	        return locs;
	    } 
	 
}
