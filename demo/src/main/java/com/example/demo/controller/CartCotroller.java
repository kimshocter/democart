package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ProductRepository;
import com.example.demo.dao.ProductService;
import com.example.demo.entity.Product;
import com.example.demo.model.Cart;
import com.example.demo.model.CartManeger;

@Controller
public class CartCotroller {
	@Autowired
	private ProductRepository pr;
	@Autowired
	ProductService ps;
	@Autowired
	CartManeger cartManager;

	@RequestMapping("/add") // them san pham vao gio hang
	public String add(HttpSession session, @RequestParam("id") long id,
			@RequestParam(value = "qyt", required = false, defaultValue = "1") int qty) {
		Product product = ps.get(id);
		Cart cart = cartManager.getCart(session);
		cart.addItem(product, qty);
		return "cart";
	}

	@RequestMapping("/remove")
	public String remove(HttpSession session, @RequestParam("id") Long id) {
		Product product = ps.get(id);
		Cart cart = cartManager.getCart(session);
		cart.removeItem(product);
		return "cart";
	}

	@RequestMapping("/update")
	public String update(HttpSession session, @RequestParam("id") Long id, @RequestParam("qty") int qyt) {
		Product product = ps.get(id);
		Cart cart = cartManager.getCart(session);
		cart.updateItem(product, qyt);
		return "cart";
	}
}
