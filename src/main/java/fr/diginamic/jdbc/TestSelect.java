package fr.diginamic.jdbc;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TestSelect {
    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_USER = bundle.getString("db.user");
        DB_PWD = bundle.getString("db.pwd");

    }
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
        System.out.println(connection);
        Statement str = connection.createStatement();
        ResultSet curseur = str.executeQuery("Select * from fournisseur");
        ArrayList<Fournisseur> fournisseurList = new ArrayList<>();
        while(curseur.next()){
            Integer id = curseur.getInt("ID");
            String nom = curseur.getString("Nom");
            Fournisseur fournisseur = new Fournisseur(id, nom);
            fournisseurList.add(fournisseur);
            System.out.println(fournisseur);
        }
        curseur.close();
        str.close();
        connection.close();
    }
}


