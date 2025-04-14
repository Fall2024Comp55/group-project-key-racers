//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class Scoreboard {
	private int playerScoreboard;
	private GameScreenPane gameScreenPane;
	
	// Scoreboard can call methods on GameScreenPane
	public Scoreboard (GameScreenPane gameScreenPane) {
        this.gameScreenPane = gameScreenPane;
    }
	
	//Resets both players score to zero as the game starts
	public void startScore() {
		playerScoreboard = 0;
	}
	
	// Points for bonus item
	public void bonusPoints() {
		playerScoreboard += 100;
	}
	
	// Minus Points for hitting obstacles
	public void obstacleMinusPoints() {
		playerScoreboard -= 100;
	}
	
	public void speedScore() {
		playerScoreboard += gameScreenPane.getSpeed();
	}
	
	//Format the score in game screen
	public String scoreFormat() {
		return "" + playerScoreboard;
	}
	
	//Updates the score at the GameScreen class
	public int updateScore() {
		return playerScoreboard;
	}

}
