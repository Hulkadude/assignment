package com.omnicuris.assignment.dao;

import java.util.List;

import com.omnicuris.assignment.model.Item;
import com.omnicuris.assignment.model.Cart;

public interface CartDAO {
	
	public List<Cart> OrderHistory(String email);
	
	public String saveOrder(String item_ids, String email);
	
	public void clearFailedOrders();

}
