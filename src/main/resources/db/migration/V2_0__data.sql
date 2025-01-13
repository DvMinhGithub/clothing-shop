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

INSERT INTO techStore.brand(id, description, name) VALUES(1, 'Đây là thuơng hệu ACER', 'ACER');

INSERT INTO techStore.brand(id, description, name) VALUES(2, 'Đây là thuơng hiệu DELL', 'DELL');

INSERT INTO techStore.brand(id, description, name) VALUES(3, 'Đây là thuơng hiệu ASUS', 'ASUS');

INSERT INTO techStore.brand(id, description, name) VALUES(4, 'Đây là thuơng hiệu HP', 'HP');

INSERT INTO techStore.brand(id, description, name) VALUES(5, 'Đây là thuơng hiệu LENOVO', 'LENOVO');

INSERT INTO techStore.brand(id, description, name) VALUES(6, 'Đây là thuơng hiệu APPLE', 'APPLE');

INSERT INTO techStore.brand(id, description, name) VALUES(7, 'Đây là thuơng hiệu MSI', 'MSI');

INSERT INTO techStore.brand(id, description, name) VALUES(8, 'Đây là thuơng hiệu LG', 'LG');

INSERT INTO techStore.brand(id, description, name) VALUES(9, 'Đây là thuơng hiệu VAIO', 'VAIO');

INSERT INTO techStore.category(id, description, name) VALUES(1, 'Đây là danh mục laptop văn phòng', 'Laptop văn phòng');

INSERT INTO techStore.category(id, description, name) VALUES(2, 'Đây là danh mục laptop gaming', 'Laptop gaming');

INSERT INTO techStore.category(id, description, name) VALUES(3, 'Đây là danh mục laptop cảm ứng', 'Laptop cảm ứng');

