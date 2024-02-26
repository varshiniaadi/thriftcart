package com.varshini.spring.boot.web.thriftcart.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.varshini.spring.boot.web.thriftcart.model.CartItem;
import com.varshini.spring.boot.web.thriftcart.service.CartService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    
    @GetMapping
    public List<CartItem> getAllCartItems() {
        return cartService.getAllCartItems();
    }

    @GetMapping("/{cartItemId}")
    public CartItem getCartItemById(@PathVariable Long cartItemId) {
        return cartService.getCartItemById(cartItemId);
    }
    @GetMapping("/pid/{product_id}")
    public CartItem getCartItemByPId(@PathVariable Long product_id) {
    	System.out.println("Entered controller"+product_id);
        return cartService.getCartItemByPId(product_id);
    }

    @PostMapping("/add/{productId}")
    public CartItem addToCart(@PathVariable Long productId) {
        return cartService.addToCart(productId);
    }

    @PostMapping("/remove/{productId}")
    public void removeFromCart(@PathVariable Long productId) {
        cartService.removeFromCart(productId);
    }
    
    @DeleteMapping("/delete/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        cartService.deleteProduct(productId);
    }
    
    @DeleteMapping("/removeAll")
    public void removeAllItems() {
        cartService.removeAllItems();
    }
    
    @GetMapping("/cart/totalSum")
    public double getCartTotalSum() {
        double totalSum = cartService.calculateTotalSum();
        return totalSum;
    }

   

}

