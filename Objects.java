package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Point2D;

public abstract class Objects  implements ImageTile{
	
	private Point2D position;
	private String imageName;
	private int layer;
	
	public Objects(Point2D position, String imageName, int layer) {
		this.position = position;
		this.imageName = imageName;
		this.layer = layer;
	}

	@Override
	public String getName() {
		return imageName;
	}

	@Override
	public Point2D getPosition() {
		return position;
	}

	@Override
	public int getLayer() {
		return layer;
	}
	
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	public void setPosition(Point2D position) {
		this.position = position;
	}

	public abstract boolean isBlockable();
	public abstract boolean isMovable();
}
