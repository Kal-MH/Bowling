package game;

public class Frame {
	private int round;
	private int firstShot;
	private int secondShot;
	private int thirdShot;
	private boolean isStrike;
	private boolean isSpare;
	private boolean isCompleted;
	
	
	public Frame(int round) {
		this.round = round;
		
		firstShot = -1;
		secondShot = -1;
		thirdShot = -1;
		isStrike = false;
		isSpare = false;
		isCompleted = false;
	}
	
	
	public void setPinCount(int pins) {
		if (firstShot == -1) {
			firstShot = pins;
			if (firstShot == 10) {
				isStrike = true;
				isCompleted = true;
			}
		} else if (secondShot == -1) {
			secondShot = pins;
			
			if (firstShot + secondShot == 10) {
				isSpare = true;
			}
			
			isCompleted = true;
		} else if (round == 10 && thirdShot == -1) {
			thirdShot = pins;
			isCompleted = true;
		}
	}

	public int getRound() {
		return round;
	}


	public int getFirstShot() {
		return firstShot == -1 ? 0 : firstShot;
	}


	public int getSecondShot() {
		return secondShot == -1 ? 0 : secondShot;
	}


	public int getThirdShot() {
		return thirdShot == -1 ? 0 : thirdShot;
	}


	public boolean isStrike() {
		return isStrike;
	}


	public boolean isSpare() {
		return isSpare;
	}


	public boolean isCompleted() {
		return isCompleted;
	}
}
