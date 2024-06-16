CREATE DATABASE MovieBoxOffice;
USE MovieBoxOffice;

-- Creating a Movies table
CREATE TABLE Movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    release_date DATE,
    genre VARCHAR(100)
);

-- Creating a BoxOffice table
CREATE TABLE BoxOffice (
    id INT AUTO_INCREMENT PRIMARY KEY,
    movie_id INT,
    opening_weekend DECIMAL(10, 2),
    total_earnings DECIMAL(10, 2),
    region VARCHAR(100),
    FOREIGN KEY (movie_id) REFERENCES Movies(id)
);

-- Inserting some sample data into Movies table
INSERT INTO Movies (title, release_date, genre) VALUES 
('The Shawshank Redemption', '1994-09-23', 'Drama'),
('The Godfather', '1972-03-24', 'Crime'),
('The Dark Knight', '2008-07-18', 'Action'),
('The Lord of the Rings: The Return of the King', '2003-12-17', 'Fantasy'),
('Forrest Gump', '1994-07-06', 'Drama'),
('Inception', '2010-07-16', 'Sci-Fi');

-- Insert sample data into BoxOffice table
INSERT INTO BoxOffice (movie_id, opening_weekend, total_earnings, region) VALUES
(1, 727327, 28341469, 'USA'),
(2, 302393, 246120974, 'USA'),
(3, 158411483, 1004558444, 'Worldwide'),
(4, 72516856, 1146030912, 'Worldwide'),
(5, 24543048, 678222284, 'Worldwide'),
(6, 62785337, 836848102, 'Worldwide');

select * from Movies;
select * from Boxoffice;

DELETE FROM BoxOffice;
DELETE FROM Movies;

select * from Movies;

-- Insert data into Movies table
INSERT INTO Movies (title, release_date, genre) VALUES 
('The Shawshank Redemption', '1994-09-23', 'Drama'),
('The Godfather', '1972-03-24', 'Crime'),
('The Dark Knight', '2008-07-18', 'Action'),
('The Lord of the Rings: The Return of the King', '2003-12-17', 'Fantasy'),
('Forrest Gump', '1994-07-06', 'Drama'),
('Inception', '2010-07-16', 'Sci-Fi');

INSERT INTO BoxOffice (movie_id, opening_weekend, total_earnings, region) VALUES
(1, 727327, 28341469, 'USA'),
(2, 302393, 246120974, 'USA'),
(3, 158411483, 1004558444, 'Worldwide'),
(4, 72516856, 1146030912, 'Worldwide'),
(5, 24543048, 678222284, 'Worldwide'),
(6, 62785337, 836848102, 'Worldwide');

DROP TABLE IF EXISTS BoxOffice;
DROP TABLE IF EXISTS Movies;

CREATE TABLE Movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    release_date DATE,
    genre VARCHAR(100)
);

-- Create BoxOffice table
CREATE TABLE BoxOffice (
    id INT AUTO_INCREMENT PRIMARY KEY,
    movie_id INT,
    opening_weekend DECIMAL(30, 2),
    total_earnings DECIMAL(30, 2),
    region VARCHAR(100),
    FOREIGN KEY (movie_id) REFERENCES Movies(id)
);

-- Insert data into Movies table
INSERT INTO Movies (title, release_date, genre) VALUES 
('The Shawshank Redemption', '1994-09-23', 'Drama'),
('The Godfather', '1972-03-24', 'Crime'),
('The Dark Knight', '2008-07-18', 'Action'),
('The Lord of the Rings: The Return of the King', '2003-12-17', 'Fantasy'),
('Forrest Gump', '1994-07-06', 'Drama'),
('Inception', '2010-07-16', 'Sci-Fi');

-- Verify data in Movies table
SELECT * FROM Movies;

-- Insert data into BoxOffice table
INSERT INTO BoxOffice (movie_id, opening_weekend, total_earnings, region) VALUES
(1, 727327, 28341469, 'USA'),
(2, 302393, 246120974, 'USA'),
(3, 158411483, 1004558444, 'Worldwide'),
(4, 72516856, 1146030912, 'Worldwide'),
(5, 24543048, 678222284, 'Worldwide'),
(6, 62785337, 836848102, 'Worldwide');

SELECT * FROM BoxOffice;

Drop table BoxOffice;