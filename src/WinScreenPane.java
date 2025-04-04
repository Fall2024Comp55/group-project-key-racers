import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class WinScreenPane extends GraphicsPane {
	public WinScreenPane(MainApplication mainScreen) {
		this.mainScreen = mainScreen;
	}
	
	@Override
	public void showContent() {
		addWinnerDisplay();
	}

	@Override
	public void hideContent() {
		for(GObject item : contents) {
			mainScreen.remove(item);
		}
		contents.clear();
	}
	
	public void addWinnerDisplay() {
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
}
