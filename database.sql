CREATE DATABASE IF NOT EXISTS event_ticketing_system;

USE event_ticketing_system;

CREATE TABLE users (
    username VARCHAR(100) NOT NULL PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,

    role VARCHAR(20) NOT NULL DEFAULT 'CUSTOMER',
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',

    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),

    CONSTRAINT uk_users_username UNIQUE (username)
);


CREATE TABLE event_categories (
    id CHAR(36) PRIMARY KEY DEFAULT (UUID()),

    name VARCHAR(100) NOT NULL,

    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6)
);


CREATE TABLE venues (
    id CHAR(36) PRIMARY KEY DEFAULT (UUID()),

    name VARCHAR(200) NOT NULL,

    address TEXT NOT NULL,
    city VARCHAR(100) NOT NULL,
    province VARCHAR(100),
    country VARCHAR(100) NOT NULL DEFAULT 'Indonesia',

    latitude DECIMAL(10, 7),
    longitude DECIMAL(10, 7),

    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6)
);


CREATE TABLE events (
    id CHAR(36) PRIMARY KEY DEFAULT (UUID()),

    name VARCHAR(255) NOT NULL,
    description TEXT,
    
    organizer_username VARCHAR(100) NOT NULL,
    category_id CHAR(36) NOT NULL,
    venue_id CHAR(36) NOT NULL,

    start_at DATETIME(6) NOT NULL,
    end_at DATETIME(6) NOT NULL,

    status VARCHAR(20) NOT NULL DEFAULT 'DRAFT',

    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    FOREIGN KEY (organizer_username) REFERENCES users(username),
    FOREIGN KEY (category_id) REFERENCES event_categories(id),
    FOREIGN KEY (venue_id) REFERENCES venues(id)
);
