CREATE TABLE tbl_department (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    manager_id BIGINT UNSIGNED,
    secretary_id BIGINT UNSIGNED,
    PRIMARY KEY (id)
    
);

