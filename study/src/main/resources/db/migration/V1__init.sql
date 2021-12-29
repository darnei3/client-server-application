create table usr (
                      id BIGSERIAL PRIMARY KEY,
                      login VARCHAR(128) NOT NULL,
                      email VARCHAR(128) NOT NULL,
                      password VARCHAR(128) NOT NULL,
                      salary INTEGER NOT NULL
);
