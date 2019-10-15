package com.omnicuris.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omnicuris.assignment.dao.CartDAO;
import com.omnicuris.assignment.model.Item;
import com.omnicuris.assignment.model.Cart;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	public CartDAO orderDAO;
	
	@Override
	@Transactional
	public List<Cart> OrderHistory(String email) {
		return orderDAO.OrderHistory(email);
	}

	@Override
	@Transactional
	public String saveOrder(String item_ids, String email) {
		return orderDAO.saveOrder(item_ids, email);
	}

	@Override
	@Transactional
	public void clearFailedOrders() {
		orderDAO.clearFailedOrders();
		
	}

}
