package game;

import java.util.ArrayList;

/*
 * TODO
 * 1. Pin 쓰러뜨리기
 * 2. Player의 frameList 불러와서 해당 회차 프레임에서 1차, 2차(혹은 3차) 기록
 * 3. 점수 계산해서 출력하기 
 * */
public class Game {
	static final int MAX_ROUND = 10;
	int playerNum;
	ArrayList<Player> playerList;
	Pins pins = new Pins();
	GameScoreReport report = new GameScoreReport();
	
	public Game(int playerNum) {
		this.playerNum = playerNum;
		playerList = new ArrayList<>();
		setGame();
	}
	
	private void setGame() {
		for(int i = 0; i < playerNum; i++) {
			playerList.add(new Player("Player" + (i + 1)));
		}
	}
	
	public void run() {
		Player p = playerList.get(0);
		
		//4. 10번 frame돌면서 기록하기 및 결과 출력하기
		for(int i = 0; i < MAX_ROUND; i++) {
			pins.setPins();
			
			int firstShot = pins.rolling();
			int secondShot = firstShot == 10 ? 0 : pins.rolling();
			
			ArrayList<Frame> playerFrameList = p.getFrameList();
			playerFrameList.get(i).addPinCount(firstShot);
			playerFrameList.get(i).addPinCount(secondShot);
			
			if (i == MAX_ROUND - 1 && pins.getPins() == 0) {
				pins.setPins();
				int lastShot = pins.rolling();
				playerFrameList.get(i).addPinCount(lastShot);
			}
			
			String result = report.getScoreReport(playerList);
			System.out.println(result);
		}
		//5. 10번 돌 때, score 계산하고 출력하기
		//6. player 수 늘려서 출력하기
	}
}
