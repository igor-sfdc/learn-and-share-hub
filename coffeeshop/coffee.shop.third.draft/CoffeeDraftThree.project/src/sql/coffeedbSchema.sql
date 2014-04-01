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






INSERT INTO country
(name, latitude, longitude, zoom)
VALUES("Noveo Zimlya", 69.7012621, 52.3030044, 8);


INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("COlombia", 4.1156735, -72.9301367, 6);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Ecuador", -1.7929665, -78.1368875, 7);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Peru", -9.1951786, -74.9904165, 6);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Bolivia", -16.2837065, -63.5493965, 6);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Paraguay", -23.4380203, -58.4483065,) 7;

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Chile", -36.739055, -71.0574942, 4);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Argentina", -37.2391747, -63.6648384, 5);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Brazil", -10.3334774, -52.0928553, 6);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Guatemala", 15.7778663, -90.2287257, 8);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Mexico", 23.4856642, -101.9991705, 6);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Hawaii", 20.46, -157.505, 8);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom))
Values("Ethiopia", 8.3782587, 40.7131003, 7);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom))
Values("Kenya", 8.3782587, 40.7131003, 7);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Vietnam", 13.0953646, 107.9462799, 8);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Indonesia", -1.7145503, 119.3551955, 5);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("India", 21.9669027, 79.1866461, 6);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Honduras", 15.2650424, -86.892281, 8);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Uganda", 1.5189977, 32.5367009, 8);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Ivory Coast", 7.2350022, -5.2811265, 8);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Costa Rica", 9.6897572, -83.8641697, 8);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("El Salvador", 13.802994, -88.905281, 9);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Nicaragua", 12.8263201, -85.0536794, 8);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Papua New Guinea", -6.2973513, 146.4864297, 7);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Thailand", 16.0691649, 102.0119546, 7);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Tanzania", -6.7657355, 35.1506614, 7);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Dominican Republic", 19.0465589, -70.4552228, 9);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Cameroon", 5.5739908, 12.7318537, 8);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Philippines", 11.5883663, 122.373256, 7);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Democratic Republic of the Congo", -3.1124685, 22.1620476, 7);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Burundi", -3.2634778, 

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Madagascar", 30.0196533, 10);
 

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Rwanda", -1.8778244, 29.9883811, 10);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Guinea", 10.2518443, -11.0092136, 8);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Cuba", 21.9492879, -78.5388079, 8);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Togo", 8.6177801, 0.8997954, 9);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Zambia", -13.4290435, 27.8438117, 7);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Angola", -12.0958201, 18.3109632, 7);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Central African Republic", 6.7830763, 20.7334546, 7);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Panama", 8.8436879, -80.0531795, 8);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Zimbabwe", -18.8402533, 29.7652896, 8);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("United States", 40.8002119, -98.7191992, 5);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Nigeria", 9.5547719, 8.3423737, 7);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Ghana", 8.5942144, -0.8082386, 8);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Jamaica", 18.1755471, -77.2876755, 10);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Sri Lanka", 7.8612151, 80.8060862, 9);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Malawi", -13.577157, 33.9554585, 8);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Sierra Leone", 8.4277641, -11.6618594, 9);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Trinidad and Tobago", 10.4282923, -61.3392017, 11);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Republic of the Congo", -0.5726933, 14.9048192, 8);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Equatorial Guinea", 1.56065, 10.5283148, 10);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Gabon", -0.9629363, 12.2003196, 8);

INSERT INTO COUNTRY
(name, latitude, longitude, zoom)
Values("Benin", 9.6526207, 2.4336013, 8);




INSERT INTO coffee
(name, description, region, countryFromId, processed, weight)
VALUES("Morrocan", "rich dark", "Colombia", 1, "roasted", 1);

INSERT INTO coffee
(name, description, region, countryFromId, processed, weight)
VALUES("Arabica", "full-bodied", "Colombia", 2, "roasted", 1);

INSERT INTO coffee
(name, description, region, countryFromId, processed, weight)
VALUES("Beano", "nutty", "Colombia", 3, "roasted", 1);


CREATE USER 'coffeeman'@'localhost' IDENTIFIED BY 'lovecoffeepassword';
GRANT ALL PRIVILEGES ON coffeedb.* TO 'coffeeman'@'localhost' IDENTIFIED BY 'lovecoffeepassword' WITH GRANT OPTION;