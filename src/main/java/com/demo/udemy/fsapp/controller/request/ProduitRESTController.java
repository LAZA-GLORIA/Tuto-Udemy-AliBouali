package com.demo.udemy.fsapp.controller.request;

import com.demo.udemy.fsapp.domain.Produit;
import com.demo.udemy.fsapp.dto.ProduitDTO;
import com.demo.udemy.fsapp.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Trier tous les produits
// GET / http://localhost:8080/rest?sort=nomProduit,asc ou http://localhost:8080/rest?sort=nomProduit,desc
// GET / http://localhost:8080/rest?size=3&page1
// GET / http://localhost:8080/rest?size=3&page0&sort=prixProduit,asc
// GET / http://localhost:8080/rest/search Affiche la liste de toutes les URL possibles
@RestController
@RequestMapping("/rest") //Pour accéder aux méthodes et services de cette classe on doit taper dans l'url de notre site
@CrossOrigin // Je permet à tous les origines, les adresses de consommer ces webservices
public class ProduitRESTController {

    @Autowired
    ProduitService produitService; // J'ai besoin de consommer des services

    // Webservices permettant de consulter tous les produits
    @RequestMapping(value="/produits", method=RequestMethod.GET)
    List<ProduitDTO> getAllProduits() {
        return produitService.getAllProduits();
        //return produitService.findByOrderByNomProduitAsc();
    }


    //PathVariable : permet d'affecter l'id de l'url dans l'id en parametre de type Long
    // Webservices permettant de CONSULTER un produit via son id
    @RequestMapping(value="getone/{id}",method = RequestMethod.GET)
    public ProduitDTO getProduitById(@PathVariable("id") Long id) {
        return produitService.getProduit(id);
    }

    // On recupere un objet produit grace à l'anno requestBody
    // qui permet de le recuperer dans le corps de la requete
    // Webservices pour créer un produit
    @RequestMapping(value="createProduit/{id}", method = RequestMethod.POST)
    public ProduitDTO createProduit(@RequestBody ProduitDTO produitDTO) {
        return produitService.saveProduit(produitDTO);
    }

    @RequestMapping(value="updateProduit/{id}", method = RequestMethod.PUT)
    public ProduitDTO updateProduit(@RequestBody ProduitDTO produitDTO) {
        return produitService.updateProduit(produitDTO);
    }

    @RequestMapping(value="deleteProduit/{id}",method = RequestMethod.DELETE)
    public void deleteProduit(@PathVariable("id") Long id)
    {
        produitService.deleteProduitById(id);
    }

    // Webservice permettant de retourner un produit ayant une categorie donnée
    @RequestMapping(value="/findByCategorieIdCat/{idCat}",method = RequestMethod.GET)
    public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
        return produitService.findByCategorieIdCat(idCat);
    }

    @RequestMapping(value="getNomProduitsContains/{nom}",method = RequestMethod.GET)
    public List<Produit> getProduitByNom(@PathVariable("nom") String nom) {
        return produitService.findByNomProduitContains(nom);
    }

}
