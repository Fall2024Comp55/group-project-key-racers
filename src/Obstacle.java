import acm.graphics.GImage;

public class Obstacle{
	private ObstacleType oType;
	private int positionX;
	private int positionY;
	
	GImage image;
	
	//Sets up the individual obstacle object
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
	
	//Returns the image
	public GImage getImage() {
		if (image == null) {
			spawn();
		}
	    return image;
	}
	
	//Returns the type of obstacle
	public ObstacleType getObstacleType() {
        return this.oType;
    }
	
}