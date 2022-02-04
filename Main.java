package pt.iscte.dcti.poo.sokoban.starter;

import javax.swing.JFrame;
import pt.iul.ista.poo.gui.ImageMatrixGUI;

public class Main extends JFrame{
	private static final long serialVersionUID = 6631219590643176716L;


	static Menu m = new Menu();

	public static void main(String[] args) {
		m.PlayerName();
		ImageMatrixGUI.setSize(SokobanGame.WIDTH, SokobanGame.HEIGHT);
		ImageMatrixGUI.getInstance().registerObserver(SokobanGame.getInstance());
		ImageMatrixGUI.getInstance().go();

	}
}

