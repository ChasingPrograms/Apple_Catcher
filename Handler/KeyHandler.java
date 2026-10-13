package Handler;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener{

    public boolean leftPressed,rightPressed,downPressed, enterPressed;

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

        else if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S){
            downPressed = true;
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

        else if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S){
            downPressed = false;
        }
    }

}