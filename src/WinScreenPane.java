import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class WinScreenPane extends GraphicsPane {
	private SoundPlayer endMusic = new SoundPlayer();
	private GameScreenPane gameScreenPane;
	
	
	public WinScreenPane(MainApplication mainScreen, GameScreenPane gameScreenPane) {
		this.mainScreen = mainScreen;
		this.gameScreenPane = gameScreenPane;
	}
	
	@Override
	public void showContent() {
		addReturnTitleButton();
		addWinnerDisplay();
		playMusic();
	}

	@Override
	public void hideContent() {
		for(GObject item : contents) {
			mainScreen.remove(item);
		}
		contents.clear();
	}
	
	private void addReturnTitleButton() {
		GImage titleButton = new GImage("ReturnTitleButton.png", 200, 200);
		titleButton.scale(0.5, 0.5);
		titleButton.setLocation((mainScreen.getWidth() - titleButton.getWidth())/ 2, 215);
		
		contents.add(titleButton);
		mainScreen.add(titleButton);

	}
	
	private void addWinnerDisplay() {
		/* if (score1 > score2) this would be for the score
		 * GImage Winner = imageBlue...
		 * else 
		 * GImage Winner = imageRed...
		 */
		GImage blueWinner = new GImage("WinScreenBlue.png", 200, 100);
		blueWinner.scale(0.85, 0.85);
		blueWinner.setLocation((mainScreen.getWidth() - blueWinner.getWidth())/ 2, 0);
		
		contents.add(blueWinner);
		mainScreen.add(blueWinner);
	}
	
	private void playMusic() {
		endMusic.playEndSound("media/Gameend.wav");
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (mainScreen.getElementAtLocation(e.getX(), e.getY()) == contents.get(1)) {
			mainScreen.switchToWelcomeScreen();
		}
	}
}
