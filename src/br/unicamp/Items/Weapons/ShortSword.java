package br.unicamp.Items.Weapons;


public class ShortSword extends Weapon{
	
	public ShortSword(){
		super(2);
	}
	
	@Override
	public void report() {
		String message = "Short Sword: "  + "(range " + String.valueOf(range) + ") (attackBonus" + String.valueOf(attackBonus) + ")\n";
		System.out.println(message);
	}
 
}
