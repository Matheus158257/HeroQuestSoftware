package br.unicamp.Map;

import br.unicamp.Map.GroupElements.Hall;
import br.unicamp.Map.GroupElements.Room;
import br.unicamp.Map.GroupElements.Wall;
import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Map.MapElements.StaticElements.FloorElement;
import br.unicamp.Map.MapElements.StaticElements.WallElement;


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
		
		// Coloca FloorElement em tudo
		for(int i=0; i<sizeX; i++) {
			for(int j=0; j<sizeY; j++) {
				map[i][j] = new FloorElement(i,j);
			}	
		}
		
		// Making fixed Rooms
		
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
		

		
//		this.characterMask = new Characters[xMax][yMax];
		
//		for (int i = 0; i < nRooms; i++) { 
//			rooms[i].generateRoom(); 
//        } 
//		this.wall.generateWalls();
//		this.hall.generateHall();
		

//		generateCharacterMask();
		
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
	
	//----------------------- Private Methods
	
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

	
	//----------------------- Getters and Setters

	



//	private void generateCharacterMask(){
//		for(int j = Map.Y_MAX-1; j>=0; j-- ){
//			for(int i = this.xMax-1; i>=0; i-- ){
////				this.activeMask[i][j] = new EmptyMask(i,j);
//			}
//		}
//	}
		

}
