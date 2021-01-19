
package servlets;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientController extends HttpServlet {
    
    @Inject             
    private di.Clients clients;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( StandardCharsets.UTF_8.name() ) ;
        String names = "" ;
        for( String s : clients.getList() ) {
            names += s + " ";
        }
        req.setAttribute( "clientList", names ) ;
        req.getRequestDispatcher( "/clients.jsp" ).forward( req, resp ) ;

    }
    
}
