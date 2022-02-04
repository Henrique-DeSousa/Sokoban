package pt.iscte.dcti.poo.sokoban.starter;

public class Player{
	
	private String name;
	private int score;
	
	public Player() {
		
	}
	
	public void setPlayerName(String name) {
		this.name = name;
	}

	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public int getScore() {
		return score;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name + "'s score: " + score + " points;\n";
	}

}
