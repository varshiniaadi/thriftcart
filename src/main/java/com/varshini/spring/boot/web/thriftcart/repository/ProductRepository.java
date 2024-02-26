package com.varshini.spring.boot.web.thriftcart.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.varshini.spring.boot.web.thriftcart.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
