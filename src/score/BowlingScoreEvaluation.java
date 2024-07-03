package score;

import java.util.List;

import game.Frame;

public interface BowlingScoreEvaluation {
	public abstract int getScore(List<Frame> frameList, int curFrameIdx);
}
