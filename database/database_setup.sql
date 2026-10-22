CREATE DATABASE it_asset_db;
USE it_asset_db;

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    department VARCHAR(50),
    email VARCHAR(100)
);

CREATE TABLE assets (
    asset_tag VARCHAR(50) PRIMARY KEY,
    device_type VARCHAR(50) NOT NULL,
    model_name VARCHAR(100),
    status VARCHAR(20) DEFAULT 'Available'
);

CREATE TABLE allocations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    asset_tag VARCHAR(50),
    employee_id INT,
    checkout_date DATE,
    return_date DATE NULL,
    FOREIGN KEY (asset_tag) REFERENCES assets(asset_tag),
    FOREIGN KEY (employee_id) REFERENCES employees(id)
);