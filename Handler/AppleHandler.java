package Handler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import java.util.*;

import Entity.Apple;
import Main.Panel;

public class AppleHandler{

    Apple apple;
    Panel gp;
    Random ran = new Random();
    BufferedImage image;

    public AppleHandler(Apple apple, Panel gp){
        this.apple = apple;
        this.gp = gp;
        getImage();
    }

    public void getImage(){
        try {
            image = ImageIO.read(new File("res/Apple_Media.png"));
        } catch (IOException e) {
             e.printStackTrace();
        }
    }

    public void fall(){
        apple.y += apple.speed;

    }

    public void respawn(){
        apple.x = ran.nextInt(gp.w - 100);
        apple.y = 0;
        
    }

    public void spawn(Graphics2D g2){

            if(image != null){
            g2.drawImage(image,apple.x,apple.y,50,50,null);
        }

        else{
        g2.setColor(Color.red);
        g2.fillOval(apple.x, apple.y, 50, 50);
        }
    }
}