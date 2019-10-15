package com.omnicuris.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omnicuris.assignment.dao.ItemDAO;
import com.omnicuris.assignment.model.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	public ItemDAO itemDAO;
	
	@Override
	@Transactional
	public List<Item> findAll() {
		return itemDAO.findAll();
	}

	@Override
	@Transactional
	public Item findById(int id) {
		return itemDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Item item) {
		itemDAO.save(item);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		itemDAO.deleteById(id);

	}

}
