package theGame;

import theGame.entity.AbstractEntity;
import theGame.entity.tile.tower.*;
import theGame.entity.enemy.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.util.*;

public final class MyGameStage extends JPanel implements ActionListener {
	private int money = 200; // tien de mua thap
	private int score = 0; // diem so
	private int live = 100; // mang de tiep tuc choi
	private int level = 0; // game level
	
	private Timer timer;
	private final int DELAY = 30; // delay time
	private boolean ingame = false;
	private boolean win = true;
	private JButton playButton = new JButton("Next Level");
	
	private Image[] myImage;
	//public static List<AbstractEntity> gameObjects = new ArrayList<>();
	public final List<Enemy> gameEnemy;
	public final List<AbstractTower> towerObjects;
	
    public MyGameStage() {
        setFocusable(true); // Focus on JPanel to receive key events
        requestFocus();
            
        gameEnemy = new ArrayList<>();
        towerObjects = new ArrayList<>();
        
        initBoard();
        
    	JPanel sidePanel = new JPanel();
    	add(sidePanel);
    	sidePanel.setBounds(1050, 0, 230, 720);
    	sidePanel.setBackground(Color.LIGHT_GRAY);
    	
        playButton.setBounds(1165, 900, 200, 100);
    	playButton.setBorderPainted(true);
    	sidePanel.add(playButton);
    	setLayout(null);
          
        if (!ingame) {
        	initPlayButton();
        }
    	
    }
    
    private void initPlayButton() {
    	playButton.setVisible(true);
    	playButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if (level == 0) {
        			playButton.setVisible(false);
        			ingame = true;
        			initGame();
    			}
    		}
    	});	
    }
    
    private void initGame() {
    	this.level++;
        initEnemy();
        initTower();
        ingame = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }
    

    private void reInitPlayButton() {
    	playButton.setVisible(true);
    	playButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			playButton.setVisible(false);
    			initEnemy();
    			initTower();
    			
    			timer.isRepeats();
    			ingame = true;
    		}
    	});	    	
    }

    
    public boolean getIngame() {
    	return this.ingame;
    }
      
    /*
    public Dimension getPreferredSize() {
        // Override getPreferredSize by defining own size
        return new Dimension(500, 500);
    } */
    
    
    private void initBoard() {
    	myImage = new Image[5];
    	myImage[0] = loadImage("src/icon/sand2.jpg");
    	myImage[1] = loadImage("src/icon/grass1.png");
    	myImage[2] = loadImage("src/icon/Gate.png");
    	myImage[3] = loadImage("src/icon/sand.jpg");
    	myImage[4] = loadImage("src/icon/grass_TowerDefense.jpg");
    }
    
    private void initTower() {
    	towerObjects.add(new NormalTower(50,100));
    }
    
    private void initEnemy() {
    	gameEnemy.add(new NormalEnemy());
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
    
    private void drawTower(Graphics g) {
    		for (int i = 0; i < towerObjects.size(); i++) {
    			g.drawImage(towerObjects.get(i).getImage(), towerObjects.get(i).getPosX(), towerObjects.get(i).getPosY(), null);
    		}
    }
    
    private void drawMap(Graphics g) {
    	for (int i = 0; i < 14; i++) {
    		for (int j = 0; j < 21; j++) {
    			if (MAP_SPRITES_1[i][j] == "1") g.drawImage(myImage[1], j*50, i*50, null); // draw grass
    			if (MAP_SPRITES_1[i][j] == "0") g.drawImage(myImage[0], j*50, i*50, null); // draw road
    			if (MAP_SPRITES_1[i][j] == "2") g.drawImage(myImage[3], j*50, i*50, null); // draw road
    		}
    	}    	
    }
    
    private void drawEnemy(Graphics g) {
    	for (int i = 0; i < gameEnemy.size(); i++) {
    		if (gameEnemy.get(i).isVisible()) g.drawImage(gameEnemy.get(i).loadImage(), gameEnemy.get(i).getPosX(), gameEnemy.get(i).getPosY(), null);
    	}
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	
    	drawMap(g); // draw map
    	if (win) {		
    		if (ingame) {
    			drawEnemy(g); // draw enemy
    		}
    		drawTower(g); // draw tower
    		g.drawImage(myImage[2], 20*50, 8*50, null); // draw gate
    	}

    	Toolkit.getDefaultToolkit().sync();
    }
    
    private void inGame() {
    	if (live <= 0) {
    		win = false;
    		deleteAllObjects();
    		timer.stop();
    	}
    	if (live > 0 && gameEnemy.size() == 0) {
    		ingame = false;
    		reInitPlayButton();
    	}
    }
    
    // chi xoa het cac doi tuong khi nguoi choi thua
    public void deleteAllObjects() {
    	for (int i = 0; i < gameEnemy.size(); i++) {
    		gameEnemy.remove(i);
    	}
    	for (int i = 0; i < towerObjects.size(); i++) {
    		towerObjects.remove(i);
    	}
    }
    
    // thuc hien vong lap game
    public void actionPerformed(ActionEvent e) {
    	inGame();
    	
    	if (ingame) {
    	
    		updateEnemy();
    	
    		updateTower();
    	
    		checkCollisions();
    	}
    	
    	repaint();
    }
    
    // cap nhat di chuyen cho enemy
    private void updateEnemy() {
    	for (int i = 0; i < gameEnemy.size(); i++) {
    		Enemy a = gameEnemy.get(i);
    		if (a.isVisible()) {
    			a.update();
    			if (a.finishPoint) {
    				live -= a.getDamage();
    			}
    			continue;
    		} else {
    			if (!a.finishPoint) money += a.getAward();
    			gameEnemy.remove(i);
    		}
    	}
    }
    
    // cap nhat tower
    private void updateTower() {
    	for (int i = 0; i < towerObjects.size(); i++) {
    		towerObjects.get(i).update();
    	}
    }
    
    // kiem tra xem bullet co ban trung vao enemy hay khong
    private void checkCollisions() {
    	
    }
    

}
