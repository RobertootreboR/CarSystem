package agh.cs.lab2;

import java.util.ArrayList;

public class CarSystem {

	public static void main(String[] args) {
		try {
			MoveDirection[] directions = new OptionsParser().parse(args);

			ArrayList<HayStack> hayStacks = new ArrayList<>();
			hayStacks.add(new HayStack(new Position(2, 3)));
			IWorldMap map = new BoundedMap(10, 5, hayStacks);
			map.add(new Car(map, 1, 2));
			map.add(new Car(map, 3, 4));
			System.out.println(map.toString());
			map.run(directions);
			System.out.println(map.toString());
		} catch (IllegalArgumentException ex){
			System.out.print(" an exception ocured " + ex);
		}
	}

}
