package br.unicamp.Map.MapElements.Characters.Monsters;

public class SkeletonWizard extends Monster {

	public static final int ATK = 1;
	public static final int DEF = 1;
	public static final int LP = 1;
	public static final int MP = 1;
	
	
	public SkeletonWizard(int x0, int y0) {
		super(x0,y0,"Skeleton", SkeletonWizard.ATK, SkeletonWizard.DEF, SkeletonWizard.LP, SkeletonWizard.MP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "K";
	}
	
}
