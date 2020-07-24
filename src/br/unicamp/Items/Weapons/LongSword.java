package br.unicamp.Items.Weapons;


public class LongSword extends Weapon {
	
	public LongSword(){
		super(2,3,false,false);
		
	}
	
	@Override
	public void report() {
		String message = "Long Sword: "  + this.getData();
		System.out.println(message);
	}
	
	@Override
	public void report(int i) {
		String message = String.valueOf(i) + " - "+  "Long Sword: "  + this.getData();
		System.out.println(message);
	}
}
