package com.onimurasame.productcatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onimurasame.productcatalog.exception.CustomException;
import com.onimurasame.productcatalog.service.ProductService;

@RestController
@RequestMapping(path = "/products")
class ProductController {

	@Value("${msg}")
	private String msg;
	
	@Autowired
	private ProductService productService;

	@GetMapping("/findall")
	public String findAll() {
		return productService.getAllProducts();
	}

	@GetMapping("/findbyid")
	public String findById(@RequestParam("id") String id) {
		return productService.getProductById(id);
	}

	@GetMapping("/save")
	public String process() {
		return productService.saveProducts();
	}

	@GetMapping("/exception")
	void getException() throws CustomException {
		throw new CustomException();
	}
	
	@GetMapping("/message")
	public String getMessage(){
	return this.msg;	
	}
}
