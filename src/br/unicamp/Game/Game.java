package br.unicamp.Game;

import java.util.ArrayList;
import java.util.Scanner;

import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.RedDice;
import br.unicamp.Exceptions.*;
import br.unicamp.Map.Map;
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


public class Game {

	private Map gameMap;
	private RedDice redDice;
	private CombatDice combatDice;

	public Game() {
		this.gameMap = new Map();
		this.redDice = new RedDice();
		this.combatDice= new CombatDice();

	}

	public void start() {
		

		Hero player = null;
		boolean running1 = true;
		Command input1;
		
		// Loading the Map
		while (running1) {
			input1 = readGameType();
			switch(input1) {
			case FROM_TXT:
				@SuppressWarnings("resource")
				Scanner keyboard = new Scanner(System.in);
				System.out.print ("Name from .txt file: ");
				String command = keyboard.nextLine();
				TxtReader stage = new TxtReader(command);
				
				
				//Player
				player = stage.getMyHero();
				gameMap.addElement(player);
				
				//All other map elements except doors
				ArrayList<MapElement> mapElements = stage.getArrayStageElements();
				for(MapElement mapElement: mapElements){
					gameMap.addElement(mapElement);
				}
				//All Doors
				ArrayList<DoorMask> doorMaskElements = stage.getArraydoorMaskElements();
				for(DoorMask doorMaskElement: doorMaskElements){
					int x = doorMaskElement.getX();
					int y= doorMaskElement.getY();
					int roomA= doorMaskElement.getRoomA();
					int roomB= doorMaskElement.getRoomB();
					boolean vert= doorMaskElement.getVericability();
					gameMap.addDoor(x,y,roomA,roomB,vert);
				}
				// All monsters
				ArrayList<Monster> monsterElements = stage.getArrayMonsterElements();
				for(Monster monster: monsterElements){
					gameMap.addMonster(monster);
				}
				
				running1 = false;
				break;
			case PREGAME:
				// Hero addition
				player = chooseHero();
				gameMap.addElement(player);

				// TODO gameMap.makeStandardMonsters()
				// Test Monster additions
				Monster m1 = new Goblin(3,4);
				gameMap.addMonster(m1);
				
				Monster m2 = new Skeleton(5,10);
				gameMap.addMonster(m2);
				
				Monster m3 = new SkeletonWizard(8,8);
				gameMap.addMonster(m3);
				
				
				// Making Doors
				gameMap.makeStandardDoors();
				
				// Making Chests
				gameMap.makeStandardChest();
			
				running1 = false;
				break;
				
			case NONE:
				break;
			
			
			}
		}

			
		// Starting the game

		System.out.println("Game started!\n");

		boolean running2 = true;
		Command input2;

		
		gameMap.updateMap(player);
		gameMap.print();

		while (running2) {
			
			input2 = readInput();
			try {
				switch(input2) {
				case QUIT:
					running2 = false;
					break;
				case OPEN_DOOR:
					gameMap.searchDoors(player);
					break;
					
				case OPEN_CHEST:
					gameMap.searchChests(player);
					break;
					
				case BAG_REPORT:
					player.reportBagElements();
					int position = choosePosition();
					if (position != -1) {
						try{
							player.useBagItem(position);						
						}catch(ItemNotInBagException e) {
							// TODO consertar interacao com o usuario nesse ponto, falar que a entrada foi invalida
								System.out.println (e.getMessage());
						}
					}
					break;
				
				case PLAYER_STATUS:
					player.status();
					break;
					
				case ATTACK:
					gameMap.attackMonster(this.combatDice, player);
					break;
				case MAGIC:
					try {
						gameMap.spellMagic(player,redDice,combatDice);
					}catch(NotSpellerException e) {
						System.out.println(e.getMessage());
					}
					break;
				case HELP:
					this.giveHelp();
					break;
					//TODO
//				case MOVE:
//					this.makeMove();
//					break;
				default:
					gameMap.moveCharacter(input2, player);
					break;
				}
			} catch (OccupiedTileException | OutOfBoundsException e) {
				System.out.println (e.getMessage());
			}

			gameMap.updateMap(player);
			gameMap.print();

			try {
				gameMap.runMonsterActions(combatDice, player);
			} catch (OccupiedTileException | OutOfBoundsException e) {
				System.out.println (e.getMessage());
			}
			
			gameMap.print();

		}

	}

	private void makeMove() {
		
	}
	
