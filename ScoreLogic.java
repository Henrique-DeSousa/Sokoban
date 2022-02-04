package pt.iscte.dcti.poo.sokoban.starter;

public class ScoreLogic {

	private int score = 0;

	public void scoreLogic() {
		int moves = SokobanGame.getInstance().getLm().getPlayer().getTotalMoves();
		int battery = SokobanGame.getInstance().getLm().getPlayer().getEnergy();
		int hiddenMoveScore = 200; //hiddenMovesScore
		int hiddenEnergyScore = 100; //hiddenEnergyScore


		if(SokobanGame.getInstance().getLm().getLevelID() == 0) { // tutorial level 100 points
			score = score + 100;
		}
		if(SokobanGame.getInstance().getLm().getLevelID() == 1) {

			if(moves <= 42)
				score = score + (hiddenMoveScore - 60);
			else if(moves > 43 && moves < 60) {
				score = score + (hiddenMoveScore - 120);
			}else
				score = score + (hiddenMoveScore - hiddenMoveScore);
			if(battery >= 91) {
				score = score + (hiddenEnergyScore + 40);
			}else if(battery > 92 && battery <= 58) {
				score = score + (hiddenEnergyScore - 30);
			}else
				score = score + (hiddenEnergyScore-hiddenEnergyScore);
		}

		if(SokobanGame.getInstance().getLm().getLevelID() == 2) {
			if(moves <= 76)
				score = score + (hiddenMoveScore);
			else if(moves > 76 && moves < 80) {
				score = score + (hiddenMoveScore - 100);
			}else
				score = score + (hiddenMoveScore - hiddenMoveScore);
			if(battery >= 24) {
				score = score + (hiddenEnergyScore + 50);
			}else if(battery < 24 && battery <= 20) {
				score = score + (hiddenEnergyScore -50);
			}else
				score = score + (hiddenEnergyScore-hiddenEnergyScore);
		}

		if(SokobanGame.getInstance().getLm().getLevelID() == 3) {
			if(moves <= 42)
				score = score + (hiddenMoveScore-20);
			else if(moves > 43 && moves <= 60) {
				score = score + (hiddenMoveScore - 100);
			}else
				score = score + (hiddenMoveScore - hiddenMoveScore);
			if(battery >= 91) {
				score = score + (hiddenEnergyScore + 50);
			}else if(battery < 90 && battery <= 58) {
				score = score + (hiddenEnergyScore);
			}else
				score = score + (hiddenEnergyScore-hiddenEnergyScore);
		} 

		if(SokobanGame.getInstance().getLm().getLevelID() == 4) {
			if(moves <= 59)
				score = score + (hiddenMoveScore+100);
			else if(moves > 59 && moves < 70) {
				score = score + (hiddenMoveScore + 20);
			}else
				score = score + (hiddenMoveScore - hiddenMoveScore);
			if(battery >= 41) {
				score = score + (hiddenEnergyScore + 60);
			}else if(battery < 41 && battery <= 20) {
				score = score + (hiddenEnergyScore);
			}else
				score = score + (hiddenEnergyScore-hiddenEnergyScore);
		}
		if(SokobanGame.getInstance().getLm().getLevelID() == 5) {
			if(moves <= 18)
				score = score + (hiddenMoveScore - 100);
			else if(moves > 18 && moves < 30) {
				score = score + (hiddenMoveScore - 150);
			}else
				score = score + (hiddenMoveScore - hiddenMoveScore);
			if(battery >= 82) {
				score = score + (hiddenEnergyScore - 50);
			}else if(battery < 82 && battery <= 70) {
				score = score + (hiddenEnergyScore - 30);
			}else
				score = score + (hiddenEnergyScore-hiddenEnergyScore);
		}
		if(SokobanGame.getInstance().getLm().getLevelID() == 6) {
			if(moves <= 45)
				score = score + (hiddenMoveScore-120);
			else if(moves > 45 && moves < 60) {
				score = score + (hiddenMoveScore - 160);
			}else
				score = score + (hiddenMoveScore - hiddenMoveScore);
			if(battery >= 55) {
				score = score + (hiddenEnergyScore - 60);
			}else if(battery < 55 && battery <= 70) {
				score = score + (hiddenEnergyScore - 80);
			}else
				score = score + (hiddenEnergyScore-hiddenEnergyScore);
		}
	}

	public int getScore() {
		return score;
	}
}
