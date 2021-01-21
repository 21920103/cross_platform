/*
 * Демонстрація впровадження залежностей
 * Іменований залежний клас, зверненя до нього за іменем на сторінці clients.jsp
 * Термін життя - визначаеється за замовчуванням (Dependent)
 */

package di;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named
@Dependent
public class ClientCounter {
    private int cnt ;

    public int getCnt() {
        try {
            ResultSet res =
            model
                .DbConnector
                .getConnection()
                .createStatement()
                .executeQuery( "select count(*) from clients" ) ;
            res.next() ;
            cnt = res.getInt( 1 ) ;
        } catch( SQLException ignored ) {
            cnt = -1 ;
        }
            
        return cnt;
    }

    
    
}
