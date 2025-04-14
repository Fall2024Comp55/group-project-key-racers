import javax.swing.Timer;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class RaceTimer {
	//This is the equivalent to 3 minutes in seconds
	private int timeLeft;
	private int gameSpeed;
	private Timer countdownTimer;
	private GameScreenPane gameScreenPane;
	
	// RaceTimer can call methods on GameScreenPane
	public RaceTimer(GameScreenPane gameScreenPane) {
        this.gameScreenPane = gameScreenPane;
    }
	
	//Race timer starts running after the 3 second count down; will add this later
	public void startCountdown(){
		timeLeft = 10;
		gameSpeed = 5;
		countdownTimer = new Timer(1000, e -> {
            timeLeft--;
            gameScreenPane.updateTimerLabel(formatTime());
            if (timeLeft <= 0) {
                countdownTimer.stop();
            }
        });
        countdownTimer.start();
	
	}
	
	//For the car class to get time for the car to increase speed
	public int getTimeLeft(){
		return timeLeft;
		
	}
	
	
	//Timer stops when it reaches to 0 and a winner is determined
	public void stopCountdown(){
		if (countdownTimer != null) {
            countdownTimer.stop();
        }
	}
	
	// math to make the timer change between minutes and seconds
    private String formatTime() {
        int minutes = timeLeft / 60;
        int seconds = timeLeft % 60;
        if (seconds % 5 == 0) {
        	gameSpeed++;
        }
        
        if (seconds < 10) {
        	return minutes + ":0" + seconds;
        }
        return minutes + ":" + seconds;
    }
    
    
    public int getSpeed() {
    	return gameSpeed;
    }
    
    
	
}
