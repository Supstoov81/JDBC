package fr.diginamic.jdbc.dal;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public interface FournisseurDao {
    void insert(Fournisseur fournisseur) throws SQLException;
    void update(Fournisseur fournisseur) throws SQLException;
    Fournisseur selectById(int id) throws SQLException;
    List<Fournisseur> selectAll() throws SQLException;
    void delete(int id) throws SQLException;
}
