-- role table
CREATE TABLE role (
    id BIGINT NOT NULL AUTO_INCREMENT,
    created_by BIGINT,
    created_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    deleted TINYINT(1) NULL DEFAULT 0,
    modified_by BIGINT,
    modified_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    role_name VARCHAR(255),
    role_value INTEGER,
    PRIMARY KEY (id)
);

-- user table
CREATE TABLE user (
    id BIGINT NOT NULL AUTO_INCREMENT,
    created_by BIGINT,
    created_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    deleted TINYINT(1) NULL DEFAULT 0,
    modified_by BIGINT,
    modified_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    dob VARCHAR(255),
    email VARCHAR(255),
    firstname VARCHAR(255),
    gender VARCHAR(255),
    is_active VARCHAR(255),
    last_access_date VARCHAR(255),
    lastname VARCHAR(255),
    mobile VARCHAR(255),
    password VARCHAR(255),
    username VARCHAR(255),
    image_id BIGINT,
    PRIMARY KEY (id)
);

-- address type table
CREATE TABLE address_type (
    id BIGINT NOT NULL AUTO_INCREMENT,
    created_by BIGINT,
    created_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    deleted TINYINT(1) NULL DEFAULT 0,
    modified_by BIGINT,
    modified_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    address_type VARCHAR(255),
    PRIMARY KEY (id)
);

-- Post Table
CREATE TABLE post (
    id BIGINT NOT NULL AUTO_INCREMENT,
    created_by BIGINT,
    created_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    deleted TINYINT(1) NULL DEFAULT 0,
    modified_by BIGINT,
    modified_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    post_description VARCHAR(255),
    image_id BIGINT,
    post_type BIGINT,
    user_id BIGINT,
    PRIMARY KEY (id)
);

-- Reaction Type Table
CREATE TABLE reaction_type (
    id BIGINT NOT NULL AUTO_INCREMENT,
    created_by BIGINT,
    created_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    deleted TINYINT(1) NULL DEFAULT 0,
    modified_by BIGINT,
    modified_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    reaction_name VARCHAR(255),
    PRIMARY KEY (id)
);

-- Comment table
CREATE TABLE comment (
    id BIGINT NOT NULL AUTO_INCREMENT,
    created_by BIGINT,
    created_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    deleted TINYINT(1) NULL DEFAULT 0,
    modified_by BIGINT,
    modified_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    comment VARCHAR(255),
    parent_comment_id VARCHAR(255),
    post_id BIGINT,
    user_id BIGINT,
    PRIMARY KEY (id)
);

-- Image Table
CREATE TABLE image (
    id BIGINT NOT NULL AUTO_INCREMENT,
    created_by BIGINT,
    created_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    deleted TINYINT(1) NULL DEFAULT 0,
    modified_by BIGINT,
    modified_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    image_latitude VARCHAR(255),
    image_longitude VARCHAR(255),
    image_name VARCHAR(255),
    image_url VARCHAR(255),
    PRIMARY KEY (id)
);

-- Pincode table
CREATE TABLE pincode (
    id BIGINT NOT NULL AUTO_INCREMENT,
    created_by BIGINT,
    created_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    deleted TINYINT(1) NULL DEFAULT 0,
    modified_by BIGINT,
    modified_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    city VARCHAR(255),
    pincode VARCHAR(255),
    state VARCHAR(255),
    PRIMARY KEY (id)
);

-- Post Type Table
CREATE TABLE post_type (
    id BIGINT NOT NULL AUTO_INCREMENT,
    created_by BIGINT,
    created_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    deleted TINYINT(1) NULL DEFAULT 0,
    modified_by BIGINT,
    modified_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    post_type VARCHAR(255),
    PRIMARY KEY (id)
);

-- Reaction
CREATE TABLE reaction (
    id BIGINT NOT NULL AUTO_INCREMENT,
    created_by BIGINT,
    created_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    deleted TINYINT(1) NULL DEFAULT 0,
    modified_by BIGINT,
    modified_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    object_id VARCHAR(255),
    post_type VARCHAR(255),
    reaction_id BIGINT,
    user_id BIGINT,
    PRIMARY KEY (id)
);

-- User Role Map Table
CREATE TABLE user_role_map (
    id BIGINT NOT NULL AUTO_INCREMENT,
    created_by BIGINT,
    created_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    deleted TINYINT(1) NULL DEFAULT 0,
    modified_by BIGINT,
    modified_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    role_id BIGINT,
    user_id BIGINT,
    PRIMARY KEY (id)
);

-- Address Details
CREATE TABLE address (
    id BIGINT NOT NULL AUTO_INCREMENT,
    created_by BIGINT,
    created_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    deleted TINYINT(1) NULL DEFAULT 0,
    modified_by BIGINT,
    modified_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    address_line_1 VARCHAR(255),
    address_line_2 VARCHAR(255),
    landmark VARCHAR(255),
    latitude VARCHAR(255),
    locality VARCHAR(255),
    longitude VARCHAR(255),
    title VARCHAR(255),
    address_type_id BIGINT,
    pincode BIGINT,
    user_id BIGINT,
    PRIMARY KEY (id)
);

-- Post Image Mapping
CREATE TABLE post_image_mapping (
    id BIGINT NOT NULL AUTO_INCREMENT,
    created_by BIGINT,
    created_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    deleted TINYINT(1) NULL DEFAULT 0,
    modified_by BIGINT,
    modified_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    image_id BIGINT,
    post_id BIGINT,
    PRIMARY KEY (id)
)  ENGINE=INNODB

