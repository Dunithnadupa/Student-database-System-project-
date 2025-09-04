 🎓 Student Management System (Java + JDBC + MySQL)

A simple *console-based Student Management System* built with *Java 11, **JDBC, and **MySQL*.  
The app demonstrates *CRUD operations* (Create, Read, Update, Delete) on a students table in a MySQL database.

---

## ✨ Features
- Connects to MySQL using JDBC (MySQL Connector/J)  
- Table: students (id, name, email, age)  
- CRUD operations:  
  - ➕ Add new student  
  - 📋 View all students  
  - ✏️ Update student by ID  
  - ❌ Delete student by ID  
- Bonus: 🔍 Search students by name  
- Uses *PreparedStatement* to prevent SQL injection  
- Proper resource management with *try-with-resources*

---

## 🛠 Requirements
- Java 11 (JDK 11)  
- MySQL 8+  
- MySQL Connector/J (JDBC driver)  
- VS Code or any Java IDE  

---

## 🗄 Database Setup
Run these commands in *MySQL Workbench* or CLI:

```sql
CREATE DATABASE IF NOT EXISTS studentdb;
USE studentdb;

CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    age INT NOT NULL
);
