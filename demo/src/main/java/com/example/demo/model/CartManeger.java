// gio hang
package com.example.demo.model;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class CartManeger {
	private static final String SESSION_STRING_SHOPPING_CART = "gioHang";
	//kiem tra ton tai
	public Cart getCart(HttpSession session) {
		Cart cart = (Cart) session.getAttribute(SESSION_STRING_SHOPPING_CART);

		if (cart == null) {
			cart = new Cart();
		}
		return cart;
	}

	// tao moi 1 cart
	public void setCart(HttpSession session, Cart cart) {
		session.setAttribute(SESSION_STRING_SHOPPING_CART, cart);
	}

	// xoa 1 cart
	public void removeCart(HttpSession session) {
		session.removeAttribute(SESSION_STRING_SHOPPING_CART);
	}
}
