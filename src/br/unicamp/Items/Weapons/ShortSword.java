package br.unicamp.Items.Weapons;


public class ShortSword extends Weapon{
	
	public ShortSword(){
		super(1,2,false,true);
	}
	
	
	@Override
	public void report() {
		String message = "Short Sword: "  + this.getData();
		System.out.println(message);
	}
 
}
