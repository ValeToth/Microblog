package RegistrationLogin;

import Dao.RegistrationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
    Connection connection;
        String username;
        String password;
       
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("registration.html").include(request, response);
        
        username = request.getParameter("username");
        password = request.getParameter("password");
      
        response.setContentType("text/html");
         
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionString=("jdbc:derby://localhost:1527/Microblog");
            connection =  DriverManager.getConnection(connectionString);
            PreparedStatement user = connection.prepareStatement("insert into utente (username, password) values (?,?)");
            user.setString(1,username);
            user.setString(2, password);
            user.executeUpdate();
           
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
       finally 
        {
	
        try {
		if (connection != null)
	            connection.close();
	} catch (SQLException e) {
		
	}
         out.print("<p>" + username + "</p>");
         request.getRequestDispatcher("ProfileServlet.html").include(request, response);

        }
}
}
