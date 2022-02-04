package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Point2D;

public class Hammer extends Objects implements Interactable{

	public Hammer(Point2D position, String imageName, int layer) {
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
	@Override
	public boolean isInteractable() {
		return true;
	}
	@Override
	public void interact(Objects obj) {
		if(obj instanceof Forklift) {
			SokobanGame.getInstance().destroyObject(this);
			SokobanGame.getInstance().getLm().getPlayer().setCanBreak(true);
		}
	}
}
