package game;

import java.util.ArrayList;

import score.ScoreEvaluation;

/*
 * TODO
 * 1. header, body, footer로 출력포맷 정의하기
 * 2. ScoreEvaluation을 통해서 각 플레이어 순회하며 점수 계산 및 출력하기 
 * */
public class GameScoreReport {
	private static StringBuffer buffer;
	private final static String HEAD = "Bowling Game \t\t\n";
	private final static String LINE = "----------------------------------------------------------------------------------\n";
	private final static String LINE_DOUBLE = "==================================================================================\n";
	
	public static String getScoreReport(ArrayList<Player> playerList) {
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
	
	private static void initializeBuffer() {
		buffer = new StringBuffer();
	}

	private static void makeHeader(){
		buffer.append(LINE_DOUBLE);
		buffer.append("점수판\n");
		buffer.append(LINE_DOUBLE);
	} 
	
    private static void makeBody(Player p){
    	ArrayList<Frame> playerFrameList = p.getFrameList();
    	
    	//UserName
    	buffer.append(p.getName() + '\n');
    	buffer.append("프레임:\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\n");
    	
    	buffer.append("투구:\t");
    	//Frame Score
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
    	
    	buffer.append("점수:\t");
    	int sum = 0;
    	for(int i = 0; i < playerFrameList.size(); i++) {
    		Frame frame = playerFrameList.get(i);
    		boolean isAllCleared = frame.isSpare() || frame.isStrike();
    		boolean isNextFrameNotCompleted = (i + 1) < playerFrameList.size() && !playerFrameList.get(i + 1).isCompleted();
    		
      		if (!frame.isCompleted()) break;
      		if (isAllCleared && isNextFrameNotCompleted) break;
      		
    		sum += ScoreEvaluation.getScore(playerFrameList, i);
    		buffer.append(sum + "\t");
    	}
    	buffer.append("\n");
    	 
		buffer.append("총점:\t" + sum + "\n");
	}
	
	private static void makeFooter(){
		buffer.append(LINE_DOUBLE);
	}
}
