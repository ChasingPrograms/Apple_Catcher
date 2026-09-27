package Handler;

import Entity.Apple;
import Main.Panel;

public class AppleHandler {

    Apple apple;
    Panel gp;

    public AppleHandler(Apple apple, Panel gp){
        this.apple = apple;
        this.gp = gp;
    }

    public void fall(){
        if(apple.y < gp.h - 50){
            apple.y += apple.speed;
        }
    }
}