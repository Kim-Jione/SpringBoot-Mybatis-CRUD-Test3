package site.metacoding.firstapp.domain.admin;

import java.util.List;

import site.metacoding.firstapp.domain.orders.Orders;

public interface AdminDao {

	public void insert(Admin admin);

	public Admin findById(Integer adminId);

	public List<Admin> findAll(Integer adminId);

	public void update(Admin admin);

	public void delete(Integer adminId);
}
