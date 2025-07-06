package com.example.PromotionEngine.controller;

import com.example.PromotionEngine.modal.Cart;
import com.example.PromotionEngine.modal.SKU;
import com.example.PromotionEngine.modal.CartItem;
import com.example.PromotionEngine.promotion.BulkPromotion;
import com.example.PromotionEngine.promotion.ComboPromotion;
import com.example.PromotionEngine.service.PromotionEngineImpl;
import com.example.PromotionEngine.service.PromotionEngine;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final PromotionEngine promotionEngine;

    private final SKU A = new SKU("A", 50);
    private final SKU B = new SKU("B", 30);
    private final SKU C = new SKU("C", 20);
    private final SKU D = new SKU("D", 15);

    public CartController() {
        this.promotionEngine = new PromotionEngineImpl(Arrays.asList(
                new BulkPromotion(A, 3, 130),
                new BulkPromotion(B, 2, 45),
                new ComboPromotion(C, D, 30)
        ));
    }

    @PostMapping("/calculate")
    public double calculateTotal(@RequestBody List<CartItemRequest> cartItems) {
        List<CartItem> items = cartItems.stream()
                .map(req -> {
                    SKU sku = switch (req.getSkuId()) {
                        case "A" -> A;
                        case "B" -> B;
                        case "C" -> C;
                        case "D" -> D;
                        default -> throw new IllegalArgumentException("Unknown SKU: " + req.getSkuId());
                    };
                    return new CartItem(sku, req.getQuantity());
                })
                .toList();

        Cart cart = new Cart(items);
        return promotionEngine.calculateTotal(cart);
    }

    public static class CartItemRequest {
        private String skuId;
        private int quantity;

        public String getSkuId() { return skuId; }
        public void setSkuId(String skuId) { this.skuId = skuId; }

        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
    }
}
