package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
    
    public boolean validation(String username, String password) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connectionString = DriverManager.getConnection("jdbc:derby://localhost:1527/Microblog");
            PreparedStatement user = connectionString.prepareStatement("select * from utente where username=? and password=?");
            user.setString(1, username);
            user.setString(2, password);

            ResultSet a = user.executeQuery();
            
            if (a.first()) {
                return true;
            } 
            else {
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }
}