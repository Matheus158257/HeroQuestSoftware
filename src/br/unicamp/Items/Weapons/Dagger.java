package br.unicamp.Items.Weapons;


public class Dagger extends Weapon {
	
	public Dagger(){
		super(1);
	}
	
	@Override
	public void report() {
		String message = "Dagger: "  + "(range " + String.valueOf(range) + ") (attackBonus" + String.valueOf(attackBonus) + ")\n";
		System.out.println(message);
	}
}
