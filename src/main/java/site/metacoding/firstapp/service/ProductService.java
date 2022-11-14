package site.metacoding.firstapp.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.product.Product;
import site.metacoding.firstapp.domain.product.ProductDao;
@RequiredArgsConstructor
@Service
public class ProductService {
	private final ProductDao productDao;
	public boolean 상품명중복확인(String productName) {
		Product productPS = productDao.findByProductName(productName);
		
		if(productPS == null) { // 상품명이 중복 안됨
			return false;
		}else { // 상품명이 중복됨
			return true;
		}
	}
}
