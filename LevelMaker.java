package pt.iscte.dcti.poo.sokoban.starter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Point2D;

public class LevelMaker {

	private Forklift player;
	private List<ImageTile> tiles = new ArrayList<>();
	private List<Objects> objects = new ArrayList<>();
	private int levelID = 4;

	public int getLevelID() {
		return levelID;
	}

	public void setLevelID(int levelID) {
		this.levelID = levelID;
	}

	public Forklift getPlayer() {
		return player;
	}

	public void setPlayer(Forklift player) {
		this.player = player;
	}


	public List<ImageTile> levelMaking(){
		try {
			Scanner lV = new Scanner(new File("levels/level" + levelID + ".txt"));
			String line = "";

			for (int y = 0; y != SokobanGame.HEIGHT; y++) {
				line = lV.nextLine();
				for (int x = 0; x != SokobanGame.WIDTH ; x++) {
					tiles.add(new Floor(new Point2D(x,y), "floor", 0));
					char letter = line.charAt(x); // checking the character in the X coordinate
					if(letter == 'E') {
						player = new Forklift(new Point2D(x,y),"Player_U", 2);
						tiles.add(player);
						objects.add(player);
					}else if(letter != ' ') {
						Objects objs = ObjectCreation.readChar(letter, x, y);
						tiles.add(objs);
						objects.add(objs);
					}
				}
			}
			lV.close(); //Closing Scanner

		}catch (FileNotFoundException e) {
			System.out.println("No levels found!");
			try {
				SokobanGame.getInstance().getFw().allScoresWrite();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.exit(0);
		}
		return tiles;	
	}

	private void eraseLevel(){
		tiles.clear();
		objects.clear();
		ImageMatrixGUI.getInstance().clearImages();	
	}

	public void nextLevel(){

		SokobanGame.getInstance().getSl().scoreLogic();
		try {
			SokobanGame.getInstance().getFw().levelWriter(levelID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		levelID++;
		player.setEnergy(101);
		player.setTotalMoves(-1);
		eraseLevel();
		levelMaking();
		ImageMatrixGUI.getInstance().addImages(tiles);
	}

	public void loseLevel() {
		try {
			SokobanGame.getInstance().getFw().levelWriter(levelID);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageMatrixGUI.getInstance().update();
		ImageMatrixGUI.getInstance().setStatusMessage("You've lost! Better luck next time!");
		eraseLevel();

	}

	public void restartLevel() {
		levelID = 0;
		eraseLevel();
		levelMaking();
		ImageMatrixGUI.getInstance().addImages(tiles);
		SokobanGame.getInstance().lose = false;

	}

	public List<ImageTile> getTiles() {
		return tiles;
	}

	public List<Objects> getObjects() {
		return objects;
	}
}
