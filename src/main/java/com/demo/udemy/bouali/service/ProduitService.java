package com.demo.udemy.bouali.service;

import com.demo.udemy.bouali.domain.Produit;

import java.util.List;

// Je declare mes methode dans l'interface et je l'implemente dans l'implementation
public interface ProduitService {
    Produit saveProduit(Produit p);
    Produit updateProduit(Produit p);
    void deleteProduit(Produit p);
    void deleteProduitById(Long id);
    Produit getProduit(Long id);
    List<Produit> getAllProduits();
}
