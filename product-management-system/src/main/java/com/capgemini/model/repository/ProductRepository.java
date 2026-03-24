package com.capgemini.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.capgemini.model.entity.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
}