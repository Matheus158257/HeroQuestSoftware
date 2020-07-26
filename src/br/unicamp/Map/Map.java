package br.unicamp.Map;

//import br.unicamp.Map.GroupElements.Hall;
import br.unicamp.Map.GroupElements.Room;
import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Map.MapElements.StaticElements.FloorElement;
import br.unicamp.Map.MapElements.StaticElements.WallElement;
import br.unicamp.Map.MapElements.StaticElements.VariableElements.*;

import java.util.ArrayList;
import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.RedDice;
import br.unicamp.Exceptions.*;
import br.unicamp.Game.Command;
import br.unicamp.Interfaces.Collectable;
import br.unicamp.Items.Coin;
import br.unicamp.Items.Potion;
import br.unicamp.Items.Armor.Armor;
import br.unicamp.Items.Weapons.Dagger;
import br.unicamp.Items.Weapons.LongSword;
import br.unicamp.Items.Weapons.ShortSword;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.Barbarian;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;
import br.unicamp.Map.MapElements.Characters.Monsters.Goblin;
import br.unicamp.Map.MapElements.Characters.Monsters.Monster;
import br.unicamp.Map.MapElements.Characters.Monsters.Skeleton;
import br.unicamp.Map.MapElements.Characters.Monsters.SkeletonWizard;


public class Map {

	public static final int ROOMS = 21;

	public static final int SIZE_X = 34;
	public static final int SIZE_Y = 25;

	private int sizeX;
	private int sizeY;

	private MapElement map[][];

	private Room[] rooms;
	private int roomIndex;
	private ArrayList<Monster> monsters;

//	private RedDice redDice;
//	private CombatDice combatDice;


	//----------------------- CONSTRUCTOR

	public Map() {
		this.sizeX = Map.SIZE_X;
		this.sizeY = Map.SIZE_Y;
		this.map = new MapElement[this.sizeX][this.sizeY];

		// Foram passados para Game
//		this.redDice= new RedDice();
//		this.combatDice= new CombatDice();

		this.rooms = new Room[Map.ROOMS];
		this.roomIndex = 0;

		this.monsters = new ArrayList<Monster>();

		// sets FloorElement in entire map
		for(int i=0; i<sizeX; i++) {
			for(int j=0; j<sizeY; j++) {
				map[i][j] = new FloorElement(i,j, false);
			}	
		}

		// Making fixed Rooms
		makeRooms();

	}

	//----------------------- GENERIC CHARACTER METHODS

	public void moveCharacter(Command direction, Character character) throws OccupiedTileException, OutOfBoundsException {
		int currX = character.getX();
		int currY = character.getY();
		int incrX=0;
		int incrY=0;

		switch (direction) {
		case UP:
			incrX=0;
			incrY=-1;
			break;
		case RIGHT:
			incrX=1;
			incrY=0;
			break;
		case DOWN:
			incrX=0;
			incrY=1;
			break;
		case LEFT:
			incrX=-1;
			incrY=0;
			break;
		default:
			break;
		}


		int destX = character.getX()+incrX;
		int destY = character.getY()+incrY;


		if (isInMap(destX,destY)) {

			if (isFree(destX,destY)) {

				character.changePosition(direction);

				//map[currX][currY] = new FloorElement(currX,currY,true);
				this.clearTile(currX, currY, true);
				map[destX][destY] = character;

			} else {
				String message = ("Tried to move to an occupied tile.");
				throw new OccupiedTileException(message);
			}
		} else {
			String message = ("Tried to move out of bounds.");
			throw new OutOfBoundsException(message);
		}
	}

	private void updatePlayerPosition(int oldX, int oldY, Character character) {
		this.clearTile(oldX, oldY, true);

		int newX = character.getX();
		int newY = character.getY();
		this.map[newX][newY] = character;
	}
	
	public int oneAxeMaxAbsoluteDistanceBetweenCharacters(Character c1, Character c2) {
		int c1X = c1.getX();
		int c1Y = c1.getY();
		int c2X = c2.getX();
		int c2Y = c2.getY();
		int xD = Math.abs(c1X-c2X);
		int yD = Math.abs(c1Y-c2Y);
		
		return Math.max(xD, yD);
	}
	
	public void telePortCharacter(Character character, int newX, int newY) {
		int oldX = character.getX();
		int oldY = character.getY();
		this.clearTile(oldX, oldY, true);
		character.changeCoordinates(newX, newY);
		this.map[newX][newY] = character;
		
	}



