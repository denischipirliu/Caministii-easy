CREATE TABLE TEST( bookName VARCHAR(255), author VARCHAR(255), publishers VARCHAR(255))
    INSERT INTO TEST( bookName, author, publishers )
SELECT  "bookName", "author", "publishers"
FROM CSVREAD( 'C:\Users\dench\Documents\GitHub\Caministii-easy\resources\booksAndPublishers.csv', 'bookName,author,publishers', NULL )