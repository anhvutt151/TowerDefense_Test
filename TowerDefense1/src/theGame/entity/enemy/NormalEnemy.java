package theGame.entity.enemy;

import java.awt.Image;

import javax.swing.ImageIcon;

public class NormalEnemy extends Enemy{
	
	public NormalEnemy(double posX, double posY) {
		super(posX,posY);
		blood = 50;
		speed = 50;
		defense = 50;
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
