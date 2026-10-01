package Entity;

import java.awt.*;
import java.util.Random;

import Handler.AppleHandler;
import Main.Panel;

public class Apple extends Entity{

    Panel gp; // Our GamePanel instance
    AppleHandler ah; // Our AppleHandler instance
    Random ran = new Random();

    public Apple(Panel gp){
        this.gp = gp;

        x = ran.nextInt(gp.w - 100);
        speed = 1;

        ah = new AppleHandler(this, gp);
    }

    public void update(){
        ah.fall();
    }

    public void draw(Graphics2D g2){
        ah.spawn(g2);
    }
}