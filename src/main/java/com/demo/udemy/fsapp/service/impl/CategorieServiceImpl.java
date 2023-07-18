package com.demo.udemy.fsapp.service.impl;

import com.demo.udemy.fsapp.domain.Categorie;
import com.demo.udemy.fsapp.domain.Produit;
import com.demo.udemy.fsapp.repository.CategorieRepository;
import com.demo.udemy.fsapp.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public Categorie saveCategorie(Categorie c) {
        return categorieRepository.save(c);
    }

    @Override
    public Categorie updateCategorie(Categorie c) {
        return categorieRepository.save(c);
    }

    @Override
    public void deleteCategorie(Categorie c) {
        categorieRepository.delete(c);
    }

    @Override
    public void deleteCategorieById(Long id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public Categorie getCategorie(Long id) {
        return null;
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public List<Categorie> findByNomCat(String nom) {
        return categorieRepository.findByNomCat(nom);
    }

    @Override
    public List<Categorie> findByNomCatContains(String nom) {
        return categorieRepository.findByNomCatContains(nom);
    }

    @Override
    public List<Produit> findAllProduitsInCategorieById(Long id) {
        Categorie categorie = categorieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categorie non trouvée"));
        return categorie.getProduits();
    }

}
