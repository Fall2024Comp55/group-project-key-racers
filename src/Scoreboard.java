import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scoreboard {
	private int playerScoreboard;
	private int points;
	private GameScreenPane gameScreenPane;
	
	// Scoreboard can call methods on GameScreenPane
	public Scoreboard (GameScreenPane gameScreenPane) {
        this.gameScreenPane = gameScreenPane;
    }
	
	//Resets both players score to zero as the game starts
	public void startScore() {
		playerScoreboard = 0;
		
	}
	
	//Increase points when bonus are hit
	public void increasePoints() {
		playerScoreboard += 1;
	}
	
	//Decrease points when obstacles are hit
	public void decreasePoints() {
		playerScoreboard -= 1;
	}
	
	//Updates the score at the GameScreen class
	public int updateScore() {
		return playerScoreboard;
	}

}
