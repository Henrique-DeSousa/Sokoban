package pt.iscte.dcti.poo.sokoban.starter;
import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.observer.Observed;
import pt.iul.ista.poo.observer.Observer;
import pt.iul.ista.poo.utils.Direction;

public class SokobanGame implements Observer {

	private static SokobanGame INSTANCE;

	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;

	private int totalTargets = 0;
	private int bullseye = 0;

	public boolean lose = false;

	private LevelMaker lM = new LevelMaker();
	private ScoreLogic sL = new ScoreLogic();
	private FileWriting fW = new FileWriting();
	private Player pl = new Player();
	private Menu m = new Menu();

	public Menu getm() {
		return m;
	}

	public LevelMaker getLm() {
		return lM;
	}

	public ScoreLogic getSl() {
		return sL;
	}

	public FileWriting getFw() {
		return fW;
	}

	public Player getPl() {
		return pl;
	}

	/*-Constructor-*/
	public SokobanGame(){
		getLm().levelMaking();
		ImageMatrixGUI.getInstance().addImages(getLm().getTiles());
		ImageMatrixGUI.getInstance().setName("Dungeon Fix Up");
		ImageMatrixGUI.getInstance().setStatusMessage("Level: "+ (lM.getLevelID()+1) + " Score: "+ sL.getScore() + " Energy: " + lM.getPlayer().getEnergy() + " Moves: " + lM.getPlayer().getTotalMoves());

	}

	public static SokobanGame getInstance() {
		if(INSTANCE == null)
			INSTANCE = new SokobanGame();
		return INSTANCE;
	}

	public boolean isLose() {
		return lose;
	}


	public void setLose(boolean value) {
		this.lose = value;
	}

	public int getTotalTargets() {
		return totalTargets;
	}


	public void setTotalTargets(int totalTargets) {
		this.totalTargets = totalTargets;
	}


	public int getBullseye() {
		return bullseye;
	}


	public void setBullseye(int bullseye) {
		this.bullseye = bullseye;
	}

	@Override
	public void update(Observed arg0) {
		int lastKeyPressed = ((ImageMatrixGUI)arg0).keyPressed();


		if ((getLm().getPlayer() != null && Direction.isDirection(lastKeyPressed)) && !lose) {
			getLm().getPlayer().setDirection(Direction.directionFor(lastKeyPressed));
			getLm().getPlayer().move(Direction.directionFor(lastKeyPressed));
			ImageMatrixGUI.getInstance().setStatusMessage("Level: "+ (lM.getLevelID()+1) + " Score: "+ sL.getScore() + " Energy: " + lM.getPlayer().getEnergy() + " Moves: " + lM.getPlayer().getTotalMoves());
		}

		ImageMatrixGUI.getInstance().update();
	}

	/* Helpful Functions for the Game */

	public void destroyObject(Objects obj) { // a function dedicated to simply destroying the objects
		SokobanGame.getInstance().getLm().getObjects().remove(obj);
		SokobanGame.getInstance().getLm().getTiles().remove(obj);
		ImageMatrixGUI.getInstance().removeImage(obj);
	}
}
