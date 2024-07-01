package game;

/*
 * TODO
 * 1. header, body, footer로 출력포맷 정의하기
 * 2. ScoreEvaluation을 통해서 각 플레이어 순회하며 점수 계산 및 출력하기 
 * */
public class GameScoreReport {
	private StringBuffer buffer = new StringBuffer();
	
	public String getScoreReport() {
		//makeHeader
		//makeBody
		//makeFooter
		return buffer.toString();
	}

	public void makeHeader(){
		// buffer.append("");
	} 
	
	public void makeBody(){
		// buffer.append("");
	}
	
	public void getScoreGrade(){
		// TODO : ScoreEvaluation으로 점수 계산
		// buffer.append("");
	}
	
	public void makeFooter(){
		buffer.append("\n");
	}
}
