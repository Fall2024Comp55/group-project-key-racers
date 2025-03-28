import acm.graphics.GImage;

public class Obstacle{
	private ObstacleType oType;
	private int positionX;
	private int positionY;
	private int losePoints;
	
	GImage image;
	
	public Obstacle(ObstacleType oType, int positionX) {
		this.oType = oType;
		this.positionX = positionX;
		positionY = 0;
	}
	
	public void spawn() {
		String s = "media/" + oType.toString() + ".png";
		image = new GImage(s, positionX, positionY);
	}
	
	/* public boolean checkCollision(){}
	 * to be added when the player class is made
	 * */
	
}