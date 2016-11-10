package agh.cs.lab2;

import java.util.ArrayList;

public class UnBoundedMap extends AbstractWorldMap implements IWorldMap {
	
	ArrayList<HayStack> hayStackList = new ArrayList<>();
	
	public UnBoundedMap(ArrayList<HayStack> hayStackList) {
		this.hayStackList = hayStackList;
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
	
	private Position leftDownCorner(){
		//if(carList.size()==0) return null;
		int minX=0, minY=0;
		for(Car iter : carList){
			if(iter.getPosition().x < minX) minX = iter.getPosition().x;
			if(iter.getPosition().y < minY) minY = iter.getPosition().y;
		}
		for(HayStack iter : hayStackList){
			if(iter.getPosition().x < minX) minX = iter.getPosition().x;
			if(iter.getPosition().y < minY) minY = iter.getPosition().y;
		}
		
		Position result = new Position(minX,minY);
		return result;
	}
	private Position rightUpCorner(){
		//if(carList.size()==0) return null;
		int maxX=0, maxY=0;
		for(Car iter : carList){
			if(iter.getPosition().x > maxX) maxX = iter.getPosition().x;
			if(iter.getPosition().y > maxY) maxY = iter.getPosition().y;
		}
		for(HayStack iter : hayStackList){
			if(iter.getPosition().x > maxX) maxX = iter.getPosition().x;
			if(iter.getPosition().y > maxY) maxY = iter.getPosition().y;
		}
		
		Position result = new Position(maxX,maxY);
		return result;
	}
	
	@Override
	public String toString(){
		return new MapVisualizer().dump(this,leftDownCorner(), rightUpCorner());
	}
}
