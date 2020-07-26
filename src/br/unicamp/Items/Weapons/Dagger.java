package br.unicamp.Items.Weapons;


public class Dagger extends Weapon {

	public final static int RANGE = 3;
	public final static int ATK_BONUS = 1;
	
	public Dagger(){
		super(Dagger.RANGE,Dagger.ATK_BONUS,true,true);
	}
	
	@Override
	public void report(int i) {
		String message = String.valueOf(i) + " - "+  "Dagger: "  + this.getData();
		System.out.println(message);
	}
	@Override
	public void report() {
		String message = "Dagger: "  + this.getData();
		System.out.println(message);
	}
	
	@Override
	public String toString() {
		return ("Dagger " + this.getData());
	}
	
	
}
