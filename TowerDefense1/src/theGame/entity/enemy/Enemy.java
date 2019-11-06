package theGame.entity.enemy;

import theGame.entity.GameEntity;

public abstract class Enemy implements GameEntity{
	protected double posX;
	protected double posY;
	protected int blood;
	protected int speed;
	protected int defense;
	protected int award;

	protected Enemy(double posX, double posY) {
		this.posX = posX;
		this.posY = posY;
	}

	@Override
	public final double getPosX() {
		return posX;
	}

	protected final void setPosX(double posX) {
		this.posX = posX;
	}

	@Override
	public final double getPosY() {
		return posY;
	}

	protected final void setPosY(double posY) {
		this.posY = posY;
	}

	abstract protected void move();

}
