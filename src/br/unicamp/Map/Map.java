package br.unicamp.Map;

import br.unicamp.Map.GroupElements.Hall;
import br.unicamp.Map.GroupElements.Room;
import br.unicamp.Map.GroupElements.Wall;
import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Map.MapElements.StaticElements.FloorElement;
import br.unicamp.Map.MapElements.StaticElements.WallElement;
import br.unicamp.Exceptions.*;
import br.unicamp.Map.MapElements.Command;
import br.unicamp.Map.MapElements.Characters.Character;;


public class Map {

	public static final int ROOMS = 22;

	public static final int SIZE_X = 34;
	public static final int SIZE_Y = 25;

	private int sizeX;
	private int sizeY;

	private MapElement map[][];

	//	private Characters characterMask[][];
	//	private ArrayList<Room>[] rooms = new ArrayList[nRooms]; 
	//	private List<Wall> wall = new ArrayList<Wall>();
	//	private List<FloorElement> hall = new ArrayList<FloorElement>();



	//----------------------- Constructors

	public Map() {
		this.sizeX = Map.SIZE_X;
		this.sizeY = Map.SIZE_Y;

		this.map = new MapElement[this.sizeX][this.sizeY];

		// sets FloorElement in entire map
		for(int i=0; i<sizeX; i++) {
			for(int j=0; j<sizeY; j++) {
				map[i][j] = new FloorElement(i,j);
			}	
		}

		// Making fixed Rooms
		makeRooms();




	}

	//----------------------- Public Methods


	public void print() {
		for (int j = 0; j < this.sizeY ; j++) {
			for (int i=0; i<this.sizeX; i++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.print("\n") ;
		}
	}

	public void addElement(MapElement element) {
		int posX=element.getX();
		int posY=element.getY();

		this.map[posX][posY] = element;
	}

	public void moveCharacter(Command direction, Character character) throws OccupiedTileException, OutOfBoundsException {
		int currX = character.getX();
		int currY = character.getY();
		int incrX=0;
		int incrY=0;

		switch (direction) {
		case UP:
			incrX=0;
			incrY=-1;
			break;
		case RIGHT:
			incrX=1;
			incrY=0;
			break;
		case DOWN:
			incrX=0;
			incrY=1;
			break;
		case LEFT:
			incrX=-1;
			incrY=0;
			break;
		default:
			break;
		}


		int destX = character.getX()+incrX;
		int destY = character.getY()+incrY;


		if (isInMap(destX,destY)) {

			if (isFree(destX,destY)) {

				character.changePosition(direction);
				//					int destX = character.getX();
				//					int destY = character.getY();

				map[currX][currY] = new FloorElement(currX,currY);
				map[destX][destY] = character;

			} else {
				String message = ("Tried to move to an occupied tile.");
				throw new OccupiedTileException(message);
			}
		} else {
			String message = ("Tried to move out of bounds.");
			throw new OutOfBoundsException(message);
		}
	}




	//----------------------- Private Methods

	// Method to check if a Tile is inside the map (TRUE) or Out of Bounds (FALSE)
	private boolean isInMap(int X, int Y) {
		if(X<sizeX && Y<sizeY && X>=0 && Y>=0) {
			return true;
		} else {
			return false;
		}
	}


	// Method to check is a Tile is empty (free)	
	private boolean isFree(int X, int Y) {

		if(isInMap(X,Y)) {

			if (map[X][Y].isFree()) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}

	}


	private void makeRoom(int sizeX, int sizeY, int x0, int y0) {
		// Making outer walls
		for(int i=x0; i<(x0+sizeX); i++) {
			for(int j=y0; j<(y0+sizeY); j++) {
				map[i][j] = new WallElement(i,j);
			}	
		}
		// Making room inside
		for(int i=x0+1; i<(x0+1+sizeX-2); i++) {
			for(int j=y0+1; j<(y0+1+sizeY-2); j++) {
				map[i][j] = new FloorElement(i,j);
			}	
		}

	}

	private void makeRooms() {
		// Room 1
		makeRoom(6,5,1,1);
		// TODO new Room ?
		// Room 2
		makeRoom(6,5,6,1);
		// Room 3
		makeRoom(5,7,11,1);
		// Room 4
		makeRoom(6,7,1,5);
		// Room 5
		makeRoom(6,7,6,5);

		// Room 6
		makeRoom(5,7,18,1);
		// Room 7
		makeRoom(6,6,22,1);
		// Room 8
		makeRoom(6,6,27,1);
		// Room 9
		makeRoom(6,6,22,6);
		// Room 10
		makeRoom(6,6,27,6);

		// Room 11
		makeRoom(6,6,1,13);
		// Room 12
		makeRoom(6,5,6,13);
		// Room 13
		makeRoom(6,6,1,18);
		// Room 14
		makeRoom(6,7,6,17);
		// Room 15
		makeRoom(5,7,11,17);

		// Room 16
		makeRoom(6,6,22,13);
		// Room 17
		makeRoom(6,6,27,13);
		// Room 18
		makeRoom(5,7,18,17);
		// Room 19
		makeRoom(6,6,22,18);
		// Room 20
		makeRoom(6,6,27,18);

		// Room 21
		makeRoom(8,7,13,9);
	}


	//----------------------- Getters and Setters





	//	private void generateCharacterMask(){
	//		for(int j = Map.Y_MAX-1; j>=0; j-- ){
	//			for(int i = this.xMax-1; i>=0; i-- ){
	////				this.activeMask[i][j] = new EmptyMask(i,j);
	//			}
	//		}
	//	}


}
