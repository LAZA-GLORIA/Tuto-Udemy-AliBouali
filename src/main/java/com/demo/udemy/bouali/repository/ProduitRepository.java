package com.demo.udemy.bouali.repository;

import com.demo.udemy.bouali.domain.Produit;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
