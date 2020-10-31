// gio hang
package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;


import com.example.demo.entity.Product;

public class Cart {
	private final List<CartItem> items;
	private double total;

	public Cart() {
		items = new ArrayList<CartItem>();
		total = 0;// gan tong tien bang 0
	}

	// kiem tra san pham trong gio hang
	public CartItem getItem(Product p) {
		for (CartItem item : items) {
			if (item.getProduct().getId() == p.getId())// co ton tai item
			{
				return item;
			}

		}
		return null;// khong ton tai item
	}

	// lay ve tat ca item
	public List<CartItem> geCartItems() {
		return items;
	}

	// lay item theo so luong
	public int getIemCount() {
		return items.size();
	}

	// them item theo so luong
	public void addItem(Product p, int quantity) {
		CartItem item = getItem(p);
		if (item != null) {
			item.setQuantity(item.getQuantity() + quantity);// so luong item cu + so luong item moi
		} else // neu chua ton tai item
		{
			item = new CartItem(p); // tao moi item
			item.setQuantity(quantity); // set so luong item
			items.add(item); // them vao list cac item
		}
	}

	// them 1 item
	public void addItem(CartItem item) {
		addItem(item.getProduct(), item.getQuantity());
	}

	// update item
	public void updateItem(Product p, int quantity) {
		CartItem item = getItem(p); // lay ve item can update
		if (item != null) {
			item.setQuantity(quantity);
		}
	}

	// xoa item
	public void removeItem(Product p) {
		CartItem item = getItem(p);
		if (item != null) {
			items.remove(item);
		}
	}

	// xoa toan bo item
	public void clearAll() {
		items.clear();
		total = 0;// gan tong tien bang 0
	}

	// kiem tra gio hang null or not null
	public boolean cartEmpty() {
		return items.isEmpty();
	}

	// lay ve tong tien
	public double getTotal() {
		total = 0;
		for (CartItem item : items) {
			total = +item.getSubTotal();
		}
		return total;

	}
}
