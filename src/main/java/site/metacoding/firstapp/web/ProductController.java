package site.metacoding.firstapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.product.Product;
import site.metacoding.firstapp.domain.product.ProductDao;
import site.metacoding.firstapp.service.ProductService;
import site.metacoding.firstapp.web.dto.response.CMRespDto;

@RequiredArgsConstructor
@Controller
public class ProductController {
	private final ProductDao productDao;
	private final ProductService productService;
	private final HttpSession session;

	// 상품 목록 페이지
	@GetMapping({ "/listForm", "/" })
	public String list(Model model) {
		model.addAttribute("product", productDao.findAll());
		return "product/listForm";
	}

	// 상품 상세보기 페이지
	@GetMapping("/product/{productId}")
	public String detail(@PathVariable Integer productId, Model model) {
		model.addAttribute("detail", productDao.findById(productId));
		return "product/detailForm";
	}

	@GetMapping("/product/add")
	public String save() {
		return "product/saveForm";
	}

	// 수정하기
	@GetMapping("/product/{id}/edit")
	public String productUpdate(@PathVariable Integer id, Product product, Model model) {
		model.addAttribute("update", productDao.findById(id));
		return "product/updateForm";
	}

	@PostMapping("/product/{id}/edit")
	public String update(@PathVariable Integer id, Product product) {
		Product productPS = productDao.findById(id);
		productPS.update(product);
		productDao.update(productPS);
		return "redirect:/product/" + id;
	}

	// 삭제하기
	@PostMapping("/product/{id}/delete")
	public String productUpdate(@PathVariable Integer id) {
		productDao.deleteById(id);
		return "redirect:/";
	}

	// 상품명 중복확인
	@GetMapping("/product/productNameSameCheck")
	public @ResponseBody CMRespDto<Boolean> productNameSameCheck(String productName) {
		boolean isSame = productService.상품명중복확인(productName);
		return new CMRespDto<>(1, "성공", isSame);
	}

	// 등록하기
	@PostMapping("/product/add")
	public @ResponseBody CMRespDto<?> join(@RequestBody Product product) {
		productDao.insert(product);
		return new CMRespDto<>(1, "상품등록성공", null);
	}

}