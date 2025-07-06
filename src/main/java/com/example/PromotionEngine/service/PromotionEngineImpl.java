package com.example.PromotionEngine.service;

import com.example.PromotionEngine.modal.Cart;
import com.example.PromotionEngine.promotion.Promotion;

import java.util.List;

public class PromotionEngineImpl implements PromotionEngine{
    private List<Promotion> promotions;

    public PromotionEngineImpl(List<Promotion> promotions) {
        this.promotions = promotions;
    }
    @Override
    public double calculateTotal(Cart cart) {
        return 0;
    }
}
