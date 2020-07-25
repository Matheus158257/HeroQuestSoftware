package br.unicamp.Items.Spells;

import br.unicamp.Map.MapElements.Characters.Character;

public class Teleport extends Spell {

	public static final int POINTS = 0;
	public Teleport() {
		super(POINTS);
	}
	
	


	/*private teleportUse(Character teleportedCharacter){
		//entender como o personagem vai ter acesso a outras pois��es visiveis
		//chamada ao mapa?
		int newX = teleportedCharacter.getVisiblePositionX();
		int newy = teleportedCharacter.getVisiblePositionY();
		teleportedCharacter.x = newX;//Chatacter � um mapElement por iso tem atributos x e y de posi��o herdados
		teleportedCharacter.y = newY;
	}*/
}
