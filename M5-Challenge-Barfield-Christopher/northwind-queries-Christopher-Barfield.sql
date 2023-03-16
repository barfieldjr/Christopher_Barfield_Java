-- Query 1: What are the categories of products in the database?
SELECT CategoryName
FROM Categories;

-- Query 2: What products are made by Dell?
SELECT ProductName
FROM Products
WHERE SupplierID = (
  SELECT SupplierID
  FROM Suppliers
  WHERE CompanyName LIKE '%Dell%'
);

-- Query 3: List all the orders shipped to Pennsylvania.
SELECT *
FROM Orders
WHERE ShipRegion = 'PA';

-- Query 4: List the first name and last name of all employees with last names that start with the letter W.
SELECT FirstName, LastName
FROM Employees
WHERE LastName LIKE 'W%';

-- Query 5: List all customers from zip codes that start with 55.
SELECT *
FROM Customers
WHERE LEFT(PostalCode, 2) = '55';

-- Query 6: List all customers from zip codes that end with 0.
SELECT *
FROM Customers
WHERE RIGHT(PostalCode, 1) = '0';

-- Query 7: List the first name, last name, and email for all customers with a ".org" email address.
SELECT ContactName AS FirstName, ContactTitle AS LastName, EmailAddress AS Email
FROM Customers
WHERE EmailAddress LIKE '%.org';

-- Query 8: List the first name, last name, and phone number for all customers from the 202 area code.
SELECT ContactName AS FirstName, ContactTitle AS LastName, Phone
FROM Customers
WHERE Phone LIKE '(202)%';

-- Query 9: List the first name, last name, and phone number for all customers from the 202 area code, ordered by last name, first name.
SELECT ContactName AS FirstName, ContactTitle AS LastName, Phone
FROM Customers
WHERE Phone LIKE '(202)%'
ORDER BY LastName, FirstName;
