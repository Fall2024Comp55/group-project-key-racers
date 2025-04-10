import acm.graphics.GImage;

public class Obstacle{
	private ObstacleType oType;
	private int positionX;
	private int positionY;
	private final int losePoints = 1;
	
	GImage image;
	
	public Obstacle(ObstacleType oType, int positionX) {
		this.oType = oType;
		this.positionX = positionX;
		positionY = 0;
	}
	
	//This function fills out the image variable to be used when shown
	public void spawn() {
		if (image == null) {
			String s = "media/" + oType.toString() + ".png";
			image = new GImage(s, positionX, positionY);
			image.scale(0.6, 0.6); 
		}
	}
	
	// returns the image
	public GImage getImage() {
		if (image == null) {
			spawn();
		}
	    return image;
	}
	
	public ObstacleType getObstacleType() {
        return this.oType;
    }
	
}