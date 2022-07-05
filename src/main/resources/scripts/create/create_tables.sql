CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE reserve (
    id bigint NOT NULL,
    user_document character varying(255) NOT NULL,
    user_name character varying(255) NOT NULL,
    phone_number character varying(255),
    entry_date date NOT NULL,
    departure_date date NOT NULL
);

CREATE SEQUENCE reserve_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE room (
    id bigint NOT NULL,
    number character integer NOT NULL,
    hotel character varying(255) NOT NULL
);

CREATE SEQUENCE room_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE users (
    id bigint NOT NULL,
    document character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    phone character varying(255)
);

CREATE SEQUENCE users_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