	private Command readGameType() {
		
		Command retorno = Command.NONE;
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.println("To read default map press '0'.\nFor configuration file, press '1':");
		String command = keyboard.nextLine();
	
		if ( command.compareTo("1") == 0) {
			System.out.println("Reading game form file...");
			retorno = Command.FROM_TXT;

		} else if ( command.compareTo("0") == 0 ) {
			System.out.println ("Loading the default game...\n");
			retorno =  Command.PREGAME;

		} else {
			System.out.print ("To read default map press '0'.\nFor configuration file, press '1':");
		}
		
		return retorno;
	}
	
	
	private void giveHelp() {

		System.out.println("Write [quit] to Quit the game");
		System.out.println("Press [u] to open Door");
		System.out.println("Press [c] to open Chest");
		System.out.println("Press [b] to check Bag and possibily use/equip Items");
		System.out.println("Press [v] to check your Hero's current status");
		System.out.println("Press [t] to attack a Monster with a Weapon\n");
		
		System.out.println("While in move phase:");
		System.out.println("Press [w] to move Up");
		System.out.println("Press [s] to move Down");
		System.out.println("Press [a] to move Left");
		System.out.println("Press [d] to move Right");
		System.out.println("Press [p] to stop moving");

	}
		
	
//	private Command readMovement(int steps) {
//
//		@SuppressWarnings("resource")
//		Scanner keyboard = new Scanner(System.in);
//		System.out.print ("Enter the next direction:") ;
//		String command = keyboard.nextLine();
//
//		System.out.println("If you need to check commands, press [h] for help\n");
//		
//		if ( command.compareTo("quit") == 0) {
//			System.out.println("Game terminated. Bye!");
//			return Command.QUIT;
//		} else if ( command.compareTo("w") == 0 ) {
//			return Command.UP;
//		} else if ( command.compareTo("a") == 0 ) {
//			return Command.LEFT;
//		} else if ( command.compareTo("s") == 0 ) {
//			return Command.DOWN;
//		} else if ( command.compareTo("d") == 0 ) {
//			return Command.RIGHT;
//		} else if ( command.compareTo("h") == 0 ) {
//			return Command.HELP;
//		} else if ( command.compareTo("p") == 0 ) {
//			return Command.QUIT;
//		} else {
//			return Command.NONE;	
//		}
//	}
	
	private Command readInput() {

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print ("Enter the command:") ;
		String command = keyboard.nextLine();

		System.out.println("If you need to check commands, press [h] for help\n");
		
		if ( command.compareTo("quit") == 0) {
			System.out.println("Game terminated. Bye!");
			return Command.QUIT;
		} else if ( command.compareTo("w") == 0 ) {
//			System.out.println ("Moving UP \n");
			return Command.UP;
		} else if ( command.compareTo("a") == 0 ) {
//			System.out.println ("Moving LEFT \n");	
			return Command.LEFT;
		} else if ( command.compareTo("s") == 0 ) {
//			System.out.println ("Moving DOWN \n");
			return Command.DOWN;
		} else if ( command.compareTo("d") == 0 ) {
//			System.out.println ("Moving RIGHT \n");
			return Command.RIGHT;
		} else if ( command.compareTo("u") == 0 ) {
//			System.out.println ("INTERACTING WITH DOOR\n");
			return Command.OPEN_DOOR;
		} else if ( command.compareTo("m") == 0 ) {
			return Command.MOVE;
		} else if ( command.compareTo("c") == 0 ) {
			return Command.OPEN_CHEST;
		} else if ( command.compareTo("v") == 0 ) {
			return Command.PLAYER_STATUS;
		} else if ( command.compareTo("b") == 0 ) {
			System.out.println ("ITEMS ON THE BAG:\n");
			return Command.BAG_REPORT;
		} else if ( command.compareTo("t") == 0 ) {
			return Command.ATTACK;
		}
		else if ( command.compareTo("t") == 0 ) {
			System.out.println ("TRY TO SPELL MAGIC\n");
			return Command.MAGIC;
		}
		else if ( command.compareTo("h") == 0 ) {
//			System.out.println ("HELPING WITH COMMANDS \n");
			return Command.HELP;
		} else {
			return Command.NONE;	
		}

	}
	
	
	private Hero chooseHero() {

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print ("Choose your Hero: \n W => Wizard \n B => Barbarian \n D => Dwarf \n E => Elf \n") ;
		String command = keyboard.nextLine();

		if ( command.compareTo("W") == 0 ) {
			System.out.println ("Chose Wizard \n");
			return new Wizard(0,0);

		} else if ( command.compareTo("B") == 0 ) {
			System.out.println ("Chose Barbarian \n");
			return new Barbarian(0,0);

		} else if ( command.compareTo("D") == 0 ) {
			System.out.println ("Chose Dwarf \n");
			return new Dwarf(0,0);

		} else if ( command.compareTo("E") == 0 ) {
			System.out.println ("Chose Elf \n");
			return new Elf(0,0);
		} else {
			return new Barbarian(0,0);
		}
	}
	
	
	private int choosePosition() {

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print ("\nPress the number next to desired Item in order to use/equip it.\nPress [n] to cancel.\n") ;
		String command = keyboard.nextLine();
		int position = -1;
		if ( command.compareTo("n") == 0 ) {
			System.out.println ("Not using items \n");
			return position;
		}
		try{
			position = Integer.valueOf(command);
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		
		return position;
	}
	
}