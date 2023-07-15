package com.demo.udemy.bouali.repository;

import com.demo.udemy.bouali.domain.Categorie;
import com.demo.udemy.bouali.domain.Produit;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "rest")
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    List<Produit> findAll();

    // Consulter les produits non pas par leur id
    // mais par un autre attribut non clé comme le nom

    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);

   // @Query("SELECT p FROM Produit p WHERE p.nomProduit like %?1 AND p.prixProduit > ?2")
  //  List<Produit> findByNomPrix(String nom, Double prix);

    @Query("SELECT p FROM Produit p WHERE p.nomProduit like %:nom AND p.prixProduit > :prix")
    List<Produit> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);

    @Query("SELECT p FROM Produit p WHERE p.categorie = ?1")
    List<Produit> findByCategorie (Categorie categorie);

    //Interroger les produits selon l'id de leur categorie
    List<Produit> findByCategorieIdCat(Long id);

    List<Produit> findByOrderByNomProduitAsc();

    @Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
    List<Produit> trierProduitsNomsPrix();

}
