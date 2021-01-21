/*
 * Демонстрація впровадження залежностей
 * Залежний клас з життєвим циклом протягом запиту (RequestScoped)
 * 
 */

package di;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;


@RequestScoped
public class Clients {
    
    ArrayList<String> namesList ;
    ArrayList<model.orm.Client> clients;

    public Clients() {
        namesList = null;
    }     
 
    public ArrayList<String> getList() {
        if( namesList == null ) {
            try {
                ResultSet res =
                model
                    .DbConnector
                    .getConnection()
                    .createStatement()
                    .executeQuery( "select * from clients" ) ;
                namesList = new ArrayList<>() ;
                while( res.next() ) {
                    namesList.add( res.getString( "name" ) ) ;
                }
            } catch( SQLException ignored ) {
                
            }
        }
        return namesList ;
    }
}
