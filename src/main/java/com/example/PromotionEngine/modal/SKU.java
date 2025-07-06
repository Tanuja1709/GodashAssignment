package com.example.PromotionEngine.modal;

public class SKU {
    private String id;
    private double unitPrice;

    public SKU(String id, double unitPrice) {
        this.id = id;
        this.unitPrice = unitPrice;
    }

    public String getId() { return id; }
    public double getUnitPrice() { return unitPrice; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SKU)) return false;
        SKU sku = (SKU) o;
        return id.equals(sku.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
