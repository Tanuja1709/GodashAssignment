package com.example.PromotionEngine.promotion;

import com.example.PromotionEngine.modal.Cart;

public interface Promotion {
    double apply(Cart cart);
}
