CREATE TABLE IF NOT EXISTS USER (
                                        id IDENTITY NOT NULL PRIMARY KEY,
                                        login VARCHAR(128) NOT NULL,
                                        email VARCHAR(128) NOT NULL,
                                        password VARCHAR(128) NOT NULL,
                                        salary INTEGER NOT NULL
);
