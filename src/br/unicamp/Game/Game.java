package br.unicamp.Game;

import java.util.Scanner;

import br.unicamp.Exceptions.*;
import br.unicamp.Map.Map;
import br.unicamp.Map.MapElements.Command;
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

		Barbarian barb = new Barbarian(0,0);
		gameMap.addElement(barb);
		
		System.out.println("Game started!");

		boolean running = true;
		Command input;

		while (running) {

			gameMap.print();
			input = readInput();

			switch(input) {
			case QUIT:
				running = false;
				break;

			default:
				try {
					gameMap.moveCharacter(input, barb);
				} catch (OccupiedTileException | OutOfBoundsException e) {
					// TODO Auto-generated catch block
					System.out.println (e.getMessage());
				}
				//				move(input); //?
				//				updateBoard(input); //?
				break;
			}

		}

	}

	private Command readInput() {

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print ("Enter the command:") ;
		String command = keyboard.nextLine();

		//			try {
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

			//		} else if ( command.compareTo("u") == 0 ) {
			//			// TODO Interact 
			//		}

			//			}
			//			catch (OccupiedTileException e) {
			//				System.out.println (e.getMessage());
			//
			//			} catch (OutOfBoundsException e) {
			//				System.out.println (e.getMessage());
			//
			//			}


		}
		return Command.NONE;


	}
}