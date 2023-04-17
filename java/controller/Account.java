package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Account {
    public boolean createNewAccount(String userName, String Password) {

        GetConnection con = new GetConnection();
        Connection connection = con.connectTo();
        int rs = 0;

        try {
            Statement st = connection.createStatement();

            rs = st.executeUpdate("insert into users(username,password) values('" + userName + "','" + Password + "')");
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        boolean flag = false;
        if (rs == 1) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

}


