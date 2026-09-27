package Entity;
import java.awt.Color;
import java.awt.Graphics2D;

import Handler.KeyHandler;
import Main.Panel;

public class Catcher extends Entity{
    Panel gp; //Our Gamepanel instance
    KeyHandler kh; //Key Handler instance

    public Catcher(Panel gp, KeyHandler kh){
        this.gp = gp;
        this.kh = kh;
        defaultPos();
    }

    public void defaultPos(){
        //Default position for our catcher, Bottom Center of the Screen
        x = ((gp.w / 2) - 50);
        y = (gp.h - 100);
        speed = 20;
    }
    
    public void update(){ //Update Method
        if(kh.leftPressed){
            
            x -= speed;
        }

        else if(kh.rightPressed){
           x += speed;
        }

        //Keep the catcher within the left and right boundaries of the game panel
        if( x < 0){
            x = 0;
        }

        if(x > gp.w - 100){
            x = gp.w - 100;
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(x, y, 100, 100);
    }
}
