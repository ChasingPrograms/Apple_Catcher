package Entity;

import java.awt.*;
import java.util.Random;

import Handler.AppleHandler;
import Handler.CollisionHandler;
import Main.Panel;
import Handler.KeyHandler;

public class Apple extends Entity{

    Panel gp; // Our GamePanel instance
    AppleHandler ah; // Our AppleHandler instance
    Random ran = new Random();
    KeyHandler kh;

    public Apple(Panel gp, CollisionHandler ch, KeyHandler kh){
        this.gp = gp;
        this.kh = kh;

        x = ran.nextInt(gp.w - 100);
        speed = 1;

        ah = new AppleHandler(this, gp, ch);
    }

    public void respawn(){
        ah.respawn();
    }

    public void update(){
        if(kh.downPressed){
            speed = 2;
        }

        else{
            speed = 1;
        }

        ah.fall();

    }

    public void draw(Graphics2D g2){
        ah.spawn(g2);
    }
}