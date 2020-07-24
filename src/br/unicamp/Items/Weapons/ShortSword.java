package br.unicamp.Items.Weapons;


public class ShortSword extends Weapon{
	
	public ShortSword(){
		super(1,2,false,true);
	}
	
	
	@Override
	public void report(int i) {
		String message = String.valueOf(i) + " - "+ "Short Sword: "  + this.getData();
		System.out.println(message);
	}
	
	@Override
	public void report() {
		String message = "Short Sword: "  + this.getData();
		System.out.println(message);
	}
 
}
