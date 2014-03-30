/*
 * create user may fail if user already exists, then comment out this line and proceed with grant.
 */
CREATE USER 'coffeeman'@'localhost' IDENTIFIED BY 'lovecoffeepassword';
GRANT ALL PRIVILEGES ON coffeedb.* TO 'coffeeman'@'localhost' IDENTIFIED BY 'lovecoffeepassword' WITH GRANT OPTION;
