import acm.graphics.GImage;
import acm.graphics.GObject;

public class GameScreenPane extends GraphicsPane {
	
	private SoundPlayer gameMusic = new SoundPlayer();
	
	public GameScreenPane(MainApplication mainScreen) {
		this.mainScreen = mainScreen;
		
	}
	
	@Override
	public void showContent() {
		playMusic();
		addRoad();
	}

	@Override
	public void hideContent() {
		for(GObject item : contents) {
			mainScreen.remove(item);
		}
		contents.clear();
	}
	
	// plays game music
	private void playMusic() {
		gameMusic.playSound("media/Gamesound.wav");
	}
	
	// adds the backdrop of the road
	private void addRoad(){
		GImage roadImage = new GImage("Roads.png", 200, 100);
		roadImage.scale(0.85, 0.75);
		roadImage.setLocation((mainScreen.getWidth() - roadImage.getWidth())/ 2, 70);
		
		contents.add(roadImage);
		mainScreen.add(roadImage);
	}
}
