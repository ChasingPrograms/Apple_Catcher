package Main;

import Entity.*;
import Handler.*;

import java.awt.*;
import javax.swing.JPanel;
import java.util.Random;

public class Panel extends JPanel implements Runnable{

     //Game Threads
    final int fps = 60; // FPS
    //KeyHandler
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //CollisionHandler
    CollisionHandler collH = new CollisionHandler();

    //ScoreHandler
    ScoreHandler scoreH = new ScoreHandler(this,collH);

    //BackgroundHandler
    BackgroundHandler backH = new BackgroundHandler(this);

    //SoundHandler
    SoundHandler soundH = new SoundHandler();

    //GameState Handler
    GameStateHandler gH = new GameStateHandler(this);

    //Random
    Random ran = new Random();
    
    //Panel Dimensions
    public  final int w = 800;
    public  final int h = 600;

    //Creating the catcher
    Catcher catcher = new Catcher(this,keyH); 

    //Shake Effect
    int shakeTimer = 0;
    int shakeDuration = 15;
    final int shakeStength = 5;
    int shakeX,shakeY = 0; 

    //Creating the apple
    Apple apple = new Apple(this, keyH);


    //Panel Constructor
    public Panel(){ 
        this.setPreferredSize(new Dimension(w, h)); // Sets the preferred panel dimensions
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH); //Adding Key Handler
        this.setFocusable(true); //Panel focused to receive keyboard inputs
    }

    public void launch(){ //Method to start the gameThread
        soundH.playMusic(); //Starts Music
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

            else{ //This will help the CPU from overheating
                try {
                    Thread.sleep(1);
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void update(){

        if(gH.state == GameStateHandler.State.GAMEOVER){
            return;
        }
        
        catcher.update();
        apple.update();
        collH.checkCollision(apple, catcher, h);
        if(collH.caught){soundH.playCatch();} //Play Caught SFX
        if(collH.miss){
            shakeTimer = shakeDuration;
            soundH.playMiss();} //Play Missed SFX

        if(shakeTimer > 0){
        int power = shakeStength * shakeTimer / shakeDuration; // fades out
        shakeX = ran.nextInt(power * 2 + 1) - power; // -power to +power
        shakeY = ran.nextInt(power * 2 + 1) - power;
        shakeTimer--;
        } else {
            shakeX = 0;
            shakeY = 0;
        }
        if(collH.caught || collH.miss){apple.respawn();}
        scoreH.update();

        if(scoreH.miss >= 3){
        gH.state = GameStateHandler.State.GAMEOVER;
        shakeX = 0;
        shakeY = 0;
        shakeTimer = 0;
    }
        
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; // Casts g from Graphics to Graphics2D and stores it in g2
        g2.translate(shakeX, shakeY);
        backH.draw(g2);
        apple.draw(g2);
        catcher.draw(g2);
        g2.translate(-shakeX, -shakeY);  // undo, so the score text stays steady
        scoreH.draw(g2);

        if(gH.state == GameStateHandler.State.GAMEOVER){
            gH.drawGameOver(g2);
        }
    }
}
