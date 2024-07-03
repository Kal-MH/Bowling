package game;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import utils.BowlingConstants;

public class Game {
	private int playerNum;
	private int curPlayerIdx;
	private int curRound;
	private ArrayList<Player> playerList;
	private boolean isFinished;
	private Scanner scanner;
	private GameScoreReport report;
	
	
	public Game(int playerNum) {
		this.playerNum = playerNum;
		curPlayerIdx = 0;
		curRound = 1;
		isFinished = false;
		playerList = new ArrayList<>();
		for(int i = 0; i < this.playerNum; i++) {
			playerList.add(new Player("Player" + (i + 1)));
		}
		
		scanner = new Scanner(System.in);
		report = new GameScoreReport();
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bowling Game");
		
		while (!isFinished) {
			startRound();
			
			curPlayerIdx = (curPlayerIdx + 1) % playerList.size();
			if (curPlayerIdx == 0) {
				printResult();
				curRound++;
				isFinished = curRound > BowlingConstants.MAX_FRAME_ROUND;
			}
		}

		String result = report.getTotalReport(playerList);
		System.out.println(result);
		scanner.close();
	}
	
	private void startRound() {
		Player curPlayer = playerList.get(curPlayerIdx);
		Frame curFrame = curPlayer.getFrameList().get(curRound - 1);
		
		if (curPlayerIdx == 0) System.out.println("프레임 " + curRound + " 경기를 시작합니다.");
		System.out.println("[" + curPlayer.getName() + "]");
		
		if (!curFrame.isCompleted()) {
			playFrame(curFrame);
		}
	}
	
	private void playFrame(Frame frame) {
		int firstShot = getValidShot("첫번째 투구 : ",  0, 10);
		frame.setPinCount(firstShot);
		
		if (!frame.isStrike() || (curRound == 10 && frame.isStrike())) {
			int remainingPins = curRound != 10 ? 10 - firstShot : 10;
	        int secondShot = getValidShot("두번째 투구 : ", 0, remainingPins);
	        frame.setPinCount(secondShot);
		}
        
        if (curRound == 10 && (frame.isSpare() || frame.isStrike())) {
           int thirdShot = getValidShot("보너스 투구 : ", 0, 10);
           frame.setPinCount(thirdShot);
        }
	}
	
	private int getValidShot(String prompt, int min, int max) {
		int shot; 
		
		while (true) {
			try {
				System.out.print(prompt);
	             shot = scanner.nextInt();
	             if (shot >= min && shot <= max) {
	                 return shot;
	             } else {
	                 System.out.println("잘못된 입력입니다. "+min+"에서 "+ max+" 사이의 값을 입력하세요.");
	                 
	             }
			} catch(InputMismatchException e) {
				 System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
				 scanner = new Scanner(System.in);
			}
         }
	}
	
	private void printResult() {
		System.out.println();
		String reportStr = report.getScoreReport(playerList);
		System.out.println(reportStr);
	}
}
