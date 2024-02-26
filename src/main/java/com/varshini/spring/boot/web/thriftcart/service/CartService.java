package com.varshini.spring.boot.web.thriftcart.service;




import java.util.List;

import com.varshini.spring.boot.web.thriftcart.model.CartItem;
import com.varshini.spring.boot.web.thriftcart.model.Product;

public interface CartService {

    CartItem addToCart(Long productId);

    void removeFromCart(Long productId);

	void deleteProduct(Long productId);

	void removeAllItems();

	List<CartItem> getAllCartItems();

	CartItem getCartItemById(Long cartItemId);

	CartItem getCartItemByPId(Long product_id);

	double calculateTotalSum();
}
