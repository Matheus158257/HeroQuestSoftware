package br.unicamp.Items.Weapons;


public class ShortSword extends Weapon{
	
	public final static int RANGE = 1;
	public final static int ATK_BONUS = 2;
	
	public ShortSword(){
		super(ShortSword.RANGE,ShortSword.ATK_BONUS,false,true);
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
 
	@Override
	public String toString() {
		return ("Short Sword "  + this.getData());
	}
	
}
