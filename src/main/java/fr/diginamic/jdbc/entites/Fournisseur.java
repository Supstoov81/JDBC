package fr.diginamic.jdbc.entites;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Fournisseur {

    private int id;
    private String nom;


    public Fournisseur(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Fournisseur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}


