# Library Management SQL Mini Project

This project contains a SQL script for a basic library management database.

- Database name: `library_db_mp`
- Main file: `Library.sql`
- SQL dialect: MySQL-compatible (uses `CURDATE()` and `INTERVAL`)

## Project Objective

Build and test a simple relational database for library operations such as:

- storing books and students
- tracking issued books
- finding overdue books
- analyzing most borrowed categories
- marking inactive students

## Files

- `Library.sql`: complete script containing database creation, table definitions, sample inserts, and queries.

## Database Schema Overview

The script creates these tables:

1. `Books`
- `book_id` (INT, Primary Key)
- `title` (VARCHAR)
- `category` (VARCHAR)

2. `Students`
- `student_id` (INT, Primary Key)
- `name` (VARCHAR)

3. `IssuedBooks`
- `issue_id` (INT, Primary Key)
- `student_id` (INT, Foreign Key -> `Students.student_id`)
- `book_id` (INT, Foreign Key -> `Books.book_id`)
- `issue_date` (DATE)
- `return_date` (DATE, nullable)

Relationship summary:

- one student can issue many books
- one book can be issued multiple times over time
- `IssuedBooks` is the transaction table linking students and books

## Sample Data Included

The script inserts:

- 5 books
- 5 students
- 5 issue records

Data is intentionally mixed to support analysis:

- overdue items (not returned for more than 14 days)
- returned items
- very old issue history
- recent active user records

## Queries Included

### 1) Overdue Books Query
Returns student name, book title, and issue date where:

- the book is not returned (`return_date IS NULL`)
- issue date is older than 14 days

Use case: identify students who need reminders or fines.

### 2) Popularity Index Query
Groups borrow transactions by `category` and sorts by borrow count descending.

Use case: understand which categories are borrowed most often.

### 3) Inactive Student Update
The script tries to set student status to `Inactive` if no issues exist in the last 3 years.

Important: this update needs a `status` column in `Students`, but the current table definition does not include it.

## Required Fix for Inactive Update

Run this before the inactive-student `UPDATE` query:

```sql
ALTER TABLE Students
ADD COLUMN status VARCHAR(20) DEFAULT 'Active';
```

Then run:

```sql
UPDATE Students
SET status = 'Active'
WHERE status IS NULL;
```

After that, the inactive update in `Library.sql` will work correctly.

## How to Run

1. Open MySQL client or MySQL Workbench.
2. Execute the full `Library.sql` script.
3. If the inactive update fails, apply the `ALTER TABLE` fix above and rerun that section.
4. Run:

```sql
SELECT * FROM Students;
```

to verify active/inactive status values.

## Expected Learning Outcomes

By using this project, you practice:

- creating relational schemas with PK/FK constraints
- inserting realistic sample test data
- writing join-based reporting queries
- using date arithmetic in SQL
- performing conditional updates safely

## Notes

- `SET SQL_SAFE_UPDATES = 0/1` is used in the script around update operations.
- Cleanup `DELETE` statements are included but commented out at the end.

## Author

Goli Vignesh
