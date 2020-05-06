package com.uca.capas.Tarealabo3_00301417.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.Tarealabo3_00301417.domain.Product;

@Controller
public class ProductController {
	
private List<Product> products = new ArrayList<Product>();
	
	@GetMapping("/productos")
	public ModelAndView compraProducto() {
		ModelAndView mav = new ModelAndView();
		
		products.add(new Product(0, "Samsung Galaxy A2 Core", 40));
		products.add(new Product(1, "Samsung Galaxy A10.", 90));
		products.add(new Product(2, "Samsung Galaxy A20.", 85));
		products.add(new Product(3, "Samsung Galaxy A30", 700));
		products.add(new Product(4, "Samsung Galaxy A40", 500));
		products.add(new Product(5, "Samsung Galaxy A70", 23));
		products.add(new Product(6, "Samsung Galaxy A80", 63));
		products.add(new Product(7, "Samsung Galaxy Neo", 900));
		products.add(new Product(8, "Samsung Galaxy Pro", 100));
		products.add(new Product(9, "Samsung Galaxy Rush", 50));
		products.add(new Product(10, "Samsung Galaxy Appeal", 90));
		products.add(new Product(11, "nokia ladrillo", 1000));
		
		
		mav.setViewName("productos");
		mav.addObject("product", new Product());
		mav.addObject("productos", products);

		return mav;	
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("product", products.get(product.getId()).getNombre());
		
		if(products.get(product.getId()).getCantidad() >= product.getCantidad()
				&& product.getCantidad() > 0) { mav.setViewName("compra"); }
		else {
			mav.setViewName("error");
		}
		return mav;
	}
	
}
