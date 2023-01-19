package com.springboot.aop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.aop.model.Product;



public interface ProductRepository extends JpaRepository<Product, Integer>{

}
