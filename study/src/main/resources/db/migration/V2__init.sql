CREATE TABLE IF NOT EXISTS User (
                                        id SERIAL PRIMARY KEY,
                                        login VARCHAR(128) NOT NULL,
                                        email VARCHAR(128) NOT NULL,
                                        password VARCHAR(128) NOT NULL
);
