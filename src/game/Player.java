package game;

import java.util.ArrayList;

import utils.BowlingConstants;

public class Player {
	private String name;
	private ArrayList<Frame> frameList;
	
	public Player(String name) {
		this.name = name;
		frameList = new ArrayList<>();
		for(int i = 1; i <= BowlingConstants.MAX_FRAME_ROUND; i++) {
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
