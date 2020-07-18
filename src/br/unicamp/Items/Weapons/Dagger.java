package br.unicamp.Items.Weapons;


public class Dagger extends Weapon {

	
	public Dagger(){
		super(1,1,true,true);
	}
	
	@Override
	public void report() {
		String message = "Dagger: "  + this.getData();
		System.out.println(message);
	}
	
}
