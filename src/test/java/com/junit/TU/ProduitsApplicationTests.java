package com.junit.TU;

import com.demo.udemy.fsapp.DemoUdemySpringFullStackApplication;
import com.demo.udemy.fsapp.domain.Categorie;
import com.demo.udemy.fsapp.domain.Produit;
import com.demo.udemy.fsapp.repository.CategorieRepository;
import com.demo.udemy.fsapp.repository.ProduitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest(classes = DemoUdemySpringFullStackApplication.class)
class ProduitsApplicationTests {

    // L'injection de dépendance ou Inversion de controle Ioc
    // avec l'anno Autowired
    // c'est quand on veut que Spring injecte dans
    // une variable un objet qui implemente de l'interface
    // ici ProduitRepository
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @DisplayName(value = "Test de création de produits")
    @Test
    public void testCreateProduit() {
        Categorie categorie = new Categorie();
        categorie.setNomCat("Pour pgrammeurs informatiques");
        categorie.setDescriptionCat("IT");

        Produit prod = new Produit("PC Dell",2200.500, new Date(), categorie);
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
        Produit p = produitRepository.findById(12L)
                .orElseThrow(() -> new RuntimeException(("Produit non trouvé")));

        if (p.getCategorie() != null) {
            Categorie categorie = p.getCategorie();
            //Mise à jour categorie
            categorie.setNomCat("Equipement");
            categorie.setDescriptionCat("Equipements informatiques");
        } else {
            // On récupère la catégorie existante du produit ou on en crée une nouvelle
            Categorie categorie = categorieRepository.findById(3L)
                    .orElseGet(() -> {
                        Categorie newCategorie = new Categorie();
                        newCategorie.setNomCat("Equipement");
                        newCategorie.setDescriptionCat("Equipements informatiques");
                        return categorieRepository.save(newCategorie);
                    });

            // Assigner la nouvelle catégorie au produit
            p.setCategorie(categorie);
        }

        //Mise à jour nom
      //  p.setNomProduit("clavier ergo");

        //Mise à jour prix
       // p.setPrixProduit(55.50);


        produitRepository.save(p);
        System.out.println("Produit mis à jour :" + p);
        System.out.println("Ctagorie du produit :" + p.getCategorie());
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
