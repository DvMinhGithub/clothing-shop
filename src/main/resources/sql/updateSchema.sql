ALTER TABLE techStore.order_detail ADD COLUMN order_code varchar(255);

ALTER TABLE techStore.revenue ADD UNIQUE (date);

ALTER TABLE techStore.order_detail MODIFY status ENUM('CANCEL', 'PENDING', 'SUCCESS', 'RETURN');