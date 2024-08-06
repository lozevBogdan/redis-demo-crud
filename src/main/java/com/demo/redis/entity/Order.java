/**
 * 
 */
package com.demo.redis.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lozev
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String details;

	private int qty;

	private long price;

}
