package Handler;
import Entity.Apple;
import Entity.Catcher;


public class CollisionHandler {
    public boolean miss;
    public boolean caught;

    public void checkCollision(Apple apple, Catcher catcher, int panelH ){

        resetCollision();

        // Check 1: Apple / Catcher over-laps at the x-axis.
        boolean xCollision = ((apple.x +50) > catcher.x) && (apple.x <(catcher.x+100));

        // Check 2: Apple / Catcher over-laps at the y-axis.
        boolean yCollision = (apple.y +50) >= catcher.y;
        if(xCollision && yCollision){
            caught = true;
        }

        // Check 3: If the apple reaches the bottom = miss.
        else if(apple.y >= panelH - 50){
            miss = true;
        }
    }

    public void resetCollision(){
        miss = false;
        caught = false;
    }
}
