package theGame.entity;

public abstract class AbstractEntity implements GameEntity {
	private double posX;
	private double posY;
	private double width;
	private double height;

	protected AbstractEntity(double posX, double posY, double width, double height) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
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



	protected final void setHeight(double height) {
		this.height = height;
	}

}
