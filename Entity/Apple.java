package Entity;
import java.awt.*;

import Handler.AppleHandler;
import Main.Panel;
import Handler.KeyHandler;

public class Apple extends Entity{

    Panel gp; // Our GamePanel instance
    AppleHandler ah; // Our AppleHandler instance
    KeyHandler kh;

    public Apple(Panel gp, KeyHandler kh){
        this.gp = gp;
        this.kh = kh;

        ah = new AppleHandler(this, gp);
        respawn();
    }
    public void respawn(){
        ah.respawn();
    }

    public void update(){

        if(kh.downPressed){
            speed = 5;
        }

        else{
            speed = 3;
        }

        ah.fall();
    }

    public void draw(Graphics2D g2){
        ah.spawn(g2);
    }
}