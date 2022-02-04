package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

public class Forklift extends Movable{
	
	private Direction direction;
	private boolean canBreakDamagedWalls = false; // can the player break the damaged wall? No by default 
	private int energy = 100; // energy used for the player to move
	private int totalMoves = 0; // the total of moves the player did.
	
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public boolean isCanBreak() {
		return canBreakDamagedWalls;
	}

	public void setCanBreak(boolean value) {
		this.canBreakDamagedWalls = value;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getTotalMoves() {
		return totalMoves;
	}

	public void setTotalMoves(int totalMoves) {
		this.totalMoves = totalMoves;
	}

	public Forklift(Point2D position, String imageName, int layer) {
		super(position, imageName, layer);
	}

	@Override
	public void move(Direction direction) {
		Point2D currentPosition = getPosition();
		Point2D newPosition = currentPosition.plus(this.direction.asVector());
		Objects obj0 = getMovableObject(newPosition);
		Objects obj1 = getObject(newPosition);
		// create a list for the objects that are in the same position 

		if(energy > 0 ) {
			if(obj0 != null && obj0.isMovable()) {
				((Movable)obj0).move(direction);
			}
			if(isWalkable(newPosition)) {
				setPosition(newPosition);
				totalMoves++;
				energy--;
			}
			if(obj1 != null && obj1 instanceof Interactable)
				((Interactable)obj1).interact(this); // polimorphismo
		}
		changeImage(direction);
	}

	public void changeImage(Direction direction) { // function to change the direction of the player according to the direction it wants to go
		switch(direction) {
		case DOWN:
			setImageName("Player_D");
			break;		
		case UP:
			setImageName("Player_U");
			break;
		case LEFT:
			setImageName("Player_L");
			break;
		case RIGHT:
			setImageName("Player_R");
			break;
		default:
			setImageName("Player_U");
			break;
		}
	}

	@Override
	public boolean isBlockable() {
		return false;
	}

	@Override
	public boolean isMovable() {
		return true;
	}
}
