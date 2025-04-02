import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.HashSet;
import java.util.Set;

public class KeyEvents extends JPanel implements KeyListener {
	private GameScreenPane gameScreenPane;
	private boolean keyPressed;
	
	
	public KeyEvents(GameScreenPane gameScreenPane) {
        this.gameScreenPane = gameScreenPane;
		setFocusable(true);
        addKeyListener(this);
    }
	
	 @Override
	 public void keyPressed(KeyEvent e) {
		 if (!keyPressed) {
			 keyPressed = true;
			 int key = e.getKeyCode();
		 
			 if (key == KeyEvent.VK_LEFT) {
				 gameScreenPane.moveLeftPlayer2();
			 } else if (key == KeyEvent.VK_RIGHT) {
				 gameScreenPane.moveRightPlayer2();
			 } else if (key == KeyEvent.VK_A) {
				 gameScreenPane.moveLeftPlayer1();
			 } else if (key == KeyEvent.VK_D){
				 gameScreenPane.moveRightPlayer1();
			 }
		 }
		 	 
	 }

	    @Override
	    public void keyReleased(KeyEvent e) {
	    	keyPressed = false;
	    }

	    @Override
	    public void keyTyped(KeyEvent e) {}

}
