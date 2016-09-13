create role htbw login password 'htbw123';

CREATE DATABASE htbwdb;

ALTER DATABASE htbwdb OWNER TO htbw;

grant all privileges on database htbwdb to htbw;

CREATE TABLE users (id BIGSERIAL PRIMARY KEY,
	 email_id varchar(255) NOT NULL,
	 first_name varchar(50) NOT NULL,
	 last_name varchar(50),
	 password varchar(50) NOT NULL,
	 created_time TIMESTAMP NOT NULL);