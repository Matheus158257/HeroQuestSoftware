package br.unicamp.Map.GroupElements;


public class Room extends GroupMapElement {
	

	public Room(int sizeX, int sizeY, int x0, int y0, int ID) {
		super(sizeX, sizeY, x0, y0,ID);
		// TODO Auto-generated constructor stub

	}
	
	public Boolean acceptDoor(int doorX, int doorY) {
		Boolean accept = false;
		if ((this.x0 != doorX && this.y0!= doorY) && (this.x0 + this.sizeX != doorX && this.y0!= doorY) && (this.x0 != doorX && this.y0+this.sizeY != doorY) && (this.x0+this.sizeX != doorX && this.y0+this.sizeY != doorY)) {
			accept = true;
		}
		
		return accept;
	}
	

	/*
	@Override
	protected void strucSpace() {
		// Making outer walls
		for(int i=0; i<(this.sizeX); i++) {
			for(int j=0; j<(sizeY); j++) {
				mapElements[i][j] = new WallElement(i,j);
			}	
		}
		// Making room inside
		for(int i=x0+1; i<(x0+1+sizeX-2); i++) {
			for(int j=y0+1; j<(y0+1+sizeY-2); j++) {
				mapElements[i][j] = new FloorElement(i,j);
			}	
		}

	}*/
}
