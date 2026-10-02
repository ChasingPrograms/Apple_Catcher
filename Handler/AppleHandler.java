package Handler;

import java.awt.*;
import java.util.Random;

import Entity.Apple;
import Main.Panel;

public class AppleHandler {

    Apple apple;
    Panel gp;
    Random ran = new Random();

    public AppleHandler(Apple apple, Panel gp){
        this.apple = apple;
        this.gp = gp;
    }

    public void fall(){
         if(apple.y < gp.h - 50){
            apple.y += apple.speed;
        }
        else{
            apple.miss = true;
            respawn();
        }
    }

    public void collisionReset(){
        apple.miss = false;
        apple.caught = false;
    }
    public void respawn(){
        apple.x = ran.nextInt(gp.w - 100);
        apple.y = 0;
        collisionReset();
        
    }

    public void spawn(Graphics2D g2){
        g2.setColor(Color.red);
        g2.fillOval(apple.x, apple.y, 50, 50);
    }
}