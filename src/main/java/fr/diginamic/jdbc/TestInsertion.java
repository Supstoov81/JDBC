package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {

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
        int nb = str.executeUpdate("INSERT INTO fournisseur (Nom) values ('La Maison de la Peinture')");
        System.out.println(nb);
        str.close();
        connection.close();
    }
}