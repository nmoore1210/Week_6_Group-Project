package com.promineo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {//Author Nathan Moore, Ryan Leyva, Jade Chung
    
    private final static String URL = "jdbc:mysql://localhost:3306/elementary_db";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "Hugooreo1210!";

    public static Connection connection;
    public static DBConnection instance;
    
    private DBConnection(Connection connection){
        this.connection = connection;
    }
    
    public static Connection getConnection(){
        if(instance == null){
            try{
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                instance = new DBConnection(connection);
                System.out.println("Connection successful.");
            }catch(SQLException e){
                e.printStackTrace();

            }
        }

        return DBConnection.connection;
    }
    
}
