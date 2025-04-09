import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GLabel;
import acm.util.RandomGenerator;


public class GameScreenPane extends GraphicsPane {
	
	private SoundPlayer gameMusic = new SoundPlayer();
	
	private Car car1;
	private Car car2;
	private GImage tree1, tree2, tree3, tree4, tree5;
	private GLabel timerLabel;
	private GImage roadImage;
	private RaceTimer raceTimer;
	private Timer roadTimer;
	private Timer treeTimer;
	private GLabel oneScore;
	private GLabel twoScore;
	private Scoreboard totalScore;
	
	private ArrayList<GImage> obstacleList;
	private RandomGenerator rgen;
	private Timer obstacleTimer;
	//increments until enough time has passed since the previous obstacle spawned
	private int obstacleSpawnTimer;
	
	private Random rand = new Random(); //// Create a random number generator for the trees
	
	private Timer universalTimer;
	
	public GameScreenPane(MainApplication mainScreen) {
		this.mainScreen = mainScreen;
		raceTimer = new RaceTimer(this);
		car1 = new Car("RedCar.png", 220, 500, 124, 316);
		car2 = new Car("BlueCar.png", 550, 500, 456, 648);
		totalScore = new Scoreboard(this);
		
		obstacleList = new ArrayList<GImage>();
		rgen = RandomGenerator.getInstance();
		obstacleSpawnTimer = 0;
		
		
	}
	
	@Override
	public void showContent() {
		playMusic();
		addRoad();
		addCars();
		addTimer();
		addTrees();
		//addObstacles();
		addScoreboard();
		
	    /*startTreeMovement(); // Start tree movement
	    startRoadMovement(); // Start road movement
	    startObstacleMovement();*/
		startUniversalTimer();
		
		raceTimer.startCountdown(); // access the timer from RaceTimer class
		
	}

	@Override
	public void hideContent() {
		for(GObject item : contents) {
			mainScreen.remove(item);
		}
		contents.clear();
		
		if (roadTimer != null) {
	        roadTimer.cancel();
	        roadTimer.purge();
	        roadTimer = null;
	    }
	    
	    if (treeTimer != null) {
	        treeTimer.cancel();
	        treeTimer.purge();
	        treeTimer = null;
	    }
	    
	    if(obstacleTimer != null) {
	    	obstacleTimer.cancel();
	    	obstacleTimer.purge();
	    	obstacleTimer = null;
	    }
	    
	    if (raceTimer != null) {
	        raceTimer.stopCountdown();
	    }
	    
	    gameMusic.stopSound();
	}
	
	// plays game music
	private void playMusic() {
		gameMusic.playSound("media/Gamesound.wav");
	}
	
