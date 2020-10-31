//crud
package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository repo;

	// Lay ve list san pham
	public List<Product> listAll() {
		return repo.findAll();
	}

	// them 1 san pham
	public void save(Product p) {
		repo.save(p);
	}

	// tim theo id
	public Product get(Long id) {
		return repo.findById(id).get();

	}

	// xoa san pham
	public void delete(long id) {
		repo.deleteById(id);
	}
}
