package Handler;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener{

    public boolean leftPressed,rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {
        //Not Needed
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A){
            leftPressed = true;
        }

        else if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D){
            rightPressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A){
            leftPressed = false;
        }

        else if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D){
            rightPressed = false;
        }
    }

}