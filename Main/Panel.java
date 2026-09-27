package Main;

import Entity.*;
import Handler.KeyHandler;

import java.awt.*;
import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable{

     //Game Threads
    final int fps = 60; // FPS
    //KeyHandler
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    
    //Panel Dimensions
    public  final int w = 800;
    public  final int h = 600;

    //Creating the catcher
    Catcher catcher = new Catcher(this,keyH); 

    //Creating the apple
    Apple apple = new Apple(this); 

    //Panel Constructor
    public Panel(){ 
        this.setPreferredSize(new Dimension(w, h)); // Sets the preferred panel dimensions
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH); //Adding Key Handler
        this.setFocusable(true); //Panel focused to receive keyboard inputs
    }

    public void launch(){ //Method to start the gameThread
        gameThread = new Thread(this); //Creates a new game thread
        gameThread.start(); //Starts the game thread
    }

    @Override //Method to run the game loop
    public void run() {
        double drawInterval = 1000000000 /fps; //60fps
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){ //As long gameThread exists, it repeats the below block of code
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1){
                update(); //Update Method
                repaint(); //Draw Method
                delta--;
            }
        }
    }
    
    public void update(){
        catcher.update();
        apple.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; // Casts g from Graphics to Graphics2D and stores it in g2
        catcher.draw(g2);
        apple.draw(g2);
    }
}
