package com.qa.ims.persistence.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderItemDAO implements Dao<OrderItem> {
	
	
public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public OrderItem modelFromResultSet(ResultSet resultSet) throws SQLException {
		
		Long orderItemId = resultSet.getLong("order_items_id");
		Long fkOrderId = resultSet.getLong("fk_order_id");
		Long fkItemId = resultSet.getLong("fk_item_id");
		Long quantity = resultSet.getLong("Quantity");
		return new OrderItem(orderItemId, fkOrderId, fkItemId, quantity);
		
	}
	
	
	/**
	 * Reads all order items from the database
	 * 
	 * @return A list of order items
	 */
	@Override
	public List<OrderItem> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items");) {
			List<OrderItem> orderItem = new ArrayList<>();
			while (resultSet.next()) {
				orderItem.add(modelFromResultSet(resultSet));
			}
			return orderItem;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	/**
	 * Reads most recent order item added to the database
	 * 
	 * @return Most recent order item added to the database
	 */
	public OrderItem readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items ORDER BY order_item_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
	/**
	 * Creates an order item in the database
	 * 
	 * @param item - takes in a order items object. id will be ignored
	 */
	@Override
	public OrderItem create(OrderItem orderItem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO order_items(fk_order_id, fk_item_id, Quantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, orderItem.getFkOrderId());
			statement.setLong(2, orderItem.getFkItemId());
			statement.setLong(3, orderItem.getQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
	/**
	 * Reads an order items from the database
	 * 
	 * @param orderItemId - takes in an itemId.
	 * @return item details of specified itemId
	 */
	@Override
	public OrderItem read(Long orderItemId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM order_items WHERE order_items_id = ?");) {
			statement.setLong(1, orderItemId);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
	/**
	 * Updates an order item in the database
	 * @param orderItem - takes in an order item object, the item_id field will be used to
	 *                 update that item in the database
	 * @return  The item_id of the updated item object.
	 */
	@Override
	public OrderItem update(OrderItem orderItem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE order_items SET fk_order_id = ?, fk_item_id = ?, Quantity =? WHERE order_items_id = ?");) {
			statement.setLong(1, orderItem.getFkOrderId());
			statement.setLong(2, orderItem.getFkItemId());
			statement.setLong(3, orderItem.getQuantity());
			statement.setLong(4, orderItem.getOrderItemId());
			statement.executeUpdate();
			return read(orderItem.getOrderItemId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	/**
	 * Deletes an order item in the database
	 * 
	 * @param orderItemId - id of the order item
	 */
	@Override
	public int delete(long orderItemId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM order_items WHERE order_items_id = ?");) {
			statement.setLong(1, orderItemId);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}