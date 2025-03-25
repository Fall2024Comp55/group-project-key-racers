import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundPlayer {
    private Clip clip;

    public void playSound(String filePath) {
        try {
            File soundFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Error playing sound: " + e.getMessage());
        }
    }

    public void stopSound() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}
