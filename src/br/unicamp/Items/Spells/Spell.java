package br.unicamp.Items.Spells;

import java.util.Scanner;

import br.unicamp.Dices.Dice;
import br.unicamp.Exceptions.OutOfBoundsException;

public abstract class Spell {
	
	protected int points;
	
	
	public Spell(int points){
		this.points = points;
	}
		
	protected void cast(Character target, Dice dice){}
	
	
	protected int readNumber(String coordinate) throws OutOfBoundsException{
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print ("Choose " + coordinate) ;
		String command = keyboard.nextLine();
		int position;
		try {
			position = Integer.valueOf(command);
		}catch(NumberFormatException e) {
			System.out.println("Only numbers acceptable");
			position = -1;
		}
		
		if (position<0 || (position>33 && coordinate == "X")|| (position>24 && coordinate == "Y")) {
			throw new OutOfBoundsException("The spell cant be casted on this position");
		}
		
		return position;
	}
	
	protected int[] positionAction() {
		
		boolean xOk = false;
		boolean yOk = false;
		int x = 0;
		int y = 0;
		while (!xOk || !yOk) {
	
			if (!xOk) {
				try {
					x = readNumber("X");
					if (x!=-1) {
						xOk = true;
					}
				}catch(OutOfBoundsException e) {
					System.out.println(e.getMessage());
				}
				
			}
			if (!yOk) {
				try {
					y = readNumber("Y");
					if (y!=-1) {
						yOk = true;
					}
				}catch(OutOfBoundsException e) {
					System.out.println(e.getMessage());
				}
			}
		}

		return new int[] {x,y};
	}
}


