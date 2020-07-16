package br.unicamp.Game;

import java.util.Scanner;

import br.unicamp.Exceptions.*;
import br.unicamp.Map.Map;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.*;
import br.unicamp.Map.MapElements.Characters.Monsters.*;

public class Game {

	//	private boolean exitSelected;

	private Map gameMap;

	public Game() {
		//door1 = new Door();
		
		gameMap = new Map();

	}

	public void start() {
		
		// Heros additions
		Barbarian player = new Barbarian(0,0);
		gameMap.addElement(player);
		
		// Monster additions
		Monster m1 = new Goblin(3,4);
		gameMap.addElement(m1);
		
		Monster m2 = new Skeleton(5,10);
		gameMap.addElement(m2);
		
		Monster m3 = new SkeletonWizard(8,8);
		gameMap.addElement(m3);
		
		
		
		

		System.out.println("Game started!");

		boolean running = true;
		Command input;

		gameMap.updateMap(player);
		gameMap.print();

		while (running) {

			
			input = readInput();
			try {
				switch(input) {
				case QUIT:
					running = false;
					break;
				case OPEN_DOOR:
					gameMap.interacWithDoor(player);
					break;
					
				case OPEN_CHEST:
					gameMap.interactWithChest(player);
					break;
					
				case BAG_REPORT:
					player.reportBagElements();
					break;
				default:

					gameMap.moveCharacter(input, player);
					break;
				}
			} catch (OccupiedTileException | OutOfBoundsException e) {
				System.out.println (e.getMessage());
			}

			gameMap.updateMap(player);
			gameMap.print();
			gameMap.excuteNPCsMovements();

		}

	}

	private Command readInput() {

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print ("Enter the command:") ;
		String command = keyboard.nextLine();


		if ( command.compareTo("quit") == 0) {
			System.out.println("Game terminated. Bye!");
			return Command.QUIT;

		} else if ( command.compareTo("w") == 0 ) {
			System.out.println ("Moving UP \n");
			return Command.UP;

		} else if ( command.compareTo("a") == 0 ) {
			System.out.println ("Moving LEFT \n");	
			return Command.LEFT;

		} else if ( command.compareTo("s") == 0 ) {
			System.out.println ("Moving DOWN \n");
			return Command.DOWN;

		} else if ( command.compareTo("d") == 0 ) {
			System.out.println ("Moving RIGHT \n");
			return Command.RIGHT;

		} else if ( command.compareTo("u") == 0 ) {
			System.out.println ("INTERACTING WITH DOOR\n");
			return Command.OPEN_DOOR;
		}
		
		else if ( command.compareTo("c") == 0 ) {
			System.out.println ("INTERACTING WITH CHEST\n");
			return Command.OPEN_CHEST;
		}
		
		else if ( command.compareTo("b") == 0 ) {
			System.out.println ("ITEMS ON THE BAG\n");
			return Command.BAG_REPORT;
		}

		return Command.NONE;


	}
}