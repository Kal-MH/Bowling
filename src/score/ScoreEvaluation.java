package score;

import java.util.List;


import game.Frame;

public class ScoreEvaluation implements BowlingScoreEvaluation {
	@Override
	public int getScore(List<Frame> frameList, int curFrameIdx) {
		Frame curFrame = frameList.get(curFrameIdx);
		int curFirstShot =curFrame.getFirstShot();
		int curSecondShot = curFrame.getSecondShot();
		
		int score = curFirstShot + curSecondShot;
		
		if (curFrame.isStrike()) {
			score += calculateStrike(frameList, curFrameIdx);
		} else if (curFrame.isSpare()) {
			score += calculateSpare(frameList, curFrameIdx);
		}
		
		score += calculateTenthBonus(curFrame);
		
		return score;
	}
	
	private int calculateStrike(List<Frame> frameList, int curFrameIdx) {
		int score = 0;
		
		if (curFrameIdx + 1 < frameList.size()) {
			Frame nextFrame = frameList.get(curFrameIdx + 1);
			
			int nextFirstShot = nextFrame.getFirstShot();
			int nextSecondShot = nextFrame.getSecondShot();
			
			score += nextFirstShot;
			if (nextFrame.isStrike() && (curFrameIdx + 2) < frameList.size()) {
				score += frameList.get(curFrameIdx + 2).getFirstShot();
			} else {
				score += nextSecondShot;
			}
		}
		
		return score;
	}
	
	private int calculateSpare(List<Frame> frameList, int curFrameIdx) {
		int score = 0;
		
		if (curFrameIdx + 1 < frameList.size()) {
			score += frameList.get(curFrameIdx + 1).getFirstShot();
		}
		
		return score;
	}
	
	private int calculateTenthBonus(Frame curFrame) {
		int score = 0;
		
		if (curFrame.getRound() == 10 && (curFrame.isSpare() || curFrame.isStrike())) {
			score += curFrame.getThirdShot();
		}
		
		return score;
	}
}
