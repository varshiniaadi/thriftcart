package com.varshini.spring.boot.web.thriftcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.varshini.spring.boot.web.thriftcart.model.Product;
import com.varshini.spring.boot.web.thriftcart.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	 @Autowired
	    private ProductRepository productRepository;

	    @Override
	    public Product createProduct(Product product) {
	        return productRepository.save(product);
	    }

	    @Override
	    public List<Product> getAllProducts() {
	    	 //return productRepository.findAll();
	        return productRepository.findAll(Sort.by(Sort.Order.asc("id")));
	    }

	    @Override
	    public Product getProductById(Long id) {
	        return productRepository.findById(id).orElse(null);
	    }

	    @Override
	    public Product updateProduct(Long id, Product product) {
	        if (productRepository.existsById(id)) {
	            product.setId(id);
	            return productRepository.save(product);
	        }
	        return null;
	    }

	    @Override
	    public void deleteProduct(Long id) {
	        productRepository.deleteById(id);
	    }

}
