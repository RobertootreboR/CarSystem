package agh.cs.lab2;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapTest {
	
	
	
	@Test
	public void testUnbounded() {
		String[] args= new String[] {"f","f","f","f","f","r","r","b","b","b","b","b","b"};
		MoveDirection[] directions = new OptionsParser().parse(args);
		Map<Position,HayStack> hayStacks = new HashMap<>();
		hayStacks.put(new Position(2,3),new HayStack(new Position(2,3)));
		hayStacks.put(new Position(2,4),new HayStack(new Position(2,4)));
		hayStacks.put(new Position(2,5),new HayStack(new Position(2,5)));
		
		IWorldMap map = new BoundedMap(10,5,hayStacks);
		map.add(new Car(map,2,1));
		map.add(new Car(map,3,4));
		assertTrue(map.isOccupied(new Position(3,4)));
		assertTrue(map.isOccupied(new Position(2,1)));
		
		map.run(directions);

		assertTrue(map.isOccupied(new Position(2,3)));
		assertTrue(map.isOccupied(new Position(2,4)));
		assertTrue(map.isOccupied(new Position(2,5)));
		assertTrue(map.isOccupied(new Position(0,2)));
		assertTrue(map.isOccupied(new Position(3,5)));
		
		
		
	}
	@Test
	public void testRectangular() {
		String[] args= new String[] {"f","f","f","f","f","r","r","b","b","b","b","b","b"};
		MoveDirection[] directions = new OptionsParser().parse(args);
		
		
		IWorldMap map = new RectangularMap(10,5);
		map.add(new Car(map,2,1));
		map.add(new Car(map,3,4));
		assertTrue(map.isOccupied(new Position(3,4)));
		assertTrue(map.isOccupied(new Position(2,1)));
		
		map.run(directions);

		
		assertTrue(map.isOccupied(new Position(0,5)));
		assertTrue(map.isOccupied(new Position(0,4)));
		assertFalse(map.isOccupied(new Position(0,8)));
		
		
	}
	

}
