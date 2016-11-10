package agh.cs.lab2;

import java.util.ArrayList;

public class BoundedMap extends AbstractWorldMap implements IWorldMap {

	private Position upRightCorner;
	private Position leftDownCorner;

	ArrayList<HayStack> hayStackList = new ArrayList<>();

	public BoundedMap(int width, int height, ArrayList<HayStack> hayStackList) {
		if(width>0 && height>0)
			this.upRightCorner = new Position(width,height);
		
		this.leftDownCorner = new Position(0, 0);
		this.hayStackList = hayStackList;
	}

	@Override
	public boolean canMoveTo(Position position) {
		return  (super.canMoveTo(position) && position.smaller(upRightCorner) && position.larger(leftDownCorner));
	}    

	
	@Override
	public boolean isOccupied(Position position) {
		for (HayStack hayStackIter : hayStackList) {
			if (hayStackIter.getPosition().equals(position))
				return true;
		}
		return super.isOccupied(position);
	}

	@Override
	public Object objectAt(Position position) {
		
		for (HayStack hayStackIter : this.hayStackList) {   
			if (hayStackIter.getPosition().equals(position)) 
				return hayStackIter;
		}
		return super.objectAt(position);
    }
	
	@Override
	public String toString(){
		return new MapVisualizer().dump(this,leftDownCorner, upRightCorner);
	}
	

}
