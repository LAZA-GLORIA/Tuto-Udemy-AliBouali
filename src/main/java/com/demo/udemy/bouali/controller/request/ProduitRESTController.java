package com.demo.udemy.bouali.controller.request;

import com.demo.udemy.bouali.domain.Produit;
import com.demo.udemy.bouali.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api") //Pour accéder aux méthodes et services de cette classe on doit taper dans l'url de notre site
@CrossOrigin // Je permet à tous les origines, les adresses de consommer ces webservices
public class ProduitRESTController {

    @Autowired
    ProduitService produitService; // J'ai besoin de consommer des services

    // Webservices permettant de consulter tous les produits
    @RequestMapping(value="produits", method=RequestMethod.GET)
    List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }


    //PathVariable : permet d'affecter l'id de l'url dans l'id en parametre de type Long
    // Webservices permettant de CONSULTER un produit via son id
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Produit getProduitById(@PathVariable("id") Long id) {
        return produitService.getProduit(id);
    }

    // On recupere un objet produit grace à l'anno requestBody
    // qui permet de le recuperer dans le corps de la requete
    // Webservices pour créer un produit
    @RequestMapping(method = RequestMethod.POST)
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Produit updateProduit(@RequestBody Produit produit) {
        return produitService.updateProduit(produit);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteProduit(@PathVariable("id") Long id)
    {
        produitService.deleteProduitById(id);
    }

    // Webservice permettant de retourner un produit ayant une categorie donnée
    @RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
    public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
        return produitService.findByCategorieIdCat(idCat);
    }

}
