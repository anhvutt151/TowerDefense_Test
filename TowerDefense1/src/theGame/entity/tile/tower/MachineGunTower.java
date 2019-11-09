package theGame.entity.tile.tower;

import java.awt.Image;

import javax.swing.ImageIcon;

import theGame.entity.tile.GameTile;
import theGame.entity.enemy.Enemy;
import theGame.entity.bullet.Bullet;

public class MachineGunTower extends AbstractTower implements GameTile {
	private final int x;
	private final int y;
	
	public MachineGunTower(int x, int y) {
		this.x = x;
		this.y = y;
		this.bulletSpeed = 5; // tuy chinh
		this.damage = 20; // tuy chinh
		this.shootingDistance = 10; // tuy chinh
	}
	
	public int getPosX() {
		return this.x;
	}
	
	public int getPosY() {
		return this.y;
	}
	
	public void update() {
		
	}
	
	public void graphic() {
		// bo sung anh
        ImageIcon ii = new ImageIcon("");
        myImage = ii.getImage(); 
	}
	
	@Override
	public Image getImage() {
		return this.myImage;
	}
	
	// attack enemy
	private void fire() {
		// bo sung direction cho bullet 
		towerBullet.add(new Bullet(this.x, this.y, this.bulletSpeed, this.damage));
	}
	
	
	public void attack(Enemy enemy) {
		
	}
	
}
