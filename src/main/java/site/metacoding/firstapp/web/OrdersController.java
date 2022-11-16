package site.metacoding.firstapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.orders.OrdersDao;
import site.metacoding.firstapp.domain.product.Product;
import site.metacoding.firstapp.domain.product.ProductDao;
import site.metacoding.firstapp.domain.users.Users;
import site.metacoding.firstapp.web.dto.request.OrdersProductDto;

@RequiredArgsConstructor
@Controller
public class OrdersController {
	private final ProductDao productDao;
	private final OrdersDao ordersDao;
	private final HttpSession session;

	// 구매 목록페이지
	@GetMapping("/orders/ordersList")
	public String ordersList(Model model) {
		Users principal = (Users) session.getAttribute("principal");
		model.addAttribute("ordersList", ordersDao.findAll(principal.getUsersId()));
		return "orders/orderListForm";
	}

	// 상품 구매하기
	@PostMapping("/orders/{productId}")
	public String ordersProduct(@PathVariable Integer productId,
			OrdersProductDto ordersProductDto) {
		Users principal = (Users) session.getAttribute("principal");
		if (principal == null) {
			return "redirect:/loginForm";
		}
		Product productPS = productDao.findById(productId);
		if (productPS.getProductQty() - ordersProductDto.getOrdersCount() < 0) {
			return "redirect:/";
		}
		productDao.productQtyUpdate(ordersProductDto);
		System.out.println(ordersProductDto.getOrdersMember());
		ordersDao.insert(ordersProductDto.toEntity(principal.getUsersId()));
		return "redirect:/";
	}

	// 유저주문 삭제하기
	@PostMapping("/members/{ordersId}/delete")
	public String saveListDelete(@PathVariable Integer ordersId) {
		ordersDao.delete(ordersId);
		return "/orders/orderListForm";
	}
}
