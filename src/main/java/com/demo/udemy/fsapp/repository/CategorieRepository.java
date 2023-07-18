package com.demo.udemy.fsapp.repository;

import com.demo.udemy.fsapp.domain.Categorie;
import com.demo.udemy.fsapp.domain.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "restCategories")
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

    List<Categorie> findAll();
    List<Categorie> findByNomCat(String nom);

    List<Categorie> findByNomCatContains(String nom);

    @Query("SELECT c.produits FROM Categorie c WHERE c.idCat = :id")
    List<Produit> findAllProduitsInCategorieById(@Param("id") Long id);


}
