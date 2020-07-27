package br.unicamp.Map.MapElements.StaticElements.VariableElements;

import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;

public class Trap extends VariableElement {

	public final static int DAMAGE = 1;
	
	private boolean discovered;
	
	public Trap(int x, int y) {
		super(x, y);
		this.discovered = false;
	}

	@Override
	public String toString() {
		
		if(this.isVisible()) {
			if(discovered) {
				return "T";
			} else {
				return " ";

			}
		} else {
			return "-";
		}
	}
	
	@Override
	public boolean isFree() {
		if(discovered) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public boolean trapsHero(Character character) {
		if(discovered) {
			return false;
		} else {
			return true;
		}
	};

	@Override
	public boolean getDetected(Character character){
		this.discovered=true;
		
		return true;
	}


}
