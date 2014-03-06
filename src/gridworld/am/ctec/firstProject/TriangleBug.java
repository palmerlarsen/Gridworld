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
	
	public TriangleBug(int length)
	{
		movement = 0;
		sideLength = length;
	}
	
	public void move()	
	{
		
		while(movement < sideLength && canMove())
		{
			move();
			movement++;
		}
		
	}
	
}

