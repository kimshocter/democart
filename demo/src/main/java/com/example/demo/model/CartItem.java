//tinh toan gia tri gio hang
package com.example.demo.model;

import com.example.demo.entity.Product;

public class CartItem {
	private final Product product;
	private int quantity;
	private double subTotal;

	public CartItem(Product product) {
		this.product = product;
		this.quantity = 1;// tao so luong san pham
		this.subTotal = product.getPrice();// tinh gia tien cho san pham

	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubTotal() {
		subTotal = product.getPrice() * quantity;
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public Product getProduct() {
		return product;
	}

}
