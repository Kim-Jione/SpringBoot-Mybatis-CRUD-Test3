package site.metacoding.firstapp.domain.orders;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
public class Orders {

	private Integer ordersId;
	private String ordersMember;
	private String ordersName;
	private Integer ordersPrice;
	private Integer ordersCount; // 주문수량
	private Integer productId;
	private Integer usersId;
	private Timestamp createdAt;

	public Orders(String ordersMember, String ordersName, Integer ordersPrice, Integer ordersCount, Integer productId,
			Integer usersId) {
		this.ordersMember = ordersMember;
		this.ordersName = ordersName;
		this.ordersPrice = ordersPrice;
		this.ordersCount = ordersCount;
		this.productId = productId;
		this.usersId = usersId;
	}
}
