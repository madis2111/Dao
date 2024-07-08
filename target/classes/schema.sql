create table netology.Customers(
   id int primary key AUTO_INCREMENT,
   name varchar(50),
   surename varchar(50),
   age int,
   phone_number text
);

insert into netology.Customers (id, name, surename, age, phone_number)
values (1,'Alexey', 'Alexeev', 35, 79999430125);
insert into netology.Customers (name, surename, age, phone_number)
values ('Ivan', 'Ivanov', 23, 79944567971);
insert into netology.Customers (name, surename, age, phone_number)
values ('Petr', 'Petrov', 29, 79865251530);
insert into netology.Customers (name, surename, age, phone_number)
values ('Vasiliy', 'Vasilev', 22, 79943213990);


create table netology.Orders(
    id int primary key auto_increment,
    order_data date,
    customer_id int,
    product_name text,
    amount int
);

ALTER TABLE Orders
    ADD CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES Customers(id);

insert into netology.Orders (id, order_data, customer_id,product_name, amount)
values (1, '2023-05-17', 1, 'молоко', 50);
insert into netology.Orders (order_data, customer_id,product_name, amount)
values ('2024-02-02', 2, 'хлеб', 30);
insert into netology.Orders (order_data, customer_id,product_name, amount)
values ('2024-07-21', 1, 'сыр', 40);