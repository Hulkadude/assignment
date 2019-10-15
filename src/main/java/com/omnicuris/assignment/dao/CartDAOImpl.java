package com.omnicuris.assignment.dao;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.omnicuris.assignment.model.Cart;
import com.omnicuris.assignment.model.Item;

@Repository
public class CartDAOImpl implements CartDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void clearFailedOrders() {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("delete from Cart where order_id is null");
		query.executeUpdate();

	}

	@Override
	public List<Cart> OrderHistory(String email) {
		Session session = entityManager.unwrap(Session.class);
		Query<Cart> theQuery = session.createQuery("from Cart where email = :email", Cart.class);
		theQuery.setParameter("email", email);
		return theQuery.getResultList();
	}

	@Override
	public String saveOrder(String item_Ids, String email) {
		Session session = entityManager.unwrap(Session.class);
		Instant instant = Instant.now();
		String order_id = "ord" + instant.toEpochMilli();
		List<Integer> items = new ArrayList<Integer>();
		Gson gson = new Gson();
		Map<String, String> order = gson.fromJson(item_Ids, HashMap.class);
		System.out.println(order);
		int flag = 0;
		for(String id:order.keySet()) {
			items.add(Integer.parseInt(id));
		}
		for (int id : items) {
			Item item = session.get(Item.class, id);
			int req_quantity = Integer.parseInt(order.get(""+item.getId()));
			int avail_quantity = item.getQuantity();
			if(avail_quantity == 0) {
				Cart cart = new Cart(item.getId(), email, req_quantity, null, "Out of stock");
				session.saveOrUpdate(cart);
			}
			else if (req_quantity <= avail_quantity) {
				item.setQuantity(avail_quantity-req_quantity);
				Cart cart = new Cart(item.getId(), email, req_quantity, order_id, "Successfully added to cart");
				cart.setId(0);
				session.saveOrUpdate(cart);
				
				session.saveOrUpdate(item);
				flag++;
			}
			else {
				Cart cart = new Cart(item.getId(), email, req_quantity, null, "Insufficient stock");
				session.saveOrUpdate(cart);
			}
		}
		if(flag == order.keySet().size())
			return "All Items added to cart successfully with order ID - "+ order_id;
		else if(flag == 0)
			return "No items are added to cart. Items are either insufficient or out of stock";
		else
			return "Some of the items are added to cart with order ID - "+order_id+". Other items are either insufficient or out of stock";

	}

}
