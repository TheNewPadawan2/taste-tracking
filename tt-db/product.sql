CREATE TABLE IF NOT EXISTS `taste_tracking_db`.`product` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `product_name` VARCHAR(128) NOT NULL,
    `product_type` TINYINT UNSIGNED NOT NULL,
    `creation_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `delete_date` TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE `UNQ_PRDCT_NAME` (`product_name`));