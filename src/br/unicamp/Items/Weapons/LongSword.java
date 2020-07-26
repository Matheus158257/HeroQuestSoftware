package br.unicamp.Items.Weapons;


public class LongSword extends Weapon {
	
	public final static int RANGE = 2;
	public final static int ATK_BONUS = 3;
	
	public LongSword(){
		super(LongSword.RANGE,LongSword.ATK_BONUS,false,false);
		
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

	public String toString() {
		return ("Long Sword " + this.getData());
	}

}
