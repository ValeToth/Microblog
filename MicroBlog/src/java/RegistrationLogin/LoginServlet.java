package RegistrationLogin;

import Dao.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
       
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginDAO login = new LoginDAO();
        boolean v = login.validation(username, password);
     
        if (v == true) {
             request.getRequestDispatcher("ProfileServlet.html").include(request, response);
        } else {
            out.print("<p>" + "invalid credentials" + "</p>");
            request.getRequestDispatcher("login.html").include(request, response);
        }
}
}

    
