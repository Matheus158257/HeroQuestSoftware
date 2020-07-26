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
import br.unicamp.Map.MapElements.Characters.Monsters.Monster;
import br.unicamp.Map.MapElements.Characters.Monsters.Skeleton;
import br.unicamp.Map.MapElements.Characters.Monsters.SkeletonWizard;
import br.unicamp.Map.MapElements.StaticElements.VariableElements.ChestTrap;
import br.unicamp.Map.MapElements.StaticElements.VariableElements.Obstacle;
import br.unicamp.Map.MapElements.StaticElements.VariableElements.Trap;
import br.unicamp.Map.MapElements.StaticElements.VariableElements.Treasure;

public class TxtReader {
  
	private ArrayList<MapElement> stageElements = new ArrayList<MapElement>();
	private ArrayList<DoorMask> doorMaskElements = new ArrayList<DoorMask>();
	private ArrayList<Monster> monstersElements = new ArrayList<Monster>();
	private String stageName;
	
	public TxtReader(String stageName){
		this.stageName = stageName;
		readTxtFile();
	}
	public ArrayList<MapElement>  getArrayStageElements() {
		return this.stageElements;
	}
	
	public ArrayList<Monster>  getArrayMonsterElements() {
		return this.monstersElements;
	}
	
	
	public ArrayList<DoorMask>  getArraydoorMaskElements() {
		return this.doorMaskElements;
	}
	

	private void readTxtFile() {


		String filePath = "";
		String OS = System.getProperty("os.name");
		if (OS.startsWith("Windows")) {
			String cwd = "..\\HeroQuestSoftware\\src\\stages\\" ; 
//			System.out.println("LOG: Checking directory " + cwd);
			filePath = cwd + this.stageName +".txt";

		}else {
			String cwd = ("../stages/");
			filePath =  cwd + this.stageName +".txt";
		}
		
		
		 try {
		      File myObj = new File(filePath);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        addToMapElementsArrayList(data);
	
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error has occurred. Please respect the map file pattern.");
		      e.printStackTrace();
		    }
	}
	
	private void addToMapElementsArrayList(String data) {
		String[] parts = data.split(" ");
		int x0 = Integer.valueOf(parts[1]);
		int y0 = Integer.valueOf(parts[2]);
		// My Hero
//		System.out.println(data);
		
		/*
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
		*/
		//Monsters
		if (parts[0].equals("G")) {
			Monster monster = new Goblin(x0,y0);
			stageElements.add(monster);
			monstersElements.add(monster);
		} else if (parts[0].equals("S")) {
			Monster monster = new Skeleton(x0,y0);
			stageElements.add(monster);
			monstersElements.add(monster);
		}
		else if (parts[0].equals("K")) {
			Monster monster = new SkeletonWizard(x0,y0);
			stageElements.add(monster);
			monstersElements.add(monster);
		}
		// Variable Elements
		else if (parts[0].equals("O")) {
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