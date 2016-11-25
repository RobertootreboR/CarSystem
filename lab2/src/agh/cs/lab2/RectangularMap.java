package agh.cs.lab2;


public class RectangularMap extends AbstractWorldMap implements IWorldMap {
	private Position upRightCorner;
	private Position leftDownCorner;


	public RectangularMap(int width, int height) {
		if(width>0 && height>0)
		this.upRightCorner = new Position(width,height);
		this.leftDownCorner = new Position(0, 0);
	}

	@Override
	public boolean canMoveTo(Position position) {
		return (super.canMoveTo(position) && position.smaller(this.upRightCorner) && position.larger(this.leftDownCorner));
	
	}

	@Override
	public String toString(){
		return new MapVisualizer().dump(this,leftDownCorner, upRightCorner);
	}

}
