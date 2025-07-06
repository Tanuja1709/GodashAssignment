package com.example.PromotionEngine;

import com.example.PromotionEngine.modal.Cart;
import com.example.PromotionEngine.modal.CartItem
import com.example.PromotionEngine.modal.SKU;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PromotionEngineApplicationTests {
	private PromotionEngine promotionEngine;
	@BeforeEach
	public void setup() {
		SKU A = new SKU("A", 50);
		SKU B = new SKU("B", 30);
		SKU C = new SKU("C", 20);
		SKU D = new SKU("D", 15);

		promotionEngine = new PromotionEngineImpl(Arrays.asList(
				new BulkPromotion(A, 3, 130),
				new BulkPromotion(B, 2, 45),
				new ComboPromotion(C, D, 30)
		));
	}

	@Test
	public void testScenarioA() {
		Cart cart = new Cart(Arrays.asList(
				new CartItem(new SKU("A", 50), 1),
				new CartItem(new SKU("B", 30), 1),
				new CartItem(new SKU("C", 20), 1)
		));
		double total = promotionEngine.calculateTotal(cart);
		Assertions.assertEquals(100, total);
	}

	@Test
	public void testScenarioB() {
		Cart cart = new Cart(Arrays.asList(
				new CartItem(new SKU("A", 50), 5),
				new CartItem(new SKU("B", 30), 5),
				new CartItem(new SKU("C", 20), 1)
		));
		double total = promotionEngine.calculateTotal(cart);
		Assertions.assertEquals(370, total);
	}

	@Test
	public void testScenarioC() {
		Cart cart = new Cart(Arrays.asList(
				new CartItem(new SKU("A", 50), 3),
				new CartItem(new SKU("B", 30), 5),
				new CartItem(new SKU("C", 20), 1),
				new CartItem(new SKU("D", 15), 1)
		));
		double total = promotionEngine.calculateTotal(cart);
		Assertions.assertEquals(280, total);
	}
}
