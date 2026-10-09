package Handler;

import Main.Panel;
import java.awt.*;

public class ScoreHandler{

    Panel gp; // Our GamePanel instance
    CollisionHandler ch; //Our Collision Handler
    public int score,miss;

    public ScoreHandler(Panel gp, CollisionHandler ch) {
        this.gp = gp;
        this.ch = ch;
    }

    public void update(){
        if(ch.miss){
            miss++;
        }

        else if(ch.caught){
            score++;
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.setFont(new Font("Arial", Font.PLAIN, 20));
        g2.drawString("Score: " + score, (gp.w-100), (50));
        g2.drawString("Miss: " + miss, (gp.w-100), (100));
    }
}
