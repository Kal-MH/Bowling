package game;

import java.util.ArrayList;

public class Player {
	private static final int MAX_FRAME_COUNT = 10;
	private String name;
	private ArrayList<Frame> frameList = new ArrayList<>();
	
	public Player(String name) {
		this.name = name;
		setFrameList();
	}
	
	private void setFrameList() {
		for(int i = 1; i <= MAX_FRAME_COUNT; i++) {
			if (i == MAX_FRAME_COUNT) {
				frameList.add(new Frame(i, "FINAL"));
				break;
			}
			frameList.add(new Frame(i, "BASIC"));
		}
	}
	
	public ArrayList<Frame> getFrameList() {
		return frameList;
	}
	
	public String getName() {
		return name;
	}
}
