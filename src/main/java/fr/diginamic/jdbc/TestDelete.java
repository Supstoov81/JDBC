package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dal.FournisseurDao;
import fr.diginamic.jdbc.dal.FournisseurJDBCDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDelete {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3308/compta", "root", "Supstoov1981?")) {
            FournisseurDao fournisseurDAO = new FournisseurJDBCDAO(connection);
            fournisseurDAO.delete(5);
            System.out.println("Fournisseur avec ID 5 supprimé");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
