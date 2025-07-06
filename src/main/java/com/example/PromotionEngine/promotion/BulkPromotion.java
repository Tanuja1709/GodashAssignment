package com.example.PromotionEngine.promotion;

import com.example.PromotionEngine.modal.Cart;
import com.example.PromotionEngine.modal.CartItem;
import com.example.PromotionEngine.modal.SKU;

public class BulkPromotion implements Promotion {
    private SKU sku;
    private int requiredQty;
    private double discountedPrice;

    public BulkPromotion(SKU sku, int requiredQty, double discountedPrice) {
        this.sku = sku;
        this.requiredQty = requiredQty;
        this.discountedPrice = discountedPrice;
    }


    @Override
    public double apply(Cart cart) {
        double total = 0;
        for (CartItem item : cart.getItems()) {
            if (item.getSku().equals(sku)) {
                int qty = item.getQuantity();
                int numOfDeals = qty / requiredQty;
                int remaining = qty % requiredQty;

                total += numOfDeals * discountedPrice + remaining * sku.getUnitPrice();
                item.setQuantity(0);
            }
        }
        return total;
    }

}
