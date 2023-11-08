package com.crud.app.crudjavafx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector
{
    static Connection conne;
    public Connection Connect()
    {
        try {
            Class.forName("org.postgresql.Driver");
            conne = DriverManager.getConnection("jdbc:postgresql://localhost/university","postgres","password");
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conne;
    }
}
