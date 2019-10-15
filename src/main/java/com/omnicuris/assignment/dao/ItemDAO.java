package com.omnicuris.assignment.dao;

import java.util.List;

import com.omnicuris.assignment.model.Item;

public interface ItemDAO {
	
	public List<Item> findAll();
	
	public Item findById(int id);
	
	public void save(Item item);
	
	public void deleteById(int id);

}
