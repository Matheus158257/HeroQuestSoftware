package br.unicamp.Game;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

import br.unicamp.Items.Coin;
import br.unicamp.Items.Potion;
import br.unicamp.Items.Armor.Armor;
import br.unicamp.Items.Weapons.Dagger;
import br.unicamp.Items.Weapons.LongSword;
import br.unicamp.Items.Weapons.ShortSword;
import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Map.MapElements.Characters.Heroes.Barbarian;
import br.unicamp.Map.MapElements.Characters.Heroes.Dwarf;
import br.unicamp.Map.MapElements.Characters.Heroes.Elf;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;
import br.unicamp.Map.MapElements.Characters.Heroes.Wizard;
import br.unicamp.Map.MapElements.Characters.Monsters.Goblin;
import br.unicamp.Map.MapElements.Characters.Monsters.Skeleton;
import br.unicamp.Map.MapElements.Characters.Monsters.SkeletonWizard;
import br.unicamp.Map.MapElements.StaticElements.VariableElements.ChestTrap;
import br.unicamp.Map.MapElements.StaticElements.VariableElements.Obstacle;
import br.unicamp.Map.MapElements.StaticElements.VariableElements.Trap;
import br.unicamp.Map.MapElements.StaticElements.VariableElements.Treasure;

public class TxtReader {
  
	private ArrayList<MapElement> stageElements = new ArrayList<MapElement>();
	private ArrayList<DoorMask> doorMaskElements = new ArrayList<DoorMask>();
	private String stageName;
	private Hero myhero;
	
	public TxtReader(String stageName){
		this.stageName = stageName;
		readTxtFile();
	}
	public ArrayList<MapElement>  getArrayStageElements() {
		return this.stageElements;
	}
	
	public ArrayList<DoorMask>  getArraydoorMaskElements() {
		return this.doorMaskElements;
	}
	
	public Hero getMyHero() {

		return this.myhero;
	}
	
	private void readTxtFile() {
		
		String cwd = System.getProperty("user.dir");
		String filePath = cwd + "\\stages\\" + this.stageName +".txt";
		
		 try {
		      
		      File myObj = new File(filePath);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        addToMapElementsArrayList(data);
	
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred. Please respect the manual format");
		      e.printStackTrace();
		    }
	}
	
	private void addToMapElementsArrayList(String data) {
		String[] parts = data.split(" ");
		int x0 = Integer.valueOf(parts[1]);
		int y0 = Integer.valueOf(parts[2]);
		// My Hero
		System.out.println(data);
		
		if (parts[0].equals("HB")) {
			myhero = new Barbarian(x0,y0);
			
		} else if (parts[0].equals("HD")) {
			myhero = new Dwarf(x0,y0);
			
		}else if (parts[0].equals("HE")) {
			myhero = new Elf(x0,y0);
			
		}else if (parts[0].equals("HW")) {
			myhero = new Wizard(x0,y0);
		}
		
		//Heros
		else if (parts[0].equals("B")) {
			stageElements.add(new Barbarian(x0,y0));
			
		} else if (parts[0].equals("D")) {
			stageElements.add(new Dwarf(x0,y0));
		}
		 else if (parts[0].equals("E")) {
			 stageElements.add(new Elf(x0,y0));
		}
		else if (parts[0].equals( "W")) {
			stageElements.add(new Wizard(x0,y0));
		}
		//Monsters
		else if (parts[0].equals("G")) {
			stageElements.add(new Goblin(x0,y0));
		} else if (parts[0].equals("S")) {
			stageElements.add(new Skeleton(x0,y0));
		}
		else if (parts[0].equals("K")) {
			stageElements.add(new SkeletonWizard(x0,y0));
		}
		// Variable Elements
		else if (parts[0].equals("O")) {
			System.out.println(parts[0]);
			stageElements.add(new Obstacle(x0,y0));
		}
		 else if (parts[0].equals("T")) {
			 stageElements.add(new Trap(x0,y0));
		}
		else if (parts[0].equals("U")) {
			boolean vert = Boolean.valueOf(parts[3]);// "true" para ser true
			int roomA = Integer.valueOf(parts[4]);
			try {
				int roomB = Integer.valueOf(parts[5]);
				doorMaskElements.add(new DoorMask(x0, y0, vert, roomA,roomB));
						
			}catch(Exception e){
				doorMaskElements.add(new DoorMask(x0, y0, vert, roomA));
			}
			
		}else if (parts[0].equals("C1")) {
			 if (parts[3].equals("G")) {
				 stageElements.add(new ChestTrap(x0, y0, new Goblin(x0,y0)));
			 }else if (parts[3].equals("S")) {
				 stageElements.add(new ChestTrap(x0, y0, new Skeleton(x0,y0)));
			 }
			 else if (parts[3].equals("K")) {
				 stageElements.add(new ChestTrap(x0, y0, new SkeletonWizard(x0,y0)));
			 }
			
			
		}else if (parts[0].equals("C2")) {
			if (parts[3].equals("A")) {
				int defensePoints = Integer.valueOf(parts[4]);
				stageElements.add(new Treasure(x0, y0, new Armor(defensePoints)));
			 }else if (parts[3].equals("Z")) {
				 stageElements.add(new Treasure(x0, y0, new Dagger()));
			 }else if (parts[3].equals("L")) {
				 stageElements.add(new Treasure(x0, y0, new LongSword()));
			 }else if (parts[3].equals("S") ) {
				 stageElements.add(new Treasure(x0, y0, new ShortSword()));
			 }
			 else if (parts[3].equals("P") ) {
				 int heallingPoints = Integer.valueOf(parts[4]);
				 stageElements.add(new Treasure(x0, y0, new Potion(heallingPoints)));
			 }
			 else if (parts[3].equals("Q")) {
				 int moneyPoints = Integer.valueOf(parts[4]);
				 stageElements.add(new Treasure(x0, y0, new Coin(moneyPoints)));
			 }
		
		}
		
			
	
	}
		
   
    
}