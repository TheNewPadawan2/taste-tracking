CREATE TABLE IF NOT EXISTS `taste_tracking_db`.`user` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(64) NOT NULL,
    `lastname` VARCHAR(64) NOT NULL,
    `birthday` DATE NOT NULL,
    `tax` VARCHAR(16) NOT NULL,
    `email` VARCHAR(320) NOT NULL,
    `password` VARCHAR(60) NOT NULL,
    `phone_number` VARCHAR(25) NOT NULL,
    `verfied` BOOLEAN NULL DEFAULT FALSE,
    `creation_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `delete_date` TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE `UNQ_EMAIL` (`email`));
