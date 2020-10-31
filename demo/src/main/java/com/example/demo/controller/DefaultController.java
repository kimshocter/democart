package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.ProductRepository;
import com.example.demo.dao.ProductService;
import com.example.demo.entity.Product;

@Controller

public class DefaultController {
	@Autowired
	private ProductRepository pr;
	@Autowired
	ProductService ps;

	@RequestMapping({ "/", "/index" }) // vao trang chu
	public String index() {
		return "index";
	}
	@RequestMapping("/shop")//lay ve toan boi san pham
	public String shop (Model model) {
		model.addAttribute("product",pr.findAll());
		return "shop";
	}
	@RequestMapping("/cart")//vào gio hang
	public String cart()
	{
		return "cart";
	}
	@RequestMapping("/product/{id}")//truy cap vao 1 san pham
	public String product(@PathVariable("id")Long id, Model model)
	{
		Product product=ps.get(id);
		model.addAttribute("product", product);
		return "product";
	}

}
