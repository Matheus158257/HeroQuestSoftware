package br.unicamp.Map.MapElements.Characters.Heroes;

import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.RedDice;
import br.unicamp.Interfaces.Caster;
import br.unicamp.Items.Spells.Spell;
import br.unicamp.Items.Weapons.Dagger;
import br.unicamp.Items.Weapons.Weapon;
import br.unicamp.Map.MapElements.Characters.Monsters.Monster;



public class Wizard extends Hero implements  Caster{
	
	public static final int ATK = 1; // Attack Points
	public static final int DEF = 2; // Defense Points
	public static final int LP = 3; // Life Points
	public static final int MP = 4; // Mana Points
	public static final int MAX_SPELLS = 4;
	
	private Spell heroSpells[];
	private int actualSpellsNo = 0;
	
	public Wizard (int x0, int y0){
		super(x0,y0,"Wizard",Wizard.ATK,Wizard.DEF,Wizard.LP,Wizard.MP);
		
//		Weapon dagger1 = new Dagger();
//		Weapon dagger2 = new Dagger();
//		Weapon dagger3 = new Dagger();
//		this.equipWeapon(dagger1);
//		this.equipWeapon(dagger2);
//		this.equipWeapon(dagger3);
//		Spell magicmissile = new MagicMissile();
//		heroGetSpell(magicmissile);
//		Spell fireball = new Fireball();
//		heroGetSpell(fireball);
//		Spell teleport = new Teleport();
//		heroGetSpell(teleport);
	}
	
//	private void heroGetSpell(Spell newSpell){
//		heroSpells[actualSpellsNo]= newSpell;
//		actualSpellsNo++;
//	}

	@Override
	public String toString() {
		return "W";
	}

	@Override
	public void castSpell(Spell castSpeell, Monster targetMontser, RedDice redDice1, CombatDice combatDice) {
		/*int result = redDice1.rollDices();
		if(result<this.getMana()){
			// verifica os pontos de dano da spell lan�ada
			// int damage = castSpeell.getDamage();
			// verifica se o alvo tem defesa e retona quantos pontos ele tem de defesa
			// int targetDefensePoints = targetMontser.defenseAgainstMagic(combatDice);
			// targetMontser.receiveDamage(damage,targetDefensePoints);
		}	*/	
	}

	/*
	@Override
	public void castSpell( castSpeell, Monster targetMontser, RedDice redDice1,
			CombatDice combatDice) {
		// TODO Auto-generated method stub
		
	}*/
	
}
 