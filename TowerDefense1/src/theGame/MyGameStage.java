package theGame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyGameStage extends JPanel {
	private Image[] myImage;
	
    public MyGameStage() {
        setFocusable(true); // Focus on JPanel to receive key events
        requestFocus();
    	initBoard();
    }
    
    public Dimension getPreferredSize() {
        // Override getPreferredSize by defining own size
        return new Dimension(500, 500);
    } 
    
    
    private void initBoard() {
    	myImage = new Image[4];
    	myImage[0] = loadImage("src/icon/sand2.jpg");
    	myImage[1] = loadImage("src/icon/grass1.png");
    	myImage[2] = loadImage("src/icon/Gate.png");
    	myImage[3] = loadImage("src/icon/sand.jpg");
    }
    
    private Image loadImage(String file) {
        ImageIcon ii = new ImageIcon(file);
        return ii.getImage();        
    }
    
    private static final String[][] MAP_SPRITES_1 = new String[][] {
    	{"1","1","1","1", "1","1","1","1", "1","1","1","1", "1","1","1","1", "1","1","1","1","1"},
    	{"0","0","0","2", "1","1","1","1", "1","1","1","1", "1","1","1","1", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "1","1","1","1", "1","1","1","1", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "1","1","1","1", "1","1","1","1", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "2","0","0","0", "0","0","0","2", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "2","1","1","1", "1","1","1","2", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "2","1","1","1", "1","1","1","2", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "2","1","1","1", "1","1","1","2", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "2","1","1","1", "1","1","1","2", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "2","1","1","1", "1","1","1","2", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "2","1","1","1", "1","1","1","2", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "2","1","1","1", "1","1","1","2", "0","0","0","0","0"},
    	{"1","1","1","2", "0","0","0","0", "2","1","1","1", "1","1","1","1", "1","1","1","1","1"},
    	{"1","1","1","1", "1","1","1","1", "1","1","1","1", "1","1","1","1", "1","1","1","1","1"},
    };
    
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	for (int i = 0; i < 14; i++) {
    		for (int j = 0; j < 21; j++) {
    			if (MAP_SPRITES_1[i][j] == "1") g.drawImage(myImage[1], j*50, i*50, null); // draw grass
    			if (MAP_SPRITES_1[i][j] == "0") g.drawImage(myImage[0], j*50, i*50, null); // draw road
    			if (MAP_SPRITES_1[i][j] == "2") g.drawImage(myImage[3], j*50, i*50, null); // draw road
    		}
    	}
    	g.drawImage(myImage[2], 20*50, 8*50, null); // draw gate
    }
}
