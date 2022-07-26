package com.qa.ims.controller;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;

import com.qa.ims.utils.Utils;

/**
 * Takes in order details for CRUD functionality
 *
 */

public class OrderController implements CrudController<Order> {
	

		public static final Logger LOGGER = LogManager.getLogger();

		private OrderDAO orderDAO;
		private Utils utils;

		public OrderController(OrderDAO orderDAO, Utils utils) {
			super();
			this.orderDAO = orderDAO;
			this.utils = utils;
		}



		/**
		 * Reads all orders to the logger
		 */
		@Override
		
		public List<Order> readAll() {
			List<Order> orders = orderDAO.readAll();
			for (Order order : orders) {
				LOGGER.info(order);
			}
			return orders;
		}
		
		
		/**
		 * Creates an order ID by taking in user input
		 */
		@Override
		public Order create() {
			LOGGER.info("Please enter the customer id for order");
			Long customerId = utils.getLong();
			Order order = orderDAO.create(new Order(customerId));
			LOGGER.info("Order ID Generated - Please READ the orderID and create OrderItems");
			return order  ;
		}
		
		
		/**
		 * Updates an existing order by taking in user input
		 */
		@Override
		public Order update() {
			LOGGER.info("Please enter the order id ");
			Long orderId = utils.getLong();
			LOGGER.info("Please enter a customer id");
			Long customerId = utils.getLong();
			Order order = orderDAO.update(new Order(orderId, customerId));
			LOGGER.info("Customer Updated");
			return order;
		}
		
		/**
		 * Deletes an existing order by the order id of the item
		 * 
		 * @return
		 */
		@Override
		public int delete() {
			LOGGER.info("Please enter the id of the order you would like to delete");
			Long orderId = utils.getLong();
			return orderDAO.delete(orderId);
		}
		
//		
//		/**
//		 * Calculates the total of order
//		 * @return total cost of order
//		 */
//		public double cost() {
//			LOGGER.info("Please enter Order Id for total cost:");
//			Long orderId = utils.getLong();
//			double total = orderDAO.totalCost(orderId);
//			LOGGER.info("Order Total £" + total);
//			return total;
//		}
		
		
}