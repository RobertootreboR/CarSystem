package agh.cs.lab2;

import java.util.ArrayList;

public class Car {

	private MapDirection orientation= MapDirection.North;
	private Position carPosition;
	private AbstractWorldMap map;
    private ArrayList<IPositionChangeListener> listenerList = new ArrayList<>();


	public Car(AbstractWorldMap map, int x, int y) {
		this.carPosition = new Position(x, y);
		this.map = map;
        listenerList.add(map);
	}
    void addListener(IPositionChangeListener listener){
        listenerList.add(listener);
    }
    void removeListener(IPositionChangeListener listener){
        listenerList.remove(listener);
    }
    void positionChanged(Position oldPosition, Position newPosition){
        for(IPositionChangeListener listener : listenerList)
            listener.positionChanged(oldPosition, newPosition);
    }

	public Position getPosition() {
		return carPosition;
	}

	@Override
	public String toString() {
		switch (orientation) {
		case North:
			return "N";
		case South:
			return "S";
		case East:
			return "E";
		case West:
			return "W";
		default:
			return null;
		}
	}

	public void move(MoveDirection direction) {
		switch (direction) {
		case Right:
			orientation = orientation.next();
			break;
		case Left:
			orientation = orientation.previous();
			break;
		case Forward:
			this.moveForward();
			break;
		case Backward:
			this.moveBackward();
			break;
		default:
			break;
		}

	}

	private void moveBackward() {
		switch (orientation) {
		case North:
			changePositionIfPossible(0, -1);
			break;
		case South:
			changePositionIfPossible(0, 1);
			break;
		case West:
			changePositionIfPossible(1, 0);
			break;
		case East:
			changePositionIfPossible(-1, 0);
			break;

		}
	}

	private void moveForward() {

		switch (orientation) {
		case North:
			changePositionIfPossible(0, 1);
			break;
		case South:
			changePositionIfPossible(0, -1);
			break;
		case West:
			changePositionIfPossible(-1, 0);
			break;
		case East:
			changePositionIfPossible(1, 0);
			break;

		}

	}

	private void changePositionIfPossible(int x, int y) {
		Position changedPosition = carPosition.add(new Position(x, y));
		if (map.canMoveTo(changedPosition)) {
            positionChanged(carPosition,changedPosition);
			carPosition = changedPosition;
		}

	}

}
