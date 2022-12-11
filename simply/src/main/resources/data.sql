INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(1, 'Light Roast - Arabica', 'This is a light roast coffee made with Arabica beans', 6.00,130,'beans',15);
INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(2, 'Light Roast - Robusta', 'This is a light roast coffee make with Robusta beans', 6.00,100,'beans',15);

INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(3, 'Medium Roast - Arabica', 'This is a medium roast coffee made with Arabica beans', 6.00,144,'beans',0);
INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(4, 'Medium Roast - Robusta', 'This is a medium roast coffee make with Robusta beans', 6.00,230,'beans',0);

INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(5, 'Dark Roast - Arabica', 'This is a dark roast coffee made with Arabica beans', 6.00,142,'beans',0);
INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(6, 'Dark Roast - Robusta', 'This is a dark roast coffee make with Robusta beans', 6.00,169,'beans',0);

INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(7, 'SC T-shirt', 'This is a t-shirt with the SC logo, sizes are standard', 20.00,22,'merch',0);
INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(8, 'SC Sweatshirt', 'This is a t-shirt with the SC logo, sizes are standard', 30.00,20,'merch',30);

INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(9, 'Coffee', 'What is coffees favorite programming language? Javascript!', 3.00,50,'brew',0);
INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(10, 'Americano', 'Just hot water + expresso', 4.00,10,'brew',0);
INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(11, 'Expresso', 'Expresso = Americano - water', 4.50,2,'brew',0);

INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(12, 'Mocha', 'For the chocolate lovers', 3.00,3,'brew',0);
INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(13, 'Latte', 'For those who are running a little latte', 4.00,4,'brew',0);
INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(14, 'Cappuchino', 'There are no jokes for a cappuchino', 4.50,5,'brew',0);


INSERT INTO users (u_id,u_first_name,u_password,u_admin,u_cc_num,u_cc_cvv,u_cc_exp,u_email) VALUES(1, 'admin', 'mypassword',true,1234,1234,'12/30','admin@sc');
