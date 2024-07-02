package game;

import java.util.ArrayList;

public class Player {
	private static final int MAX_FRAME_COUNT = 10;
	private String name;
	private ArrayList<Frame> frameList;
	
	public Player(String name) {
		this.name = name;
		frameList = new ArrayList<>();
		for(int i = 1; i <= MAX_FRAME_COUNT; i++) {
			frameList.add(new Frame(i));
		}
	}
	
	public ArrayList<Frame> getFrameList() {
		return frameList;
	}
	
	public String getName() {
		return name;
	}
}
