package com.pokeinv.View.shared;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class SoundPlayer {

    private static boolean loop;
    private static String path;

    public static void play(String soundPath) {
        path = soundPath;
        loop = false;
        init();
    }

    public static void play(String soundPath, boolean loopPlay) {
        path = soundPath;
        loop = loopPlay;
        init();
    }

    private static void init() {
        try {
            URL url = SoundPlayer.class.getResource(path);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            if (loop) clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
