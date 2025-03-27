import acm.graphics.GImage;
import acm.graphics.GObject;


public class Car {
	private int speed;
	private int originalSpeed;
	private int positionX;
	private int leftBoundary;
	private int rightBoundary;
	
	private GImage carImage;
	
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
		
		
	}
	
	public void moveRight() {
	
		
	}
	
	public void checkBoundaries() {
		
		
	}
	
	public GImage getCarImage() {
		return carImage;
	}
}
