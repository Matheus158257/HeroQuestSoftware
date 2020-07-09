package br.unicamp.Map.MapElements.Characters.Heroes;

import br.unicamp.Dices.Dice;
import br.unicamp.Items.Spells.SimpleHeal;
import br.unicamp.Items.Spells.Spell;
import br.unicamp.Items.Weapons.ShortSword;
import br.unicamp.Items.Weapons.Weapon;
import br.unicamp.Map.MapElements.Characters.Monsters.Monster;

public class Elf extends Hero{
	public static final int MAX_ELF_SPELLS = 4;
	private Spell elfSpells[];
	private int actualSpellsNo = 0;
	
	public Elf (){
		super("Elf",2,2,6,4);
		Weapon shortSword = new ShortSword();
		this.equipWeapon(shortSword);
		Spell simpleHeal = new SimpleHeal();
		elfSpells = new Spell[MAX_ELF_SPELLS];
		elfGetSpell(simpleHeal);
		
	}

	private void elfGetSpell(Spell newSpell){
		elfSpells[actualSpellsNo]= newSpell;
		actualSpellsNo++;
	}

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

