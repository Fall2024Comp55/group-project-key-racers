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
		String s = "media/" + oType.toString() + ".png";
		image = new GImage(s, positionX, positionY);
	}
	
	// returns the image
	public GImage getImage() {
	    return image;
	}
	
	public ObstacleType getObstacleType() {
        return this.oType;
    }
	
}