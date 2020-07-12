package br.unicamp.Map;

import br.unicamp.Map.GroupElements.Corner;
import br.unicamp.Map.GroupElements.Hall;
import br.unicamp.Map.GroupElements.Room;
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

	private Room[] rooms = new Room[22];
	private Hall[] halls= new Hall[16];
	private Corner[] corners= new Corner[16];

	//	private Characters characterMask[][];
	//	private ArrayList<Room>[] rooms = new ArrayList[nRooms]; 
	//	private List<Wall> wall = new ArrayList<Wall>();
	//	private List<FloorElement> hall = new ArrayList<FloorElement>();



	//----------------------- Constructors

	public Map() {
		this.sizeX = Map.SIZE_X;
		this.sizeY = Map.SIZE_Y;

		this.map = new MapElement[this.sizeX][this.sizeY];


		// /it was a strategy to just add a bound on add rooms and avoid an instance of
		for(int i=0; i<sizeX; i++) {
			for(int j=0; j<sizeY; j++) {
				map[i][j] = new WallElement(i,j);
			}	
		}

		// Making fixed Rooms
		makeRooms();
		makeHalls();
		makeCorners();




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
				
				//Essa parte aqui vai ser uma brisa. Tem que verificar se
				//está trocando de região, mas por enquanto vou pegar apenas 
				// a anterior
				FloorElement floor = (FloorElement) map[currX][currY];
				map[currX][currY] = new FloorElement(currX,currY,floor.getID());
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


	private void makeRoom(Room room) {
		// Making outer walls
		for(int i=room.getX0(); i<(room.getX0()+room.getSizeX()); i++) {
			for(int j=room.getY0(); j<(room.getY0()+room.getSizeY()); j++) {
				WallElement wall= (WallElement)map[i][j];
				wall.adddRegionsWithAcess(room.getID());
				if (room.acceptDoor(i,j)){
					wall.changeDoorAcceptability();
				}
				map[i][j] = wall;
			}	
		}
		
		// Making room inside
		for(int i=room.getX0()+1; i<(room.getX0()+1+room.getSizeX()-2); i++) {
			for(int j=room.getY0()+1; j<(room.getY0()+1+room.getSizeY()-2); j++) {
				map[i][j] = new FloorElement(i,j,room.getID());
			}	
		}

	}

	private void makeRooms() {
		
		this.rooms[0] = new Room(6,5,1,1,1);
		this.rooms[1] = new Room(6,5,6,1,2);
		this.rooms[2] = new Room(5,7,11,1,3);
		this.rooms[3] = new Room(6,7,1,5,4);
		this.rooms[4] = new Room(6,7,6,5,5);
		this.rooms[5] = new Room(5,7,18,1,6);
		this.rooms[6] = new Room(6,6,22,1,7);
		this.rooms[7] = new Room(6,6,27,1,8);
		this.rooms[8] = new Room(6,6,22,6,9);
		this.rooms[9] = new Room(6,6,27,6,10);
		this.rooms[10] = new Room(6,6,1,13,11);
		this.rooms[11] = new Room(6,5,6,13,12);
		this.rooms[12] = new Room(6,6,1,18,13);
		this.rooms[13] = new Room(6,7,6,17,14);
		this.rooms[14] = new Room(5,7,11,17,15);
		this.rooms[15] = new Room(6,6,22,13,16);
		this.rooms[16] = new Room(6,6,27,13,17);
		this.rooms[17] = new Room(5,7,18,17,18);
		this.rooms[18] = new Room(6,6,22,18,19);
		this.rooms[19] = new Room(6,6,27,18,20);
		this.rooms[20] = new Room(8,7,13,9,21);
		
		// Room 1
		makeRoom(this.rooms[0]);
		// TODO new Room ?
		// Room 2
		makeRoom(this.rooms[1]);
		// Room 3
		makeRoom(this.rooms[2]);
		// Room 4
		makeRoom(this.rooms[3]);
		// Room 5
		makeRoom(this.rooms[4]);

		// Room 6
		makeRoom(this.rooms[5]);
		// Room 7
		makeRoom(this.rooms[6]);
		// Room 8
		makeRoom(this.rooms[7]);
		// Room 9
		makeRoom(this.rooms[8]);
		// Room 10
		makeRoom(this.rooms[9]);

		// Room 11
		makeRoom(this.rooms[10]);
		// Room 12
		makeRoom(this.rooms[11]);
		// Room 13
		makeRoom(this.rooms[12]);
		// Room 14
		makeRoom(this.rooms[13]);
		// Room 15
		makeRoom(this.rooms[14]);
		
		// Room 16
		makeRoom(this.rooms[15]);
		// Room 17
		makeRoom(this.rooms[16]);
		// Room 18
		makeRoom(this.rooms[17]);
		// Room 19
		makeRoom(this.rooms[18]);
		// Room 20
		makeRoom(this.rooms[19]);
		
		// Room 21
		makeRoom(this.rooms[20]);
	}
	
	
	
	
	private void makeHall(Hall hall) {
		// Making outer walls
		for(int i=hall.getX0(); i<(hall.getX0()+hall.getSizeX()); i++) {
			for(int j=hall.getY0(); j<(hall.getY0()+hall.getSizeY()); j++) {
				map[i][j] = new FloorElement(i, j, hall.getID());
			}	
		}
	}

	private void makeHalls() {
		
		this.halls[0] = new Hall(1,0,15,1,22);
		this.halls[1] = new Hall(18,0,15,1,23);
		this.halls[2] = new Hall(33,1,1,11,24);
		this.halls[3] = new Hall(33,13,1,11,25);
		this.halls[4] = new Hall(18,24,15,1,26);
		this.halls[5] = new Hall(1,24,15,1,27);
		this.halls[6] = new Hall(0,13,1,11,28);
		this.halls[7] = new Hall(0,1,1,11,29);
		this.halls[8] = new Hall(16,1,2,6,30);
		this.halls[9] = new Hall(23,12,10,1,31);
		this.halls[10] = new Hall(16,18,2,6,32);
		this.halls[11] = new Hall(1,12,10,1,33);
		this.halls[12] = new Hall(12,9,1,7,34);
		this.halls[13] = new Hall(13,8,8,1,35);
		this.halls[14] = new Hall(21,9,1,7,36);
		this.halls[15] = new Hall(13,16,8,1,37);
		
		// Hall 1
		makeHall(this.halls[0]);
		// TODO new Room ?
		// Hall 2
		makeHall(this.halls[1]);
		// Hall 3
		makeHall(this.halls[2]);
		// Hall 4
		makeHall(this.halls[3]);
		// Hall 5
		makeHall(this.halls[4]);

		// Hall 6
		makeHall(this.halls[5]);
		// Hall 7
		makeHall(this.halls[6]);
		// Hall 8
		makeHall(this.halls[7]);
		// Hall 9
		makeHall(this.halls[8]);
		// Hall 10
		makeHall(this.halls[9]);

		// Hall 11
		makeHall(this.halls[10]);
		// Hall 12
		makeHall(this.halls[11]);
		// Hall 13
		makeHall(this.halls[12]);
		// Hall 14
		makeHall(this.halls[13]);
		// Hall 15
		makeHall(this.halls[14]);

		// Room 16
		makeHall(this.halls[15]);

	}
	
	private void makeCorner(Corner corner) {
		// Making outer walls
		for(int i=corner.getX0(); i<(corner.getX0()+corner.getSizeX()); i++) {
			for(int j=corner.getY0(); j<(corner.getY0()+corner.getSizeY()); j++) {
				map[i][j] = new FloorElement(i, j, corner.getID());
			}	
		}
	}
	
	private void makeCorners() {
		//Anel externo
		int[] fronteiras1 = {22,37};
		this.corners[0] = new Corner(0,0,1,1,38,fronteiras1);
		int[] fronteiras2 = {22,23,30};
		this.corners[1] = new Corner(16,0,2,1,39,fronteiras2);
		int[] fronteiras3 = {23,24};
		this.corners[2] = new Corner(33,0,1,1,40,fronteiras3);
		int[] fronteiras4 = {24,25,31};
		this.corners[3] = new Corner(33,12,1,1,41,fronteiras4);
		int[] fronteiras5 = {25,26};
		this.corners[4] = new Corner(33,24,1,1,42,fronteiras5);
		int[] fronteiras6 = {27,28,32};
		this.corners[5] = new Corner(16,24,2,1,43,fronteiras6);
		int[] fronteiras7 = {28,29};
		this.corners[6] = new Corner(0,24,1,1,44,fronteiras7);
		int[] fronteiras8 = {29,30,33};
		this.corners[7] = new Corner(0,12,1,1,45,fronteiras8);
		//Anel interno
		int[] fronteiras9 = {34,35};
		this.corners[8] = new Corner(12,8,1,1,38,fronteiras9);
		int[] fronteiras10 = {35,31};
		this.corners[9] = new Corner(16,7,2,1,39,fronteiras10);
		int[] fronteiras11 = {35,36};
		this.corners[10] = new Corner(21,8,1,1,40,fronteiras11);
		int[] fronteiras12 = {36,32};
		this.corners[11] = new Corner(22,12,1,1,41,fronteiras12);
		int[] fronteiras13 = {36,37};
		this.corners[12] = new Corner(21,16,1,1,42,fronteiras13);
		int[] fronteiras14 = {37,33};
		this.corners[13] = new Corner(16,17,2,1,43,fronteiras14);
		int[] fronteiras15 = {37,34};
		this.corners[14] = new Corner(16,12,1,1,44,fronteiras15);
		int[] fronteiras16 = {33,34};
		this.corners[15] = new Corner(11,12,1,1,45,fronteiras16);
		
		makeCorner(this.corners[0]);
		makeCorner(this.corners[1]);
		makeCorner(this.corners[2]);
		makeCorner(this.corners[3]);
		makeCorner(this.corners[4]);
		makeCorner(this.corners[5]);
		makeCorner(this.corners[6]);
		makeCorner(this.corners[7]);
		makeCorner(this.corners[8]);
		makeCorner(this.corners[9]);
		makeCorner(this.corners[10]);
		makeCorner(this.corners[1]);
		makeCorner(this.corners[12]);
		makeCorner(this.corners[13]);
		makeCorner(this.corners[14]);
		makeCorner(this.corners[15]);
		
		
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
