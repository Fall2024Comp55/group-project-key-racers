import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class WinScreenPane extends GraphicsPane {
	private SoundPlayer endMusic = new SoundPlayer();
	private GameScreenPane gameScreenPane;
	private GImage titleButton;
	
	// Sets up the winning screen pane once the game ends as it goes over the screen to show winner
	public WinScreenPane(MainApplication mainScreen, GameScreenPane gameScreenPane) {
		this.mainScreen = mainScreen;
		this.gameScreenPane = gameScreenPane;
	}
	
	// Shows the content of the win screen pane
	@Override
	public void showContent() {
		addWinnerDisplay();
		addReturnTitleButton();
		playMusic();
	}

	// Hides the content of the win screen pane
	@Override
	public void hideContent() {
		for(GObject item : contents) {
			mainScreen.remove(item);
		}
		contents.clear();
	}
	
	// Adds button for the player to return to the welcome pane/main menu
	private void addReturnTitleButton() {
		titleButton = new GImage("media/ReturnTitleButton.png", 200, 200);
		
		if (gameScreenPane.getPlayerOneScore() > gameScreenPane.getPlayerTwoScore()) {
			titleButton.scale(0.85, 0.85);
			titleButton.setLocation((mainScreen.getWidth() - titleButton.getWidth())/ 2, 325);
		}
		else if (gameScreenPane.getPlayerOneScore() < gameScreenPane.getPlayerTwoScore()) {
			titleButton.scale(0.85, 0.85);
			titleButton.setLocation((mainScreen.getWidth() - titleButton.getWidth())/ 2, 325);
		}
		else if (gameScreenPane.getPlayerOneScore() == gameScreenPane.getPlayerTwoScore()) {
			titleButton.scale(1.0, 1.0);
			titleButton.setLocation((mainScreen.getWidth() - titleButton.getWidth())/ 2, 385);
		}
		
		contents.add(titleButton);
		mainScreen.add(titleButton);

	}
	
	// Display the winner of the game
	// Note: Add a screen in case the players tied
	private void addWinnerDisplay() {
		if (gameScreenPane.getPlayerOneScore() > gameScreenPane.getPlayerTwoScore()) {
			GImage blueWinner = new GImage("media/WinScreenBlue.png", 200, 100);
			blueWinner.scale(0.85, 0.85);
			blueWinner.setLocation((mainScreen.getWidth() - blueWinner.getWidth())/ 2, 0);
			
			contents.add(blueWinner);
			mainScreen.add(blueWinner);

		} else if (gameScreenPane.getPlayerOneScore() < gameScreenPane.getPlayerTwoScore()){
			GImage redWinner = new GImage("media/WinScreenRed.png", 200, 100);
			redWinner.scale(0.85, 0.85);
			redWinner.setLocation((mainScreen.getWidth() - redWinner.getWidth())/ 2, 0);
			
			contents.add(redWinner);
			mainScreen.add(redWinner);
		} else if (gameScreenPane.getPlayerOneScore() == gameScreenPane.getPlayerTwoScore()){
			GImage tieWinner = new GImage("media/WinScreeTie.png", 200, 100);
			tieWinner.setLocation((mainScreen.getWidth() - tieWinner.getWidth())/ 2, 0);
			
			contents.add(tieWinner);
			mainScreen.add(tieWinner);
		}
	}
	
	// Plays the background sound for the winner screen
	private void playMusic() {
		endMusic.playEndSound("media/Gameend.wav");
	}
	
	// Allow mouse to click on button to return to the welcome screen/main menu
	@Override
	public void mouseClicked(MouseEvent e) {
		if (mainScreen.getElementAtLocation(e.getX(), e.getY()) == contents.get(1)) {
			mainScreen.switchToWelcomeScreen();
		}
	}
}
