import java.awt.Color;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GLabel;

public class GameScreenPane extends GraphicsPane {
	
	private SoundPlayer gameMusic = new SoundPlayer();
	
	private Car car1;
	private Car car2;
	private GLabel timer;
	private GImage roadImage;
	
	public GameScreenPane(MainApplication mainScreen) {
		this.mainScreen = mainScreen;
		car1 = new Car("RedCar.png", 200, 500, 200, 500);
		car2 = new Car("BlueCar.png", 500, 500, 200, 500);
		
	}
	
	@Override
	public void showContent() {
		playMusic();
		addRoad();
		addCars();
		addTimer();
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
		roadImage = new GImage("Roads.png", 200, 100);
		roadImage.scale(0.85, 1);
		roadImage.setLocation((mainScreen.getWidth() - roadImage.getWidth())/ 2, 0);
		
		contents.add(roadImage);
		mainScreen.add(roadImage);
	}
	
	private void addTimer() {
		timer = new GLabel("3:00", 100, 100);
		timer.setFont("Arial-Bold-40");
		timer.setColor(Color.blue);
		timer.setLocation((mainScreen.getWidth() - timer.getWidth())/2, 50);
		
		contents.add(timer);
		mainScreen.add(timer);
	}
	
	private void addCars() {
		contents.add(car1.getCarImage());
		contents.add(car2.getCarImage());
		
		mainScreen.add(car1.getCarImage());
		mainScreen.add(car2.getCarImage());
	}
}
