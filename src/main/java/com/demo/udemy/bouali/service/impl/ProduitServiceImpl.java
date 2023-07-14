package com.demo.udemy.bouali.service.impl;

import com.demo.udemy.bouali.domain.Produit;
import com.demo.udemy.bouali.repository.ProduitRepository;
import com.demo.udemy.bouali.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    ProduitRepository produitRepository;

    @Override
    public Produit saveProduit(Produit p) {
        return produitRepository.save(p);
    }

    @Override
    public Produit updateProduit(Produit p) {
        return produitRepository.save(p);
    }

    @Override
    public void deleteProduit(Produit p) {
        produitRepository.delete(p);
    }

    @Override
    public void deleteProduitById(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public Produit getProduit(Long id) {
        return produitRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Produit non trouvé")
                );
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }
}