	public void startUniversalTimer() {
		universalTimer = new Timer();
		universalTimer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				moveRoad();
				moveTrees();
				moveObstacles();
				checkCollision();
				if(obstacleList.size() < 5) {
					if(obstacleSpawnTimer >= 50) {
						GImage i = makeObstacles(true);
						obstacleList.add(i);
						contents.add(i);
						mainScreen.add(i);
						
						GImage i2 = makeObstacles(false);
						obstacleList.add(i2);
						contents.add(i2);
						mainScreen.add(i2);
						
						obstacleSpawnTimer = 0;
					}
					obstacleSpawnTimer++;
				}
			}
		}, 0, 50);
	}
	
	// adds the backdrop of the road
	private void addRoad() {
		roadImage = new GImage("Roads.png", 200, 100);
		roadImage.scale(0.85, 1);
		roadImage.setLocation((mainScreen.getWidth() - roadImage.getWidth()) / 2, -100);
		
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
		timerLabel.sendToFront();
		if(raceTimer.getTimeLeft() == 0) {
			raceTimer.stopCountdown();
			mainScreen.switchToWinScreen();
		}
    }

	private void addCars() {
		contents.add(car1.getCarImage());
		contents.add(car2.getCarImage());
		
		mainScreen.add(car1.getCarImage());
		mainScreen.add(car2.getCarImage());
	}
	
	public void addTrees() {
		
		Random rand = new Random(); // // Create a random number generator for tree scaling
		
		// Create and scale each tree with a random size between 0.6x and 1.2x
		tree1 = new GImage("Tree.png", 50, 10);
		tree1.scale(getRandomScale(rand));
		
		tree2 = new GImage("Tree.png", 50, 400);
		tree2.scale(getRandomScale(rand));
		
		tree3 = new GImage("Tree.png", 370, 200);
		tree3.scale(getRandomScale(rand));
		
		tree4 = new GImage("Tree.png", 700, 10);
		tree4.scale(getRandomScale(rand));
		
		tree5 = new GImage("Tree.png", 700, 400);
		tree5.scale(getRandomScale(rand));
		
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
	
	
	// Returns a random scale factor between 0.6 and 1.2 to vary tree sizes. 
	private double getRandomScale(Random rand) {
		return 0.6 + (1.2 - 0.6) * rand.nextDouble(); 
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
		
	    // Move trees downward
	    tree1.move(0, raceTimer.getSpeed());
	    tree2.move(0, raceTimer.getSpeed());
	    tree3.move(0, raceTimer.getSpeed());
	    tree4.move(0, raceTimer.getSpeed());
	    tree5.move(0, raceTimer.getSpeed());

	    // Reset trees when they move past the bottom of the screen
	    resetTreePosition(tree1);
	    resetTreePosition(tree2);
	    resetTreePosition(tree3);
	    resetTreePosition(tree4);
	    resetTreePosition(tree5);
	}
	
	private void resetTreePosition(GImage tree) {
	    if (tree.getY() > mainScreen.getHeight()) { //Checks if a tree has moved past the screen bottom
	    	int randomY = rand.nextInt(200) - 300; // Generates a random Y between -300 and -100
	        tree.setLocation(tree.getX(), randomY); //// Reset tree at a random Y above the screen
	    }
	}
	
	// similar to tree movement function, will move downward continuously
	public void startRoadMovement() {
		roadTimer = new Timer();
		roadTimer.scheduleAtFixedRate(new TimerTask() { // Runs the task every 50 milliseconds.
	        @Override
	        public void run() {
	            moveRoad();
	        }
	    }, 0, 50); // Update every 50ms (adjust for speed)
	}
	
	private void moveRoad() {
		roadImage.move(0, raceTimer.getSpeed()); // move road downwards based on speed
		
		resetRoadPosition(roadImage); // Reset road if image is going off screen
	}
	
	private void resetRoadPosition(GImage road) {
		if (road.getY() > -16) {
			road.setLocation(road.getX(), -100);
		}
	}

	//removed
	public void addObstacles() {
		while(obstacleList.size() < 6) {
			obstacleList.add(makeObstacles(obstacleList.size() % 2 == 0));
		}
		
		for(GImage i : obstacleList) {
			contents.add(i);
			mainScreen.add(i);
		}
	}
	
	//Creates and places the image for each obstacle
	private GImage makeObstacles(boolean forLeftRoad) {
		int startXPosition = 124 + ((forLeftRoad) ? 0 : 332);
		String name = "media/";
		int r = rgen.nextInt(0,5);
		double scale = 1;
		System.out.println(r);
		
		//to fix other scaling
		
		if(r == 0) {
			if(forLeftRoad) {
				name+="Mirrored";
			}
			name+="FallenTree.png";
			scale = .4;
		}else if(r == 1) {
			name+="BonusItem.png";
			scale = .4;
		}else if(r == 2) {
			name+="Crate.png";
			scale = .4;
		}else if(r == 3) {
			name+="Stick.png";
			scale = .4;
		}else {
			name+="Stone.png";
			scale = .4;
		}
		
		if(r != 0) {
			startXPosition += rgen.nextInt(192);
		} else {
			if(forLeftRoad) {
				startXPosition -= 270;
			}else {
				startXPosition += 50;
			}
		}
		GImage i = new GImage(name, startXPosition, 0);
		i.scale(scale);
		return i;
	}
	
	public void startObstacleMovement() {
		obstacleTimer = new Timer();
		obstacleTimer.scheduleAtFixedRate(new TimerTask() { // Runs the task every 50 milliseconds.
	        @Override
	        public void run() {
	        	if(obstacleList.size() < 6) {
	        		if(obstacleSpawnTimer > 50 && obstacleList.size() < 5) {
		        		GImage o = makeObstacles(true);
		        		contents.add(o);
		        		mainScreen.add(o);
		        		obstacleList.add(o);
		        		GImage o1 = makeObstacles(false);
		        		contents.add(o1);
		        		mainScreen.add(o1);
		        		obstacleList.add(o1);
		        		obstacleSpawnTimer = 0;
	        		} else if(obstacleList.size() < 4) {
	        			//GImage o = makeObstacle
	        		}
	        		obstacleSpawnTimer++;
	        	}
	            moveObstacles();
	        }
	    }, 0, 50); // Update every 50ms (adjust for speed)
	}
	
	//made more sense to separate the movement and placing at the top
	private void moveObstacles() {
		for(GImage obstacle : obstacleList) {
			obstacle.move(0, raceTimer.getSpeed());
		}
		for(int i = 0; i < obstacleList.size(); i++) {
			resetObstaclePosition(obstacleList.get(i));
		}
		/*if(obstacleList.size() < 5) {
			GImage i = makeObstacles(true);
			obstacleList.add(i);
			contents.add(i);
			mainScreen.add(i);
			GImage i2 = makeObstacles(false);
			obstacleList.add(i2);
			contents.add(i2);
			mainScreen.add(i2);
		}*/
	}
	
	private void resetObstaclePosition(GImage obstacle) {
		if(obstacle.getY() > mainScreen.getHeight()) {
			//obstacle = makeObstacles(obstacle.getX() < 300);
			//obstacleList.set(i, makeObstacles(obstacle.getX() < 300));
			obstacleList.remove(obstacle);
			contents.remove(obstacle);
			mainScreen.remove(obstacle);
		}
	}
	
	private void addScoreboard() {
		oneScore = new GLabel("0", 100, 100);
		oneScore.setFont("Arial-Bold-40");
		oneScore.setColor(Color.YELLOW);
		oneScore.setLocation(50, 50);
			
		twoScore = new GLabel("0", 100, 100);
		twoScore.setFont("Arial-Bold-40");
		twoScore.setColor(Color.YELLOW);
		twoScore.setLocation(725, 50);
			
		contents.add(oneScore);
		contents.add(twoScore);
			
		mainScreen.add(oneScore);
		mainScreen.add(twoScore);
	}
	
	// checks if the car is touching an obstacle
	public void checkCollision() {
		for (int i = 0; i < obstacleList.size(); i++) {
	        GImage obstacle = obstacleList.get(i);
	        
	        if (car1.getCarImage().getBounds().intersects(obstacle.getBounds())) {
	            
	            obstacleList.remove(obstacle);
	            contents.remove(obstacle);
	            mainScreen.remove(obstacle);
	        }
	        
	        if (car2.getCarImage().getBounds().intersects(obstacle.getBounds())) {
	        	obstacleList.remove(obstacle);
	            contents.remove(obstacle);
	            mainScreen.remove(obstacle);
	        }
	    }
	}
	
	public void moveLeftPlayer1() {
		car1.updateXleft();
		car1.checkBoundaries();
	}
		
	public void moveRightPlayer1() {
		car1.updateXright();
		car1.checkBoundaries();
	}
	
	public void moveLeftPlayer2() {
		car2.updateXleft();
		car2.checkBoundaries();
	}
		
	public void moveRightPlayer2() {
		car2.updateXright();
		car2.checkBoundaries();
	}
	
	public void KeyPresssed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
			case KeyEvent.VK_LEFT -> moveLeftPlayer2();
			case KeyEvent.VK_RIGHT -> moveRightPlayer2();
			case KeyEvent.VK_A -> moveLeftPlayer1();
			case KeyEvent.VK_D -> moveRightPlayer1();
			
		}
	}
}
