CREATE TABLE IF NOT EXISTS price (
    id INT PRIMARY KEY AUTO_INCREMENT,
    brand_id INT,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    price_list INT,
    product_id INT,
    priority INT,
    price DECIMAL(10, 2),
    curr VARCHAR(10),
    
    FOREIGN KEY (brand_id) REFERENCES BRAND(brand_id),
    FOREIGN KEY (price_list) REFERENCES PRICE_LIST(price_list_id),
    FOREIGN KEY (product_id) REFERENCES PRODUCT(product_id)
);