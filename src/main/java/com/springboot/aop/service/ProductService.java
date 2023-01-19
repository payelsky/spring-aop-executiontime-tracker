package com.springboot.aop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.aop.advice.TrackExecutionTime;
import com.springboot.aop.model.Product;
import com.springboot.aop.repository.ProductRepository;



@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@PostConstruct
	public void initDB() {
		List<Product> list=new ArrayList<>();
		for(int i=1;i<=10000;i++) {
			list.add(new Product(i, "product"+i, new Random().nextInt(2000)));
		}
		repository.saveAll(list);
	}
	
	@TrackExecutionTime
	public List<Product> addProduct(List<Product> products) {
		return repository.saveAll(products);
	}

	@TrackExecutionTime
	public List<Product> findAllProducts() {
		return repository.findAll();
	}

}
