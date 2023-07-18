package com.demo.udemy.fsapp.service;

import com.demo.udemy.fsapp.domain.Categorie;
import com.demo.udemy.fsapp.domain.Produit;

import java.util.List;

public interface CategorieService {
    Categorie saveCategorie(Categorie c);
    Categorie updateCategorie(Categorie c);
    void deleteCategorie(Categorie c);
    void deleteCategorieById(Long id);
    Categorie getCategorie(Long id);
    List<Categorie> getAllCategories();

    List<Categorie> findByNomCat(String nom);

    List<Categorie> findByNomCatContains(String nom);

    List<Produit> findAllProduitsInCategorieById(Long id);
}
