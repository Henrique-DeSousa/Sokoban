package pt.iscte.dcti.poo.sokoban.starter;

import java.util.ArrayList;

import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

abstract class Movable extends Objects{

	public Movable(Point2D position, String imageName, int layer) {
		super(position, imageName, layer);
		// TODO Auto-generated constructor stub
	}

	public void move(Direction direction) {
		Point2D currentPosition = getPosition();
		Point2D newPosition = currentPosition.plus(direction.asVector());
		Objects obj1 = getObject(newPosition);

		if(isWalkable(newPosition))
			setPosition(newPosition);
		if(obj1 instanceof Interactable) {
			((Interactable)obj1).interact(this);
		}
	}

	public boolean isWalkable(Point2D pos) { // is the object able to move to the next position
		for(Objects obj1 : SokobanGame.getInstance().getLm().getObjects()) { // for-each to get all the objects, with the exception of the floor, from the game.
			if(obj1.isBlockable() && obj1.getPosition().equals(pos)){ // if the object is able to block and if it's position is the same as the nextPosition.
				return false;
			}
		}
		return true; // otherwise it's able to be walked on.
	}

	public Objects getObject(Point2D position) {
		for(Objects obj : SokobanGame.getInstance().getLm().getObjects()) {
			if(obj.getPosition().equals(position)) {
				return obj;
			}
		}
		return null;
	}

	public ArrayList<Objects> Overlap() {
		ArrayList<Objects> aux = new ArrayList<>();
		
		for(Objects obj : SokobanGame.getInstance().getLm().getObjects()) {
			for(Objects obj1 : SokobanGame.getInstance().getLm().getObjects()) {
				if(obj.getPosition().equals(obj1.getPosition())) {
					aux.add(obj);
					aux.add(obj1);
				}
			}
		}
		return aux;
	}

	public Objects getMovableObject(Point2D position) {
		for(Objects obj : SokobanGame.getInstance().getLm().getObjects()) {
			if(obj.getPosition().equals(position) && obj instanceof Movable) {
				return obj;
			}
		}
		return null;
	}

	public Objects getInteractableObject(Point2D position) {
		for(Objects obj : SokobanGame.getInstance().getLm().getObjects()) {
			if(obj.getPosition().equals(position) && obj instanceof Interactable){
				return obj;
			}
		}
		return null;
	}



}
