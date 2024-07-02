package score;

import java.util.ArrayList;

/*
 * TODO
 * 1. curFirstShot, curSecondShot을 합치는 메서드를 따로 뺄까?
 * 2. strike 점수 계산하는 메서드
 * 3. */

import game.Frame;

public class ScoreEvaluation {
	public static int getScore(ArrayList<Frame> frameList, int curFrameIdx) {
		Frame curFrame = frameList.get(curFrameIdx);
		int curFirstShot = getSafeShot(curFrame.getFirstShot());
		int curSecondShot = getSafeShot(curFrame.getSecondShot());
		
		int score = curFirstShot + curSecondShot;
		
		if (curFrame.isStrike()) {
			if (curFrameIdx + 1 < frameList.size()) {
				Frame nextFrame = frameList.get(curFrameIdx + 1);
				
				int nextFirstShot = getSafeShot(nextFrame.getFirstShot());
				int nextSecondShot = getSafeShot(nextFrame.getSecondShot());
				
				score += nextFirstShot;
				if (nextFrame.isStrike() && (curFrameIdx + 2) < frameList.size()) {
					score += getSafeShot(frameList.get(curFrameIdx + 2).getFirstShot());
				} else {
					score += nextSecondShot;
				}
			}
		} else if (curFrame.isSpare()) {
			if (curFrameIdx + 1 < frameList.size()) {
				score += frameList.get(curFrameIdx + 1).getFirstShot();
			}
		}
		
		if (curFrame.getRound() == 10 && (curFrame.isSpare() || curFrame.isStrike())) {
			score += curFrame.getThirdShot();
		}
		
		return score;
	}
	
	private static int getSafeShot(int shot) {
		return shot == -1 ? 0 : shot;
	}

}
