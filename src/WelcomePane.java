import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class WelcomePane extends GraphicsPane{
	public WelcomePane(MainApplication mainScreen) {
		this.mainScreen = mainScreen;
	}
	
	@Override
	public void showContent() {
		addPicture();
		addDescriptionButton();
	}

	@Override
	public void hideContent() {
		for(GObject item : contents) {
			mainScreen.remove(item);
		}
		contents.clear();
	}
	
	private void addPicture(){
		GImage startImage = new GImage("TitleScreen.jpg", 200, 100);
		startImage.scale(0.85, 0.75);
		startImage.setLocation((mainScreen.getWidth() - startImage.getWidth())/ 2, 70);
		
		contents.add(startImage);
		mainScreen.add(startImage);
	}
	
	private void addDescriptionButton() {
		GImage moreButton = new GImage("InstructionsButton.png", 200, 200);
		moreButton.scale(0.5, 0.5);
		moreButton.setLocation((mainScreen.getWidth() - moreButton.getWidth())/ 2 - 1, 301);
		
		contents.add(moreButton);
		mainScreen.add(moreButton);

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (mainScreen.getElementAtLocation(e.getX(), e.getY()) == contents.get(1)) {
			mainScreen.switchToDescriptionScreen();
		}
	}

}
