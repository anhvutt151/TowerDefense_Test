package theGame.entity.tile.tower;

import theGame.entity.tile.GameTile;
import theGame.entity.enemy.Enemy;
import theGame.entity.bullet.Bullet;

import java.awt.Image;

import java.util.*;

public abstract class AbstractTower implements GameTile {
	protected int bulletSpeed; // toc do dan
	protected int shootingDistance; // tam ban
	protected int damage; // sat thuong
	public List<Bullet> towerBullet;

    public List<Bullet> getBullet() {
    	return towerBullet;
    }
	
	public abstract void attack(Enemy enemy);
	
	Image myImage;
	
	public abstract Image getImage();
	
}
