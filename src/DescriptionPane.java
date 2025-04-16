import java.awt.event.MouseEvent;
import acm.graphics.*;

public class DescriptionPane extends GraphicsPane{
	
	// Window size
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
		
	//Connecting the description pane into the main screen	
	public DescriptionPane(MainApplication mainScreen) {
		this.mainScreen = mainScreen;
	}
	
	//Show content of the description pane
	@Override
	public void showContent() {
		disPlay();
		backButton();
		
	}

	//Hide content of the description pane
	@Override
	public void hideContent() {
		for(GObject item : contents) {
			mainScreen.remove(item);
		}
		
		contents.clear();
	}
	
	//This method display the image in the background
	public void disPlay() {
		GImage backGround = new GImage("InstructionsScreen.jpg");
		backGround.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		
		contents.add(backGround);
		mainScreen.add(backGround);
	}
	
	//This method create an oval button and placed behind the backArrow icon in top left of the screen.
	public void backButton() {
		GOval button = new GOval(16,26,100,105);
		button.setVisible(false);
	
		contents.add(button);
		mainScreen.add(button);
		
	}
	
	//Goes back to welcome/main menu screen when clicking the go-back button in description pane
	@Override
	public void mouseClicked(MouseEvent e) {
		if (mainScreen.getElementAtLocation(e.getX(), e.getY()) == contents.get(1)) {
			mainScreen.switchToWelcomeScreen();
		}
	}
}
