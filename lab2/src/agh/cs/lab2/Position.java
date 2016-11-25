package agh.cs.lab2;

public class Position {
	public int x;
	public int y;
	
	public Position(int x, int y){
		this.x =x;
		this.y =y;
	}
	@Override
	public String toString (){
		return "(" + this.x + "," + this.y + ")";
	}
	
	
	public boolean smaller(Position othe){
		return ((this.x <= othe.x) && (this.y <= othe.y));
	}
	
	public boolean larger(Position other){
		return ((this.x >= other.x) && (this.y >= other.y));

	}
	
	public Position add( Position other){
		return  new Position(this.x + other.x , this.y + other.y);
	}
	@Override
	public boolean equals(Object other){
		if(this == other)
			return true;
		if (other == null || getClass() != other.getClass()) return false;
		Position that = (Position) other;
		if((this.x == that.x) && (this.y == that.y))
			return true; 
		else 
			return false;
	}


	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		return result;
	}
}
