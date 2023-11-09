package com.crud.app.crudjavafx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector
{
    static Connection connector;
   final public Connection Connect()
    {
        try {
            Class.forName("org.postgresql.Driver");
            connector = DriverManager.getConnection("jdbc:postgresql://localhost/university","postgres","password");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connector;
    }
}
