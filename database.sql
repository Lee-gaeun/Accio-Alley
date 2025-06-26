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

-- 상품 추가
INSERT INTO products (product_name, description, price, quantity)
VALUES
    ('마법지팡이', '강력한 마력을 품은 지팡이입니다.', 5000, 10),
    ('투명망토', '입으면 투명해지는 마법의 망토입니다.', 8000, 3),
    ('변신물약', '마시면 다른 모습으로 변할 수 있는 물약입니다.', 3000, 15),
    ('부엉이 우편세트', '마법 편지를 부엉이로 보낼 수 있는 세트 상품.', 2000, 20),
    ('호그와트 지도', '어디든지 다 볼 수 있는 마법 지도.', 6000, 5);

