package br.unicamp.Items.Weapons;


public class Dagger extends Weapon {
	// usa 1 m�o
	// perdido ap�s o uso

	
	public Dagger(){
		super(1,1,true,true);
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
