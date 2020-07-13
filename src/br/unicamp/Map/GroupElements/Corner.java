package br.unicamp.Map.GroupElements;

public class Corner extends GroupMapElement {

	private int[] adjacentIDs;

	public Corner(int sizeX, int sizeY, int x0, int y0, int ID, int[] adjacentIDs) {
		super(sizeX, sizeY, x0, y0);
		// TODO Auto-generated constructor stub
		this.adjacentIDs = adjacentIDs;
	}
	
	
	public int[] getAdjacentIDs() {
		return adjacentIDs;
	}

}
