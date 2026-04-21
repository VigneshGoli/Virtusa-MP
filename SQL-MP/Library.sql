--- Creations

CREATE DATABASE library_db_mp;
USE library_db_mp;

-- Books Table
CREATE TABLE Books (
    book_id INT PRIMARY KEY,
    title VARCHAR(100),
    category VARCHAR(50)
);

-- Students Table
CREATE TABLE Students (
    student_id INT PRIMARY KEY,
    name VARCHAR(100)
);

-- Issued Books Table
CREATE TABLE IssuedBooks (
    issue_id INT PRIMARY KEY,
    student_id INT,
    book_id INT,
    issue_date DATE,
    return_date DATE,
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id)
);



--- Insertions

-- Books
INSERT INTO Books VALUES
(1, 'Java Basics', 'Science'),
(2, 'World History', 'History'),
(3, 'Harry Potter', 'Fiction'),
(4, 'Data Structures', 'Science'),
(5, 'Ancient India', 'History');

-- Students
INSERT INTO Students (student_id, name) VALUES
(101, 'Vignesh'),
(102, 'Rahul'),
(103, 'Sneha'),
(104, 'Arjun'),
(105, 'Meena');

-- Issued Books
INSERT INTO IssuedBooks VALUES
-- Overdue (more than 14 days, not returned)
(1, 101, 1, CURDATE() - INTERVAL 20 DAY, NULL),

-- Returned properly
(2, 102, 2, CURDATE() - INTERVAL 10 DAY, CURDATE() - INTERVAL 5 DAY),

-- Overdue
(3, 103, 3, CURDATE() - INTERVAL 25 DAY, NULL),

-- Old record (more than 3 years ago → inactive candidate)
(4, 104, 4, CURDATE() - INTERVAL 4 YEAR, CURDATE() - INTERVAL 4 YEAR + INTERVAL 5 DAY),

-- Recent active user
(5, 105, 5, CURDATE() - INTERVAL 5 DAY, NULL);



--- Queries

-- Overdue
SELECT s.name, b.title, i.issue_date
FROM IssuedBooks i
JOIN Students s ON i.student_id = s.student_id
JOIN Books b ON i.book_id = b.book_id
WHERE i.return_date IS NULL
  AND i.issue_date < CURDATE() - INTERVAL 14 DAY;
  
  -- Popularity Index
SELECT b.category, COUNT(*) AS total_borrows
FROM IssuedBooks i
JOIN Books b ON i.book_id = b.book_id
GROUP BY b.category
ORDER BY total_borrows DESC;

-- Delete
SET SQL_SAFE_UPDATES = 0;

UPDATE Students s
LEFT JOIN IssuedBooks i 
ON s.student_id = i.student_id 
AND i.issue_date >= CURDATE() - INTERVAL 3 YEAR
SET s.status = 'Inactive'
WHERE i.student_id IS NULL;

select * from Students;
SET SQL_SAFE_UPDATES = 1;


-- DELETE FROM IssuedBooks;
-- DELETE FROM Students;
-- DELETE FROM Books;