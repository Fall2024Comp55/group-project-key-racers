//import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;

public class DescriptionPane extends GraphicsPane{
	
	// window size
		public static final int WINDOW_WIDTH = 800;
		public static final int WINDOW_HEIGHT = 600;
		
		
		
	public DescriptionPane(MainApplication mainScreen) {
		this.mainScreen = mainScreen;
	}
	
	
	@Override
	public void showContent() {
		disPlay();
		backButton();
		
	}

	@Override
	public void hideContent() {
		for(GObject item : contents) {
			mainScreen.remove(item);
		}
		contents.clear();
	}
	// this method display the image in the background
	public void disPlay() {
		GImage backGround = new GImage("InstructionsScreen.jpg");
		backGround.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		
		
		contents.add(backGround);
		mainScreen.add(backGround);
	}
	
	//this method create an oval button and placed behind the backArrow icon in top left of the screen.
	public void backButton() {
		GOval button = new GOval(16,26,100,105);
		button.setVisible(false);
	
		
		contents.add(button);
		mainScreen.add(button);
		
	}
	
	

	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (mainScreen.getElementAtLocation(e.getX(), e.getY()) == contents.get(1)) {
			mainScreen.switchToWelcomeScreen();
		}
	}

}
