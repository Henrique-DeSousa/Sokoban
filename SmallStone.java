package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Point2D;

public class SmallStone extends Movable{

	public SmallStone(Point2D position, String imageName, int layer) {
		super(position, imageName, layer);
	}

	@Override
	public boolean isBlockable() {
		return true;
	}

	@Override
	public boolean isMovable() {
		return true;
	}

}
