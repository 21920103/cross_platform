package model;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Doctors {
    private static ArrayList<model.orm.Doctor> doctors;
    
    /* 
        CRUD methods    
    */
    public static boolean add( String name, String spec ) {
        try{
            int x = 0;
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
    
    public static boolean update( int id, String name, String spec ){
        try{
            int x = 0;
            model
                .DbConnector
                .getConnection()
                .createStatement()
                .executeUpdate( "update doctors set name='"+name+"', spec='"+spec+"' where id="+id ) ;

            doctors = null ;
            return true ;
        } catch( Exception ignored ) {
            return false ;
        }
    }
    
    public static boolean remove( int id ) {
        try{
            int x = 0;
            model
                .DbConnector
                .getConnection()
                .createStatement()
                .executeUpdate( "delete from doctors where id="+id ) ;

            doctors = null ;
            return true ;
        } catch( Exception ignored ) {
            return false ;
        }
    }
    
    /*
        CRUD methods with ORM
    */
    public static boolean add( model.orm.Doctor d ) {
        return add( d.getName(), d.getSpeciality() ) ;
    }
    
    public static boolean update(  model.orm.Doctor d ){
        return update( d.getId(), d.getName(), d.getSpeciality() ) ;
    }
    
    public static boolean remove(  model.orm.Doctor d ) {
       return remove( d.getId() ) ;
    }
    
    /*
        Specialities
    */
    public static ArrayList<String> getSpecList() {
        try{
            ResultSet res =
            model
                .DbConnector
                .getConnection()
                .createStatement()
                .executeQuery( "select distinct spec from doctors" ) ;
            ArrayList<String> ret = new ArrayList<>() ;
            while( res.next() ) {
                ret.add( res.getString( "spec" ) ) ;
            }
            return ret ;
        } catch( Exception ignored ) {
            return null;
        }
    }
    
    public static ArrayList<model.orm.Doctor> getListBySpec( String spec ) {
        ArrayList<model.orm.Doctor> ret = new ArrayList<>() ;
        try{
            ResultSet res =
            model
                .DbConnector
                .getConnection()
                .createStatement()
                .executeQuery( "select * from doctors where spec like '"+spec+"'" ) ;

            while( res.next() ) {
                ret.add( new model.orm.Doctor(
                        res.getInt( "id" ),
                        res.getString( "name" ),
                        res.getString( "spec" )                            
                ));
            }
            return ret ;
        } catch( Exception ignored ) {
            return null ;
        }
    }
}
