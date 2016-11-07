package agh.cs.lab2;

public enum MapDirection {
	West, North, East, South;

	@Override
	public String toString() {
		switch (this) {
		case North:
			return "Północ";
		case South:
			return "Południe";
		case West:
			return "Zachód";
		case East:
			return "Wschód";
		default:
			return null;

		}
	}         // 

	public MapDirection next() {
		/*
		 * switch(this){
		 *  case North: 
		 *  	return East;
		 *  case South: 
		 *  	return West; 
		 *  case West: 
		 *  	return North;
		 *  case East: 
		 *  	return South;
		 *  default: 
		 *  	return null;
		 * 
		 * }
		 */
		return MapDirection.values()[(this.ordinal() + 1) % 4];
	}

	public MapDirection previous() {
		switch (this) {
		case North:
			return West;
		case South:
			return East;
		case West:
			return South;
		case East:
			return North;
		default:
			return null;

		}
	}

}