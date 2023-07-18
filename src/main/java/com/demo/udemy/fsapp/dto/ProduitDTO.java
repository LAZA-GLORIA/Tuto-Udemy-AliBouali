package com.demo.udemy.fsapp.dto;

import com.demo.udemy.fsapp.domain.Categorie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //Permet d'utiliser le Design Pattern Builder pour construire des objets complexes
// Pour eviter d'instancier des objets avec new qui est assez lourd à faire
public class ProduitDTO {
    private Long idProduit;
    private String nomProduit;
    private Double prixProduit;
    private Date dateCreation;
    private String nomCategorie;
    //private Categorie categorie;
}
