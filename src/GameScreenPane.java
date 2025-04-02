import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;


import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GLabel;


public class GameScreenPane extends GraphicsPane {
	
	private SoundPlayer gameMusic = new SoundPlayer();
	
	private Car car1;
	private Car car2;
	private GImage tree1, tree2, tree3, tree4, tree5;
	private GLabel timerLabel;
	private GImage roadImage;
	private RaceTimer raceTimer;
	
	private Timer treeTimer;
	
	
	public GameScreenPane(MainApplication mainScreen) {
		this.mainScreen = mainScreen;
		raceTimer = new RaceTimer(this);
		car1 = new Car("RedCar.png", 200, 500, 200, 500);
		car2 = new Car("BlueCar.png", 500, 500, 200, 500);
		
		// add trees
		tree1 = new GImage("Tree.png", 50, 10);
		tree2 = new GImage("Tree.png", 50, 400);
		tree3 = new GImage("Tree.png", 370, 200);
		tree4 = new GImage("Tree.png", 700, 10);
		tree5 = new GImage("Tree.png", 700, 400);

	}
	
	@Override
	public void showContent() {
		playMusic();
		addRoad();
		addCars();
		addTimer();
		addTrees();
		
	    startTreeMovement(); // Start tree movement

		
		raceTimer.startCountdown(); // access the timer from RaceTimer class
		
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
		roadImage.setLocation((mainScreen.getWidth() - roadImage.getWidth()) / 2, 0);
		
		contents.add(roadImage);
		mainScreen.add(roadImage);
	}
	
	// adds timer label
	private void addTimer() {
		timerLabel = new GLabel("3:00", 100, 100);
		timerLabel.setFont("Arial-Bold-40");
		timerLabel.setColor(Color.YELLOW);
		timerLabel.setLocation((mainScreen.getWidth() - timerLabel.getWidth()) / 2, 50);
		
		contents.add(timerLabel);
		mainScreen.add(timerLabel);
	}
	
	// updates the timer label
	public void updateTimerLabel(String newTime) {
		timerLabel.setLabel(newTime);
    }

	
	private void addCars() {
		contents.add(car1.getCarImage());
		contents.add(car2.getCarImage());
		
		mainScreen.add(car1.getCarImage());
		mainScreen.add(car2.getCarImage());
	}
	
	public void addTrees() {
		contents.add(tree1);
		mainScreen.add(tree1);
		
		contents.add(tree2);
		mainScreen.add(tree2);
		
		contents.add(tree3);
		mainScreen.add(tree3);
		
		contents.add(tree4);
		mainScreen.add(tree4);
		
		contents.add(tree5);
		mainScreen.add(tree5); 
	}
	
	// This function moves the trees downward continuously, making it look like the background is moving.
	public void startTreeMovement() {
	    treeTimer = new Timer(); //Creates a timer that executes tasks at fixed intervals.
	    treeTimer.scheduleAtFixedRate(new TimerTask() { // Runs the task every 50 milliseconds.
	        @Override
	        public void run() {
	            moveTrees();
	        }
	    }, 0, 50); // Update every 50ms (adjust for speed)
	}


	private void moveTrees() {
		
	    int speed = 5; // Speed of the tree movement

	    // Move trees downward
	    tree1.move(0, speed);
	    tree2.move(0, speed);
	    tree3.move(0, speed);
	    tree4.move(0, speed);
	    tree5.move(0, speed);

	    // Reset trees when they move past the bottom of the screen
	    resetTreePosition(tree1);
	    resetTreePosition(tree2);
	    resetTreePosition(tree3);
	    resetTreePosition(tree4);
	    resetTreePosition(tree5);
	}
	
	private void resetTreePosition(GImage tree) {
	    if (tree.getY() > mainScreen.getHeight()) { //Checks if a tree has moved past the screen bottom
	        tree.setLocation(tree.getX(), -100); // Reset tree to the top
	    }
	}


	
	public void moveLeftPlayer1() {
		car1.checkBoundaries();
		car1.updateXleft();
	}
	
	
	public void moveRightPlayer1() {
		car1.checkBoundaries();
		car1.updateXright();
	}
	
	public void moveLeftPlayer2() {
		car2.checkBoundaries();
		car2.updateXleft();
	}
	
	
	public void moveRightPlayer2() {
		car2.checkBoundaries();
		car2.updateXright();
	}
}
