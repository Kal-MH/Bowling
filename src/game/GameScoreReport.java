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
		buffer.append(LINE_DOUBLE);
	} 
	
    private void makeBody(Player p){
    	ArrayList<Frame> playerFrameList = p.getFrameList();
    	
    	//UserName
    	buffer.append(p.getName() + '\n');
    	buffer.append("프레임:\\t1\\t2\\t3\\t4\\t5\\t6\\t7\\t8\\t9\\t10");
    	buffer.append("투구:\t");
    	
    	//Frame Score
    	
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
