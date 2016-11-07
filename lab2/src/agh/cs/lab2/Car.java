package agh.cs.lab2;

public class Car {

	private MapDirection orientation= MapDirection.North;
	private Position carPosition;
	private IWorldMap map;

	public Car(IWorldMap map, int x, int y) {
		this.carPosition = new Position(x, y);
		this.map = map;
	}

	public Car(IWorldMap map) {
		this.map = map;
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
		if (map.canMoveTo(changedPosition))
			carPosition = changedPosition;

	}

}
