package com.omnicuris.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omnicuris.assignment.model.Item;
import com.omnicuris.assignment.service.ItemService;

@RestController
@RequestMapping("/api")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/items")
	public List<Item> findAll(){
		return itemService.findAll();
	}
	
	@GetMapping("/items/{itemId}")
	public Item getItem(@PathVariable int itemId){
		Item item = itemService.findById(itemId);
		if(item == null) {
			throw new RuntimeException("Item Id not found - " +itemId);
		}
		return item;
	}
	
	@PostMapping("/items")
	public Item addItem(@RequestBody Item item){
		item.setId(0);
		itemService.save(item);
		return item;
	}
	
	@PutMapping("/items")
	public Item updateItem(@RequestBody Item item){
		itemService.save(item);
		return item;
	}
	
	@DeleteMapping("/items/{itemId}")
	public String deleteItem(@PathVariable int itemId){
		Item item = itemService.findById(itemId);
		if(item == null) {
			throw new RuntimeException("Item Id not found - " +itemId);
		}
		itemService.deleteById(itemId);
		return "Deleted Item Id - "+itemId;
	}	
}
