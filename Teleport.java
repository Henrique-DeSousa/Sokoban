package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Point2D;

public class Teleport extends Objects implements Interactable{

	public Teleport(Point2D position, String imageName, int layer) {
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

	private boolean isFull(Point2D pos) {
		boolean full = false;

		for(Objects obj1 : SokobanGame.getInstance().getLm().getObjects()) {
			if(obj1 instanceof Movable) { // looking for an obj
				if(obj1.getPosition().equals(pos)) { // if the obj we found is Movable and is in the same Position as the Teleport
					full = true; // it sets the boolean to true, meaning, that nothing will be transported until the other side is cleared
				}
			}
		}
		return full; // otherwise returns the original value
	}
	@Override
	public void interact(Objects obj) {

		for(Objects obj1 : SokobanGame.getInstance().getLm().getObjects()) {
			if(obj1 instanceof Teleport && !obj1.equals(this)) {
				if(!isFull(obj1.getPosition())){ // if the empty return true and it;s the same position
					obj.setPosition(obj1.getPosition()); // teleports the object to the other Teleport
				}
			}
		}
	}
}