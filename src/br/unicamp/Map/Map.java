package br.unicamp.Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.stream.events.Characters;

import br.unicamp.Map.GroupElements.Hall;
import br.unicamp.Map.GroupElements.Room;
import br.unicamp.Map.GroupElements.Wall;
import br.unicamp.Map.MapElements.StaticElements.FloorElement;
import br.unicamp.Map.MapElements.StaticElements.StaticElement;
import br.unicamp.Map.MapElements.StaticElements.WallElement;


public class Map {
	
	public static final int nRooms = 22;
	public static final int xMax = 34;
	public static final int yMax = 22;
	private StaticElement board[][];
	private Characters characterMask[][];
	private ArrayList<Room>[] rooms = new ArrayList[nRooms]; 
	private List<WallElement> wall = new ArrayList<WallElement>();
	private List<FloorElement> hall = new ArrayList<FloorElement>();
	
	//----------------------- Constructors
	
	public Map() {
		this.board = new StaticElement[xMax][yMax];
		this.board = new StaticElement[xMax][yMax];
		this.characterMask = new Characters[xMax][yMax];
		
//		for (int i = 0; i < nRooms; i++) { 
//			rooms[i].generateRoom(); 
//        } 
//		this.wall.generateWalls();
//		this.hall.generateHall();
		
		generateBoard();
		generateCharacterMask();
	}
	
	//----------------------- Getters and Setters
	public int getXmax() {
		return this.xMax;
	}
	public int getYmax() {
		return this.yMax;
	}
	
	//----------------------- Private Classes
	
	private void generateBoard() {
		for(FloorElement floor: this.hall) {
			
		}
		for(WallElement floor: this.wall) {
			
		}
	
	}
	
	
	private void generateCharacterMask(){
		for(int j = this.yMax-1; j>=0; j-- ){
			for(int i = this.xMax-1; i>=0; i-- ){
//				this.activeMask[i][j] = new EmptyMask(i,j);
			}
		}
	}
		

}