INSERT INTO techStore.category(id, description, name) VALUES(4, 'Đây là danh mục laptop đồ hoạ', 'Laptop đồ hoạ');

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(1, 'Đây là laptop ACER ASPIRE 7 A715-76-53PJ (NH.QGESV.007) (I5 12450H/16GB RAM/512GB)', 0, 'LAPTOP ACER ASPIRE 7 A715-76-53PJ (NH.QGESV.007) (I5 12450H/16GB RAM/512GB)', 14000000, 'https://hanoicomputercdn.com/media/product/250_76816_laptop_acer_aspire_7_a715_76_53pj__nh_qgesv_007___1_.jpg', 0, 0, 1);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(2, 'Đây là laptop ACER ASPIRE LITE AL16-51P-55N7 (NX.KX0SV.001) (I5 1235U/16GB/512GB SSD/16)', 0, 'LAPTOP ACER ASPIRE LITE AL16-51P-55N7 (NX.KX0SV.001) (I5 1235U/16GB/512GB SSD/16)', 17000000, 'https://hanoicomputercdn.com/media/product/250_84394_laptop_acer_aspire_lite_al16_51p_55n7_nx_kx0sv__3_.jpg', 0, 0, 1);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(3, 'Đây là laptop ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB)', 0, 'LAPTOP ACER ASPIRE 7 A715-76-728X (NH.QGESV.008) (I7 12650H/16GB RAM/512GB)', 20000000, 'https://hanoicomputercdn.com/media/product/250_77583_laptop_acer_aspire_7_a715_76_728x__nh_qgesv_008__3.jpg', 0, 0, 1);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(4, 'Đây là laptop ASUS ZENBOOK UX3402VA-KM203W (I5 1340P/16GB RAM/512GB)', 0, 'LAPTOP ASUS ZENBOOK UX3402VA-KM203W (I5 1340P/16GB RAM/512GB)', 20000000, 'https://hanoicomputercdn.com/media/product/250_71267_ux3402va_km203w.png', 0, 0, 3);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(5, 'Đây là laptop ASUS VIVOBOOK X1504VA-NJ070W (I5 1335U/16GB RAM/512GB)', 0, 'LAPTOP ASUS VIVOBOOK X1504VA-NJ070W (I5 1335U/16GB RAM/512GB)', 22000000, 'https://hanoicomputercdn.com/media/product/250_73232_laptop_asus_vivobook_x1504va_nj070w.jpg', 0, 0, 3);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(6, 'Đây là laptop ASUS VIVOBOOK X1504ZA-NJ582W (I3 1215U/8GB RAM/512GB)', 0, 'LAPTOP ASUS VIVOBOOK X1504ZA-NJ582W (I3 1215U/8GB RAM/512GB)', 30000000, 'https://hanoicomputercdn.com/media/product/250_76877_46130_582w.jpg', 0, 0, 3);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(7, 'Đây là laptop DELL LATITUDE 3540 (71038102) (I7-1355U/16GB RAM/512GB SSD/15.6 INCH)', 0, 'LAPTOP DELL LATITUDE 3540 (71038102) (I7-1355U/16GB RAM/512GB SSD/15.6 INCH)', 22000000, 'https://hanoicomputercdn.com/media/product/250_77789_laptop_dell_latitude_3540__71021489_.jpg', 0, 0, 2);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(8, 'Đây là laptop AI DELL XPS 13 PLUS 9320 (71013325) (I5 1340P/16GB RAM/512GB)', 0, 'LAPTOP AI DELL XPS 13 PLUS 9320 (71013325) (I5 1340P/16GB RAM/512GB)', 19000000, 'https://hanoicomputercdn.com/media/product/250_76265_laptop_dell_xps_13_plus_9320__71013325_.jpg', 0, 0, 2);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(9, 'Đây là laptop AI DELL XPS 13 9340 (71034922) (ULTRA 5 125H/16GB RAM/1TB SSD/13.4)', 0, 'LAPTOP AI DELL XPS 13 9340 (71034922) (ULTRA 5 125H/16GB RAM/1TB SSD/13.4', 18000000, 'https://hanoicomputercdn.com/media/product/250_82352_laptop_dell_xps_13_9340__71034923_.jpg', 0, 0, 2);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(10, 'Đây là laptop HP PROBOOK 440 G10 (9H8U1PT) (I3 1315U/8GB RAM/256GB SSD/14)', 0, 'LAPTOP HP PROBOOK 440 G10 (9H8U1PT) (I3 1315U/8GB RAM/256GB SSD/14)', 20000000, 'https://hanoicomputercdn.com/media/product/250_80939_laptop_hp_probook_440_g10__873b1pa___1.jpg', 0, 0, 4);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(11, 'Đây là laptop HP PROBOOK 440 G10 (873A2PA) (I3 1315U/8GB RAM/256GB SSD/14)', 0, 'LAPTOP HP PROBOOK 440 G10 (873A2PA) (I3 1315U/8GB RAM/256GB SSD/14)', 22000000, 'https://hanoicomputercdn.com/media/product/250_82488_laptop_hp_probook_440_g10__873a2pa_.jpg', 0, 0, 4);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(12, 'Đây là laptop HP PAVILION 15-EG3095TU (8C5L6PA) (I5 1335U/8GB RAM/512GB)', 0, 'LAPTOP HP PAVILION 15-EG3095TU (8C5L6PA) (I5 1335U/8GB RAM/512GB', 21000000, 'https://hanoicomputercdn.com/media/product/250_75386_laptop_hp_pavilion_15_eg3095tu__8c5l6pa____2_.jpg', 0, 0, 4);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(13, 'Đây là laptop LENOVO THINKBOOK 15 G4 (21DJ00CWVN) (I7 1255U/8GB RAM/512GB)', 0, 'LAPTOP LENOVO THINKBOOK 15 G4 (21DJ00CWVN) (I7 1255U/8GB RAM/512GB)', 18000000, 'https://hanoicomputercdn.com/media/product/250_73173_lenovo_thinkbook_15_g4__21dj00cwvn___3_.jpg', 0, 0, 5);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(14, 'Đây là laptop LENOVO IDEAPAD 3 15AIU7 (82RK015AVN) (I3 1215U/16GB RAM/512GB)', 0, 'LAPTOP LENOVO IDEAPAD 3 15AIU7 (82RK015AVN) (I3 1215U/16GB RAM/512GB', 21000000, 'https://hanoicomputercdn.com/media/product/250_84060_82rk015avn.jpg', 0, 0, 5);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(15, 'Đây là laptop LENOVO THINKPAD T14 GEN 4 (I5 1335U/16GB RAM/512GB SSD)', 0, 'LAPTOP LENOVO THINKPAD T14 GEN 4 (I5 1335U/16GB RAM/512GB SSD)', 19000000, 'https://hanoicomputercdn.com/media/product/250_77367_laptop_lenovo_thinkpad_t14_gen_4__21hd006pva___6_.jpg', 0, 0, 5);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(16, 'Đây là laptop APPLE MACBOOK AIR (Z15W005J9) (APPLE M2/8C CPU/10C GPU/16GB)', 0, 'LAPTOP APPLE MACBOOK AIR (Z15W005J9) (APPLE M2/8C CPU/10C GPU/16GB)', 30000000, 'https://hanoicomputercdn.com/media/product/250_82682_laptop_apple_macbook_air__z15w005j9_.jpg', 0, 0, 6);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(17, 'Đây là laptop APPLE MACBOOK AIR (Z15S006J7) (APPLE M2/8C CPU/10C GPU/16GB)', 0, 'LAPTOP APPLE MACBOOK AIR (Z15S006J7) (APPLE M2/8C CPU/10C GPU/16GB)', 30000000, 'https://hanoicomputercdn.com/media/product/250_82681_laptop_apple_macbook_air__z15s006j7_.jpg', 0, 0, 6);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(18, 'Đây là laptop APPLE MACBOOK PRO 14 (MXE13SA/A) (APPLE M3 8 CORE CPU/10 CORE GPU/16GB)', 0, 'LAPTOP APPLE MACBOOK PRO 14 (MXE13SA/A) (APPLE M3 8 CORE CPU/10 CORE GPU/16GB)', 29000000, 'https://hanoicomputercdn.com/media/product/250_82046_laptop_apple_macbook_pro_14__mxe13saa___3_.jpg', 0, 0, 6);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(19, 'Đây là laptop MSI MODERN 15 H (C13M-216VN) ( I7-13700H/16GB DDR4/SSD 1TB)', 0, 'LAPTOP MSI MODERN 15 H (C13M-216VN) ( I7-13700H/16GB DDR4/SSD 1TB)', 21000000, 'https://hanoicomputercdn.com/media/product/250_82838_file_pts_chu___n_l____0003_laptop_msi_modern_14_h__1_.png', 0, 0, 7);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(20, 'Đây là laptop MSI PRESTIGE 14EVO (B13M-401VN) (I5 13500H/16GB RAM/512GB)', 0, 'LAPTOP MSI PRESTIGE 14EVO (B13M-401VN) (I5 13500H/16GB RAM/512GB)', 23000000, 'https://hanoicomputercdn.com/media/product/250_71031_laptop_msi_prestige_14evo_b13m_5.png', 0, 0, 7);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(21, 'Đây là laptop MSI MODERN 15 (B7M-238VN) (R7 7730U/16GB RAM/512GB SSD/15.6 INCH)', 0, 'LAPTOP MSI MODERN 15 (B7M-238VN) (R7 7730U/16GB RAM/512GB SSD/15.6 INCH)', 21000000, 'https://hanoicomputercdn.com/media/product/250_73283_laptop_msi_modern_15__b7m_238vn___1_.png', 0, 0, 7);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(22, 'Đây là laptop LG GRAM 16Z90R-G.AH76A5 (I7-1360P/16GB RAM/512GB SSD/16.0 INCH)', 0, 'LAPTOP LG GRAM 16Z90R-G.AH76A5 (I7-1360P/16GB RAM/512GB SSD/16.0 INCH)', 19000000, 'https://hanoicomputercdn.com/media/product/250_71768_laptop_lg_gram_16z90r_g_ah76a5_1.jpg', 0, 0, 8);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(23, 'Đây là laptop LG GRAM 14Z90R-G.AH75A5 (I7-1360P/16GB RAM/512GB SSD/14.0 INCH)', 0, 'LAPTOP LG GRAM 14Z90R-G.AH75A5 (I7-1360P/16GB RAM/512GB SSD/14.0 INCH)', 21000000, 'https://hanoicomputercdn.com/media/product/250_71766_laptop_lg_gram_14z90r_6.png', 0, 0, 8);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(24, 'Đây là laptop LG GRAM 14Z90R-G.AH53A5 (I5-1340P/16GB RAM/256GB SSD/14.0 INCH)', 0, 'LAPTOP LG GRAM 14Z90R-G.AH53A5 (I5-1340P/16GB RAM/256GB SSD/14.0 INCH)', 23000000, 'https://hanoicomputercdn.com/media/product/250_71765_laptop_lg_gram_14z90r_6.png', 0, 0, 8);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(25, 'Đây là laptop VAIO FE 14 (VWNC51427-SL) (I5-1235U/8GB RAM/512GB)', 0, 'LAPTOP VAIO FE 14 (VWNC51427-SL) (I5-1235U/8GB RAM/512GB)', 22000000, 'https://hanoicomputercdn.com/media/product/250_73014_laptop_vaio_fe_14__vwnc51427_sl___2_.jpg', 0, 0, 9);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(26, 'Đây là laptop VAIO FE 15 (VWNC51527-SL) (I5-1235U/8GB RAM/512GB)', 0, 'LAPTOP VAIO FE 15 (VWNC51527-SL) (I5-1235U/8GB RAM/512GB)', 22000000, 'https://hanoicomputercdn.com/media/product/250_73011_vwnc51527__4_.jpg', 0, 0, 9);

