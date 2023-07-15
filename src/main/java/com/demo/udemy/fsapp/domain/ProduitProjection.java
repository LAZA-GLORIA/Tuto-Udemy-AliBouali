package com.demo.udemy.fsapp.domain;

import org.springframework.data.rest.core.config.Projection;

// GET / http://localhost:8080/rest?projection=nomProduit
@Projection(name="nomProduit", types = { Produit.class })
public interface ProduitProjection {
    public String getNomProduit();
}
