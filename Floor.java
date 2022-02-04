package pt.iscte.dcti.poo.sokoban.starter;
import pt.iul.ista.poo.utils.Point2D;

public class Floor extends Objects{

	public Floor(Point2D position, String imageName, int layer) {
		super(position, imageName, layer);
	}
	
	@Override
	public boolean isBlockable() {
		return false;
	}

	@Override
	public boolean isMovable() {
		return false;
	}

}
