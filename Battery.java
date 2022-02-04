package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Point2D;

public class Battery extends Objects implements Interactable{

	public Battery(Point2D position, String imageName, int layer) {
		super(position, imageName, layer);
	}

	@Override
	public boolean isInteractable() {
		return true;
	}

	@Override
	public void interact(Objects obj) {
			SokobanGame.getInstance().getLm().getPlayer().setEnergy(100);
			SokobanGame.getInstance().destroyObject(this);

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
