package com.example.PromotionEngine.promotion;

import com.example.PromotionEngine.modal.Cart;
import com.example.PromotionEngine.modal.CartItem;
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
        CartItem item1 = null, item2 = null;

        for (CartItem item : cart.getItems()) {
            if (item.getSku().equals(sku1)) item1 = item;
            if (item.getSku().equals(sku2)) item2 = item;
        }

        if (item1 == null || item2 == null) return 0;

        int combos = Math.min(item1.getQuantity(), item2.getQuantity());
        double total = combos * comboPrice;

        item1.setQuantity(item1.getQuantity() - combos);
        item2.setQuantity(item2.getQuantity() - combos);

        return total;
    }
}
