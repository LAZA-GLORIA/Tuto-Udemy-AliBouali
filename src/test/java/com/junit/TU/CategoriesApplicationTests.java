package com.junit.TU;

import com.demo.udemy.fsapp.DemoUdemySpringFullStackApplication;
import com.demo.udemy.fsapp.domain.Categorie;
import com.demo.udemy.fsapp.domain.Produit;
import com.demo.udemy.fsapp.repository.CategorieRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = DemoUdemySpringFullStackApplication.class)
public class CategoriesApplicationTests {

    @Autowired
    private CategorieRepository categorieRepository;

    @DisplayName(value = "Test pour créer une categorie")
    @Test
    public void testCreateCategorie() {
        Categorie cat = new Categorie(1L, "Logiciels", "Logiciel pour installation Java");
        categorieRepository.save(cat);
    }

    @DisplayName(value = "Test pour trouver une categorie par son ID")
    @Test
    public void testFindCategorie() {
        Categorie cat = categorieRepository.findById(3L)
                .orElseThrow(() -> new RuntimeException("Categorie non trouvé !"));
        System.out.println(cat);
    }

    @Test
    public void testListerAllCategories() {
        List<Categorie> cats = categorieRepository.findAll();
        for (Categorie c : cats) {
            System.out.println("Voici la liste de toutes les categorie"+ c);
        }
    }

    @Test
    @Transactional
    public void testerAllProduitsInCategorieById() {
        Categorie cat = categorieRepository.findById(3L)
                .orElseThrow(() -> new RuntimeException("Categorie non trouvée !"));


        //List<Produit> produits = cat.getProduits();
        //System.out.println("Produits attendus: " + produits);

        List<Produit> resultProduitsInCategorie = categorieRepository.findAllProduitsInCategorieById(3L);
        System.out.println("Produits attendus DEUX : " + resultProduitsInCategorie);

    }
}