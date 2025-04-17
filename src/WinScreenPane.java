import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class WinScreenPane extends GraphicsPane {
	private SoundPlayer endMusic = new SoundPlayer();
	private GameScreenPane gameScreenPane;
	
	//Sets up the winning screen pane once the game ends as it goes over the screen to show winner
	public WinScreenPane(MainApplication mainScreen, GameScreenPane gameScreenPane) {
		this.mainScreen = mainScreen;
		this.gameScreenPane = gameScreenPane;
	}
	
	//Shows the content of the win screen pane
	@Override
	public void showContent() {
		addReturnTitleButton();
		addWinnerDisplay();
		playMusic();
	}

	//Hides the content of the win screen pane
	@Override
	public void hideContent() {
		for(GObject item : contents) {
			mainScreen.remove(item);
		}
		contents.clear();
	}
	
	//Adds button for the player to return to the welcome pane/main menu
	private void addReturnTitleButton() {
		GImage titleButton = new GImage("ReturnTitleButton.png", 200, 200);
		titleButton.scale(0.5, 0.5);
		titleButton.setLocation((mainScreen.getWidth() - titleButton.getWidth())/ 2, 215);
		
		contents.add(titleButton);
		mainScreen.add(titleButton);

	}
	
	//Display the winner of the game
	//Note: Add a screen in case the players tied
	private void addWinnerDisplay() {
		if (gameScreenPane.getPlayerOneScore() > gameScreenPane.getPlayerTwoScore()) {
			GImage blueWinner = new GImage("media/WinScreenBlue.png", 200, 100);
			blueWinner.scale(0.85, 0.85);
			blueWinner.setLocation((mainScreen.getWidth() - blueWinner.getWidth())/ 2, 0);
			
			contents.add(blueWinner);
			mainScreen.add(blueWinner);
		}
		else {
			GImage redWinner = new GImage("media/WinScreenRed.png", 200, 100);
			redWinner.setLocation((mainScreen.getWidth() - redWinner.getWidth())/ 2, 0);
			
			contents.add(redWinner);
			mainScreen.add(redWinner);
		}
	}
	
	//Plays the background sound for the winner screen
	private void playMusic() {
		endMusic.playEndSound("media/Gameend.wav");
	}
	
	//Allow mousse to click on button to return to the welcome screen/main menu
	@Override
	public void mouseClicked(MouseEvent e) {
		if (mainScreen.getElementAtLocation(e.getX(), e.getY()) == contents.get(1)) {
			mainScreen.switchToWelcomeScreen();
		}
	}
}
