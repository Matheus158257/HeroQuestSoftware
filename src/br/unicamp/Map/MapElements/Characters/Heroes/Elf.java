package br.unicamp.Map.MapElements.Characters.Heroes;

import br.unicamp.Dices.Dice;
import br.unicamp.Items.Spells.SimpleHeal;
import br.unicamp.Items.Spells.Spell;
import br.unicamp.Items.Weapons.ShortSword;
import br.unicamp.Items.Weapons.Weapon;
import br.unicamp.Map.MapElements.Characters.Monsters.Monster;

public class Elf extends Hero{
	
	public static final int ATK = 2; // Attack Points
	public static final int DEF = 2; // Defense Points
	public static final int LP = 6; // Life Points
	public static final int MP = 4; // Mana Points
	public static final int MAX_SPELLS = 4;
	
	private Spell elfSpells[];
	private int actualSpellsNo = 0;
	
	public Elf (int x0, int y0){
		super(x0,y0,"Elf",Elf.ATK,Elf.DEF,Elf.LP,Elf.MP);
		
//		Weapon shortSword = new ShortSword();
//		this.equipWeapon(shortSword);
//		Spell simpleHeal = new SimpleHeal();
//		elfSpells = new Spell[Elf.MAX_SPELLS];
//		elfGetSpell(simpleHeal);
		
	}

//	private void elfGetSpell(Spell newSpell){
//		elfSpells[actualSpellsNo]= newSpell;
//		actualSpellsNo++;
//	}

	protected void castSpell(Monster targetMontser, Dice redDice1, Dice redDice2, Dice combatDice){
		//		int result = redDice1.roll()+ redDice2.roll();
		//		if(result<targetMontser.getMana()){
		//			//verifica se o alvo tem defesa
		//			targetMontser.defenseAgainstMagic(combatDice);

	}
	
	@Override
	public String toString() {
		return "E";
	}
	
}

