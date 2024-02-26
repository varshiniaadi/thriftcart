
package com.varshini.spring.boot.web.thriftcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.varshini.spring.boot.web.thriftcart.model.CartItem;
import com.varshini.spring.boot.web.thriftcart.model.Product;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    // You can define custom query methods here if needed.
	CartItem findByProduct(Product product);

	CartItem findByProductId(Long productId);


}

