package game;

import java.util.List;

import score.ScoreEvaluation;
import utils.BowlingConstants;

public class GameScoreReport {
	private static StringBuffer buffer;
	private final static String LINE = "----------------------------------------------------------------------------------\n";
	private final static String LINE_DOUBLE = "==================================================================================\n";
	private ScoreEvaluation evaluation = new ScoreEvaluation();
	
	public String getScoreReport(List<Player> playerList) {
		initializeBuffer();
		makeHeader();
		for(int i = 0; i < playerList.size(); i++) {
			Player p = playerList.get(i);
			makeBody(p);
			
			if (i < playerList.size() - 1) buffer.append(LINE);
		}
		makeFooter();
		return buffer.toString();
	}
	
	private void initializeBuffer() {
		buffer = new StringBuffer();
	}

	private void makeHeader(){
		buffer.append(LINE_DOUBLE);
		buffer.append("점수판\n");
		buffer.append(LINE_DOUBLE);
	} 
	
    private void makeBody(Player p){
    	List<Frame> playerFrameList = p.getFrameList();
    	
    	//UserName
    	buffer.append(p.getName() + '\n');
    	buffer.append("프레임:\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\n");
    	
    	makeBodyFrameScore(playerFrameList);
    	makeBodyScore(playerFrameList);
	}
    
    private void makeBodyFrameScore(List<Frame> playerFrameList) {
    	buffer.append("투구:\t");
    	for(Frame frame: playerFrameList) {
    		if (!frame.isCompleted()) break;
    		if (frame.isStrike()) {
    			buffer.append("X");
    			
    			if (frame.getRound() == 10) {
    	   			buffer.append(",");
    				buffer.append(frame.getSecondShot() == 10 ? "X" : frame.getSecondShot());
    			}
    		} else if (frame.isSpare()) {
    			buffer.append(frame.getFirstShot() + " /");
    		} else {
    			buffer.append(frame.getFirstShot() + "," + frame.getSecondShot());
    		}
    		
    		if (frame.getRound() == 10 && (frame.isSpare() || frame.isStrike())) {
    			buffer.append(",");
    			buffer.append(frame.getThirdShot() == 10 ? "X" : frame.getThirdShot());
    		}
    		
    		buffer.append("\t");
    	}
    	buffer.append("\n");
    }
    
    private void makeBodyScore(List<Frame> playerFrameList) {
    	buffer.append("점수:\t");
    	int sum = 0;
    	for(int i = 0; i < playerFrameList.size(); i++) {
    		Frame frame = playerFrameList.get(i);
    		boolean isAllCleared = frame.isSpare() || frame.isStrike();
    		boolean isNextFrameNotCompleted = (i + 1) < playerFrameList.size() && !playerFrameList.get(i + 1).isCompleted();
    		
    		
      		if (!frame.isCompleted()) break;
      		if (isAllCleared && isNextFrameNotCompleted) break;
      		
    		sum += evaluation.getScore(playerFrameList, i);
    		buffer.append(sum + "\t");
    	}
    	buffer.append("\n");
    	
		buffer.append("총점:\t");
		Frame firstFrame = playerFrameList.get(0);
    	Frame secondFrame = playerFrameList.get(1);
    	boolean isShowTotalSum = !(firstFrame.isSpare() || firstFrame.isStrike()) || secondFrame.isCompleted();
		if (isShowTotalSum) buffer.append(sum);
		buffer.append("\n");
    }
	
	private void makeFooter(){
		buffer.append(LINE_DOUBLE);
	}
	
	public String getTotalReport(List<Player> playerList) {
		initializeBuffer();
		
		buffer.append("최종 결과\n");
		for(Player p : playerList) {
			int total = evaluation.getTotalScore(p.getFrameList());
			buffer.append(p.getName() + " : " + total + "\n");
		}
		
		return buffer.toString();
	}
}
