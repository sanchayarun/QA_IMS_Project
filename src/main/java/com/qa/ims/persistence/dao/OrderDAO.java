
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


	import com.qa.ims.persistence.domain.Order;
	import com.qa.ims.utils.DBUtils;

	public class OrderDAO implements Dao<Order>  {


			
			public static final Logger LOGGER = LogManager.getLogger();
			
			@Override
			public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
				Long orderId = resultSet.getLong("order_id");
				Long customerId = resultSet.getLong("fk_customer_id");
//				Long itemId = resultSet.getLong("item_id");
//				String itemName = resultSet.getString("item_name");
//				Double itemPrice = resultSet.getDouble("item_price");
//				Long quantity = resultSet.getLong("quantity");
//				Double totalCost = resultSet.getDouble("Need to put in a sum of quantity * price");   // need to add commands for MySQL to return price
				return new Order(orderId, customerId);
			}
		
			
			/**
			 * Reads all orders from the database
			 * 
			 * @return A list of orders
			 */
			@Override
			public List<Order> readAll() {
				try (Connection connection = DBUtils.getInstance().getConnection();
						Statement statement = connection.createStatement();
						ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
					List<Order> orders = new ArrayList<>();
					while (resultSet.next()) {
						orders.add(modelFromResultSet(resultSet));
					}
					return orders;
				} catch (SQLException e) {
					LOGGER.debug(e);
					LOGGER.error(e.getMessage());
				}
				return new ArrayList<>();
			}
			
			
			/**
			 * Reads most recent order added to the database
			 * 
			 * @return Most recent order added to the database
			 */
			public Order readLatest() {
				try (Connection connection = DBUtils.getInstance().getConnection();
						Statement statement = connection.createStatement();
						ResultSet resultSet = statement.executeQuery("SELECT * FROM orders o INNER JOIN order_items oi ON o.order_id = oi.fk_order_id INNER JOIN items i ON oi.fk_item_id = i.item_id ORDER BY order_id DESC LIMIT 1");) {
					resultSet.next();
					return modelFromResultSet(resultSet);
				} catch (Exception e) {
					LOGGER.debug(e);
					LOGGER.error(e.getMessage());
				}
				return null;
			}
			
			/**
			 * Creates an order in the database
			 * 
			 * @param order - takes in a order object. id will be ignored
			 */
			@Override
			public Order create(Order order) {
				try (Connection connection = DBUtils.getInstance().getConnection();
						PreparedStatement statement = connection
								.prepareStatement("INSERT INTO orders(fk_customer_id) VALUES (?)");) { 
//					statement.setLong(1, order.getOrderId());
					statement.setLong(1, order.getCustomerId());
					statement.executeUpdate();
					return readLatest();
				} catch (Exception e) {
					LOGGER.debug(e);
					LOGGER.error(e.getMessage());
				}
				return null;
			}
			
			
			
			/**
			 * Reads an order from the database
			 * 
			 * @param orderId - takes in an orderId.
			 * @return order details of specified orderId
			 */
			@Override
			public Order read(Long orderId) {
				try (Connection connection = DBUtils.getInstance().getConnection();
						PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders o INNER JOIN order_items oi ON o.order_id = oi.fk_order_id INNER JOIN items i ON oi.fk_item_id = i.item_id WHERE order_id = ?");) {
					statement.setLong(1, orderId);
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
			 * Updates an order in the database
			 * 
			 * @param order - takes in an order object, the order_id field will be used to
			 *                 update that order in the database
			 * @return  The order_id of the updated item object.
			 */
			@Override
			public Order update(Order order) {
				try (Connection connection = DBUtils.getInstance().getConnection();
						PreparedStatement statement = connection
								.prepareStatement("UPDATE orders SET fk_customer_id = ? WHERE order_id = ?");) {
					statement.setLong(1, order.getCustomerId());
					statement.setLong(2, order.getOrderId());
					statement.executeUpdate();
					return read(order.getOrderId());
				} catch (Exception e) {
					LOGGER.debug(e);
					LOGGER.error(e.getMessage());
				}
				return null;
			}
			
			/**
			 * Deletes an order in the database
			 * 
			 * @param orderId - id of the order
			 */
			@Override
			public int delete(long orderId) {
				try (Connection connection = DBUtils.getInstance().getConnection();
						PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE order_id = ?");) {
					statement.setLong(1, orderId);
					return statement.executeUpdate();
				} catch (Exception e) {
					LOGGER.debug(e);
					LOGGER.error(e.getMessage());
				}
				return 0;
			}
	}

	

