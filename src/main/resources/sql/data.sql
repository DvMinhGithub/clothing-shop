INSERT INTO techStore.role(id, name)
VALUES (1, 'ADMIN');

INSERT INTO techStore.role(id, name)
VALUES (2, 'EMPLOYEE');

INSERT INTO techStore.role(id, name)
VALUES (3, 'CUSTOMER');

INSERT INTO techStore.`user`(id, address, avatar, dob, email, gender, name, password, phone_number)
VALUES (1, 'Hà Đông', NULL, '2001-11-02 07:00:00', 'loidev02112001@gmail.com', 'MALE', 'loi',
        '$2a$10$heV4omX1SH9URGmQgbBimuRBifbWM8Fkk3oYW14Yjdh.WoC9ZKNQe', '0823539327');

INSERT INTO techStore.`user`
    (id, address, avatar, dob, email, gender, name, password, phone_number)
VALUES (2, 'Hà Đông', NULL, '2001-11-02 07:00:00', 'loi65732102@gmail.com', 'MALE', 'loi',
        '$2a$10$NyvEbHAqOdK6YlXWrgsg2.Byhh.9XH2YQsgyaLop43MN986..WgNi', '0823539328');

INSERT INTO techStore.`user_role`(user_id, role_id)
VALUES (1, 1);

INSERT INTO techStore.`user_role`(user_id, role_id)
VALUES (2, 3);

INSERT INTO techStore.`brand`(id, name, description)
VALUES (1, 'brand name 1', 'brand description 1');

INSERT INTO techStore.`brand`(id, name, description)
VALUES (2, 'brand name 2', 'brand description 2');

INSERT INTO techStore.`category`(id, name, description)
VALUES (1, 'category name 1', 'category description 1');

INSERT INTO techStore.`category`(id, name, description)
VALUES (2, 'category name 2', 'category description 2');

INSERT INTO techStore.`category`(id, name, description)
VALUES (3, 'category name 3', 'category description 3');

INSERT INTO techstore.voucher
(id, code, voucher_condition, description, discount_limit, discount_type, end_time, start_time, total_quantity,
 used_quantity, created_at, updated_at, is_deleted)
VALUES (1, 'string1123123', 0.0, 'string', 0.0, 'AMOUNT_DISCOUNT', NOW(6), DATE_ADD(NOW(6), INTERVAL 3 DAY), 0, 0,
        '2024-05-19 23:15:36', '2024-05-19 23:15:36', 0);

INSERT INTO techstore.voucher
(id, code, voucher_condition, description, discount_limit, discount_type, end_time, start_time, total_quantity,
 used_quantity, created_at, updated_at, is_deleted)
VALUES (2, 'string1123133', 0.0, 'string', 0.0, 'AMOUNT_DISCOUNT', NOW(6), DATE_ADD(NOW(6), INTERVAL 3 DAY), 0, 0,
        '2024-05-19 23:15:36', '2024-05-19 23:15:36', 0);

INSERT INTO techstore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES (1, 'description 1', 0, 'product 3', 1200.0, 'https://via.placeholder.com/300', 0, 2, 1);

INSERT INTO techstore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES (2, 'description 1', 0, 'product 3', 1200.0, 'https://via.placeholder.com/300', 0, 15, 1);

INSERT INTO techstore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES (3, 'description 1', 0, 'product 3', 1200.0, 'https://via.placeholder.com/300', 0, 4, 1);

INSERT INTO techstore.product_inventory
    (id, import_price, quantity, product_id)
VALUES (1, 1000.0, 1000, 1);

INSERT INTO techstore.product_inventory
    (id, import_price, quantity, product_id)
VALUES (2, 1000.0, 1000, 2);

INSERT INTO techstore.product_inventory
    (id, import_price, quantity, product_id)
VALUES (3, 1000.0, 1000, 3);

INSERT INTO techstore.product_category
    (product_id, category_id)
VALUES (1, 1);

INSERT INTO techstore.product_category
    (product_id, category_id)
VALUES (1, 2);

INSERT INTO techstore.product_category
    (product_id, category_id)
VALUES (2, 2);

INSERT INTO techstore.product_category
    (product_id, category_id)
VALUES (3, 3);