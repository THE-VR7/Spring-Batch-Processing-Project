CREATE TABLE If Not EXISTS products
(
    productId varchar(10) primary key,
    title varchar(200),
    description varchar(200),
    price varchar(10),
    discount varchar(10),
    discounted_price varchar(10)
);