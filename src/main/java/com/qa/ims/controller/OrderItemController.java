package com.qa.ims.controller;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.utils.Utils;

/**
 * Takes in order item details for CRUD functionality
 *
 */

public class OrderItemController implements CrudController<OrderItem>{

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderItemDAO orderItemDAO;
	private Utils utils;

	public OrderItemController(OrderItemDAO orderItemDAO, Utils utils) {
		super();
		this.orderItemDAO = orderItemDAO;
		this.utils = utils;
	}
	

	/**
	 * Reads all order items to the logger
	 */
	@Override
	
	public List<OrderItem> readAll() {
		List<OrderItem> orderItems = orderItemDAO.readAll();
		for (OrderItem orderItem : orderItems) {
			LOGGER.info(orderItem);
		}
		return orderItems;
	}
	
	
	
	/**
	 * Creates an order ID by taking in user input
	 */
	@Override
	public OrderItem create() {
		LOGGER.info("Please enter id of order");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter id of item");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter quantity of item");
		Long quantity = utils.getLong();
		OrderItem orderItem = orderItemDAO.create(new OrderItem(orderId, itemId, quantity));
		LOGGER.info("Order ID Generated - Please READ the orderID and create orderitems");
		return orderItem  ;
		
	}
	
	
	/**
	 * Updates an existing order item by taking in user input
	 */
	@Override
	public OrderItem update() {
		LOGGER.info("Please enter the order id ");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter the item id");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter the quantity");
		Long quantity = utils.getLong();
		OrderItem orderItem = orderItemDAO.update(new OrderItem(orderId, itemId, quantity));
		LOGGER.info("Order Item Updated");
		return orderItem;
	}
	
	
	/**
	 * Deletes an existing order item by the order id of the item
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the order_item_id of the order item you would like to delete");
		Long orderItemId = utils.getLong();
		return orderItemDAO.delete(orderItemId);
	}
	
	
}
