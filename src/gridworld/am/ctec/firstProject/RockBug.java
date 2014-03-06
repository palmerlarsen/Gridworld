package gridworld.am.ctec.firstProject;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class RockBug extends Bug
{

	public void move()
	{
		Grid<Actor> myGrid = getGrid();
		if(myGrid == null)
		{
			return;
		}
		
		Location currentLocation = getLocation();
		Location nextLocation = currentLocation.getAdjacentLocation(getDirection());
		if(myGrid.isValid(nextLocation))
		{
			moveTo(nextLocation);
		}
		else
		{
			removeSelfFromGrid();
		}
		
		Rock currentRock = new Rock(getColor());
		currentRock.putSelfInGrid(myGrid, currentLocation);
	}
}
