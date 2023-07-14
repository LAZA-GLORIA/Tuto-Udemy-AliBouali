package com.demo.udemy.bouali.repository;

import com.demo.udemy.bouali.domain.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProduitRepository extends JpaRepository<Produit, Long> {

    // Consulter les produits non pas par leur id
    // mais par un autre attribut non clé comme le nom

    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);
}
