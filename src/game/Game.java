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
	ArrayList<Player> playerList;
	int round;
	
	public Game() {
		playerList = new ArrayList<>();
		round = 1;
	}
	
	public void run(int playerNum) {
		//1. player 생성
//		for(int i = 0; i < playerNum; i++) {
//			playerList.add(new Player("Player" + i));
//		}
		Player p = new Player("Player1");
		
		//2. Pin random 생성해서 출력해보기
		Pins pins = new Pins();
		pins.rolling();
		
		int firstShot = pins.getPins();
		
		pins.setPins();
		pins.rolling();

		int secondShot = pins.getPins();
		
		//3. 첫번째 frame에 쓰러뜨린 pin 기록하기
		ArrayList<Frame> playerFrameList = p.getFrameList();
		playerFrameList.get(round).addPinCount(firstShot);
		playerFrameList.get(round).addPinCount(secondShot);
		
		ArrayList<Integer> pinCountList = playerFrameList.get(round).getPinCountList();
		for(int count: pinCountList) {
			System.out.println(count);
		}
		
		//4. 10번 frame돌면서 기록하기 및 결과 출력하기
		//5. 10번 돌 때, score 계산하고 출력하기
		//6. player 수 늘려서 출력하기
	}
}
