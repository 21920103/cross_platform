package model;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Doctors {
    private static ArrayList<model.orm.Doctor> doctors;
    public static ArrayList<model.orm.Doctor> getList() {
        if( doctors == null ) {
            doctors = new ArrayList<>() ;
            try{
                ResultSet res =
                model
                    .DbConnector
                    .getConnection()
                    .createStatement()
                    .executeQuery( "select * from doctors" ) ;
                
                while( res.next() ) {
                    doctors.add( new model.orm.Doctor(
                            res.getInt( "id" ),
                            res.getString( "name" ),
                            res.getString( "spec" )                            
                    ));
                }
            } catch( Exception ignored ) {
                
            }
        }
        return doctors;
    }
    
    public static boolean add( String name, String spec ) {
        try{
            int x= 0;
                model
                    .DbConnector
                    .getConnection()
                    .createStatement()
                    .executeUpdate( "insert into doctors (name, spec) values ('"+name+"', '"+spec+"')" ) ;
                
                doctors = null ;
                return true ;
            } catch( Exception ignored ) {
                return false ;
            }
    }
}
