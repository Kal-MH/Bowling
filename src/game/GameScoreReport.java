package game;

import java.util.ArrayList;

/*
 * TODO
 * 1. header, body, footer로 출력포맷 정의하기
 * 2. ScoreEvaluation을 통해서 각 플레이어 순회하며 점수 계산 및 출력하기 
 * */
public class GameScoreReport {
	private StringBuffer buffer = new StringBuffer();
	private final static String HEAD = "Bowling Game \t\t\n";
	private final static String HEAD_INTRODUCE = "   User  ||  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10  |\n";
	private final static String LINE = "-----------------------------------------------------------------------\n";
	private final static String LINE_DOUBLE = "=======================================================================\n";
	
	public String getScoreReport(ArrayList<Player> playerList) {
		//makeHeader
		makeHeader();
		//makeBody
		for(Player p : playerList) {
			makeBody(p);
		}
		//makeFooter
		makeFooter();
		return buffer.toString();
	}

	private void makeHeader(){
		// buffer.append("");
		buffer.append(HEAD);
		buffer.append(LINE);
		buffer.append(HEAD_INTRODUCE);
		buffer.append(LINE_DOUBLE);
	} 
	
    private void makeBody(Player p){
    	ArrayList<Frame> playerFrameList = p.getFrameList();
    	
    	//UserName
    	buffer.append(" " + p.getName());
    	buffer.append(" || ");
    	
    	//Frame Score
    	for(int i = 0; i < 10; i++) {
    		ArrayList<Integer> pinCountList = playerFrameList.get(i).getPinCountList();
    		for(int j = 0; j < pinCountList.size(); j++) {
    			buffer.append(pinCountList.get(j));
    			if (j < pinCountList.size() - 1) buffer.append(' ');
    		}
    		buffer.append(" | ");
    	}
		buffer.append("\n");
		buffer.append(LINE);
	}
	
	private void getScore(){
		// TODO : ScoreEvaluation으로 점수 계산
		// buffer.append("");
	}
	
	private void makeFooter(){
		buffer.append("\n");
	}
}
