package br.unicamp.Map.MapElements.StaticElements.VariableElements;

public class Trap extends OptionalElement {

	public Trap(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "T";
	}
	
	@Override
	public boolean isFree() {
		return true;
	}
	
}
