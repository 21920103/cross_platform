/*
 * Лабораторна робота 1. 
 * Сервлет, що реалізує функції контроллера (за MVC)
 */
package servlets;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoctorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( StandardCharsets.UTF_8.name() ) ;
        String message ;
        if( req.getRequestURI().endsWith( "/add_doctor" ) ) {
            String name = req.getParameter( "name" ) ;
            if( name == null || name.length() == 0 ) {
                message = "Потрібно вказати ПІБ" ;
            } else {
                String spec = req.getParameter( "spec" ) ;
                if( spec == null || spec.length() == 0 ) {
                    message = "Потрібно вказати Спеціалізацію" ;
                } else {
                    if( model.Doctors.add(name, spec) ) {
                        message = "Додано успішно" ;
                    } else {
                        message = "Помилка додавання" ;
                    }
                }
            }
            req.setAttribute( "message", message ) ;
            req.getRequestDispatcher( "/index.jsp" ).forward( req, resp ) ;
        }
    }
    
}
