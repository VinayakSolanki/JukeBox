package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatePlaylist {
    public static void songsPlaylist(String playlistName, int playlistId, int userId, int songId) {
        Connection connection = GetConnection.connectTo();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("insert into playlist(playlistName,playlistId,userId,songId)  values('" + playlistName + "'," + playlistId + "," + userId + "," + songId + ")");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
