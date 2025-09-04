-- Make sure the database exists
CREATE DATABASE IF NOT EXISTS studentdb;
USE studentdb;

-- Create a user with password 1234 (you can change this)
DROP USER IF EXISTS 'student_user'@'localhost';
CREATE USER 'student_user'@'localhost' IDENTIFIED BY '12345';

-- Give all rights on studentdb only (not other databases)
GRANT ALL PRIVILEGES ON studentdb.* TO 'student_user'@'localhost';

-- Apply changes
FLUSH PRIVILEGES;
