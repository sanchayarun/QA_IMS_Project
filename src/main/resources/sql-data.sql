USE ims;


INSERT INTO `ims`.`customers` (`first_name`, `last_name`) VALUES ('jordan', 'harrison');

INSERT INTO `items` (`item_name`, `item_value`) VALUES ('Football', '15.99');

INSERT INTO `orders` (`fk_customer_id`) VALUES (1);

INSERT INTO `order_items` (`fk_order_id`, `fk_item_id`, `Quantity`) VALUE (1, 1, 1);