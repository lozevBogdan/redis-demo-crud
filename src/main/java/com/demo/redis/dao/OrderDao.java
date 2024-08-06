/**
 * 
 */
package com.demo.redis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.demo.redis.entity.Order;

/**
 * @author lozev
 *
 */
@Repository
public class OrderDao {

	private static final String HASH_KEY = "Order";

	@Autowired
	private RedisTemplate template;

	public Order save(Order order) {
		template.opsForHash().put(HASH_KEY, order.getId(), order);
		return order;
	}

	public List<Order> findAll() {
		return template.opsForHash().values(HASH_KEY);
	}

	public String deleteOrder(Long id) {
		template.opsForHash().delete(HASH_KEY, id);
		return "Order deleted successfully";
	}

}
