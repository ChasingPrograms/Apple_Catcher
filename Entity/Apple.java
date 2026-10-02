package Entity;

import java.awt.*;
import java.util.Random;

import Handler.AppleHandler;
import Handler.CollisionHandler;
import Main.Panel;

public class Apple extends Entity{

    Panel gp; // Our GamePanel instance
    AppleHandler ah; // Our AppleHandler instance
    Random ran = new Random();
    CollisionHandler ch;

    public Apple(Panel gp, CollisionHandler ch){
        this.gp = gp;

        x = ran.nextInt(gp.w - 100);
        speed = 1;

        ah = new AppleHandler(this, gp, ch);
    }

    public void update(){
        ah.fall();
    }

    public void draw(Graphics2D g2){
        ah.spawn(g2);
    }
}