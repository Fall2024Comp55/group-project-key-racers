import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RaceTimer {
	//This is the equivalent to 3 minutes in seconds
	private int timeLeft = 180;
	private boolean timerRunning = false;
	private Timer countdownTimer;
	
	
	//Race timer starts running after the 3 second count down; will add this later
	public void startCountdown(){
		if (timerRunning) {
			return;
		}
		
		timerRunning = true;
		countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeLeft > 0) {
                    timeLeft--;
                } else {
                    stopCountdown();
                }
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
        timerRunning = false;
	}
	
}
