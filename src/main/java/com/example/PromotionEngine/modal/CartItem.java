package com.example.PromotionEngine.modal;

public class CartItem {
    private SKU sku;
    private int quantity;

    public CartItem(SKU sku, int quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }

    public SKU getSku() { return sku; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
