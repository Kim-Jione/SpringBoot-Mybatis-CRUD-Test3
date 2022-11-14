package site.metacoding.firstapp.web.dto.request;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.firstapp.domain.orders.Orders;

@Setter
@Getter
public class OrdersProductDto {
	private String ordersName;
	private Integer ordersPrice;
	private Integer ordersCount;
	private Integer productId;

	public Orders toEntity(Integer usersId) {
		Orders orders = new Orders(this.ordersName, this.ordersPrice, this.ordersCount, this.productId, usersId);
		return orders;
	}

}
