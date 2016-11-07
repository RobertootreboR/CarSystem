package agh.cs.lab2;

public class OptionsParser {

	public MoveDirection[] parse(String[] arguments) {
		MoveDirection[] result = new MoveDirection[arguments.length];

		for (int i = 0; i < arguments.length; i++)
			if (arguments[i].equals("f") || arguments[i].equals("forward"))
				result[i] = MoveDirection.Forward;
			else if (arguments[i].equals("b") || arguments[i].equals("backward"))
				result[i] = MoveDirection.Backward;
			else if (arguments[i].equals("l") || arguments[i].equals("left"))
				result[i] = MoveDirection.Left;
			else if (arguments[i].equals("r") || arguments[i].equals("right"))
				result[i] = MoveDirection.Right;
		return result;

	}

}
