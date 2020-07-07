package br.unicamp.Map.MapElements.Spell;

import br.unicamp.Map.MapElements.Characters.Character;

public class Teleport extends Spell {

	public Teleport(){
		super();
	}
	
	private teleportUse(Character teleportedCharacter){
		//entender como o personagem vai ter acesso a outras poisções visiveis
		//chamada ao mapa?
		int newX = teleportedCharacter.getVisiblePositionX();
		int newy = teleportedCharacter.getVisiblePositionY();
		teleportedCharacter.x = newX;//Chatacter é um mapElement por iso tem atributos x e y de posição herdados
		teleportedCharacter.y = newY;
	}
}
