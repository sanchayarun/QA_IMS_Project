drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `customer_id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(50) DEFAULT NULL,
    `last_name` VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (`customer_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
	`order_id` INT(9) NOT NULL AUTO_INCREMENT,
    `fk_customer_id` INT(11) NOT NULL,
    `order_date` datetime default now() NOT NULL,
    PRIMARY KEY (`order_id`),
    FOREIGN KEY (`fk_customer_id`) REFERENCES `customers`(`customer_id`)
    );
    
CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`item_id` INT(9) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(50) NOT NULL,
    `item_value` DOUBLE NOT NULL,
    PRIMARY KEY (`item_id`)
    );

CREATE TABLE IF NOT EXISTS `ims`.`order_items` (
	`order_items_id` INT(9) NOT NULL AUTO_INCREMENT,
    `fk_order_id` INT(9) NOT NULL,
    `fk_item_id` INT(9) NOT NULL,
    `Quantity` INT NOT NULL,
    PRIMARY KEY (`order_items_id`),
    FOREIGN KEY (`fk_order_id`) REFERENCES `orders`(`order_id`),
	FOREIGN KEY (`fk_item_id`) REFERENCES `items`(`item_id`)
    );