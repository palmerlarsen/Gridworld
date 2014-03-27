package gridworld.am.ctec.firstProject;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class TriangleBug extends Bug
{
	
	private int movement;
	private int sideLength;
	private int side;
	
	public TriangleBug(int length)
	{
		
		setDirection(Location.NORTH);
		movement = 0;
		sideLength = length;
		side = 1;
	}
	

	public void act()	
	{
		
		if(side < 5 && movement < sideLength && canMove())
		{
			move();
			movement++;
		}
		else if (side ==1)
		{
			setDirection(Location.EAST);
			movement = 0;
			side++;
		}
		else if (side == 2)
		{
			setDirection(Location.SOUTHWEST);
			movement = 0;
		}
		
			
		
		
	}
	
}

