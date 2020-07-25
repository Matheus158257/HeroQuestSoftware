package br.unicamp.Map.MapElements.Characters.Heroes;

import java.util.ArrayList;

import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.RedDice;
import br.unicamp.Interfaces.Caster;
import br.unicamp.Items.Spells.Fireball;
import br.unicamp.Items.Spells.MagicMissile;
import br.unicamp.Items.Spells.Spell;
import br.unicamp.Items.Spells.Teleport;
import br.unicamp.Items.Weapons.Dagger;
import br.unicamp.Items.Weapons.Weapon;
import br.unicamp.Map.MapElements.Characters.Monsters.Monster;



public class Wizard extends Hero implements  Caster{
	
	public static final int ATK = 1; // Attack Points
	public static final int DEF = 2; // Defense Points
	public static final int LP = 3; // Life Points
	public static final int MP = 4; // Mana Points
	
	private ArrayList<Spell> spells = new ArrayList<Spell>();
	
	public Wizard (int x0, int y0){
		super(x0,y0,"Wizard",Wizard.ATK,Wizard.DEF,Wizard.LP,Wizard.MP,true);
		
//		this.equipWeapon(new Dagger());
//		this.equipWeapon(new Dagger());
//		this.equipWeapon(new Dagger());
		
		this.spells.add(new MagicMissile());
		this.spells.add(new Fireball());
		this.spells.add(new Teleport());
	}
	

	@Override
	public String toString() {
		return "W";
	}

	@Override
	public void castSpell(Spell castSpell, Character target, RedDice redDice1, CombatDice combatDice) {
		//int result = redDice1.rollDices();
		int result = 1;
		if(result<this.getMana()){
			// verifica os pontos de dano da spell lan�ada
			// int damage = castSpeell.getDamage();
			// verifica se o alvo tem defesa e retona quantos pontos ele tem de defesa
			// int targetDefensePoints = targetMontser.defenseAgainstMagic(combatDice);
			// targetMontser.receiveDamage(damage,targetDefensePoints);
			
			/*
			 * int result = redDice1.getResults();
		if(result<this.getMana()){
			// verifica os pontos de dano da spell lan�ada
			int damage = castSpeell.getDamage();
			//verifica se o alvo tem defesa e retona quantos pontos ele tem de defesa
			int targetDefensePoints = targetMontser.defenseAgainstMagic(combatDice);
			targetMontser.receiveDamage(damage,targetDefensePoints);
			 * */
		}
	}


	
}
 