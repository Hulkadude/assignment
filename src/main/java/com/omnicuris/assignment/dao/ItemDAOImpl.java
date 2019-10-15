package com.omnicuris.assignment.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.omnicuris.assignment.model.Item;

@Repository
public class ItemDAOImpl implements ItemDAO {
	
	@Autowired
	private EntityManager entityManager;
	

	@Override
	public List<Item> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Item> theQuery = session.createQuery("from Item",Item.class);
		
		return theQuery.getResultList();
	}


	@Override
	public Item findById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Item item = session.get(Item.class, id);
		return item;
	}


	@Override
	public void save(Item item) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(item);
		
	}


	@Override
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("delete from Item where id=:itemId");
		query.setParameter("itemId", id);
		query.executeUpdate();
		
	}

}
