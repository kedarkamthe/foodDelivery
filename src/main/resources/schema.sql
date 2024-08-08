CREATE TABLE food
(
    id numeric(50) NOT NULL,
    name varchar(30) NOT NULL ,
    reserved boolean NOT NULL ,
    order_id numeric(50),
    PRIMARY KEY (id)
);

CREATE TABLE Agent
(
    id numeric(50) NOT NULL,
    order_id numeric(50),
    reserved boolean NOT NULL ,
    name varchar(20) ,
    PRIMARY KEY (id)
);

CREATE TABLE "foodorder"
(
    id numeric(50) NOT NULL,
    booked boolean NOT NULL ,
    PRIMARY KEY (id)
);

CREATE SEQUENCE AGENT_SEQ START 101;

CREATE SEQUENCE FOOD_SEQ START 201;

CREATE SEQUENCE FOOD_ORDER_SEQ START 10000;


