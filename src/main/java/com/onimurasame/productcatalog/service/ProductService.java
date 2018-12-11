package com.onimurasame.productcatalog.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onimurasame.productcatalog.data.Product;
import com.onimurasame.productcatalog.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	   private ProductRepository productRepository;
	
	public String getAllProducts() {
		String result = "";
		for (Product product : productRepository.findAll()) {
			result += product.getId() + " " + product.getName() + "</br>";
		}
		return result;
	}
	
	public String getProductById(String id){
		String result = "";
		Optional<Product> product= productRepository.findById(Integer.parseInt(id));
		if(product.isPresent()){
			Product presult = product.get();
			result = "Id : "+presult.getId() +" </br> Name : "+presult.getName();
		}
		return result;
	}
	
	public String saveProducts(){
		productRepository.saveAll(Arrays.asList(new Product("Shirts"), new Product("pants"), new Product("jeans")));
		return "Done";
	}
	
}
