import acm.graphics.GImage;
import acm.graphics.GObject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Car implements ActionListener{
	private int speed;
	private int originalSpeed;
	private int positionX;
	private int leftBoundary;
	private int rightBoundary;
	private Timer t;
	private final int MS = 5000;
	
	private GImage carImage;
	
    // Constructor initializes the car with an image, position, and movement boundaries
	public Car(String imagePath,int startX, int startY, int leftBoundary, int rightBoundary){
		this.carImage = new GImage(imagePath, startX, startY);
		this.positionX = startX;
		this.originalSpeed = 5; // the default speed
        this.carImage.scale(0.3, 0.3); // Adjust the scale factor to fit the road
		this.speed = originalSpeed;
		this.leftBoundary = leftBoundary;
		this.rightBoundary = rightBoundary;
		t = new Timer(MS, this);
	
	}
	
	
	
	public void increaseSpeed(int speed) {
		speed += 1;
	}
	
	//resets speed, the timer is reset to make acceleration always take a constant amount of time
	public void restSpeedForStart() {
		speed = originalSpeed;
		t.stop();
		t = new Timer(MS, this);
	}
	
	public void moveLeftPlayer1() {
		checkBoundaries();
		positionX -= 1;
	}
	
	
	public void moveRightPlayer1() {
		checkBoundaries();
		positionX += 1;
	}
	
	public void moveLeftPlayer2() {
		checkBoundaries();
		positionX -= 1;
	}
	
	
	public void moveRightPlayer2() {
		checkBoundaries();
		positionX += 1;
	}
	
	//if the car gets out of bounds it should teleport to the closer boundary
	public void checkBoundaries() {
		if(positionX < leftBoundary) {
			positionX = leftBoundary;
		} else if(positionX > rightBoundary) {
			positionX = rightBoundary;
		}
	}
    // Returns the car's GImage object so it can be added to the game screen
	public GImage getCarImage() {
		return carImage;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		increaseSpeed(speed);
	}
}
