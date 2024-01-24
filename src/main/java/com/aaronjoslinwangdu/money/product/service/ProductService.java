package com.aaronjoslinwangdu.money.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaronjoslinwangdu.money.mapper.ProductMapper;
import com.aaronjoslinwangdu.money.product.domain.Product;
import com.aaronjoslinwangdu.money.product.dto.ProductDTO;
import com.aaronjoslinwangdu.money.repository.ProductJpaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	/* The constant productJpaRepository */
	@Autowired
	private final ProductJpaRepository productJpaRepository;
	
	/* The constant productMapper */
	private final ProductMapper productMapper;
	
	
	/**
	 * Get all Products
	 * 
	 * @return List<Product>
	 */
	public List<Product> getAllProducts() {
		return productJpaRepository.findAll();
	}
	
	
	/**
	 * Adds a new Product
	 * 
	 * @param request
	 * @return
	 */
	public Product addProduct(ProductDTO request) {
		
		Product product;
		product = Product.builder()
				.productType(request.getProductType())
				.name(request.getName())
				.description(request.getDescription())
				.price(request.getPrice())
				.build();
		product.setPrincipal(request.getCreatedBy());
		
		return productJpaRepository.save(product);
	}
	
	
}
