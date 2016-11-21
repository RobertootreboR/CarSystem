package agh.cs.lab2;

import java.util.HashMap;
import java.util.Map;

public class BoundedMap extends AbstractWorldMap implements IWorldMap {

	private Position upRightCorner;
	private Position leftDownCorner;

	protected Map<Position, HayStack>  hayStackMap = new HashMap<>();

	public BoundedMap(int width, int height, Map<Position, HayStack> hayStackMap) {
		if(width>0 && height>0)
			this.upRightCorner = new Position(width,height);
		
		this.leftDownCorner = new Position(0, 0);
		this.hayStackMap= hayStackMap;
	}

	@Override
	public boolean canMoveTo(Position position) {
		return  (super.canMoveTo(position) && position.smaller(upRightCorner) && position.larger(leftDownCorner));
	}    

	
	@Override
	public boolean isOccupied(Position position) {
		if( hayStackMap.containsKey(position))
			return true;

		return super.isOccupied(position);
	}

	@Override
	public Object objectAt(Position position) {

		if( hayStackMap.containsKey(position))
			return hayStackMap.get(position);

		return super.objectAt(position);
    }
	
	@Override
	public String toString(){
		return new MapVisualizer().dump(this,leftDownCorner, upRightCorner);
	}
	

}
