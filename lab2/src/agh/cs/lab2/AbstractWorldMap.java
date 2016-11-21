package agh.cs.lab2;

import java.util.ArrayList;

public abstract class AbstractWorldMap implements IWorldMap {
	protected ArrayList<Car> carList = new ArrayList<>();

	@Override
	public boolean canMoveTo(Position position) {
		return !isOccupied(position);
	}

	@Override
	public boolean add(Car car) {
		if(canMoveTo(car.getPosition())){
			carList.add(car);
			return true;
		}
		else throw new IllegalArgumentException("There is a car on position " + car.getPosition().toString() + "!!!");
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

}
