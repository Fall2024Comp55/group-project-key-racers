import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.HashSet;
import java.util.Set;

public class KeyEvents extends JPanel implements KeyListener {
	private GameScreenPane gameScreenPane;
	private Set<Integer> keysPressed = new HashSet<>();
	
	
	public KeyEvents(GameScreenPane gameScreenPane) {
        this.gameScreenPane = gameScreenPane;
		setFocusable(true);
        addKeyListener(this);
    }
	
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

	    @Override
	    public void keyReleased(KeyEvent e) {
	    	int key = e.getKeyCode();
	    	keysPressed.remove(key);
	    }

	    @Override
	    public void keyTyped(KeyEvent e) {}

}
