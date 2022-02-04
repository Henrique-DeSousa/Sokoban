package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Point2D;

public class Pitfall extends Objects implements Interactable{

	public Pitfall(Point2D position, String imageName, int layer) {
		super(position, imageName, layer);
	}

	@Override
	public boolean isInteractable() {
		return true;
	}

	@Override
	public void interact(Objects obj) {
		if(obj instanceof BigStone) {
			((BigStone) obj).setMove(false);
			SokobanGame.getInstance().destroyObject(this);
		}else if(obj instanceof Forklift || obj instanceof Box) {
			SokobanGame.getInstance().setLose(true);
			SokobanGame.getInstance().destroyObject(obj);
			SokobanGame.getInstance().getLm().loseLevel();
			SokobanGame.getInstance().getm().Restart();
		}else
			SokobanGame.getInstance().destroyObject(obj);
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