	//----------------------- HERO (PLAYER) METHODS


	public void spellMagic(Hero player, RedDice redDice, CombatDice combatDice) throws NotSpellerException {
		try{
			player.castSpell(this, redDice, combatDice);
		}catch(NotSpellerException e) {
			System.out.println(e.getMessage());
		}
	}
	


	
	public Monster checkMonsterTargets(int range, Character reference) {
		int Xh = reference.getX();
		int Yh = reference.getY();
		int Xm,Ym,Xdif,Ydif;

		// TODO checar se o caminho entre o player e o Monster esta realmente livre

		for (Monster m : this.monsters) {
			if(m!=null && m.isVisible()) {
				Xm = m.getX();
				Ym = m.getY();

				if(Xm>=Xh) {
					Xdif = Xm-Xh;
				} else {
					Xdif = Xh-Xm;					
				}

				if(Ym>=Yh) {
					Ydif = Ym-Yh;
				} else {
					Ydif = Yh-Ym;					
				}

				if(Xdif<=range && Ydif<=range ) {
					//					System.out.println("LOG: Monster found: " + m.toString(true));
					return m;
				}
			}
		}

		return null;
	}

	public void searchChests(Character player) {
		int X = player.getX();
		int Y = player.getY();

		// Checking NORTH
		if(isInMap(X,Y-1) && map[X][Y-1].getOpened(player)) {
			Chest chest = (Chest) map[X][Y-1];
			chest.updateChestOnMap(this);
		}

		// Checking EAST
		else if (isInMap(X+1,Y) && map[X+1][Y].getOpened(player)) {
			Chest chest = (Chest) map[X+1][Y];
			chest.updateChestOnMap(this);
		} 

		// Checking SOUTH
		else if (isInMap(X,Y+1) && map[X][Y+1].getOpened(player)) {
			Chest chest = (Chest) map[X][Y+1];
			chest.updateChestOnMap(this);
		} 

		// Checking WEST
		else if (isInMap(X-1,Y) && map[X-1][Y].getOpened(player)) {
			Chest chest = (Chest) map[X-1][Y];
			chest.updateChestOnMap(this);
		}

	}

	public void searchDoors(Character player) throws OccupiedTileException, OutOfBoundsException {
		int X = player.getX();
		int Y = player.getY();


		// Checking NORTH
		if(isInMap(X,Y-1) && map[X][Y-1].goThrough(player)) {
			// Update player position
			this.updatePlayerPosition(X,Y,player);
		}

		// Checking EAST
		else if (isInMap(X+1,Y) && map[X+1][Y].goThrough(player)) {
			// Update player position
			this.updatePlayerPosition(X,Y,player);
		} 

		// Checking SOUTH
		else if (isInMap(X,Y+1) && map[X][Y+1].goThrough(player)) {
			// Update player position
			this.updatePlayerPosition(X,Y,player);
		} 

		// Checking WEST
		else if (isInMap(X-1,Y) && map[X-1][Y].goThrough(player)) {
			// Update player position
			this.updatePlayerPosition(X,Y,player);
		}

	}

//	public void attackMonster(Hero player) {
//		//		System.out.println("LOG: Checking " + range + " tiles around " + player);
//		int range = player.getAttackRange();
//		Monster target = this.checkMonsterTargets(range, player);
//
//		if(target !=null) {
//			System.out.println("Target is " + target.toString(true));
//			int attackPoints = player.getAttackPoints();
//			//			System.out.println("LOG: Player ATK: " + attackPoints);
//			int defensePoints = target.getDefensePoints();
//			//			System.out.println("LOG: Monster DEF: " + defensePoints);
//
//			int skulls = this.combatDice.rollAttackDice(attackPoints);
//			int shields = this.combatDice.rollMonsterDefenseDice(defensePoints);
//
//			int damage = skulls - shields;
//
//			System.out.println(player.toString(true) + " rolled " + skulls + " SKULLS");
//			System.out.println(target.toString(true) + " rolled " + shields + " MONSTER SHIELDS");
//			System.out.println("Damage inflicted: " + damage);
//
//			if(target.takeDamage(damage)) {
//				System.out.println("Killed " + target.toString(true));
//				this.killMonster(target);
//			}
//		}
//	}
	
