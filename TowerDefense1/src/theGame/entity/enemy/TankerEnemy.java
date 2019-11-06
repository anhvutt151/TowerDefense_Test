package theGame.entity.enemy;

import java.awt.Image;

import javax.swing.ImageIcon;

public class TankerEnemy extends Enemy{
	
	public TankerEnemy(double posX, double posY) {
		super(posX,posY);
		blood = 100;
		speed = 25;
		defense = 100;
		award = 50;
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