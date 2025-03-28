import acm.graphics.GImage;
import acm.graphics.GObject;


public class Car {
	private int speed;
	private int originalSpeed;
	private int positionX;
	private int leftBoundary;
	private int rightBoundary;
	
	private GImage carImage;
	
    // Constructor initializes the car with an image, position, and movement boundaries
	public Car(String imagePath,int startX, int startY, int leftBoundary, int rightBoundary ) {
		this.carImage = new GImage(imagePath, startX, startY);
		this.positionX = startX;
		this.originalSpeed = 5; // the default speed
        this.carImage.scale(0.3, 0.3); // Adjust the scale factor to fit the road
		this.speed = originalSpeed;
		this.leftBoundary = leftBoundary;
		this.rightBoundary = rightBoundary;
	
	}
	
	
	
	public void increaseSpeed(int speed) {
		
	}
	
	
	public void restSpeedForStart() {
	}
	
	public void moveLeft() {
		positionX -= 1;
	}
	
	public void moveRight() {
		positionX += 1;
	}
	
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
}
