package com.example.PromotionEngine.modal;

import java.util.List;

public class Cart {
    private List<CartItem> items;

    public Cart(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }
}
