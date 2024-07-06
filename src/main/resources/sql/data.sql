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
VALUES(1, 'Đây là laptop ACER ASPIRE 7 A715-76-53PJ (NH.QGESV.007) (I5 12450H/16GB RAM/512GB', 0, 'LAPTOP ACER ASPIRE 7 A715-76-53PJ (NH.QGESV.007) (I5 12450H/16GB RAM/512GB', 14000000, 'https://hanoicomputercdn.com/media/product/250_76816_laptop_acer_aspire_7_a715_76_53pj__nh_qgesv_007___1_.jpg', 0, 0, 1);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(2, 'Đây là laptop ACER ASPIRE LITE AL16-51P-55N7 (NX.KX0SV.001) (I5 1235U/16GB/512GB SSD/16', 0, 'LAPTOP ACER ASPIRE LITE AL16-51P-55N7 (NX.KX0SV.001) (I5 1235U/16GB/512GB SSD/16', 17000000, 'https://hanoicomputercdn.com/media/product/250_84394_laptop_acer_aspire_lite_al16_51p_55n7_nx_kx0sv__3_.jpg', 0, 0, 1);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(3, 'Đây là laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 0, 'laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 20000000, 'https://hanoicomputercdn.com/media/product/250_77583_laptop_acer_aspire_7_a715_76_728x__nh_qgesv_008__3.jpg', 0, 0, 1);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(4, 'Đây là laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 0, 'laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 20000000, 'https://hanoicomputercdn.com/media/product/250_77583_laptop_acer_aspire_7_a715_76_728x__nh_qgesv_008__3.jpg', 0, 0, 1);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(3, 'Đây là laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 0, 'laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 20000000, 'https://hanoicomputercdn.com/media/product/250_77583_laptop_acer_aspire_7_a715_76_728x__nh_qgesv_008__3.jpg', 0, 0, 1);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(3, 'Đây là laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 0, 'laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 20000000, 'https://hanoicomputercdn.com/media/product/250_77583_laptop_acer_aspire_7_a715_76_728x__nh_qgesv_008__3.jpg', 0, 0, 1);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(3, 'Đây là laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 0, 'laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 20000000, 'https://hanoicomputercdn.com/media/product/250_77583_laptop_acer_aspire_7_a715_76_728x__nh_qgesv_008__3.jpg', 0, 0, 1);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(3, 'Đây là laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 0, 'laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 20000000, 'https://hanoicomputercdn.com/media/product/250_77583_laptop_acer_aspire_7_a715_76_728x__nh_qgesv_008__3.jpg', 0, 0, 1);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(3, 'Đây là laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 0, 'laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 20000000, 'https://hanoicomputercdn.com/media/product/250_77583_laptop_acer_aspire_7_a715_76_728x__nh_qgesv_008__3.jpg', 0, 0, 1);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(3, 'Đây là laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 0, 'laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 20000000, 'https://hanoicomputercdn.com/media/product/250_77583_laptop_acer_aspire_7_a715_76_728x__nh_qgesv_008__3.jpg', 0, 0, 1);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(3, 'Đây là laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 0, 'laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 20000000, 'https://hanoicomputercdn.com/media/product/250_77583_laptop_acer_aspire_7_a715_76_728x__nh_qgesv_008__3.jpg', 0, 0, 1);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(3, 'Đây là laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 0, 'laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB', 20000000, 'https://hanoicomputercdn.com/media/product/250_77583_laptop_acer_aspire_7_a715_76_728x__nh_qgesv_008__3.jpg', 0, 0, 1);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(1, 'CPU', 'Intel® Core™ i5-12450H', 1)

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(2, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 1)

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(3, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 1)

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(4, 'VGA', 'Intel® UHD Graphics', 1)

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(1, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 1)

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(1, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 1)

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(1, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 1)

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







