package game;

import java.util.ArrayList;

public class Frame {
	private int round; //회차
	private int maxPinCount;
	private String type; //1~9회차의 프레임 or 10회차 프레임
	private ArrayList<Integer> pinCountList = new ArrayList<>(); // 쓰러뜨린 pin 갯수
	
	
	public Frame(int round, String type) {
		this.round = round;
		this.type = type;
		setMaxPinCount();
	}
	
	private void setMaxPinCount() {
		switch (this.type) {
			case "BASIC" : 
				maxPinCount = 2;
				break;
			case "FINAL" : 
				maxPinCount = 3;
				break;
			default:
				throw new IllegalArgumentException("Error: Frame type, Basic or Final만 넣어주세요.");
		}
	}
	
	public void addPinCount(int count) {
		if (pinCountList.size() >= maxPinCount) {
			throw new IllegalArgumentException("더 이상 던질 수 없습니다.");
		}
		pinCountList.add(count);
	}

	public int getRound() {
		return round;
	}

	public int getMaxPinCount() {
		return maxPinCount;
	}

	public String getType() {
		return type;
	}

	public ArrayList<Integer> getPinCountList() {
		return pinCountList;
	}
	
}
