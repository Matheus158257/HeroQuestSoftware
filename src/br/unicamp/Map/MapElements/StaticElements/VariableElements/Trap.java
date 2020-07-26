package br.unicamp.Map.MapElements.StaticElements.VariableElements;

import br.unicamp.Map.MapElements.Characters.Character;

public class Trap extends VariableElement {

	public Trap(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		if(this.isVisible()) {
			return "T";
		} else {
			return "-";
		}
	}
	
	@Override
	public boolean isFree() {
		return true;
	}
	
//	protected void trapCatchesHero(Hero hero){
//		if(hero.getX() == this.getX() && hero.getY()==this.getY()){
//			//significa que o heroi pisou na armadilha
//			hero.takeDamage(1);
//		}
//	}
//	
//	protected void trapDetected(){
//		this.changeVisibility();
//	}


}
