package br.unicamp.Map.MapElements.Characters.Heroes;

import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.RedDice;
import br.unicamp.Interfaces.Caster;
import br.unicamp.Items.Weapons.ShortSword;
import br.unicamp.Items.Weapons.Weapon;
import br.unicamp.Map.MapElements.Characters.Monsters.Monster;
import br.unicamp.Map.MapElements.Spells.Spell;

public class Elf extends Hero implements Caster{
	
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

	@Override
	public String toString() {
		return "E";
	}

	@Override
	public void castSpell(Spell castSpeell, Monster targetMontser, RedDice redDice1, CombatDice combatDice) {
		//int result = redDice1.getResults();
		//if(result<this.getMana()){
			// verifica os pontos de dano da spell lançada
			// int damage = castSpeell.getDamage();
			// verifica se o alvo tem defesa e retona quantos pontos ele tem de defesa
			// int targetDefensePoints = targetMontser.defenseAgainstMagic(combatDice);
			// targetMontser.receiveDamage(damage,targetDefensePoints);
		//}		
	}
	
}

