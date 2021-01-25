DROP TABLE IF EXISTS Balances;
DROP TABLE IF EXISTS Bankcards;

CREATE TABLE Bankcards (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  card_number VARCHAR(18) NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  exp_date VARCHAR(5) NOT NULL,
  cvi VARCHAR(3) NOT NULL,
  pin INT NOT NULL,
  type VARCHAR(6) NOT NULL
);

CREATE TABLE Balances (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  balance NUMERIC DEFAULT 0,
  currency VARCHAR(3) NOT NULL,
  card_id INT NOT NULL,
    foreign key (card_id) references Bankcards(id)
);

INSERT INTO Bankcards (card_number, first_name, last_name, exp_date, cvi, pin, type) VALUES
  ('4256123542131234', 'IVAN', 'IVANOV', '10/21', '123', '1234', 'DEBET'),
  ('4256123542134526', 'ALEXEY', 'PETROV', '09/22', '452', '4521', 'DEBET'),
  ('4256123542137536', 'PETR', 'SIDOROV', '11/21', '132', '7412', 'DEBET'),
  ('4256123542131010', 'SVETLANA', 'IVANOVA', '02/22', '425', '8588', 'DEBET'),
  ('4256123542132233',  'OLGA', 'PETROVA', '05/22', '465', '6542', 'DEBET');

INSERT INTO Balances (balance,currency,card_id) VALUES
  (1500,'RUB',1),
  (3000,'RUB',2),
  (1000.50,'RUB',3),
  (2000,'RUB',4),
  (2000.50,'RUB',5);

