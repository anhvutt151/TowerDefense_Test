package theGame.entity.enemy;

import java.awt.Image;

import javax.swing.ImageIcon;

public class BossEnemy extends Enemy{
	
	public BossEnemy(double posX, double posY) {
		super(posX,posY);
		blood = 200;
		speed = 25;
		defense = 200;
		award = 150;
	}
	
	protected void move() {
		
	}
	
	// hien thi do hoa
    private Image loadImage(String file) {
        ImageIcon ii = new ImageIcon(file);
        return ii.getImage();        
    }
    
	public void graphic() {
		
	}
	
	// cap nhat trang thai cho cac doi tuong dong
	public void update() {
		
	}
	
}