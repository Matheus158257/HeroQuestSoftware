package br.unicamp.Map.MapElements.Characters.Heroes;

import java.util.ArrayList;

import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.RedDice;
import br.unicamp.Interfaces.Caster;
import br.unicamp.Items.Spells.SimpleHeal;
import br.unicamp.Items.Spells.Spell;
import br.unicamp.Items.Weapons.ShortSword;
import br.unicamp.Items.Weapons.Weapon;
import br.unicamp.Map.MapElements.Characters.Monsters.Monster;

public class Elf extends Hero implements Caster{
	
	public static final int ATK = 2; // Attack Points
	public static final int DEF = 2; // Defense Points
	public static final int LP = 6; // Life Points
	public static final int MP = 4; // Mana Points
	
	private ArrayList<Spell> spells = new ArrayList<Spell>();
	
	public Elf (int x0, int y0){
		super(x0,y0,"Elf",Elf.ATK,Elf.DEF,Elf.LP,Elf.MP,true);
		Weapon shortSword = new ShortSword();
		this.equipWeapon(shortSword);
		this.spells.add(new SimpleHeal());
		
	}



	@Override
	public String toString() {
		return "E";
	}



	@Override
	public void castSpell(Spell castSpell, Character target, RedDice redDice1, CombatDice combatDice) {
		// TODO Auto-generated method stub
		//int result = redDice1.getResults();
		//if(result<this.getMana()){
			// verifica os pontos de dano da spell lan�ada
			// int damage = castSpeell.getDamage();
			// verifica se o alvo tem defesa e retona quantos pontos ele tem de defesa
			// int targetDefensePoints = targetMontser.defenseAgainstMagic(combatDice);
			// targetMontser.receiveDamage(damage,targetDefensePoints);
		//}	
	}
	
}

