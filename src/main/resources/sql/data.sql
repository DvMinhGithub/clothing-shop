INSERT INTO techStore.role(id, name)
VALUES (1, 'ADMIN');

INSERT INTO techStore.role(id, name)
VALUES (2, 'EMPLOYEE');

INSERT INTO techStore.role(id, name)
VALUES (3, 'CUSTOMER');

INSERT INTO techStore.`user`(id, address, avatar, dob, email, gender, name, password, phone_number)
VALUES (1, 'Hà Đông', NULL, '2001-11-02', 'loidev02112001@gmail.com', 'MALE', 'loi',
        '$2a$10$heV4omX1SH9URGmQgbBimuRBifbWM8Fkk3oYW14Yjdh.WoC9ZKNQe', '0823539327');

INSERT INTO techStore.`user`
    (id, address, avatar, dob, email, gender, name, password, phone_number)
VALUES (2, 'Hà Đông', NULL, '2001-11-02', 'loi65732102@gmail.com', 'MALE', 'loi',
        '$2a$10$NyvEbHAqOdK6YlXWrgsg2.Byhh.9XH2YQsgyaLop43MN986..WgNi', '0823539328');

INSERT INTO techStore.`user_role`(user_id, role_id)
VALUES (1, 1);

INSERT INTO techStore.`user_role`(user_id, role_id)
VALUES (2, 3);

INSERT INTO techStore.revenue(`date`, total_revenue) VALUES('2024-07-01', 1000);

INSERT INTO techStore.revenue(`date`, total_revenue) VALUES('2024-07-02', 2000);

INSERT INTO techStore.revenue(`date`, total_revenue) VALUES('2024-07-03', 3000);

INSERT INTO techStore.revenue(`date`, total_revenue) VALUES('2024-07-04', 4000);

INSERT INTO techStore.revenue(`date`, total_revenue) VALUES('2024-07-05', 5000);

INSERT INTO techStore.brand(id, description, name) VALUES(1, 'Đây là thuơng hệu ACER', 'ACER');

INSERT INTO techStore.brand(id, description, name) VALUES(2, 'Đây là thuơng hiệu DELL', 'DELL');

INSERT INTO techStore.brand(id, description, name) VALUES(3, 'Đây là thuơng hiệu ASUS', 'ASUS');

INSERT INTO techStore.brand(id, description, name) VALUES(4, 'Đây là thuơng hiệu HP', 'HP');

INSERT INTO techStore.brand(id, description, name) VALUES(5, 'Đây là thuơng hiệu LENOVO', 'LENOVO');

INSERT INTO techStore.brand(id, description, name) VALUES(6, 'Đây là thuơng hiệu APPLE', 'APPLE');

INSERT INTO techStore.brand(id, description, name) VALUES(7, 'Đây là thuơng hiệu MSI', 'MSI');

INSERT INTO techStore.brand(id, description, name) VALUES(8, 'Đây là thuơng hiệu LG', 'LG');

INSERT INTO techStore.brand(id, description, name) VALUES(9, 'Đây là thuơng hiệu VAIO', 'VAIO');

INSERT INTO techStore.brand(id, description, name) VALUES(10, 'Đây là thuơng hệu ALIENWARE', 'ALIENWARE');

INSERT INTO techStore.category(id, description, name) VALUES(1, 'Đây là danh mục laptop văn phòng', 'Laptop văn phòng');

INSERT INTO techStore.category(id, description, name) VALUES(2, 'Đây là danh mục laptop gaming', 'Laptop gaming');

INSERT INTO techStore.category(id, description, name) VALUES(3, 'Đây là danh mục laptop cảm ứng', 'Laptop cảm ứng');

INSERT INTO techStore.category(id, description, name) VALUES(4, 'Đây là danh mục laptop đồ hoạ', 'Laptop đồ hoạ');

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(1, 'description 1', 0, 'product 3', 1200.0, 'https://via.placeholder.com/300', 0, 2, 1);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(2, 'description 1', 0, 'product 3', 1200.0, 'https://via.placeholder.com/300', 0, 15, 1);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(3, 'description 1', 0, 'product 3', 1200.0, 'https://via.placeholder.com/300', 0, 4, 1);

INSERT INTO techStore.product_inventory
(id, import_price, quantity, product_id)
VALUES(1, 1000.0, 1000, 1);

INSERT INTO techStore.product_inventory
(id, import_price, quantity, product_id)
VALUES(2, 1000.0, 1000, 2);

INSERT INTO techStore.product_inventory
(id, import_price, quantity, product_id)
VALUES(3, 1000.0, 1000, 3);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(1, 1);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(1, 2);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(2, 2);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(3, 3);







