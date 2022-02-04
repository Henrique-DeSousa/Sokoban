package pt.iscte.dcti.poo.sokoban.starter;

import java.util.ArrayList;
import java.util.List;

import pt.iul.ista.poo.utils.Point2D;

public class Target extends Objects implements Interactable{

	public Target(Point2D position, String imageName, int layer) {
		super(position, imageName, layer);
	}

	@Override
	public boolean isInteractable() {
		return true;
	}

	@Override
	public void interact(Objects obj) {
		if(obj instanceof Box) {
			ArrayList<Target> targets = new ArrayList<>();
			ArrayList<Box> boxes = new ArrayList<>(); // some code should be in the sokoban
			List<Objects> aux = SokobanGame.getInstance().getLm().getObjects();
			int totalTargets = 0;
			int bullseye = 0;

			for(Objects obj1 : aux) {
				if(obj1 instanceof Target){
					targets.add((Target)obj1);
					totalTargets++;
				}
				if(obj1 instanceof Box) {
					boxes.add((Box)obj1);
				}
			}
			for(Target trgts : targets) {
				for(Box bxs : boxes) {
					if(trgts.getPosition().equals(bxs.getPosition())) {
						bullseye++;
						trgts.setImageName("OpenChest");
					}
				}

			}
			if(bullseye == totalTargets) {
				SokobanGame.getInstance().getLm().nextLevel();
			}
		}
	}

	@Override
	public boolean isBlockable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMovable() {
		// TODO Auto-generated method stub
		return false;
	}




}
