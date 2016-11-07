package agh.cs.lab2;

public class Carsystem {

	public static void main(String[] args) {
		MoveDirection[] directions = new OptionsParser().parse(args);
		IWorldMap map = new RectangularMap(10,5);
		map.add(new Car(map,1,2));
		map.add(new Car(map,3,4));
		System.out.println(map.toString());
		map.run(directions);
		System.out.println(map.toString());

	}

	

}