	public void attackMonster(CombatDice combatDice, Hero player) {
		//		System.out.println("LOG: Checking " + range + " tiles around " + player);
		int range = player.getAttackRange();
		Monster target = this.checkMonsterTargets(range, player);

		if(target !=null) {
			System.out.println("Target is " + target.toString(true));
			int attackPoints = player.getAttackPoints();
			//			System.out.println("LOG: Player ATK: " + attackPoints);
			int defensePoints = target.getDefensePoints();
			//			System.out.println("LOG: Monster DEF: " + defensePoints);

			int skulls = combatDice.rollAttackDice(attackPoints);
			int shields = combatDice.rollMonsterDefenseDice(defensePoints);

			int damage = skulls - shields;

			System.out.println(player.toString(true) + " rolled " + skulls + " SKULLS");
			System.out.println(target.toString(true) + " rolled " + shields + " MONSTER SHIELDS");
			System.out.println("Damage inflicted: " + damage);

			if(target.takeDamage(damage)) {
				System.out.println("Killed " + target.toString(true));
				this.killMonster(target);
			}
		}
	}

	//----------------------- MONSTER METHODS


	public void runMonsterActions(CombatDice combatDice, Hero player)  throws OccupiedTileException, OutOfBoundsException  {
		// TODO
		for (Monster m : monsters) {
			this.dummyWalk(m);
			if(hasHeroInRange(m, player)) {
				System.out.println(m.toString(true) + " has " + player.toString(true) + " in range.");
				this.attackHero(combatDice, m,player);
			}
		}	
	}
	
	public ArrayList<Monster> getMonsters() {
		return this.monsters;
	}
	
	public ArrayList<Monster> getMonstersAround(int range, Monster reference) {
		ArrayList<Monster> monstersAround = new ArrayList<Monster>();
		for(Monster monster: monsters){
			if (this.oneAxeMaxAbsoluteDistanceBetweenCharacters(monster, reference) <= range && this.oneAxeMaxAbsoluteDistanceBetweenCharacters(monster, reference) !=0){
				monstersAround.add(monster);
			}
		}
		
		return monstersAround;
		
	}

	public void dummyWalk(Monster monster) throws OccupiedTileException, OutOfBoundsException {
//		int steps = redDice.getResult(1);
		// TODO voltar a linha anterior e comentar a proxima
		int steps = 1;
		if (monster.isVisible()) {
			do{
				while(map[monster.getX()][monster.getY()+1].isFree() && steps>0){
					this.moveCharacter(Command.DOWN, monster);
					steps--;
				}
				while(map[monster.getX()][monster.getY()-1].isFree() && steps>0){
					this.moveCharacter(Command.UP, monster);
					steps--;
				}
				while(map[monster.getX()][monster.getY()+1].isFree() && steps>0){
					this.moveCharacter(Command.RIGHT, monster);
					steps--;
				}
				while(map[monster.getX()][monster.getY()+1].isFree() && steps>0){
					this.moveCharacter(Command.LEFT, monster);
					steps--;
				}
			}while(steps>0);
		}
	}

	
	
	private boolean hasHeroInRange(Monster reference, Hero target) {
		int range = reference.getAttackRange();
		int Xm = reference.getX();
		int Ym = reference.getY();

		int Xh = target.getX();
		int Yh = target.getY();
		int Xdif,Ydif;

		// TODO checar se o caminho entre o player e o Monster esta realmente livre

		if(Xm>=Xh) {
			Xdif = Xm-Xh;
		} else {
			Xdif = Xh-Xm;					
		}

		if(Ym>=Yh) {
			Ydif = Ym-Yh;
		} else {
			Ydif = Yh-Ym;					
		}

		if(Xdif<=range && Ydif<=range ) {
			System.out.println("LOG: Hero is within found range to " + reference.toString(true));
			return true;
		}
		return false;
	}

	public void attackHero(CombatDice combatDice, Monster monster, Hero target) {
		//		System.out.println("LOG: Checking " + range + " tiles around " + monster);
		int range = monster.getAttackRange();

		if(target !=null) {
			int attackPoints = monster.getAttackPoints();
			//			System.out.println("LOG: Monster ATK: " + attackPoints);
			int defensePoints = target.getDefensePoints();
			//			System.out.println("LOG: Player DEF: " + defensePoints);

			int skulls = combatDice.rollAttackDice(attackPoints);
			int shields = combatDice.rollHeroDefenseDice(defensePoints);

			int damage = skulls - shields;

			System.out.println(monster.toString(true) + " rolled " + skulls + " SKULLS");
			System.out.println(target.toString(true) + " rolled " + shields + " HERO SHIELDS");
			System.out.println("Damage inflicted: " + damage);

			if(target.takeDamage(damage)) {
				System.out.println("----------/nGAME OVER/n---------- ");
				// TODO
				//				this.endGame();
			}
		}
	}

