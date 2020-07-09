package br.unicamp.Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.stream.events.Characters;

import br.unicamp.Map.GroupElements.Hall;
import br.unicamp.Map.GroupElements.Room;
import br.unicamp.Map.GroupElements.Wall;
import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Map.MapElements.StaticElements.FloorElement;
import br.unicamp.Map.MapElements.StaticElements.StaticElement;
import br.unicamp.Map.MapElements.StaticElements.WallElement;


public class Map {
	
	public static final int ROOMS = 22;
	
	public static final int SIZE_X = 34;
	public static final int SIZE_Y = 25;
	
	private MapElement map[][];
//	private Characters characterMask[][];
//	private ArrayList<Room>[] rooms = new ArrayList[nRooms]; 
//	private List<Wall> wall = new ArrayList<Wall>();
//	private List<FloorElement> hall = new ArrayList<FloorElement>();
	
	
	
	//----------------------- Constructors
	
	public Map() {
		this.map = new MapElement[Map.SIZE_X][Map.SIZE_Y];
		
//		this.characterMask = new Characters[xMax][yMax];
		
//		for (int i = 0; i < nRooms; i++) { 
//			rooms[i].generateRoom(); 
//        } 
//		this.wall.generateWalls();
//		this.hall.generateHall();
		
//		generateBoard();
//		generateCharacterMask();
	}
	
	//----------------------- Getters and Setters

	
	//----------------------- Private Classes
	
//	private void generateBoard() {
//		for(FloorElement floor: this.hall) {
//			
//		}
//		for(Wall floor: this.wall) {
//			
//		}
//	
//	}
//	
//	
//	private void generateCharacterMask(){
//		for(int j = Map.Y_MAX-1; j>=0; j-- ){
//			for(int i = this.xMax-1; i>=0; i-- ){
////				this.activeMask[i][j] = new EmptyMask(i,j);
//			}
//		}
//	}
		

}
