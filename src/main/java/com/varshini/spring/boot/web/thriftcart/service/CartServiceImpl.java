
package com.varshini.spring.boot.web.thriftcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varshini.spring.boot.web.thriftcart.model.CartItem;
import com.varshini.spring.boot.web.thriftcart.model.Product;
import com.varshini.spring.boot.web.thriftcart.repository.CartRepository;
import com.varshini.spring.boot.web.thriftcart.repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public CartItem addToCart(Long productId) {
    	System.out.println("Entered service");
        
        // Fetch the product by productId
        Product product = productRepository.findById(productId).orElse(null);

        if (product == null) {
            // Product not found, return null or handle the error accordingly
            return null;
        }

        if (product.getRating().getCount() > 0) {
        // Check if the product is already in the user's cart
        CartItem cartItem = cartRepository.findByProduct(product);

        if (cartItem == null) {
            // If not in the cart, create a new CartItem
            cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
            cartItem.setTotal(product.getPrice()); 
            // Update the stock count
            product.getRating().setCount(product.getRating().getCount() -1);
        } else {
            // If already in the cart, increase the quantity and update the total
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            cartItem.setTotal(cartItem.getTotal() + product.getPrice());
            // Update the stock count
            product.getRating().setCount(product.getRating().getCount() - 1);
        }

        // Save or update the cart item
        return cartRepository.save(cartItem);
        } else {
            // Stock is not available, return null or handle the error accordingly
            return null;
        }
    
    }
    

    @Override
    public void removeFromCart(Long productId) {
        // Fetch the product by productId
        Product product = productRepository.findById(productId).orElse(null);

        if (product != null) {
            // Check if the product is in the user's cart
            CartItem cartItem = cartRepository.findByProduct(product);

            if (cartItem != null) {
                // If found in the cart, decrease the quantity and update the total
                int newQuantity = cartItem.getQuantity() - 1;
                if (newQuantity <= 0) {
                    // If the quantity becomes zero, remove it from the cart
                    cartRepository.delete(cartItem);
                    
                 // Increase the stock count
                    product.getRating().setCount(product.getRating().getCount() + 1);
                    productRepository.save(product);
                } else {
                    cartItem.setQuantity(newQuantity);
                    cartItem.setTotal(cartItem.getTotal() - product.getPrice());
                    cartRepository.save(cartItem);
                    
                 // Increase the stock count
                    product.getRating().setCount(product.getRating().getCount() + 1);
                    productRepository.save(product);
                }
            }
        }
    }
    @Override
    public void deleteProduct(Long productId) {
        // Find the product in the cart by productId
        CartItem cartItem = cartRepository.findByProductId(productId);

        if (cartItem != null) {
            // If found in the cart, delete it
            cartRepository.delete(cartItem);
        }
    }
    @Override
    public void removeAllItems() {
        // Delete all records from the CartItem table
        cartRepository.deleteAll();
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return cartRepository.findAll();
    }

    @Override
    public CartItem getCartItemById(Long cartItemId) {
        return cartRepository.findById(cartItemId).orElse(null);
    }


	@Override
	public CartItem getCartItemByPId(Long product_id) {
	
		return cartRepository.findByProductId(product_id);
	}

	@Override
	public double calculateTotalSum() {
	    List<CartItem> cartItems = cartRepository.findAll();
	    double totalSum = cartItems.stream().mapToDouble(CartItem::getTotal).sum();
	    return totalSum;
	}


	
    

}

