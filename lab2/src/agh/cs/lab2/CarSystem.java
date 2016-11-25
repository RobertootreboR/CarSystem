package agh.cs.lab2;

import java.util.HashMap;
import java.util.Map;

public class CarSystem {

	public static void main(String[] args) {
		try {
			MoveDirection[] directions = new OptionsParser().parse(args);
            Map<Position, HayStack> hayStacks = new HashMap<>();
			hayStacks.put(new Position(2, 3),new HayStack(new Position(2, 3)));
			AbstractWorldMap map = new BoundedMap(10, 5, hayStacks);
            Car car1 = new Car(map, 3, 2);
            Car car2 = new Car(map, 3, 4);
			map.add(car1);
			map.add(car2);
            System.out.print(map.toString());
			System.out.println("pierwszy " + car1.getPosition().y+ " drugi: " + car2.getPosition().y);
			map.run(directions);
            System.out.println("pierwszy " + car1.getPosition().y + " drugi: " + car2.getPosition().y);
            System.out.print(map.toString());
		} catch (IllegalArgumentException ex){
			System.out.print(" an exception occurred " + ex);
		}
	}

}
