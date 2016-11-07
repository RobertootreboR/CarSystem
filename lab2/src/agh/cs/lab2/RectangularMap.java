package agh.cs.lab2;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap {
	private Position maxPosition;
	private Position minPosition;

	ArrayList<Car> carList = new ArrayList<Car>();

	public RectangularMap(int width, int height) {
		this.maxPosition = new Position(Math.abs(width), Math.abs(height));
		this.minPosition = new Position(0, 0);
	}

	@Override
	public boolean canMoveTo(Position position) {
		if (position.smaller(this.maxPosition) && position.larger(this.minPosition) && !isOccupied(position))
			return true;
		return false;
	}

	@Override
	public boolean add(Car car) {
		if(!this.isOccupied(car.getPosition()) && car.getPosition().smaller(maxPosition) && car.getPosition().larger(minPosition)){
			carList.add(car);
			return true;
		}
		return false;
	}
	

	@Override
	public void run(MoveDirection[] directions) {
		int carListLength = carList.size();
		for(int i =0; i< directions.length; i++){
			if(directions[i]!=null){
				carList.get(i%carListLength).move(directions[i]);
			}
		}

	}

	@Override
	public boolean isOccupied(Position position) {
		for (Car iter : carList) {
			if (iter.getPosition().equals(position))
				return true;
		}
		return false;
	}

	@Override
	public Object objectAt(Position position) {
		for (Car iter : this.carList) {
			if (iter.getPosition().equals(position)) 
				return iter;
		}
		return null;
	}
	@Override
	public String toString(){
		return new MapVisualizer().dump(this,minPosition, maxPosition);
	}

}
