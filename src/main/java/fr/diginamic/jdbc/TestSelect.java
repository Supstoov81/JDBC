package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dal.FournisseurDao;
import fr.diginamic.jdbc.dal.FournisseurJDBCDAO;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class TestSelect {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3308/compta", "root", "Supstoov1981?")) {
            FournisseurDao fournisseurDAO = new FournisseurJDBCDAO(connection);
            Fournisseur fournisseur = fournisseurDAO.selectById(1);
            System.out.println("Fournisseur sélectionné : " + fournisseur);

            List<Fournisseur> fournisseurs = fournisseurDAO.selectAll();
            for (Fournisseur f : fournisseurs) {
                System.out.println(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
