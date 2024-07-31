package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dal.FournisseurDao;
import fr.diginamic.jdbc.dal.FournisseurJDBCDAO;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestUpdate {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3308/compta", "root", "Supstoov1981?")) {
            FournisseurDao fournisseurDAO = new FournisseurJDBCDAO(connection);
            Fournisseur fournisseur = new Fournisseur(1, "La française des jeux");
            fournisseurDAO.update(fournisseur);
            System.out.println("Fournisseur mis à jour : " + fournisseur);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
