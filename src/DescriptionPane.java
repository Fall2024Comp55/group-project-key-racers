import java.awt.Color;
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
		
	}

	@Override
	public void hideContent() {
		for(GObject item : contents) {
			mainScreen.remove(item);
		}
		contents.clear();
	}
	
	public void disPlay() {
		GImage image = new GImage("InstructionsScreen.jpg");
		image.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		contents.add(image);
		mainScreen.add(image);
	}
	
	

	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (mainScreen.getElementAtLocation(e.getX(), e.getY()) == contents.get(1)) {
			mainScreen.switchToWelcomeScreen();
		}
	}

}
