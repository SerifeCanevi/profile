-- Create the ACCOUNT table
CREATE TABLE ACCOUNT (
    ID SERIAL PRIMARY KEY,
    USER_DETAIL_ID BIGINT,
    FOREIGN KEY (USER_DETAIL_ID) REFERENCES USER_DETAIL(ID)
);

-- Create the ACC_ROLE table
CREATE TABLE ACC_ROLE (
    ID SERIAL PRIMARY KEY,
    ROLE VARCHAR(50),
    ACCOUNT_ID BIGINT,
    FOREIGN KEY (ACCOUNT_ID) REFERENCES ACCOUNT(ID)
);

-- Create the ACC_STATUS table
CREATE TABLE ACC_STATUS (
    ID SERIAL PRIMARY KEY,
    STATUS VARCHAR(50),
    ACCOUNT_ID BIGINT,
    FOREIGN KEY (ACCOUNT_ID) REFERENCES ACCOUNT(ID)
);

-- Create the USER_DETAIL table
CREATE TABLE USER_DETAIL (
    ID SERIAL PRIMARY KEY,
    ACCOUNT_ID BIGINT,
    USERNAME VARCHAR(48) UNIQUE,
    PASSWORD VARCHAR(24),
    EMAIL VARCHAR(64),
    FOREIGN KEY (ACCOUNT_ID) REFERENCES ACCOUNT(ID)
);
