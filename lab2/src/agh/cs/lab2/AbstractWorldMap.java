package agh.cs.lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeListener{
    protected ArrayList<Car> carList = new ArrayList<>();
    private Map<Position, Car> carMap = new HashMap<>();


    @Override
    public void positionChanged(Position oldPosition, Position newPosition) {
        Car tempCar = carMap.get(oldPosition);
        carMap.remove(oldPosition);
        carMap.put(newPosition,tempCar);
    }

    @Override
    public boolean canMoveTo(Position position) {
        return !isOccupied(position);
    }

    @Override
    public boolean add(Car car) {
        if (canMoveTo(car.getPosition())) {
            carList.add(car);
            carMap.put(car.getPosition(), car);
            return true;
        } else throw new IllegalArgumentException("There is a car on position " + car.getPosition().toString() + "!!!");
    }

    @Override
    public void run(MoveDirection[] directions) {
        int carListLength = carList.size();
        for (int i = 0; i < directions.length; i++) {
            if (directions[i] != null) {
                carList.get(i % carListLength).move(directions[i]);
            }
        }
    }

    @Override
    public boolean isOccupied(Position position) {
        if (carMap.containsKey(position))
            return true;

        return false;
    }

    @Override
    public Object objectAt(Position position) {
        if (carMap.containsKey(position))
            return carMap.get(position);

        return null;
    }

}
