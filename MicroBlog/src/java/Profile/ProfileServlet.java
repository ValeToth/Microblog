package Profile;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		
		HttpSession session=request.getSession(false);
		
                if(session!=null){
		
           
		}
		else{
			out.print("Login first");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
    }

  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
            response.setContentType("text/html");
            HttpSession session=request.getSession(false);
            PrintWriter out=response.getWriter();
            request.getRequestDispatcher("ProfileServlet.html").include(request, response);       
            String name=request.getParameter("name");
            String ModifyDate=request.getParameter("ModifyDate");  
            String ModifyTitle=request.getParameter("ModifyTitle");      
            String ModifyContent=request.getParameter("ModifyContent");
       
            out.print("Welcome" + name);
              
                out.print(ModifyDate );       
                out.print("<h1>"+ModifyTitle+"</h1>");
                out.print("<p>"+ModifyContent+"</p>" + "<br>");
                
                if(session!=null){            
            }           
                
                else{			
                    }
                    out.close();   
        }
}
