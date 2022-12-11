INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(1, 'Blonde Roast', 
'<b>Flavor Profile:</b> Bright and fruity with notes of grapefruit. <br>
<b>Bean Type:</b> These beans are made with with 100% fair trade Arabica beans for a 
super silky body.', 
6.00,130,'beans',15);
INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES
(2, 'Medium Roast', 
'<b>Flavor Profile:</b> Sweet and mellow with notes of chocolate and hazelnuts. <br>
<b>Bean Type:</b> These beans are made with Arabica and Robusta beans to deliver 
a well rounded cup of coffee with a soft finish. <br> <br>',
 6.00,144,'beans',0);
 INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(3, 'Dark Roast', 
'<b>Flavor Profile:</b> Bold and rich with notes of cinnamon and nutmeg. <br>
 <b>Bean Type:</b> These beans are a blend from Arabica and Robusta beans 
 for a cup that has low acidity.',
 6.00,169,'beans',0);
INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(4, 'Expresso', 
'<b>Flavor Profile:</b> Vibrant and Smooth with notes of vanilla and sugar cane. 
<b>Bean Type:</b> These beans are a blend from Arabica and Robusta beans 
for a cup that has a full body.',
 6.00,169,'beans',0);

INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(5, 'SC T-shirt', 
'You can rock the coolest t-shirt in the world if you put your mind to it! Well I guess that goes for most things...
<br><br> All sizes are standard mens.', 20.00,22,'merch',0);
INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(6, 'SC Sweatshirt',
'Sometimes we too cold.. we get it.. <br><br> All sizes are standard mens', 30.00,20,'merch',30);

INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(7, 'Coffee', 'What is coffees favorite programming language? Javascript! ~haha~ <br> Made with our freshly roasted medium beans.', 2.00,50,'brew',0);
INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(8, 'Americano', 'Americano = Expresso + Water <br> Made with our signature freshly roasted expresso beans and distilled water.', 2.50,10,'brew',0);
INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(9, 'Expresso', 'Expresso = Americano - Water <br> Made with our signature freshly roasted expresso beans.', 2.50,2,'brew',0);
INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(10, 'Mocha', 'For the chocolate lovers<br> Made with our signature freshly roasted expresso beans and organic dutch processed cocoa powder', 4.00,3,'brew',0);
INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(11, 'Latte', 'Better latte than never!<br> Made with our signature freshly roasted expresso beans and organic milk of your choice.', 4.00,4,'brew',0);
INSERT INTO product (p_id,p_name,p_description, p_price, p_stock, p_category, p_discount_perc) VALUES(12, 'Cappuchino', 'There are no jokes for a cappuchino, just drink it...<br> Made with our signature freshly roasted expresso beans and organic milk of your choice.', 4.50,5,'brew',0);

INSERT INTO users (u_id,u_first_name,u_password,u_admin,u_cc_num,u_cc_cvv,u_cc_exp,u_email) VALUES(1, 'admin', 'admin@sc',true,1234,1234,'12/30','admin@sc');
INSERT INTO users (u_id,u_first_name,u_password,u_admin,u_cc_num,u_cc_cvv,u_cc_exp,u_email) VALUES(2, 'test', 'a',false,123,123,'12/30','a@a');
INSERT INTO users (u_id,u_first_name,u_password,u_admin,u_cc_num,u_cc_cvv,u_cc_exp,u_email) VALUES(3, 'Meghan', 'pass',false,123,123,'12/30','meghanymcdonough@gmail.com');

