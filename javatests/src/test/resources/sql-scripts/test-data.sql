
CREATE TABLE IF NOT EXISTS movies (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  minutes INT NOT NULL,
  genre VARCHAR(50) NOT NULL
);

insert into movies (name, minutes, genre) values
    ('Dark Knight', 152, 'ACTION'),
    ('Memento', 113, 'THRILLER'),
    ('Matrix 1', 136, 'ACTION'),
    ('Matrix 2', 138, 'ACTION'),
    ('Matrix 3', 132, 'ACTION');
