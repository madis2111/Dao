SELECT product_name FROM Customers
JOIN Orders ON Customers.id = Orders.customer_id
WHERE Customers.id = 1 AND LOWER(name) = :name;