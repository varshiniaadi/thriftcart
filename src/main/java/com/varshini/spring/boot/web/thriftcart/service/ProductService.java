package com.varshini.spring.boot.web.thriftcart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.varshini.spring.boot.web.thriftcart.model.Product;


public interface ProductService {
	 
	    Product createProduct(Product product);

	    List<Product> getAllProducts();

	    Product getProductById(Long id);

	    Product updateProduct(Long id, Product product);

	    void deleteProduct(Long id);
	


}
