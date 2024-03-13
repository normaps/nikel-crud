CREATE DATABASE nikel;

CREATE TABLE users (
    id VARCHAR(32) DEFAULT (uuid()),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
);