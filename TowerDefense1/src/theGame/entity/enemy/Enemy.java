package theGame.entity.enemy;

import theGame.entity.GameEntity;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Enemy implements GameEntity{
	protected int posX;
	protected int posY;
	protected int blood;
	protected int speed;
	protected int defense;
	protected int award;
	protected int damage;
	protected boolean visible;
	public boolean finishPoint = false;
	

	protected Enemy() {
		
	}

	@Override
	public final int getPosX() {
		return posX;
	}

	protected final void setPosX(int posX) {
		this.posX = posX;
	}

	@Override
	public final int getPosY() {
		return posY;
	}

	protected final void setPosY(int posY) {
		this.posY = posY;
	}
	
	public boolean isVisible() {
		return this.visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public int getAward() {
		return this.award;
	}
	
	abstract public  Image loadImage();
	
	public void move() {
		
	}

}