INSERT INTO techStore.product
(id, description, is_deleted, name, price, product_image, sold, `view`, brand_id)
VALUES(27, 'Đây là LAPTOP VAIO FE 15 (VWNC51527-BK) (I5-1235U/8GB RAM/512GB)', 0, 'LAPTOP VAIO FE 15 (VWNC51527-BK) (I5-1235U/8GB RAM/512GB)', 22000000, 'https://hanoicomputercdn.com/media/product/250_73012_laptop_vaio_fe_15__vwnc51527_bk___1_.jpg', 0, 0, 9);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(1, 1);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(2, 2);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(3, 3);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(4, 4);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(5, 1);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(6, 2);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(7, 3);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(8, 4);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(9, 1);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(10, 2);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(11, 3);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(12, 4);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(13, 1);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(14, 2);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(15, 3);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(16, 4);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(17, 1);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(18, 2);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(19, 3);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(20, 4);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(21, 1);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(21, 2);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(23, 3);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(24, 4);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(25, 1);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(26, 2);

INSERT INTO techStore.product_category
(product_id, category_id)
VALUES(27, 3);

INSERT INTO techStore.supplier
(id, name, phone_number, address)
VALUES(1, 'Nhà cung cấp ACER', '0823539320', 'Hà Nội');

INSERT INTO techStore.supplier
(id, name, phone_number, address)
VALUES(2, 'Nhà cung cấp DELL', '0823539321', 'Đà Nẵng');