	public void killMonster(Monster m) {
		this.monsters.remove(m);
		this.clearTile(m.getX(), m.getY(), true);
	}
	


	//----------------------- MAP METHODS

	public void clearTile(int x, int y, boolean seen) {
		map[x][y] = new FloorElement(x,y,seen);
	}

	public void print() {
		for (int j = 0; j < this.sizeY ; j++) {
			for (int i=0; i<this.sizeX; i++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.print("\n") ;
		}
	}

	public void updateMap(Character reference) {
		this.updateVisibility(reference);
		this.checkLights();
	}

	private void updateVisibility(Character reference) {
		// Updates map's visibility in four directions according to a Character Reference
		int currX = reference.getX();
		int currY = reference.getY();
		boolean blocked;

		// Updating RIGHT
		blocked=false;
		for(int i=(currX+1); i<this.sizeX & !blocked; i++ ) {
			if(map[i][currY].isFree()) {
				map[i][currY].beSeen();
			} else {
				map[i][currY].beSeen();
				blocked = true;
			}
		}
		// Updating DOWN
		blocked=false;
		for(int i=(currY+1); i<this.sizeY & !blocked; i++ ) {
			if(map[currX][i].isFree()) {
				map[currX][i].beSeen();
			} else {
				map[currX][i].beSeen();
				blocked = true;
			}
		}
		// Updating LEFT
		blocked=false;
		for(int i=(currX-1); i>=0 & !blocked; i-- ) {
			if(map[i][currY].isFree()) {
				map[i][currY].beSeen();
			} else {
				map[i][currY].beSeen();
				blocked = true;
			}
		}
		// Updating UP
		blocked=false;
		for(int i=(currY-1); i>=0 & !blocked; i-- ) {
			if(map[currX][i].isFree()) {
				map[currX][i].beSeen();
			} else {
				map[currX][i].beSeen();
				blocked = true;
			}
		}
	}

	private void checkLights() {
		int x0;
		int y0;
		int dimX;
		int dimY;

		for(Room r : rooms) {
			if(r != null && r.isLit()) {
				x0=r.getX0();
				y0=r.getY0();
				dimX=r.getDimX();
				dimY=r.getDimY();

				for(int i=x0; i<(x0+dimX);i++) {
					for(int j=y0; j<(y0+dimY);j++) {
						map[i][j].beSeen();
					}
				}
			}
		}
	}


	// Method to check if a Tile is inside the map (TRUE) or Out of Bounds (FALSE)
	private boolean isInMap(int X, int Y) {
		if(X<sizeX && Y<sizeY && X>=0 && Y>=0) {
			return true;
		} else {
			return false;
		}
	}


	// Method to check is a Tile is empty (free)	
	public boolean isFree(int X, int Y) {

		if(isInMap(X,Y)) {

			if (map[X][Y].isFree()) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}

	}


	//----------------------- MAP MAKER METHODS


	public void addElement(MapElement element) {
		int posX=element.getX();
		int posY=element.getY();

		this.map[posX][posY] = element;
	}

	public void addMonster(Monster monster) {
		this.addElement(monster);
		this.monsters.add(monster);
	}

	private void addRoom(int x0, int y0, int dimX, int dimY) {
		rooms[this.roomIndex] = new Room(x0,y0,dimX,dimY);
		this.roomIndex++;
	}

	public void addTreasure(int x, int y, Collectable reward) {
		this.map[x][y] = new Treasure(x,y,reward);
	}

	public void addChestTrap(int x, int y, Monster monster) {
		this.map[x][y] = new ChestTrap(x,y,monster);
	}

	// Add Door that connects a Room with an external hall
	public void addDoor(int x, int y, int roomIndex, boolean isVertical) {
		this.map[x][y] = new Door(x,y,rooms[roomIndex],isVertical);
	}

	// Add Door that connects two Rooms
	public void addDoor(int x, int y, int roomIndexA, int roomIndexB, boolean isVertical) {
		this.map[x][y] = new Door(x,y,rooms[roomIndexA],rooms[roomIndexB],isVertical);
	}

	private void makeRoom(int x0, int y0,int sizeX, int sizeY) {
		// Making outer walls
		for(int i=x0; i<(x0+sizeX); i++) {
			for(int j=y0; j<(y0+sizeY); j++) {
				map[i][j] = new WallElement(i,j);
			}	
		}
		// Making room inside
		for(int i=x0+1; i<(x0+1+sizeX-2); i++) {
			for(int j=y0+1; j<(y0+1+sizeY-2); j++) {
				map[i][j] = new FloorElement(i,j, false);
			}	
		}

		addRoom(x0+1,y0+1,sizeX-2,sizeY-2);

	}

	private void makeRooms() {
		// Room 1
		makeRoom(1,1,6,5);
		// Room 2
		makeRoom(6,1,6,5);
		// Room 3
		makeRoom(11,1,5,7);
		// Room 4
		makeRoom(1,5,6,7);
		// Room 5
		makeRoom(6,5,6,7);

		// Room 6
		makeRoom(18,1,5,7);
		// Room 7
		makeRoom(22,1,6,6);
		// Room 8
		makeRoom(27,1,6,6);
		// Room 9
		makeRoom(22,6,6,6);
		// Room 10
		makeRoom(27,6,6,6);

		// Room 11
		makeRoom(1,13,6,6);
		// Room 12
		makeRoom(6,13,6,5);
		// Room 13
		makeRoom(1,18,6,6);
		// Room 14
		makeRoom(6,17,6,7);
		// Room 15
		makeRoom(11,17,5,7);

		// Room 16
		makeRoom(22,13,6,6);
		// Room 17
		makeRoom(27,13,6,6);
		// Room 18
		makeRoom(18,17,5,7);
		// Room 19
		makeRoom(22,18,6,6);
		// Room 20
		makeRoom(27,18,6,6);

		// Room 21
		makeRoom(13,9,8,7);

	}

	public void makeStandardDoors() {
		// Vertical Doors
		addDoor(4,1,0,true);
		addDoor(4,11,3,true);

		addDoor(20,1,5,true);
		addDoor(25,6,6,8,true);
		addDoor(30,6,7,9,true);
		addDoor(25,11,8,true);

		addDoor(4,18,10,12,true);
		addDoor(8,17,11,13,true);
		addDoor(9,13,11,true);
		addDoor(9,23,13,true);
		addDoor(13,17,14,true);

		addDoor(24,13,15,true);
		addDoor(30,13,16,true);
		addDoor(25,18,15,18,true);

		addDoor(17,15,20,true);

		// Horizontal Doors
		addDoor(6,3,1,0,false);
		addDoor(11,6,2,4,false);
		addDoor(6,9,3,4,false);
		addDoor(1,8,3,false);

		addDoor(18,4,5,false);
		addDoor(22,4,5,6,false);
		addDoor(32,3,7,false);
		addDoor(1,21,12,false);

		addDoor(18,19,17,false);
		addDoor(22,20,17,18,false);
		addDoor(27,20,18,19,false);

	}


	public void makeStandardChest() {
		addTreasure(2,2, new Coin(10));
		addTreasure(2,9, new Potion(10));
		addTreasure(2,16, new Armor(10));
		addTreasure(7,2, new Armor(10));
		addTreasure(12,2, new LongSword());
		addTreasure(13,20, new ShortSword());
		addTreasure(17,14, new Potion(4));
		addTreasure(23,5, new Potion(4));
		addTreasure(26,14, new LongSword());
		addTreasure(28,21, new Dagger());
		addChestTrap(2,10, new Goblin(2,10));
		addChestTrap(2,14, new Skeleton(2,14));
		addChestTrap(2,21, new SkeletonWizard(2,21));
		addChestTrap(10,21, new Goblin(10,21));
		addChestTrap(14,14, new Skeleton(14,14));
		addChestTrap(20,4, new SkeletonWizard(20,4));
		addChestTrap(23,16, new Goblin(23,16));
		addChestTrap(24,20, new Skeleton(24,20));
		addChestTrap(29,3, new SkeletonWizard(29,3));
		addChestTrap(29,8, new Goblin(29,8));
	}





}
