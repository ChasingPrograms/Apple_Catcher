package Handler;

import java.awt.*;

import Main.Panel;

public class GameStateHandler {
    public enum State{
        ACTIVE,
        GAMEOVER
    }
    public volatile State state = State.ACTIVE;
    Panel gp;


    public GameStateHandler(Panel gp) {
        this.gp = gp;
    }

    public void drawGameOver(Graphics2D g2){
        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0, 0, gp.w, gp.h);
        
        g2.setColor(Color.white);
        g2.setFont(new Font("Arial", Font.PLAIN, 100));
        int width = g2.getFontMetrics().stringWidth("GAMEOVER");
        g2.drawString("GAMEOVER", ((gp.w-width)/2), (gp.h/2));
    }
    
}
