package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dal.FournisseurDao;
import fr.diginamic.jdbc.dal.FournisseurJDBCDAO;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestInsertion {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3308/compta", "root", "Supstoov1981?")) {
            FournisseurDao fournisseurDAO = new FournisseurJDBCDAO(connection);
            Fournisseur fournisseur = new Fournisseur();
            fournisseur.setNom("Amazon");
            fournisseurDAO.insert(fournisseur);
            System.out.println("Fournisseur inséré avec ID : " + fournisseur.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
