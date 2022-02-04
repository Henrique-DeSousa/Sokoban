package pt.iscte.dcti.poo.sokoban.starter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class FileWriting {

	private ArrayList<Player> aux = new ArrayList<>();
	private ArrayList<Player> auxTotal = new ArrayList<>();
	private Player p;

	private int hiddenScore = 0;

	
	public void levelWriter(int levelID) throws IOException {
		int temp = SokobanGame.getInstance().getSl().getScore();
		hiddenScore = hiddenScore+temp;
		
		File Highscores = new File("Scoreboard/Level_" + levelID + "_Highscore.txt");
		p = new Player(SokobanGame.getInstance().getPl().getName(), SokobanGame.getInstance().getSl().getScore());

		if(Highscores.createNewFile()) { // creates the folder if it doesn't exist
			FileWriter highscoreWriter = new FileWriter(Highscores, false);
			highscoreWriter.write("/*---Highscores---*/ \n \n");
			highscoreWriter.write(p.toString());
			highscoreWriter.close();
		}else
			levelScoreOrganiser(levelID); // if it exists, it organises it ( if it's not already) and then rewrites it
	}

	private void levelRewrite(int levelID) throws IOException { // rewrites the level folder but organised
		File Highscores = new File("Scoreboard/Level_" + levelID + "_Highscore.txt");
		FileWriter highscoreWriter = new FileWriter(Highscores,false);
		highscoreWriter.write("/*---Highscores---*/ \n \n");
		p = new Player(SokobanGame.getInstance().getPl().getName(), SokobanGame.getInstance().getSl().getScore());
		
		for(Player pl : aux) {
			highscoreWriter.write(pl.toString());
		}
		highscoreWriter.close();
	}

	public void allScoresWrite() throws IOException {
		p = new Player(SokobanGame.getInstance().getPl().getName(), SokobanGame.getInstance().getSl().getScore());
		

		File Highscores = new File("Scoreboard/Highscores.txt");

		if(Highscores.createNewFile()){ // creates a general file for a major Highscore ( the sum of all the levels) if it doesn't exist already
			FileWriter highscoreWriter = new FileWriter(Highscores, false);
			highscoreWriter.write("/*---Highscores---*/ \n \n");
			highscoreWriter.write(p.toString());
			highscoreWriter.close();
		}else
			mainScoreOrganiser(); // if it exists, it organises it and then rewrites it 
	}
	private void allScoresRewrite() throws IOException {

		File Highscores = new File("Scoreboard/Highscores.txt");
		FileWriter highscoreWriter = new FileWriter(Highscores,false);
		highscoreWriter.write("/*---Highscores---*/ \n \n");

		for(Player pl : auxTotal) {
			highscoreWriter.write(pl.toString());
		}
		highscoreWriter.close();
	}

	public void levelScoreOrganiser(int levelID){

		ArrayList<Player> levelScores = new ArrayList<>();
		Comparator<Player> levelComp = new Comp();

		try {
			Scanner sc = new Scanner(new File("Scoreboard/Level_" + levelID + "_Highscore.txt"));
			String name = "";
			int score = 0;
			String aux1 = "";

			skipLines(sc, 2);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String aux[] = line.split("'s score: "); // splitting the line
				name = aux[0]; // storing everything before the split as the player name
				aux1 = aux[1]; // storing the rest as an aux
				String temp2[] = aux1.split(" "); // splitting the aux until a space is found
				score = Integer.parseInt(temp2[0]); // storing the int found as the score
				levelScores.add(new Player(name, score)); // adding to the array list a player with the name and score we just minced.
			}
			sc.close();
			levelScores.add(new Player(SokobanGame.getInstance().getPl().getName(), SokobanGame.getInstance().getSl().getScore()));// add the current player to the list.
			Collections.sort(levelScores, levelComp); // sorts through the array list and organizes it from highest to lowest

			aux = levelScores;
			levelRewrite(levelID);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void mainScoreOrganiser() throws IOException{

		ArrayList<Player> mainScores = new ArrayList<>();
		Comparator<Player> comp = new Comp();

		Scanner sc = new Scanner(new File("Scoreboard/Highscores.txt"));
		String name = "";
		String aux1 = "";
		int score = 0;

		skipLines(sc, 1);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String aux[] = line.split("'s score: "); // splitting the line until a :
			name = aux[0]; // storing everything before the split as the player name
			aux1 = aux[1]; // storing the rest as an aux
			String temp2[] = aux1.split(" "); // splitting the aux until a space is found
			score = Integer.parseInt(temp2[0]); // storing the int found as the score
			mainScores.add(new Player(name, score)); // adding to the array list a player with the name and score we just minced.

		}
		sc.close();

		mainScores.add(new Player(SokobanGame.getInstance().getPl().getName(), hiddenScore)); // add the current player to the list.
		Collections.sort(mainScores,comp); // sorts through the array list and organizes it from highest to lowest
		auxTotal = mainScores;

		allScoresRewrite();
	}

	private void skipLines(Scanner sc, int lineNum) { // this function is for the organiser to simply ignore the 2 first lines
		for(int i = 0; i < lineNum; i++)
			if(sc.hasNextLine())
				sc.nextLine();
	}

	private class Comp implements Comparator<Player>{

		@Override
		public int compare(Player o1, Player o2) {
			return o2.getScore() - o1.getScore();
		}
	}
}
