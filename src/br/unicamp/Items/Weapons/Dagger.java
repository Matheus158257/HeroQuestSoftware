package br.unicamp.Items.Weapons;


public class Dagger extends Weapon {
	// usa 1 m�o
	// perdido ap�s o uso
	
	public Dagger(){
		super(1);
		isShort = true;
	}
	
	@Override
	public void report() {
		String message = "Dagger: "  + "(range " + String.valueOf(range) + ") (attackBonus" + String.valueOf(attackBonus) + ")\n";
		System.out.println(message);
	}
	
	
}
