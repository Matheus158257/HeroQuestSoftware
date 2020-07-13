package br.unicamp.Map.MapElements.StaticElements.VariableElements;

import br.unicamp.Map.Map;
import br.unicamp.Map.GroupElements.Room;
import br.unicamp.Map.MapElements.Coordinate;
import br.unicamp.Map.MapElements.Characters.Character;

public class Door extends VariableElement {

	private Room roomA;
	private Room roomB;
	private Coordinate coordA;
	private Coordinate coordB;
	
	// Constructor for Doors between one room and a hall
	public Door(int x, int y, Room room, boolean vert) {
		super(x, y);
		this.roomA = room;
		this.roomB = room;
		if(vert) {
			this.coordA = new Coordinate(x,y+1);
			this.coordB = new Coordinate(x,y-1);
		} else {
			this.coordA = new Coordinate(x+1,y);
			this.coordB = new Coordinate(x-1,y);
		}
	}
	
	// Constructor for Doors between two rooms
	public Door(int x, int y, Room roomA,  Room roomB, boolean vert) {
		super(x, y);
		this.roomA = roomA;
		this.roomB = roomB;
		if(vert) {
			this.coordA = new Coordinate(x,y+1);
			this.coordB = new Coordinate(x,y-1);
		} else {
			this.coordA = new Coordinate(x+1,y);
			this.coordB = new Coordinate(x-1,y);
		}
	}
	

	
//	public Door(int x, int y, Room roomA, Room roomB) {
//		super(x, y);
//		this.room = room;
//	}


	@Override
	public String toString() {
		return "U";
	}

	private void open(Character character) {
		int xA = this.coordA.getX();
		int yA = this.coordA.getY();
		int xB = this.coordB.getX();
		int yB = this.coordB.getY();
		int currX = character.getX();
		int currY = character.getY();
		
		// TODO Open Door
		System.out.println("LOG: Opening Door");
		if(currX==xA && currY==yA) {
			character.changePosition(xB, yB);
			System.out.println("LOG: Moving to " + xB + ", " + yB);
		} else {
			character.changePosition(xA, yA);
			System.out.println("LOG: Moving to " + xA + ", " + yA);
		}
	}
	
	@Override
	public boolean interact(Character character){
		open(character);
		this.roomA.lightsOn();
		this.roomB.lightsOn();
//		if(roomB!=null) {
//			this.roomB.lightsOn();
//		}
		return true;
	}
	
}
