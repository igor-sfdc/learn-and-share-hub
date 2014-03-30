DROP SCHEMA IF EXISTS coffeedb;
CREATE SCHEMA coffeedb;
USE coffeedb;


DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `countryId` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `zoom` smallint(5) unsigned NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`countryId`)

);



DROP TABLE IF EXISTS `coffee`;

CREATE TABLE `coffee` (
  `coffeeId` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `description` varchar(100) NOT NULL,
  `region` varchar(20) NOT NULL,
  `countryFromId` SMALLINT UNSIGNED NOT NULL,
  `processed` varchar(20) NOT NULL,
  `weight` smallint(5) unsigned NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`coffeeId`),
  KEY idx_fk_countryFromId (countryFromId),
  CONSTRAINT `fk_countryFromId` FOREIGN KEY (countryFromId) REFERENCES country (countryId) ON DELETE RESTRICT ON UPDATE CASCADE
);

