package music_effect;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {
    private Clip clip;


    public void playMusic(String filePath , boolean loop){

        try {
            File musicPath = new File(filePath);
           if (musicPath.exists()) {
             AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
             clip = AudioSystem.getClip();
             clip.open(audioInput);
             clip.start();
             if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
             }else{
                System.out.println("No music"+filePath);
             }
           }

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stopMusic(){
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}
