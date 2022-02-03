CREATE TABLE EMPLOYEE
(
    EMPLOYEE_ID  uuid         NOT NULL,
    FIRST_NAME   VARCHAR(100) NOT NULL,
    LAST_NAME    VARCHAR(100) NOT NULL,
    EMAIL        VARCHAR(500) NOT NULL,
    PHONE_NUMBER VARCHAR(10)  NOT NULL,
    HIRE_DATE    DATE         NOT NULL,
    SALARY       numeric      NOT NULL,
    PRIMARY KEY (EMPLOYEE_ID)
);

CREATE INDEX EMPLOYEE_NAME_IDX ON EMPLOYEE (FIRST_NAME, LAST_NAME);

CREATE TABLE EMPLOYEE_ADDRESS
(
    ADDRESS_ID     uuid         NOT NULL,
    EMPLOYEE_ID    uuid         NOT NULL,
    ADDRESS_LINE_1 VARCHAR(400) NOT NULL,
    ADDRESS_LINE_2 VARCHAR(400),
    CITY           VARCHAR(500) NOT NULL,
    PROVINCE       VARCHAR(20)  NOT NULL,
    PRIMARY KEY (ADDRESS_ID)
);

CREATE INDEX EMPLOYEE_ADDRESS_LINE_IDX ON EMPLOYEE_ADDRESS (ADDRESS_LINE_1, ADDRESS_LINE_2);
CREATE INDEX EMPLOYEE_CITY_PROV_IDX ON EMPLOYEE_ADDRESS (CITY, PROVINCE);