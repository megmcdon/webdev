use simplycoffee;

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE `simplycoffee`.`cart`, `simplycoffee`.`orders`, `simplycoffee`.`product`, `simplycoffee`.`user`;
SET FOREIGN_KEY_CHECKS=1;


CREATE TABLE if not exists USER (
    u_id int AUTO_INCREMENT,
    u_first_name varchar(50),
    u_last_name varchar(50),
    u_billing_addr varchar(255),
    u_shipping_addr varchar(255),
	u_email varchar(50),
    u_password varchar(50),
    u_cc_info int, 
    primary key (u_id)
);

Create table if not exists PRODUCT ( 
	p_id int AUTO_INCREMENT,
    p_name varchar(50),
    p_description varchar(255),
    p_price double,
    p_out_of_stock boolean,
    p_category varchar(50),
    p_discount_perc int,
	primary key (p_id)
);

create table if not exists CART (
    c_id int AUTO_INCREMENT,
    c_p_id int,
    c_u_id int,
    c_quantity int,
    primary key (c_id),
	foreign key (c_u_id) references USER(u_id),
    foreign key (c_p_id) references PRODUCT(p_id)
);

create table if not exists ORDERS (
	o_id int AUTO_INCREMENT,
    o_u_id int,
    o_total double,
	primary key (o_id),
    foreign key (o_u_id) references USER(u_id)
);
