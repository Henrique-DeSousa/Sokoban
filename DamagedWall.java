package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Point2D;

public class DamagedWall extends Objects implements Interactable{

	public DamagedWall(Point2D position, String imageName, int layer) {
		super(position, imageName, layer);
	}
	@Override
	public boolean isBlockable() {
		return true;
	}
	@Override
	public boolean isMovable() {
		return false;
	}
	@Override
	public boolean isInteractable() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void interact(Objects obj) {
		if(SokobanGame.getInstance().getLm().getPlayer().isCanBreak() && obj instanceof Forklift) {
			SokobanGame.getInstance().destroyObject(this);
		}
	}
}
