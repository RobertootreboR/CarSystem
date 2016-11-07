package agh.cs.lab2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTest {
	
	Position TestPos1 = new Position(2,3);
	Position TestPos2 = new Position(1,1);

	@Test
	public void testToString() {
		assertEquals(TestPos1.toString(),"(2,3)");
		assertNotEquals(TestPos1.toString(),"(3,2)"); 
	}
	
	@Test
	public void testSmaller(){
		assertTrue((new Position(0,0).smaller(TestPos1)));
		assertFalse((new Position(5,5).smaller(new Position(0,0))));
	}
	
	@Test
	public void testLarger(){
		assertFalse((new Position(0,0).larger(TestPos1)));
		assertTrue((new Position(5,5).larger(new Position(0,0))));
	}
	
	@Test
	public void testAdd(){
		assertEquals((new Position(1,2)).add(TestPos1),(new Position(3,5)));
		for(int i=0; i<2000000; i++)
			assertNotEquals((new Position(1,3+i)).add(TestPos1),(new Position(3,5)));
		
	}
	
}
