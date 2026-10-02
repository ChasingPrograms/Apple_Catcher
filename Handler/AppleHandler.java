package Handler;

import java.awt.*;
import java.util.Random;

import Entity.Apple;
import Main.Panel;

public class AppleHandler{

    Apple apple;
    Panel gp;
    Random ran = new Random();
    CollisionHandler ch;

    public AppleHandler(Apple apple, Panel gp, CollisionHandler ch){
        this.apple = apple;
        this.gp = gp;
        this.ch = ch;
    }

    public void fall(){
         if(apple.y < gp.h - 50){
            apple.y += apple.speed;
        }
        else{
            ch.miss = true;
            respawn();
        }
    }

    public void collisionReset(){
        ch.miss = false;
        ch.caught = false;
    }
    public void respawn(){
        apple.x = ran.nextInt(gp.w - 100);
        apple.y = 0;
        
    }

    public void spawn(Graphics2D g2){
        g2.setColor(Color.red);
        g2.fillOval(apple.x, apple.y, 50, 50);
    }
}