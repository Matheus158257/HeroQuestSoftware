package br.unicamp.Items.Weapons;


public class LongSword extends Weapon {
	
	public LongSword(){
		super(3);
		
	}
	
	@Override
	public void report() {
		String message = "Long Sword: "  + "(range " + String.valueOf(range) + ") (attackBonus" + String.valueOf(attackBonus) + ")\n";
		System.out.println(message);
	}
}
