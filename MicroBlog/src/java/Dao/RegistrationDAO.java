package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegistrationDAO {
    public boolean update(
            String username,
            String password
           ) {
            try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connectionString = DriverManager.getConnection("jdbc:derby://localhost:1527/Microblog");
            PreparedStatement user = connectionString.prepareStatement("insert into utente (username, password) values (?,?)");
            user.setString(1, username);
            user.setString(2, password);
           

            user.executeUpdate();
            return true;

        } 
            catch (Exception e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
            return false;
        }

    }
    
}