INSERT INTO techStore.supplier
(id, name, phone_number, address)
VALUES(3, 'Nhà cung cấp ASUS', '0823539322', 'Hà Nội');

INSERT INTO techStore.supplier
(id, name, phone_number, address)
VALUES(4, 'Nhà cung cấp HP', '0823539323', 'Hà Nội');

INSERT INTO techStore.supplier
(id, name, phone_number, address)
VALUES(5, 'Nhà cung cấp LENOVO', '0823539324', 'Hà Nội');

INSERT INTO techStore.supplier
(id, name, phone_number, address)
VALUES(6, 'Nhà cung cấp APPLE', '0823539325', 'Đà Nẵng');

INSERT INTO techStore.supplier
(id, name, phone_number, address)
VALUES(7, 'Nhà cung cấp MSI', '0823539326', 'Đà Nẵng');

INSERT INTO techStore.supplier
(id, name, phone_number, address)
VALUES(8, 'Nhà cung cấp LG', '0823539327', 'Đà Nẵng');

INSERT INTO techStore.supplier
(id, name, phone_number, address)
VALUES(9, 'Nhà cung cấp VAIO', '0823539328', 'Đà Nẵng');

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(1, 10000000, 100, 1, '2024-01-06', 1);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(2, 12000000, 100, 2, '2024-01-06', 1);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(3, 11000000, 100, 3, '2024-01-06', 1);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(4, 10000000, 100, 4, '2024-01-06', 3);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(5, 12000000, 100, 5, '2024-01-06', 3);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(6, 10000000, 100, 6, '2024-01-06', 3);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(7, 14000000, 100, 7, '2024-01-06', 2);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(8, 10000000, 100, 8, '2024-01-06', 2);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(9, 13000000, 100, 9, '2024-01-06', 2);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(10, 10000000, 100, 10, '2024-01-06', 4);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(11, 15000000, 100, 11, '2024-01-06', 4);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(12, 17000000, 100, 12, '2024-01-06', 4);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(13, 12000000, 100, 13, '2024-01-06', 5);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(14, 10000000, 100, 14, '2024-01-06', 5);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(15, 12000000, 100, 15, '2024-01-06', 5);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(16, 13000000, 100, 16, '2024-01-06', 6);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(17, 15000000, 100, 17, '2024-01-06', 6);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(18, 14000000, 100, 18, '2024-01-06', 6);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(19, 13000000, 100, 19, '2024-01-06', 7);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(20, 12000000, 100, 20, '2024-01-06', 7);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(21, 14000000, 100, 21, '2024-01-06', 7);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(22, 13000000, 100, 22, '2024-01-06', 8);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(23, 15000000, 100, 23, '2024-01-06', 8);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(24, 16000000, 100, 24, '2024-01-06', 8);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(25, 15000000, 100, 25, '2024-01-06', 9);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(26, 13000000, 100, 26, '2024-01-06', 9);

