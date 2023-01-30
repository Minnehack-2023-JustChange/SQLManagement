-- JustChange MySQL Schema
		
USE minnehack;        

CREATE TABLE IF NOT EXISTS `accounts` (
  `id`            VARCHAR(255) NOT NULL,
  `email`         VARCHAR(255) NOT NULL,
  `password_hash` VARCHAR(255) NOT NULL,
  `first_name`    VARCHAR(255) NOT NULL,
  `middle_name`   VARCHAR(255) NOT NULL,
  `last_name`     VARCHAR(255) NOT NULL,
  `paused`        BOOLEAN      NOT NULL,
  `plaid_token`   VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) default charset=utf8;

CREATE TABLE IF NOT EXISTS `charities` (
  `id`   VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) default charset=utf8;

CREATE TABLE IF NOT EXISTS `logs` (
  `id`          VARCHAR(255) NOT NULL,
  `account_id`  INT          NOT NULL,
  `charity_id`  INT          NOT NULL,
  `amount`      INT          NOT NULL,
  `time`        TIMESTAMP    NOT NULL,
  PRIMARY KEY (`id`)
) default charset=utf8;
