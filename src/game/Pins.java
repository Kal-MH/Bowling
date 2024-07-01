package game;

/*
 * TODO
 * 1. Max pin 갯수 지정하기
 * 2. 랜덤값 생성해서 몇 개의 pin 쓰러뜨렸는지 정하기
 *    - max pin을 넘어서 생성될 수 없음
 * 3. 처음 shot에 따라서, random값 조정
 **/
public class Pins {
	private static final int MAX_BOWLING_PIN_NUM = 10;
	private int pins;
	
	public Pins() {
		pins = MAX_BOWLING_PIN_NUM;
	}
	
	public void setPins() {
		this.pins = MAX_BOWLING_PIN_NUM;
	}
	
	public void rolling() {
		int randomValue = (int)(Math.random() * MAX_BOWLING_PIN_NUM + 1); // 1 ~ 10 사이의 숫자 생성
		pins -= randomValue;
	}
	
	public int getPins() {
		return pins;
	}
}
