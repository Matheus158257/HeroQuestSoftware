package br.unicamp.Game;

public class DoorMask {
	
	private int x;
	private int y;
	private int roomA;
	private int roomB;
	private boolean vert;

		
	DoorMask(int x, int y, boolean vert, int room) {
			this.x = x;
			this.y = y;
			this.roomA = room;
			this.roomB = room;
			this.vert = vert;
	}
	
	
	DoorMask(int x, int y, boolean vert, int roomA, int roomB) {
		this.x = x;
		this.y = y;
		this.roomA = roomA;
		this.roomB = roomB;
		this.vert = vert;
	}
	
	
	public Object[] getData() {
		Object[] doorData = {this.x,this.y,this.vert,this.roomA,this.roomB};
		return doorData;
	}
	
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	public boolean getVericability() {
		return this.vert;
	}
	
	public int getRoomA() {
		return this.roomA;
	}
	
	public int getRoomB() {
		return this.roomB;
	}
	
}
