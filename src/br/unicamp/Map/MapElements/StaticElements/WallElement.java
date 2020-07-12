package br.unicamp.Map.MapElements.StaticElements;

import java.util.ArrayList;

public class WallElement extends StaticElement {

	private ArrayList<Integer> regionsWithAcess;
	private Boolean acceptDoor;
	public WallElement(int x, int y) {
		super(x, y);
		this.regionsWithAcess = new ArrayList<Integer>();
		this.acceptDoor = false;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "X";
	}

	@Override
	public boolean isFree() {
		return false;
	}
	
	public void changeDoorAcceptability(int sizeX, int sizeY, int x0, int y0) {
		/*
		if ((this.getX() != x0 && this.getY()!= y0) && (this.getX() != x0+sizeX && this.getY() != y0) && (this.getX() != x0-sizeX && this.getY()!= y0)) {
			this.acceptDoor = false;
		}*/

	}
	
	public void changeDoorAcceptability() {
		this.acceptDoor = true;
	}
	
	public void adddRegionsWithAcess(int regionID) {
		regionsWithAcess.add(regionID);
	}
	
	public ArrayList<Integer> checkRegionsWithAcess() {
		return this.regionsWithAcess;
	}
	
}
