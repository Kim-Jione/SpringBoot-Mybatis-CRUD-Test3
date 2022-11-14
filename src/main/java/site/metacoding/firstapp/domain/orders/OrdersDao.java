package site.metacoding.firstapp.domain.orders;

import java.util.List;

public interface OrdersDao {

	public void insert(Orders orders);

	public Orders findById(Integer ordersId);

	public List<Orders> findAll(Integer usersId);

	public void orderUpdatebyProductQty(Orders orders);

	public void delete(Integer ordersId);
}
