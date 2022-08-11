CREATE TABLE book(
    id int auto_increment primary key,
    name VARCHAR(255) not null,
    price decimal(10,2) not null,
    status VARCHAR(255) not null,
    custumer_id int not null,
    FOREIGN KEY (custumer_id) REFERENCES custumer(id)
);