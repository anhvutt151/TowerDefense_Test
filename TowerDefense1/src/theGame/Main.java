package theGame;
import theGame.*;


public class Main {
	public Main() {
		mainFrame = new MyFrame();
		mainFrame.showBackground();
		mainFrame.menu();
	}
	public static MyFrame mainFrame;
	
	public static void main(String[] args) {
		Main game = new Main();
	}
}
