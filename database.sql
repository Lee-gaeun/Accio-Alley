CREATE DATABASE IF NOT EXISTS Accio_Alley;
CREATE USER IF NOT EXISTS 'scoula'@'%' IDENTIFIED BY '비밀번호';
GRANT ALL PRIVILEGES ON Accio_Alley.* TO 'scoula'@'%';
FLUSH PRIVILEGES;

USE Accio_Alley;

-- 사용자 (마법사) 테이블
CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       name VARCHAR(30) NOT NULL,
                       nickname VARCHAR(10)
);

-- 상품 테이블
CREATE TABLE products (
                          product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          product_name VARCHAR(100) NOT NULL,
                          description TEXT,
                          price INT NOT NULL,
                          quantity INT NOT NULL
);

-- 장바구니 테이블
CREATE TABLE carts (
                       cart_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       user_id BIGINT NOT NULL,
                       product_id BIGINT NOT NULL,
                       quantity INT NOT NULL,
                       is_ordered BOOLEAN DEFAULT FALSE,
                       FOREIGN KEY (user_id) REFERENCES users(id),
                       FOREIGN KEY (product_id) REFERENCES products(product_id),
                       UNIQUE KEY unique_user_product (user_id, product_id)
);

-- 리뷰 테이블
CREATE TABLE reviews (
                         review_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         user_id BIGINT NOT NULL,
                         product_id BIGINT NOT NULL,
                         rating INT NOT NULL,
                         comment TEXT,
                         FOREIGN KEY (user_id) REFERENCES users(id),
                         FOREIGN KEY (product_id) REFERENCES products(product_id)
);
