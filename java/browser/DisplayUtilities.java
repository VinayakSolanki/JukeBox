package browser;

import beans.Song;
import controller.GetConnection;
import model.UserDetails;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class DisplayUtilities {
    public static void displaySongs(ArrayList<Song> Songs) {
        Iterator<Song> i = Songs.iterator();

        Song song;

        System.out.println("________________________________-----------------------------------------------------_______________________");
        System.out.printf("| %-10s | %-30s | %-25s | %-15s |  %-15s  | %-10s |%n", "Song Id", "Song Name", "Artist", "Genre", "album", "duration");
        System.out.println("________________________________----------------------------------------------------____________________________");

        while (i.hasNext()) {
            song = i.next();
            System.out.printf("| %-10s | %-30s | %-25s | %-15s |  %-15s  | %-10s |%n", song.getId(), song.getName(), song.getArtist(), song.getGenre(), song.getAlbum(), song.getDuration());

        }
    }


    public static ArrayList<Song> displayPlaylist(String play) throws SQLException {
        ArrayList<Song> list = new ArrayList<>();
        ArrayList<Song> songslist = UserDetails.songs();
        Connection connection = GetConnection.connectTo();

        Iterator<Song> i = songslist.iterator();

        Statement st = connection.createStatement();
        Song song = null;
        ResultSet rs = st.executeQuery("select * from playlist");

        // new arraylist of integers
        ArrayList<Integer> songId = new ArrayList<>();

        //adding songs to songId arraylist by checking playlist name
        while (rs.next()) {
            if (rs.getString(2).equals(play)) {
                songId.add(rs.getInt(5));
            }
        }

        int it = songId.size();

        while (i.hasNext()) {
            song = i.next();

            for (int x = 0; x <= it - 1; x++) {
                if (song.getId() == songId.get(x)) {
                    list.add(song);
                }
            }
        }
        return list;

    }
}
