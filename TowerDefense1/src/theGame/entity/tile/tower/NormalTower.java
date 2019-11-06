package theGame.entity.tile.tower;

import theGame.entity.tile.GameTile;

public class NormalTower extends AbstractTower implements GameTile {
	private final int x;
	private final int y;
	
	public NormalTower(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double getPosX() {
		return this.x;
	}
	
	public double getPosY() {
		return this.y;
	}
	
	public void update() {
		
	}
	
	public void graphic() {
		
	}
	
	
}
