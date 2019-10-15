package com.omnicuris.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="item_id")
	private int item_id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="order_id")
	private String orderId;
	
	@Column(name="confirm_message")
	private String confirmation;
	
	public Cart() {}

	public Cart(int id, String email, int quantity, String orderId, String confirmation) {
		this.item_id = id;
		this.email = email;
		this.quantity = quantity;
		this.orderId = orderId;
		this.confirmation = confirmation;
	}

	
	
	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	@Override
	public String toString() {
		return "Order [id=" + item_id + ", email=" + email + ", quantity=" + quantity + ", orderId=" + orderId
				+ ", confirmation=" + confirmation + "]";
	}
	
	
	
}
