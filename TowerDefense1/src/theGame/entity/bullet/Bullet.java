package theGame.entity.bullet;

public class Bullet extends Sprite {
    private final int bulletSpeed; // toc do dan bay
    private final int damage; // sat thuong cua dan

    public Bullet(int x, int y, int bulletSpeed, int damage) {
        super(x, y);
        this.bulletSpeed = bulletSpeed;
        this.damage = damage;
        initBullet();
    }
    
    private void initBullet() {   
        loadImage("src/resources/missile.png");
        getImageDimensions();        
    }

    public void move() {
    	// bo sung chieu chuyen dong
    }
}
