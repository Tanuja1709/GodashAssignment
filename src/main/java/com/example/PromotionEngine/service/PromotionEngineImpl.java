package com.example.PromotionEngine.service;

import com.example.PromotionEngine.modal.Cart;
import com.example.PromotionEngine.modal.CartItem;
import com.example.PromotionEngine.promotion.Promotion;

import java.util.List;

public class PromotionEngineImpl implements PromotionEngine{
    private List<Promotion> promotions;

    public PromotionEngineImpl(List<Promotion> promotions) {
        this.promotions = promotions;
    }
    @Override
    public double calculateTotal(Cart cart) {
        double total = 0;

        for (Promotion promotion : promotions) {
            total += promotion.apply(cart);
        }

        for (CartItem item : cart.getItems()) {
            if (item.getQuantity() > 0) {
                total += item.getQuantity() * item.getSku().getUnitPrice();
            }
        }
        return total;
    }
}
