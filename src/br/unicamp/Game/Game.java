package br.unicamp.Game;

import java.io.FileNotFoundException;
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
import br.unicamp.Map.MapElements.StaticElements.VariableElements.Trap;


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
		boolean makingMapDecision = true;
		Command input1;

		// Loading the Map

		while (makingMapDecision) {

			
			input1 = readGameType();
			
			try {
				switch(input1) {
				case FROM_TXT:
					@SuppressWarnings("resource")
					Scanner keyboard = new Scanner(System.in);
					System.out.print ("Name from .txt file: ");
					String command = keyboard.nextLine();
					TxtReader stage = new TxtReader(command);


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
					// All traps
					ArrayList<Trap> trapElements = stage.getArrayTrapElements();
					for(Trap trap: trapElements){
						gameMap.addTrap(trap);
					}
					
					//Player
					player = chooseHero();
					gameMap.addElement(player);
					
					makingMapDecision = false;
					break;
				case PREGAME:
					// Hero addition
					player = chooseHero();
					gameMap.addElement(player);
					
					// Making Monsters
					gameMap.makeStandardMonsters();

					// Making Doors
					gameMap.makeStandardDoors();

					// Making Chests
					gameMap.makeStandardChest();

					makingMapDecision = false;
					break;

				case NONE:
					break;
				}
			}
			catch (FileNotFoundException e) {
				System.out.println("File not found. Try again.\n");
				makingMapDecision = true;
//				e.printStackTrace();
			}

		}



		// Starting the game

		System.out.println("Game started!\n");

		boolean gameRunning = true;
		boolean noAction = true;
		boolean moveMade = false;
		Command input2;


		gameMap.updateMap(player);

		while (gameRunning) {

			while(noAction) {

				System.out.println ("\nYOUR TURN\n");
				gameMap.print();
				input2 = readInput();
				try {
					switch(input2) {
					case QUIT:
						gameRunning = false;
						break;

					case SEARCH_TRAP:
						// TODO
						// gameMap.searchTrap(player);
						noAction = false;
						break;

					case OPEN_DOOR:
						gameMap.searchDoors(player);
						break;

					case OPEN_CHEST:
						gameMap.searchChests(player);
						noAction = false;
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
//						System.out.println ("LOG: Attacked");
						noAction = false;
						break;
					case MAGIC:
						try {

							gameMap.spellMagic(player,this.redDice,this.combatDice);
//							System.out.println ("LOG: Launched magic");
							
						}catch(NotSpellerException e) {
							System.out.println(e.getMessage());
						}
						noAction = false;
						break;
					case HELP:
						this.giveHelp();
						break;
						//TODO
					case MOVE:
						if(moveMade) {
							System.out.println ("Already made a move. Please take an action or pass your turn pressing [n].\n");
						} else {
							this.makeMove(player);
							moveMade=true;
						}
						break;
					case END_TURN:
						System.out.println ("ENDING YOUR TURN");
						noAction = false;
						break;
					default:
						break;
					}
				} catch (OccupiedTileException | OutOfBoundsException e) {
					System.out.println (e.getMessage());
					//					e.printStackTrace();
				} 
				gameMap.updateMap(player);
				gameMap.print();
			}


			System.out.println ("MORCAR'S TURN");
			try {
				gameMap.runMonsterActions(redDice, combatDice, player);
			} catch (OccupiedTileException | OutOfBoundsException e) {
				System.out.println (e.getMessage());
			}

//			gameMap.print();
			noAction=true;
			moveMade=false;
		}

	}

	private void makeMove(Hero player) {
		int steps = this.redDice.getResult(2);
		System.out.println ("MOVE PHASE");
		System.out.println("Dices rolled! You can move up to " + steps + " steps.\nPress [p] to stop moving.\n");
		MoveCommand moveCommand;
		gameMap.print();
		for(int i=steps; i>0;i--) {
			moveCommand = this.readMovement();
			switch (moveCommand) {
			case STOP:
				return;
			case HELP:
				this.giveHelp();
				i++;
				break;
			case OPEN_DOOR:
				try {
					gameMap.searchDoors(player);
				} catch (OccupiedTileException e1) {
					System.out.println(e1.getMessage());
				} catch (OutOfBoundsException e1) {
					System.out.println(e1.getMessage());
				}
				i++;
				break;
			case NONE:
				i++;
				break;
			default:
				try {
					gameMap.moveCharacter(moveCommand, player);
				} catch (OccupiedTileException e) {
					System.out.println(e.getMessage());
//					e.printStackTrace();
				} catch (OutOfBoundsException e) {
					System.out.println(e.getMessage());
//					e.printStackTrace();
				}

			}
			System.out.println((i-1) + " steps left.\nPress [p] to stop moving if you wish to take another action.\n");
			gameMap.updateMap(player);
			gameMap.print();
		}
	}


	private Command readGameType() {

		Command retorno = Command.NONE;

		System.out.println("To read default map press '0'.\nFor configuration file, press '1':");

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);

		String command = keyboard.nextLine();

		if ( command.compareTo("1") == 0) {
			System.out.println("Reading game form file...");
			retorno = Command.FROM_TXT;

		} else if ( command.compareTo("0") == 0 ) {
			System.out.println ("Loading the default game...\n");
			retorno =  Command.PREGAME;

		} else {
			System.out.print ("Input not recognized.\n");
		}

		return retorno;
	}


	private void giveHelp() {
		System.out.println("COMMANDS");
		System.out.println("> Allowed only once per turn (before or after moving):");
		System.out.println("Press [c] to open Chest");
		System.out.println("Press [r] to attack a Monster");
		System.out.println("Press [t] to look for a hidden Trap around you.");
		System.out.println("Press [z] to launch a Spell (only Wizard or Elf)");
		
		System.out.println("> Allowed only once per turn:");
		System.out.println("Press [m] to roll dice and move");

		System.out.println("\n> Allways allowed, except while moving:");
		System.out.println("Press [b] to check Bag and possibily use/equip Items");
		System.out.println("Press [v] to check your Hero's current status");
		System.out.println("Write [quit] to Quit the game");

		System.out.println("\n> While in move phase:");
		System.out.println("Press [w] to move Up");
		System.out.println("Press [s] to move Down");
		System.out.println("Press [a] to move Left");
		System.out.println("Press [d] to move Right");
		System.out.println("Press [u] to open Door");
		System.out.println("Press [p] to stop moving\n");

	}


	private MoveCommand readMovement() {

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print ("Enter the next direction:") ;
		String command = keyboard.nextLine();

		System.out.println("If you need to check commands, press [h] for help\n");

		if ( command.compareTo("p") == 0) {
			System.out.println("Stop walking.\n");
			return MoveCommand.STOP;
		} else if ( command.compareTo("w") == 0 ) {
			return MoveCommand.UP;
		} else if ( command.compareTo("a") == 0 ) {
			return MoveCommand.LEFT;
		} else if ( command.compareTo("s") == 0 ) {
			return MoveCommand.DOWN;
		} else if ( command.compareTo("d") == 0 ) {
			return MoveCommand.RIGHT;
		} else if ( command.compareTo("h") == 0 ) {
			return MoveCommand.HELP;
		} else if ( command.compareTo("u") == 0 ) {
			return MoveCommand.OPEN_DOOR;
		} else {
			return MoveCommand.NONE;	
		}
	}

	private Command readInput() {

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print ("Enter the command:") ;
		String command = keyboard.nextLine();

		System.out.println("If you need to check commands, press [h] for help\n");

		if ( command.compareTo("quit") == 0) {
			System.out.println("Game terminated. Bye!");
			return Command.QUIT;
		} else if ( command.compareTo("u") == 0 ) {
			return Command.OPEN_DOOR;
		} else if ( command.compareTo("m") == 0 ) {
			return Command.MOVE;
		} else if ( command.compareTo("c") == 0 ) {
			return Command.OPEN_CHEST;
		} else if ( command.compareTo("v") == 0 ) {
			return Command.PLAYER_STATUS;
		} else if ( command.compareTo("b") == 0 ) {
			return Command.BAG_REPORT;
		} else if ( command.compareTo("r") == 0 ) {
			return Command.ATTACK;
		} else if ( command.compareTo("z") == 0 ) {
			return Command.MAGIC;
		} else if ( command.compareTo("h") == 0 ) {
			return Command.HELP;
		} else if ( command.compareTo("n") == 0 ) {
			return Command.END_TURN;
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