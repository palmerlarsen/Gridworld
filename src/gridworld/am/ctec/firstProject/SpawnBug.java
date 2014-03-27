package gridworld.am.ctec.firstProject;

import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class SpawnBug extends Bug
{

	
	public SpawnBug()
	{
		int red = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		
		this.setColor(new Color(red, green, blue));
		
	}
	
	public void move()
	{
		Grid<Actor> myGrid = getGrid();
		if(myGrid == null)
		{
			return;
			
		}
		
		Location currentLocation = getLocation();
		Location nextLocation = currentLocation.getAdjacentLocation(getDirection());
		Location backRightLocation = currentLocation.getAdjacentLocation(90);
		Location backLeftLocation = currentLocation.getAdjacentLocation(270);
		Location furtherLeftLocation = backLeftLocation.getAdjacentLocation(225);
		Location furtherRightLocation = backRightLocation.getAdjacentLocation(135);
		
		
		if(myGrid.isValid(nextLocation))
		{
			moveTo(nextLocation);
		}
		else
		{
			removeSelfFromGrid();
		}
		
		SpawnBug backBug = new SpawnBug();
		backBug.putSelfInGrid(myGrid, currentLocation);
		SpawnBug backLeftBug = new SpawnBug();
		SpawnBug backRightBug = new SpawnBug();
		SpawnBug furtherRightBug = new SpawnBug();
		SpawnBug furtherLeftBug = new SpawnBug();
		
		if(myGrid.isValid(backLeftLocation)  && myGrid.get(backLeftLocation) == null)
		{
			backLeftBug.putSelfInGrid(myGrid, backLeftLocation);
		}
		if(myGrid.isValid(backRightLocation)  && myGrid.get(backRightLocation) == null)
		{
			backRightBug.putSelfInGrid(myGrid, backRightLocation);
		}
		if(myGrid.isValid(furtherRightLocation)  && myGrid.get(furtherRightLocation) == null)
		{
			furtherRightBug.putSelfInGrid(myGrid, furtherRightLocation);
		}
		if(myGrid.isValid(furtherLeftLocation)  && myGrid.get(furtherLeftLocation) == null)
		{
			furtherLeftBug.putSelfInGrid(myGrid, furtherLeftLocation);
		}
		
	}
}
