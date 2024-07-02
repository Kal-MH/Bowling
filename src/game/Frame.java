package game;

import java.util.ArrayList;

public class Frame {
	private int round; //회차
	private int firstShot;
	private int secondShot;
	private int thirdShot;
	private int[] shots;
	private boolean isStrike;
	private boolean isSpare;
	private boolean isCompleted;
	private int currentShot;
	
	
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
		return firstShot;
	}


	public int getSecondShot() {
		return secondShot;
	}


	public int getThirdShot() {
		return thirdShot;
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
