CREATE TABLE custumer(
    id int auto_increment primary key,
    name VARCHAR(255) not null,
    email VARCHAR(255) not null unique
);