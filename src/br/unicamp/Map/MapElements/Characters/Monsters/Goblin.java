package br.unicamp.Map.MapElements.Characters.Monsters;

import br.unicamp.Dices.CombatDice;
import br.unicamp.Interfaces.Collectable;
import br.unicamp.Items.Weapons.Dagger;
import br.unicamp.Items.Weapons.Weapon;
import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Map.MapElements.Characters.Character;


public class Goblin extends Monster {

	public static final int ATK = 0; // Attack Points
	public static final int DEF = 2; // Defense Points
	public static final int LP = 4; // Life Points
	public static final int MP = 0; // Mana Points
	public static final int noDaggers = 4; //Dagger numbers
	
	public Goblin(int x0, int y0){
		super(x0,y0,"Goblin", Goblin.ATK, Goblin.DEF, Goblin.LP, Goblin.MP);

		Dagger dagger1 = new Dagger();
		Dagger dagger2 = new Dagger();
		Dagger dagger3 = new Dagger();
		Dagger dagger4 = new Dagger();
		this.equipWeapon(dagger1);
		this.equipWeapon(dagger2);
		this.equipWeapon(dagger3);
		this.equipWeapon(dagger4);
	}
	
	@Override
	public String toString() {
		if(this.isVisible()) {
			return "G";
		} else {
			return "-";
		}
	}
	
	@Override
	public void dummyAction(Character character, CombatDice combatDice, MapElement map[][]) {
		int damage =0;
		if(noDaggers>0){
			// ataca o herói com punhais
			//tira um punhal da sacola, o ultimo //faz um downscasting de collectable p/ weapon
			Collectable bagItem = this.bag.takeItem();
			Weapon dagger = (Weapon) bagItem;
			//lança dados nºdados=bonus de ataque+bonus da arma
			//damage = somaSimbolosAtaque(combatDice, dagger);


	}
		
		/*
		public int somaSimbolosAtaque(CombatDice combatDice, Weapon dagger){
			int totalSkull=0;
			ArrayList<CombatDiceSymbol> combatResult = combatDice.getRedDicesResult(Goblin.ATK + dagger.getAttackBonus();
			for(combatResult.size():combatResult){
				if(combatResult==CombatDiceSymbol.SKULL){
					totalSkull++;
				}
				return totalSkull;
			}
		}

		*/
		
	}
	
}
