package com.omnicuris.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omnicuris.assignment.model.Item;
import com.omnicuris.assignment.model.Cart;
import com.omnicuris.assignment.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService orderService;
	
	@PostMapping("/orders")
	public List<Cart> OrderHistory(@RequestParam(value = "email", required = true) String email){
		return orderService.OrderHistory(email);
	}
	
	@PostMapping("/save")
	public String saveOrder(@RequestParam(value = "item_ids", required = true) String ids, @RequestParam(value = "email", required = true) String email) {
		return orderService.saveOrder(ids, email);
	}
	
	@DeleteMapping("/clean")
	public String clearFailedOrders() {
		orderService.clearFailedOrders();
		return "Clean Successful";
	}
}
