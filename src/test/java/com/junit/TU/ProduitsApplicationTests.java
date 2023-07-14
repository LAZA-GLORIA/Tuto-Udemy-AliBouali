package com.junit.TU;

import com.demo.udemy.bouali.DemoUdemyBoualiApplication;
import com.demo.udemy.bouali.domain.Categorie;
import com.demo.udemy.bouali.domain.Produit;
import com.demo.udemy.bouali.repository.ProduitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest(classes = DemoUdemyBoualiApplication.class)
class ProduitsApplicationTests {

    // L'injection de dépendance ou Inversion de controle Ioc
    // avec l'anno Autowired
    // c'est quand on veut que Spring injecte dans
    // une variable un objet qui implemente de l'interface
    // ici ProduitRepository
    @Autowired
    private ProduitRepository produitRepository;

    @DisplayName(value = "Test de création de produits")
    @Test
    public void testCreateProduit() {
        Produit prod = new Produit("PC Dell",2200.500, new Date());
        // grace à l'ioc on a acces aux méthodes
        produitRepository.save(prod);
    }

    @Test
    public void testFindProduit() {
        Produit p = produitRepository.findById(3L)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        System.out.println(p);
    }

    @Test
    public void testUpdateProduit() {
        Produit p = produitRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException(("Produit non trouvé")));
        p.setPrixProduit(1000.0);
        produitRepository.save(p);
    }

    @Test
    public void testDeleteProduit() {
        produitRepository.deleteById(1L);;
    }

    @Test
    public void testListerTousProduits() {
        List<Produit> prods = produitRepository.findAll();
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByNomProduit() {
        List<Produit> prods = produitRepository.findByNomProduit("PC Dell");
        System.out.println(prods);
    }

    @Test
    public void testFindByNomProduitContains() {
        List<Produit> prods = produitRepository.findByNomProduitContains("E");
        System.out.println(prods);
    }

    @Test
    public void testFindByNomPrix() {
        List<Produit> prods = produitRepository.findByNomPrix("PC Dell", 1000.0);
        for (Produit p : prods) {
            System.out.println(prods);
        }
    }

    @Test
    public void testfindByCategorie()
    {
        Categorie cat = new Categorie();
        cat.setIdCat(1L);
        List<Produit> prods = produitRepository.findByCategorie(cat);
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

    @Test
    public void findByCategorieIdCat()
    {
        List<Produit> prods = produitRepository.findByCategorieIdCat(2L);
        for (Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void testfindByOrderByNomProduitAsc() {
        List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

    @Test
    public void testTrierProduitsNomsPrix()
    {
        List<Produit> prods = produitRepository.trierProduitsNomsPrix();
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }



}
