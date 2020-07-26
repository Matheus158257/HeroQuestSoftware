
package br.unicamp.Map.MapElements.StaticElements.VariableElements;

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
	

	@Override
	public String toString() {
		return "U";
	}

	
	
	public Coordinate getDestination(Character character) {
		int currX = character.getX();
		int currY = character.getY();
		int xA = coordA.getX();
		int yA = coordA.getY();
				
		if(xA == currX && yA == currY) {
			return coordB;
		} else {
			return coordA;
		}
	}
	
	
	public Coordinate reposition(Character character) {
		Coordinate destination = this.getDestination(character);
		this.roomA.lightsOn();
		this.roomB.lightsOn();
		character.changePosition(destination.getX(), destination.getY());
		
//		System.out.print("LOG: Repositioning player to destination: " + destination);
		return destination;
	}
	
	@Override
	public boolean goThrough(Character character) {
		return true;
	}
	
}
