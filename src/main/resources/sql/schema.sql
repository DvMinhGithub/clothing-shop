CREATE DATABASE IF NOT EXISTS `techStore`;

CREATE TABLE IF NOT EXISTS techStore.`brand`
(
    `id`          bigint       NOT NULL AUTO_INCREMENT,
    `description` varchar(255) DEFAULT NULL,
    `name`        varchar(255) NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS techStore.`product`
(
    `id`            bigint NOT NULL AUTO_INCREMENT,
    `description`   varchar(255)    DEFAULT NULL,
    `is_deleted`    bit(1) NOT NULL DEFAULT 0,
    `name`          varchar(255)    NOT NULL,
    `price`         double          DEFAULT 0,
    `product_image` varchar(255)    DEFAULT NULL,
    `sold`          int    NOT NULL DEFAULT 0,
    `view`          int    NOT NULL DEFAULT 0,
    `brand_id`      bigint          DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_product_brand_id` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`)
);

CREATE TABLE IF NOT EXISTS techStore.`user`
(
    `id`           bigint       NOT NULL AUTO_INCREMENT,
    `address`      varchar(255)                   DEFAULT NULL,
    `avatar`       varchar(255)                   DEFAULT NULL,
    `dob`          date                           DEFAULT NULL,
    `email`        varchar(255) NOT NULL UNIQUE,
    `gender`       enum ('MALE','FEMALE','OTHER') DEFAULT NULL,
    `name`         varchar(255) NOT NULL,
    `password`     varchar(255) NOT NULL,
    `phone_number` varchar(255) NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS techStore.`cart_item`
(
    `id`         bigint NOT NULL AUTO_INCREMENT,
    `quantity`   int    NOT NULL DEFAULT 0,
    `product_id` bigint NOT NULL,
    `user_id`    bigint NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_cart_item_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
    CONSTRAINT `fk_cart_item_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);

CREATE TABLE IF NOT EXISTS techStore.`category`
(
    `id`          bigint       NOT NULL AUTO_INCREMENT,
    `description` varchar(255) DEFAULT NULL,
    `name`        varchar(255) NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS techStore.`voucher`
(
    `id`                bigint       NOT NULL AUTO_INCREMENT,
    `code`              varchar(255) NOT NULL UNIQUE,
    `voucher_condition` double       NOT NULL                       DEFAULT 0,
    `description`       varchar(255)                                DEFAULT NULL,
    `discount_price`    double       NOT NULL                       DEFAULT 0,
    `end_time`          date                                        NOT NULL,
    `start_time`        date                                        NOT NULL,
    `total_quantity`    int          NOT NULL                       DEFAULT 0,
    `used_quantity`     int          NOT NULL                       DEFAULT 0,
    `created_at`        datetime(6)                                 DEFAULT CURRENT_TIMESTAMP(6),
    `updated_at`        datetime(6)                                 DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    `is_active`        bit(1)       NOT NULL                       DEFAULT 0,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS techStore.`order_detail`
(
    `id`           bigint                              NOT NULL AUTO_INCREMENT,
    `address`      varchar(255)                        NOT NULL,
    `created_at`   datetime(6)                         DEFAULT CURRENT_TIMESTAMP(6),
    `phone_number` varchar(255)                        NOT NULL,
    `status`       enum ('CANCEL','SUCCESS','PENDING') NOT NULL,
    `total_price`  double                              NOT NULL,
    `voucher_code` varchar(255) DEFAULT NULL,
    `user_id`      bigint                              NOT NULL,
    `checkout_url` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_order_detail_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `fk_order_detail_voucher_code` FOREIGN KEY (voucher_code) REFERENCES `voucher` (code)
);

CREATE TABLE IF NOT EXISTS techStore.`order_item`
(
    `id`                  bigint NOT NULL AUTO_INCREMENT,
    `price_at_order_time` double NOT NULL,
    `quantity`            int    NOT NULL,
    `order_id`            bigint NOT NULL,
    `product_id`          bigint NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_order_item_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
    CONSTRAINT `fk_order_item_order_id` FOREIGN KEY (`order_id`) REFERENCES `order_detail` (`id`)
);

CREATE TABLE IF NOT EXISTS techStore.`product_attribute`
(
    `id`              bigint NOT NULL AUTO_INCREMENT,
    `attribute_name`  varchar(255) DEFAULT NULL,
    `attribute_value` varchar(255) DEFAULT NULL,
    `product_id`      bigint NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_product_attribute_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
);

CREATE TABLE IF NOT EXISTS techStore.`product_category`
(
    `product_id`  bigint NOT NULL,
    `category_id` bigint NOT NULL,
    PRIMARY KEY (`product_id`, `category_id`),
    CONSTRAINT `fk_product_category_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
    CONSTRAINT `fk_product_category_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
);

CREATE TABLE IF NOT EXISTS techStore.`supplier`
(
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `phone_number` varchar(255) NOT NULL,
    `address` varchar(255) DEFAULT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS techStore.`product_batch`
(
    `id`           bigint NOT NULL AUTO_INCREMENT,
    `import_price` double NOT NULL DEFAULT 0,
    `quantity`     int    NOT NULL DEFAULT 0,
    `product_id`   bigint NOT NULL,
    `created_at`   datetime(6) DEFAULT CURRENT_TIMESTAMP(6),
    `supplier_id`  bigint NOT NULL ,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_product_batch_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
    CONSTRAINT `fk_product_batch_supplier_id` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`)
);

CREATE TABLE IF NOT EXISTS techStore.`role`
(
    `id`   bigint NOT NULL AUTO_INCREMENT,
    `name` enum ('CUSTOMER','EMPLOYEE','ADMIN') DEFAULT NULL UNIQUE,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS techStore.`user_role`
(
    `user_id` bigint NOT NULL,
    `role_id` bigint NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`),
    CONSTRAINT `fk_user_role_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `fk_user_role_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
);

CREATE TABLE IF NOT EXISTS techStore.`rating`
(
    `id` bigint NOT NULL AUTO_INCREMENT,
    `user_id` bigint NOT NULL,
    `product_id` bigint NOT NULL,
    `rating` int DEFAULT NULL,
    PRIMARY KEY(`id`),
    CONSTRAINT `fk_rating_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `fk_rating_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
);

CREATE TABLE IF NOT EXISTS techStore.`promotion`
(
    `id` bigint NOT NULL AUTO_INCREMENT,
    `product_id` bigint NOT NULL,
    `end_time`   date DEFAULT NULL,
    `start_time` date DEFAULT NULL,
    `discount_price` double NOT NULL DEFAULT 0,
    `is_active`      bit(1) NOT NULL DEFAULT 0,
    PRIMARY KEY(`id`),
    CONSTRAINT `fk_promotion_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
);

CREATE TABLE IF NOT EXISTS techStore.`revenue`
(
    `id` bigint NOT NULL AUTO_INCREMENT,
    `date` date,
    `total_revenue` double DEFAULT 0,
    PRIMARY KEY(`id`)
);
