/*
 * Лабораторна робота 1
 * Демонстрація роботи контроллера - передобробка запиту
 * a також функції внутрішнього перенаправлення (forward)
 */
package servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Admin
 */
public class TestConnection implements Filter {
    
    private FilterConfig filterConfig = null;
    
    public TestConnection() {
    } 

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        try{
            Class.forName( "com.mysql.jdbc.Driver" ) ;
            model.DbConnector.getConnection() ;
        } catch( Exception ignored ){
            request.getRequestDispatcher( "/error.html" ).forward( request, response ) ;
        }
            
        try {
            chain.doFilter(request, response);
        } catch( IOException | ServletException t ) {
            System.out.println( t.getMessage() );
        }
    }

    /**
     * Return the filter configuration object for this filter.
     * @return 
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
    }

    
}
