-- create_user_table.sql

CREATE TABLE user (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  balance DOUBLE NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (username)
);

-- create_transaction_table.sql

CREATE TABLE transaction (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY,
  type VARCHAR(255) NOT NULL,
  amount DOUBLE NOT NULL,
  timestamp TIMESTAMP NOT NULL,
  user_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user(id)
);