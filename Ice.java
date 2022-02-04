package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

public class Ice extends Objects implements Interactable{

	private Direction direction;


	public Ice(Point2D position, String imageName, int layer) {
		super(position, imageName, layer);
	}

	@Override
	public boolean isBlockable() {
		// TODO Auto-generated method stub
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
		this.direction = SokobanGame.getInstance().getLm().getPlayer().getDirection(); 
		if(obj instanceof Movable && obj.getPosition().equals(this.getPosition())) {
			((Movable) obj).move(direction);
			
		}
	}
}
