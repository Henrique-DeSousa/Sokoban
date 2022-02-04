package pt.iscte.dcti.poo.sokoban.starter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Menu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -776221723030491203L;

	public Menu() {
		
	}

	public void PlayerName() {

		String name = JOptionPane.showInputDialog(rootPane,"Please enter your Player name:", "Dungeon Fix Up", JOptionPane.PLAIN_MESSAGE);
		if(name != null && !name.isEmpty())
			SokobanGame.getInstance().getPl().setPlayerName(name);
		else {
			System.exit(0);
		}
	}
	
	public void Restart() {
		Object[] options = {"Sure", "Maybe another time..."};
		int n = JOptionPane.showOptionDialog(rootPane, "Would you like to restart?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options, options[0]);
		if(n == JOptionPane.YES_OPTION) 
			SokobanGame.getInstance().getLm().restartLevel();
		else 
			System.exit(0);
	}
}

