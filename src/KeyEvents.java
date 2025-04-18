import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.util.HashSet;
import java.util.Set;

public class KeyEvents extends JPanel implements KeyListener {
	private GameScreenPane gameScreenPane;
	private Set<Integer> keysPressed = new HashSet<>();
	
	//Gets key actions to work in the screen
	public KeyEvents(GameScreenPane gameScreenPane) {
        this.gameScreenPane = gameScreenPane;
		setFocusable(true);
        addKeyListener(this);
    }
	
	//Makes the cars move from clicking on these specific keys
	 @Override
	 public void keyPressed(KeyEvent e) {
		 int key = e.getKeyCode();
		 
		 if (!keysPressed.contains(key)) {
			 keysPressed.add(key);
		 
			 if (key == KeyEvent.VK_LEFT) {
				 gameScreenPane.moveLeftPlayer2();
			 } 
			 if (key == KeyEvent.VK_RIGHT) {
				 gameScreenPane.moveRightPlayer2();
			 }
			 if (key == KeyEvent.VK_A) {
				 gameScreenPane.moveLeftPlayer1();
			 }
			 if (key == KeyEvent.VK_D){
				 gameScreenPane.moveRightPlayer1();
			 }
		 }
		 	 
	}

	//When key is released, the car no longer moves
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		keysPressed.remove(key);
	}

	@Override
	public void keyTyped(KeyEvent e) {}

}
