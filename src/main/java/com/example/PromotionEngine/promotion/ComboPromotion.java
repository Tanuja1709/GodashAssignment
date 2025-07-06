package com.example.PromotionEngine.promotion;

import com.example.PromotionEngine.modal.Cart;
import com.example.PromotionEngine.modal.SKU;

public class ComboPromotion implements Promotion{

    private SKU sku1;
    private SKU sku2;
    private double comboPrice;

    public ComboPromotion(SKU sku1, SKU sku2, double comboPrice) {
        this.sku1 = sku1;
        this.sku2 = sku2;
        this.comboPrice = comboPrice;
    }

    @Override
    public double apply(Cart cart) {
        return 0;
    }
}
