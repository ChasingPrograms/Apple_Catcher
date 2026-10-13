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
        g2.drawString("GAMEOVER", ((gp.w-width)/2), ((gp.h/2)-10));


        // RESTART OPTION
        g2.setFont(new Font("Arial", Font.PLAIN, 20));
        width = g2.getFontMetrics().stringWidth("RESTART?");
        g2.drawString("RESTART?", ((gp.w-width)/2), ((gp.h/2) + 50));

        // QUIT OPTION
        g2.setFont(new Font("Arial", Font.PLAIN, 20));
        width = g2.getFontMetrics().stringWidth("QUIT GAME");
        g2.drawString("QUIT GAME", ((gp.w-width)/2), ((gp.h/2) + 100));
    }
    
}
