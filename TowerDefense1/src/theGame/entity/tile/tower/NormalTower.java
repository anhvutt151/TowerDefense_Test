package theGame.entity.tile.tower;

import java.awt.Image;

import javax.swing.ImageIcon;

import theGame.entity.tile.GameTile;
import theGame.entity.enemy.Enemy;
import theGame.entity.bullet.Bullet;

public class NormalTower extends AbstractTower implements GameTile {
	private final int x;
	private final int y;
	
	public NormalTower(int x, int y) {
		this.x = x;
		this.y = y;
		this.bulletSpeed = 3; // tuy chinh
		this.damage = 20; // tuy chinh
		this.shootingDistance = 20; // tuy chinh
	}
	
	public int getPosX() {
		return this.x;
	}
	
	public int getPosY() {
		return this.y;
	}
	
	public void update() {
		// ham kiem tra xem co ke thu nao trong tam ban hay khong. neu co thi fire()
		// luon luon updateBullet() de cap nhat duong di cua dan
	}
	
	public void graphic() {
 
	}
	
	@Override
	public Image getImage() {
        ImageIcon ii = new ImageIcon("src/icon/Tower/kale1.png");
        myImage = ii.getImage();
		return this.myImage;
	}
	
	// attack enemy
	private void fire() {
		// bo sung direction cho bullet 
		towerBullet.add(new Bullet(this.x, this.y, this.bulletSpeed, this.damage));
	}
	
	
	public void attack(Enemy enemy) {
		fire();
	}
	
}
