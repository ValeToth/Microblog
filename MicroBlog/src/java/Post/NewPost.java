package Post;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NewPost extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
		
		request.getRequestDispatcher("NewPost.html").include(request, response);
		
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            response.setContentType("text/html");
            HttpSession session=request.getSession(false);
            PrintWriter out=response.getWriter();
            request.getRequestDispatcher("ProfileServlet.html").include(request, response);
        } 
         
            catch(Exception se) {        
                se.printStackTrace();
            }
    }

}
