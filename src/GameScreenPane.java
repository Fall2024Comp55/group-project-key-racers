import acm.graphics.GImage;
import acm.graphics.GObject;

public class GameScreenPane extends GraphicsPane {
	
	private SoundPlayer gameMusic = new SoundPlayer();
	
	private Car car1;
	private Car car2;
	
	public GameScreenPane(MainApplication mainScreen) {
		this.mainScreen = mainScreen;
		car1 = new Car("RedCar.png", 200, 500,200,500);
		car2 = new Car("BlueCar.png", 500,500,200,500);
		
	}
	
	@Override
	public void showContent() {
		playMusic();
		addRoad();
		addCars();
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
	
	private void addCars() {
		contents.add(car1.getCarImage());
		contents.add(car2.getCarImage());
		
		mainScreen.add(car1.getCarImage());
		mainScreen.add(car2.getCarImage());
	}
}
