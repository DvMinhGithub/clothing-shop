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