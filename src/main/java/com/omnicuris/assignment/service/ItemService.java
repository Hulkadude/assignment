package com.omnicuris.assignment.service;

import java.util.List;

import com.omnicuris.assignment.model.Item;

public interface ItemService {
	
	public List<Item> findAll();
	
	public Item findById(int id);
	
	public void save(Item item);
	
	public void deleteById(int id);

}
