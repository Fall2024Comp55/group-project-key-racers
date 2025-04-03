import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scoreboard {
	private int player1Score = 0;
	private int player2Score = 0;
	private GameScreenPane gameScreenPane;
	
	// Scoreboard can call methods on GameScreenPane
	public Scoreboard (GameScreenPane gameScreenPane) {
        this.gameScreenPane = gameScreenPane;
    }
	
	
	
	//Rely on winner at the end of the game.
	public void getWinner() {
		if (player1Score > player2Score) {
			//Send in that player 1 wins
		}else {
			//Reveal that player 2 wins
		}
	}
	
}
