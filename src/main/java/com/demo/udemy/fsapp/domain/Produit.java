package com.demo.udemy.fsapp.domain;

import jakarta.persistence.*;

import java.util.Date;

// Jakarta à partir de Spring3 sinon c'est javax
// Entity pour les objets qui seront persistés en BDD
// Si je mets pas le nom de la colonne ce sera Produit
// Pour chaque entite que je vais creer je vais creer son interface repository
//Repository permet de modifier, enregistrer, supprimer mes entites au niveau de la BDD

@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdProduit;
    private String nomProduit;
    private Double prixProduit;
    private Date dateCreation;

    @ManyToOne
    private Categorie categorie;

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Produit() {
        super();
    }

    public Produit(String nomProduit, Double prixProduit, Date dateCreation, Categorie categorie) {
        super();
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.dateCreation = dateCreation;
        this.categorie = categorie;
    }

    public Long getIdProduit() {
        return IdProduit;
    }

    public void setIdProduit(Long idProduit) {
        IdProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public Double getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(Double prixProduit) {
        this.prixProduit = prixProduit;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "IdProduit=" + IdProduit +
                ", nomProduit='" + nomProduit + '\'' +
                ", prixProduit=" + prixProduit +
                ", dateCreation=" + dateCreation +
                '}';
    }
}