INSERT INTO techStore.product_batch
(id, import_price, quantity, product_id, created_at, supplier_id)
VALUES(27, 16000000, 100, 27, '2024-01-06', 9);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(1, 'CPU', 'Intel® Core™ i5-12450H', 1);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(2, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 1);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(3, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 1);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(4, 'VGA', 'Intel® UHD Graphics', 1);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(5, 'CPU', 'Intel® Core™ i5-12450H', 2);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(6, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 2);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(7, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 2);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(8, 'VGA', 'Intel® UHD Graphics', 2);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(9, 'CPU', 'Intel® Core™ i5-12450H', 3);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(10, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 3);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(11, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 3);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(12, 'VGA', 'Intel® UHD Graphics', 3);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(13, 'CPU', 'Intel® Core™ i5-12450H', 4);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(14, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 4);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(15, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 4);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(16, 'VGA', 'Intel® UHD Graphics', 4);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(17, 'CPU', 'Intel® Core™ i5-12450H', 5);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(18, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 5);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(19, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 5);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(20, 'VGA', 'Intel® UHD Graphics', 5);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(21, 'CPU', 'Intel® Core™ i5-12450H', 6);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(22, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 6);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(23, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 6);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(24, 'VGA', 'Intel® UHD Graphics', 6);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(25, 'CPU', 'Intel® Core™ i5-12450H', 7);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(26, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 7);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(27, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 7);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(28, 'VGA', 'Intel® UHD Graphics', 7);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(29, 'CPU', 'Intel® Core™ i5-12450H', 8);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(30, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 8);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(31, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 8);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(32, 'VGA', 'Intel® UHD Graphics', 8);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(33, 'CPU', 'Intel® Core™ i5-12450H', 9);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(34, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 9);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(35, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 9);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(36, 'VGA', 'Intel® UHD Graphics', 9);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(37, 'CPU', 'Intel® Core™ i5-12450H', 10);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(38, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 10);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(39, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 10);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(40, 'VGA', 'Intel® UHD Graphics', 10);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(41, 'CPU', 'Intel® Core™ i5-12450H', 11);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(42, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 11);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(43, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 11);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(44, 'VGA', 'Intel® UHD Graphics', 11);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(45, 'CPU', 'Intel® Core™ i5-12450H', 12);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(46, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 12);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(47, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 12);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(48, 'VGA', 'Intel® UHD Graphics', 12);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(49, 'CPU', 'Intel® Core™ i5-12450H', 13);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(50, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 13);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(51, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 13);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(52, 'VGA', 'Intel® UHD Graphics', 13);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(53, 'CPU', 'Intel® Core™ i5-12450H', 14);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(54, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 14);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(55, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 14);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(56, 'VGA', 'Intel® UHD Graphics', 14);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(57, 'CPU', 'Intel® Core™ i5-12450H', 15);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(58, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 15);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(59, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 15);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(60, 'VGA', 'Intel® UHD Graphics', 15);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(61, 'CPU', 'Intel® Core™ i5-12450H', 16);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(62, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 16);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(63, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 16);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(64, 'VGA', 'Intel® UHD Graphics', 16);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(65, 'CPU', 'Intel® Core™ i5-12450H', 17);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(66, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 17);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(67, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 17);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(68, 'VGA', 'Intel® UHD Graphics', 17);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(69, 'CPU', 'Intel® Core™ i5-12450H', 18);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(70, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 18);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(71, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 18);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(72, 'VGA', 'Intel® UHD Graphics', 18);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(73, 'CPU', 'Intel® Core™ i5-12450H', 19);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(74, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 19);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(75, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 19);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(76, 'VGA', 'Intel® UHD Graphics', 19);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(77, 'CPU', 'Intel® Core™ i5-12450H', 20);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(78, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 20);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(79, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 20);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(80, 'VGA', 'Intel® UHD Graphics', 20);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(81, 'CPU', 'Intel® Core™ i5-12450H', 21);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(82, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 21);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(83, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 21);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(84, 'VGA', 'Intel® UHD Graphics', 21);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(85, 'CPU', 'Intel® Core™ i5-12450H', 22);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(86, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 22);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(87, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 22);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(88, 'VGA', 'Intel® UHD Graphics', 22);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(89, 'CPU', 'Intel® Core™ i5-12450H', 23);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(90, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 23);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(91, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 23);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(92, 'VGA', 'Intel® UHD Graphics', 23);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(93, 'CPU', 'Intel® Core™ i5-12450H', 24);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(94, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 24);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(95, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 24);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(96, 'VGA', 'Intel® UHD Graphics', 24);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(97, 'CPU', 'Intel® Core™ i5-12450H', 25);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(98, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 25);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(99, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 25);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(100, 'VGA', 'Intel® UHD Graphics', 25);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(101, 'CPU', 'Intel® Core™ i5-12450H', 26);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(102, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 26);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(103, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 26);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(104, 'VGA', 'Intel® UHD Graphics', 26);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(105, 'CPU', 'Intel® Core™ i5-12450H', 27);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(106, 'RAM', '16GB (8GBx2) DDR4 3200 MHz (Tối đa 32GB)', 27);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(107, 'Ổ cứng', '512GB SSD PCIe NVMe (Nâng cấp thay thế,tối đa 1TB)(Còn trống 1 khe)', 27);

