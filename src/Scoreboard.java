import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scoreboard {
	private int playerScoreboard = 0;
	private int points;
	private GameScreenPane gameScreenPane;
	
	// Scoreboard can call methods on GameScreenPane
	public Scoreboard (GameScreenPane gameScreenPane) {
        this.gameScreenPane = gameScreenPane;
    }
	
	public void startScore() {
		
	}
	
	public void updateScore() {
		playerScoreboard += points;
	}

	
	
	//Reveal on winner at the end of the game
	public void getWinner() {
		
	}
	
}
