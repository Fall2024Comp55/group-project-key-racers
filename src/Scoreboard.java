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
	
	//Points for bonus item
	public void bonusPoints() {
		playerScoreboard += 100;
	}
	
	//Minus points for hitting obstacles
	public void obstacleMinusPoints() {
		playerScoreboard -= 100;
	}
	
	//Score adds up due to the speed 
	public void speedScore() {
		playerScoreboard += gameScreenPane.getSpeed();
	}
	
	//Return the player's score
	public int getPlayerScore() {
        return playerScoreboard;
    }
	
	//Format the score in game screen
	public String scoreFormat() {
		return "" + playerScoreboard;
	}
	

}
