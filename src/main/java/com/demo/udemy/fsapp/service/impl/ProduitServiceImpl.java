package com.demo.udemy.fsapp.service.impl;

import com.demo.udemy.fsapp.domain.Categorie;
import com.demo.udemy.fsapp.domain.Produit;
import com.demo.udemy.fsapp.dto.ProduitDTO;
import com.demo.udemy.fsapp.repository.ProduitRepository;
import com.demo.udemy.fsapp.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    ProduitRepository produitRepository;

    @Override
    public ProduitDTO saveProduit(Produit p) {
        return convertEntityToDto(produitRepository.save(p));
        // la methode save de repository retourne une entite
        // Donc on convertit en DTO
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
    public ProduitDTO getProduit(Long id) {
        return convertEntityToDto(produitRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Produit non trouvé")
                ));
    }

    @Override // Programmation Fonctionnelle en java
    public List<ProduitDTO> getAllProduits() {
        return  produitRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        // J'ai une liste d'entité- et avec Java Functional Programming
        // Je vais convertir en stream c'est un mode abstrait qui permet de faire des changements
        // des manipulations sur les éléments de ma liste
        // et grâce à map je peux appliquer ma fonction convertToEntity à tous les élements de ma liste ou ma stream
        // retournée par findAll
        // this:: veut dire que je reference ma méthode que je viens de créer

        // Après avoir traité les streams je reviens à ma liste
    }

    @Override
    public List<Produit> findByNomProduit(String nom) {
        return produitRepository.findByNomProduit(nom);
    }

    @Override
    public List<Produit> findByNomProduitContains(String nom) {
        return produitRepository.findByNomProduitContains(nom);
    }

    @Override
    public List<Produit> findByNomPrix(String nom, Double prix) {
        return produitRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<Produit> findByCategorie(Categorie categorie) {
        return produitRepository.findByCategorie(categorie);
    }

    @Override
    public List<Produit> findByCategorieIdCat(Long id) {
        return produitRepository.findByCategorieIdCat(id);
    }

    @Override
    public List<Produit> findByOrderByNomProduitAsc() {
        return produitRepository.findByOrderByNomProduitAsc();
    }

    @Override
    public List<Produit> trierProduitsNomsPrix() {
        return produitRepository.trierProduitsNomsPrix();
    }

    @Override
    public ProduitDTO convertEntityToDto(Produit p) {
        // On instancie un nouveau produit DTO et on le remplit avec les attributs de p
       /* ProduitDTO produitDTO = new ProduitDTO();
        produitDTO.setIdProduit(p.getIdProduit());
        produitDTO.setNomProduit(p.getNomProduit());
        produitDTO.setPrixProduit(p.getPrixProduit());
        produitDTO.setCategorie(p.getCategorie());
        return produitDTO; */

        // Design pattern Builder qui nous offre des méthodes et pour chaque attribut j'aurais des méthodes
        // Je recupere les valeurs des attributs à partir du produit p
        // après avoir donné les valeurs je lance la méthode build
        return ProduitDTO.builder()
                .idProduit(p.getIdProduit())
                .nomProduit(p.getNomProduit())
                .prixProduit(p.getPrixProduit())
                .categorie(p.getCategorie())
                .build();

    }

}