INSERT INTO techStore.product_attribute(id, attribute_name, attribute_value, product_id) VALUES(108, 'VGA', 'Intel® UHD Graphics', 27);

INSERT INTO techStore.order_detail
(id, order_code, address, created_at, phone_number, status, total_price, voucher_code, user_id, checkout_url)
VALUES(1, '1234567890', 'Hà Nội','2024-07-05 03:12:11', '0823539326', 'SUCCESS', 14000000, null, 2, '');

INSERT INTO techStore.order_detail
(id, order_code, address, created_at, phone_number, status, total_price, voucher_code, user_id, checkout_url)
VALUES(2, '1234567890', 'Hà Nội','2024-07-04 03:12:11', '0823539326', 'SUCCESS', 17000000, null, 2, '');

INSERT INTO techStore.order_detail
(id, order_code, address, created_at, phone_number, status, total_price, voucher_code, user_id, checkout_url)
VALUES(3, '1234567890', 'Hà Nội','2024-07-03 03:12:11', '0823539326', 'SUCCESS', 20000000, null, 2, '');

INSERT INTO techStore.order_detail
(id, order_code, address, created_at, phone_number, status, total_price, voucher_code, user_id, checkout_url)
VALUES(4, '1234567890', 'Hà Nội','2024-07-02 03:12:11', '0823539326', 'SUCCESS', 20000000, null, 2, '');

INSERT INTO techStore.order_detail
(id, order_code, address, created_at, phone_number, status, total_price, voucher_code, user_id, checkout_url)
VALUES(5, '1234567890', 'Hà Nội','2024-07-01 03:12:11', '0823539326', 'SUCCESS', 22000000, null, 2, '');

INSERT INTO techStore.order_detail
(id, order_code, address, created_at, phone_number, status, total_price, voucher_code, user_id, checkout_url)
VALUES(6, '1234567890', 'Hà Nội','2024-06-30 03:12:11', '0823539326', 'SUCCESS', 30000000, null, 2, '');

INSERT INTO techStore.order_detail
(id, order_code, address, created_at, phone_number, status, total_price, voucher_code, user_id, checkout_url)
VALUES(7, '1234567890', 'Hà Nội','2024-05-30 03:12:11', '0823539326', 'SUCCESS', 22000000, null, 2, '');

INSERT INTO techStore.order_item
(id, price_at_order_time, quantity, order_id, product_id)
VALUES(1, 14000000, 1, 1, 1);

INSERT INTO techStore.order_item
(id, price_at_order_time, quantity, order_id, product_id)
VALUES(2, 17000000, 1, 2, 2);

INSERT INTO techStore.order_item
(id, price_at_order_time, quantity, order_id, product_id)
VALUES(3, 20000000, 1, 3, 3);

INSERT INTO techStore.order_item
(id, price_at_order_time, quantity, order_id, product_id)
VALUES(4, 20000000, 1, 4, 4);

INSERT INTO techStore.order_item
(id, price_at_order_time, quantity, order_id, product_id)
VALUES(5, 22000000, 1, 5, 5);

INSERT INTO techStore.order_item
(id, price_at_order_time, quantity, order_id, product_id)
VALUES(6, 30000000, 1, 6, 6);

INSERT INTO techStore.order_item
(id, price_at_order_time, quantity, order_id, product_id)
VALUES(7, 22000000, 1, 7, 7);














