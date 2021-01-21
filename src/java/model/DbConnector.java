/*
 * Лабораторна робота 1. 
 * Демонстрація підключення до ДБ
 * засобами JDBC
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private static Connection con;

    public static Connection getConnection() throws SQLException {
        if( con == null ) {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cross1?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "crossuser", 
                    "crosspass"
            );
        }
        return con;
    }
    
}
