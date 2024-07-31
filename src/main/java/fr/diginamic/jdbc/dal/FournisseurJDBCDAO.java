package fr.diginamic.jdbc.dal;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FournisseurJDBCDAO implements FournisseurDao {
    private Connection connection;

    public FournisseurJDBCDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Fournisseur fournisseur) throws SQLException {
        String query = "INSERT INTO fournisseur (nom) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, fournisseur.getNom());
            stmt.executeUpdate();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    fournisseur.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    @Override
    public void update(Fournisseur fournisseur) throws SQLException {
        String query = "UPDATE fournisseur SET nom = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, fournisseur.getNom());
            stmt.setInt(2, fournisseur.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public Fournisseur selectById(int id) throws SQLException {
        String query = "SELECT id, nom FROM fournisseur WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Fournisseur(rs.getInt("id"), rs.getString("nom"));
                }
            }
        }
        return null; // Ou lancez une exception si vous préférez
    }

    @Override
    public List<Fournisseur> selectAll() throws SQLException {
        String query = "SELECT id, nom FROM fournisseur";
        List<Fournisseur> fournisseurs = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                fournisseurs.add(new Fournisseur(rs.getInt("id"), rs.getString("nom")));
            }
        }
        return fournisseurs;
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM fournisseur WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
