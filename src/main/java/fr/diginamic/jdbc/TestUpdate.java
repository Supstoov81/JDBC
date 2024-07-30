package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestUpdate {

    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD ;

    static{
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_USER= bundle.getString("db.user");
        DB_PWD = bundle.getString("db.pwd");

    }

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
        System.out.println(connection);
        Statement str = connection.createStatement();
        int nbUpdate = str.executeUpdate("UPDATE fournisseur set Nom = 'Maison blanche'  where ID =4");
        System.out.println(nbUpdate);
        str.close();
        connection.close();
    }
}