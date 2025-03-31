import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyEvents extends JPanel implements KeyListener {
	
	public KeyEvents() {
        setFocusable(true);
        addKeyListener(this);
    }
	
	 @Override
	    public void keyPressed(KeyEvent e) {
	        int key = e.getKeyCode();
	        if (key == KeyEvent.VK_LEFT) {
	            System.out.println("Left arrow key pressed");
	        } else if (key == KeyEvent.VK_RIGHT) {
	            System.out.println("Right arrow key pressed");
	        } else if (key == KeyEvent.VK_A) {
	           System.out.println("A key pressed");
	        } else if (key == KeyEvent.VK_ENTER){
	            System.out.println("Enter key pressed");
	        }
	    }

	    @Override
	    public void keyReleased(KeyEvent e) {}

	    @Override
	    public void keyTyped(KeyEvent e) {}

}
