package browser;


import beans.Song;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PlayMusic {

    public static void playList(ArrayList<Song> list) {
        Scanner scanner = new Scanner(System.in);
        Iterator<Song> i = list.iterator();

        Song song = null;

        String response = "";

        try {
            while (!(response.equalsIgnoreCase("s") || response.equalsIgnoreCase("n"))) {
                while (i.hasNext() && !(response.equalsIgnoreCase("s") && !(response.equalsIgnoreCase("n")))) {
                    song = i.next();


                    File file = new File(song.getUrl());

                    if (file.exists()) {
                        AudioInputStream audioinput = AudioSystem.getAudioInputStream(file);

                        Clip clip = AudioSystem.getClip();
                        clip.open(audioinput);
                        clip.start();
                        do {
                            System.out.println("\tp:play songs\tpa:pause\tr:reset songs\tn:next\tS:stop songs");
                            response = scanner.next();
                            switch (response) {
                                case ("p"):
                                    clip.start();
                                    break;
                                case ("pa"):
                                    clip.stop();
                                    break;
                                case ("s"):
                                    clip.stop();
                                    break;
                                case ("n"):
                                    clip.stop();
                                    break;
                                case ("r"):
                                    clip.setMicrosecondPosition(0);
                                    break;
                                default:
                                    System.out.println("Not a valid response ");
                            }


                        } while (!response.equalsIgnoreCase("s") && !response.equalsIgnoreCase("n"));
                    } else {
                        System.out.println("file not found");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void playSong(ArrayList<Song> list, int a) {
        Scanner scanner = new Scanner(System.in);
        Iterator<Song> i = list.iterator();
        Song song = null;
        String response = "";
        try {
            while (i.hasNext() && (!(response.equalsIgnoreCase("s")))) {
                song = i.next();
                if (a == (song.getId())) {
                    System.out.println(song.getId());
                    //   System.out.println(song.getUrl());
                    File file = new File(song.getUrl());
                    if (file.exists()) {
                        AudioInputStream audioinput = AudioSystem.getAudioInputStream(file);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioinput);

                        do {
                            System.out.println("\tP:play songs\n\tPa:pause\n\tR:reset songs\n\tS:stop songs");
                            response = scanner.next();
                            switch (response) {
                                case ("p") -> clip.start();
                                case ("pa") -> clip.stop();
                                case ("s") -> clip.stop();
                                case ("r") -> clip.setMicrosecondPosition(0);
                                default -> System.out.println("Not a valid response ");
                            }
                        } while (!(response.equalsIgnoreCase("S")));
                    } else {
                        System.out.println("file not found");
                    }
                }
            }
            System.out.println("Enter 1 to continue , enter 0 for exit");
            int ob = scanner.nextInt();
            if (ob == 1) {
                Menu.mainMenu(0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
