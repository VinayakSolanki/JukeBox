package model;

import beans.Playlist;
import beans.Song;
import beans.User;
import controller.GetConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDetails {
    public static ArrayList<User> user() {    //arraylist user is return type
        GetConnection con = new GetConnection();
        Connection connection = con.connectTo();

        ArrayList<User> list = new ArrayList<>();

        User use = null;

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from users");

            while (rs.next()) {
                use = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(use);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static ArrayList<Song> songs() {    //arraylist user is return type
        GetConnection con = new GetConnection();
        Connection connection = con.connectTo();
        ArrayList<Song> list = new ArrayList<>();
        Song song = null;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from Music");
            while (rs.next()) {
                song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getString(7));
                list.add(song);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }


    public static ArrayList<Song> Searchsong(String Song) {
        GetConnection con = new GetConnection();
        Connection connection = con.connectTo();

        ArrayList<Song> search = new ArrayList<>();

        Song song = null;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from Music where songName='" + Song + "';");

            while (rs.next()) {
                song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getString(7));
                search.add(song);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return search;
    }

    public static ArrayList<Song> SearchByGenre(String genre) {
        GetConnection con = new GetConnection();
        Connection connection = con.connectTo();
        ArrayList<Song> search = new ArrayList<>();
        Song song = null;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from Music where genre='" + genre + "';");
            while (rs.next()) {
                song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getString(7));
                search.add(song);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return search;
    }

    public static ArrayList<Song> SearchByArtist(String artist) {
        GetConnection con = new GetConnection();
        Connection connection = con.connectTo();
        ArrayList<Song> search = new ArrayList<>();
        Song song = null;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from Music where artist='" + artist + "';");
            while (rs.next()) {
                song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getString(7));
                search.add(song);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return search;
    }


    public static void viewPlaylist() {
        String playlistName = "";
        GetConnection con = new GetConnection();
        Connection connection = con.connectTo();
        ArrayList<Playlist> list = new ArrayList<>();
        Playlist playlist = null;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from playlist");
            System.out.println("All playlist Names :");
            while (rs.next()) {
                if (!playlistName.equals(rs.getString(2))) {
                    System.out.println(rs.getString(2));
                }
                playlistName = rs.getString(2);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
