package Handler;

import java.io.File;
import javax.sound.sampled.*;

public class SoundHandler {
    
    Clip catchClip,missClip,musicClip,gameOverClip;

    public SoundHandler(){
        catchClip = load("res/Caught.wav");
        missClip = load("res/Miss.wav");
        musicClip = load("res/Background.wav");
        gameOverClip = load("res/GameOver.wav");
    }

    private Clip load(String path){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(path));
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            return clip;
        } catch (Exception e) {
            e.printStackTrace(); // clip stays null, so the game just stays silent
            return null;
        }
    }

    public void playMusic(){
        if(musicClip == null) return;
        musicClip.setFramePosition(0);
        musicClip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void playCatch(){
        if(catchClip == null) return;
        catchClip.stop();              // cut off the previous play if still going
        catchClip.setFramePosition(0); // rewind to the start
        catchClip.start();
    }

     public void playMiss(){
        if(missClip == null) return;
        missClip.stop();              // cut off the previous play if still going
        missClip.setFramePosition(0); // rewind to the start
        missClip.start();
    }

    public void playGameOver(){
        if(musicClip != null) musicClip.stop();
        if(gameOverClip == null) return;
        gameOverClip.start();
    }
}
