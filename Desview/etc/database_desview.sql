-- sql for desview database. Current version 1.0

CREATE SEQUENCE equipment_id_seq  INCREMENT 1  MINVALUE 1  MAXVALUE 9223372036854775807  START 1  CACHE 1;
CREATE SEQUENCE hibernate_sequence  INCREMENT 1  MINVALUE 1  MAXVALUE 9223372036854775807  START 100  CACHE 1;
CREATE SEQUENCE search_id_seq  INCREMENT 1  MINVALUE 1  MAXVALUE 9223372036854775807  START 1  CACHE 1;
CREATE SEQUENCE task_id_seq  INCREMENT 1  MINVALUE 1  MAXVALUE 9223372036854775807  START 1  CACHE 1;
CREATE SEQUENCE users_id_seq  INCREMENT 1  MINVALUE 1  MAXVALUE 9223372036854775807  START 1  CACHE 1;
CREATE SEQUENCE variable_id_seq  INCREMENT 1  MINVALUE 1  MAXVALUE 9223372036854775807  START 1  CACHE 1;

CREATE TABLE equipment(
  id bigserial NOT NULL,
  equipment_name character varying(250) NOT NULL,
  ip character varying(30) NOT NULL,
  port character varying(5),
  read_community character varying(50),
  retries character varying(3),
  status integer,
  timeout character varying(10),
  write_community character varying(50),
  CONSTRAINT equipment_pkey PRIMARY KEY (id)
);

CREATE TABLE task(
  id bigserial NOT NULL,
  effective_end_date character varying(255),
  effective_start_date character varying(255),
  estimated_end_date character varying(255),
  estimated_start_date character varying(255),
  frequency character varying(255),
  frequency_auxiliary character varying(255),
  frequency_volatile character varying(255),
  status integer NOT NULL,
  task_name character varying(250) NOT NULL,
  equipment_id bigint,
  CONSTRAINT task_pkey PRIMARY KEY (id),
  CONSTRAINT fk27a9a553772429 FOREIGN KEY (equipment_id)
      REFERENCES equipment (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE variable(
  id bigserial NOT NULL,
  "access" integer,
  description character varying(1000),
  label character varying(200),
  lower_value character varying(10),
  mib character varying(500),
  oid character varying(150) NOT NULL,
  "type" integer,
  upper_value character varying(10),
  CONSTRAINT variable_pkey PRIMARY KEY (id)
);

CREATE TABLE historic(
  id bigint NOT NULL,
  "day" character varying(255) NOT NULL,
  "month" character varying(255) NOT NULL,
  oid character varying(255),
  read_value double precision,
  variable_name character varying(255),
  "year" character varying(255) NOT NULL,
  task_id bigint,
  variable_id bigint,
  CONSTRAINT historic_pkey PRIMARY KEY (id),
  CONSTRAINT fkb497107f9681c10b FOREIGN KEY (task_id)
      REFERENCES task (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkb497107fb0692b FOREIGN KEY (variable_id)
      REFERENCES variable (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE reading(
  id bigint NOT NULL,
  oid character varying(255),
  read_time character varying(255) NOT NULL,
  read_value character varying(255),
  variable_name character varying(255),
  task_id bigint,
  variable_id bigint,
  CONSTRAINT reading_pkey PRIMARY KEY (id),
  CONSTRAINT fka39e666c9681c10b FOREIGN KEY (task_id)
      REFERENCES task (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fka39e666cb0692b FOREIGN KEY (variable_id)
      REFERENCES variable (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE "search"(
  id bigserial NOT NULL,
  date character varying(250) NOT NULL,
  query character varying(2000) NOT NULL,
  users character varying(250) NOT NULL,
  CONSTRAINT search_pkey PRIMARY KEY (id)
);

CREATE TABLE task_variable(
  task_id bigint NOT NULL,
  variables_id bigint NOT NULL,
  CONSTRAINT fke980c7f65ed99850 FOREIGN KEY (variables_id)
      REFERENCES variable (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fke980c7f69681c10b FOREIGN KEY (task_id)
      REFERENCES task (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT task_variable_variables_id_key UNIQUE (variables_id)
);

CREATE TABLE users(
  id bigserial NOT NULL,
  "name" character varying(255),
  "password" character varying(255),
  refresh_time integer,
  "type" integer,
  CONSTRAINT users_pkey PRIMARY KEY (id)
);

INSERT INTO users values(1, 'admin', 'desview', 5, 0);

commit;
