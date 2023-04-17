package browser;

import beans.Song;
import controller.CreatePlaylist;
import model.UserDetails;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void mainMenu(int userid) throws SQLException {
        String playlistName = "";
        int select;
        String finalsongs = "";


        DisplayUtilities display = new DisplayUtilities();

        System.out.println("---------------------------");
        System.out.println("\t\tMain menu");
        System.out.println("---------------------------");

        int selection;
        Scanner sc = new Scanner(System.in);
        ArrayList<Song> songslist = UserDetails.songs();

        String Input = "";
        System.out.print("1\t****  View All Songs And Play  ****\n2\t****  Search Song By Name     " +
                " ****\n3\t****  Search Songs By Genre   ****\n4\t****  Search Songs By Artist" +
                "   ****\n5\t****  Create Playlist        " +
                " ****\n6\t****  View Playlist          ****\n" +
                " ****\n7\t****  Exit          ****\n");
        System.out.println("Enter Option");
        selection = sc.nextInt();
        switch (selection) {
            case 1: {
                display.displaySongs(songslist);
                Menu.playSong(songslist);
            }
            break;
            case 2: {

                //Search by Song Name
                display.displaySongs(songslist);
                System.out.println("Enter Song Name To Search");
                Input = sc.next();

                ArrayList<Song> searchSongs = UserDetails.Searchsong(Input);

                display.displaySongs(searchSongs);

                Menu.playSong(searchSongs);


            }
            break;
            case 3: {
                //Search by genre
                display.displaySongs(songslist);
                System.out.println("Enter Genre of Song to Search");
                Input = sc.nextLine();
                Input = sc.nextLine();
                ArrayList<Song> searchSongs = UserDetails.SearchByGenre(Input);
                display.displaySongs(searchSongs);
                Menu.playSong(searchSongs);
            }
            break;
            case 4: {
                //Search by Artist
                display.displaySongs(songslist);
                System.out.println("Enter Artist of Song to Search");
                Input = sc.nextLine();
                Input = sc.nextLine();
                ArrayList<Song> searchSongs = UserDetails.SearchByArtist(Input);
                display.displaySongs(searchSongs);
                Menu.playSong(searchSongs);
            }
            break;


            case 5: {
                System.out.println("Enter Playlist Names :");
                playlistName = sc.nextLine();
                playlistName = sc.nextLine();
                System.out.println("Enter Playlist Id");
                int playlistId = sc.nextInt();
                System.out.println("your playlist is successfully created");
                System.out.println("1\tEnter 1 to add song in playlist\n");
                select = sc.nextInt();
                switch (select) {
                    case 1: {
                        display.displaySongs(songslist);
                        int songId;
                        do {
                            System.out.println("enter songId or press 0 to exit");
                            songId = sc.nextInt();//2
                            if (songId < 1000) {
                                CreatePlaylist.songsPlaylist(playlistName, playlistId, userid, songId);
                            } else {
                                System.out.println("this song id is not available");
                                //  Menu.mainMenu(0);
                            }
                        } while (songId > 0);
                    }
                    break;

                }
                System.out.println(playlistName);
                Menu.mainMenu(0);
            }
            break;


            case 6: {
                UserDetails.viewPlaylist();
                System.out.println("Enter playlist name to view");
                playlistName = sc.next();
                ArrayList<Song> list = DisplayUtilities.displayPlaylist(playlistName);
                DisplayUtilities.displaySongs(list);
                Menu.playSong(list);
                Menu.mainMenu(0);
            }
            break;

            case 7: {
                System.out.println("-----------------------------------------");
                System.out.println("....::::::::....Thankyou....::::::::....");
                System.out.println("-----------------------------------------");
            }
            break;


        }


    }

    public static void playSong(ArrayList<Song> Music) throws SQLException {

        Scanner sc = new Scanner(System.in);

        System.out.println("1.Play all songs!!\n2.Select song\n3.Main menu ");
        int opt = sc.nextInt();
        int songId = 0;
        switch (opt) {

            case 1 -> {
                PlayMusic.playList(Music);
            }


            case 2 -> {
                System.out.println("Enter song id");
                songId = sc.nextInt();
                PlayMusic.playSong(Music, songId);
            }

            case 3 -> Menu.mainMenu(0);

        }
    }
}
