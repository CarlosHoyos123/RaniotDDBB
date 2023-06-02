
DROP TABLE IF EXISTS tbljobs			 CASCADE;
DROP TABLE IF EXISTS tblemployees				 CASCADE;
DROP TABLE IF EXISTS tblinstitutions		 CASCADE;

CREATE TABLE tbljobs
(
	id				serial,
	name			varchar,
	description		varchar,
	PRIMARY KEY (id)
);
COMMENT ON TABLE tbljobs IS 'Contiene la informacion sobre si se los roles o cargos implicados en el reprocesado';

CREATE TABLE tblemployees
(
	id		serial,
	institution			int,
	name				varchar,
	surName 			varchar,
	lastname 			varchar,
	surLastName 		varchar,
	adrees				varchar,
	phone				varchar,
	mail				varchar,
	age					int,
	sex					varchar,
	inDate				Date,
	withdrawalDate		Date,
	is_instructor		bool,
	job					int,
	PRIMARY KEY (id),
	FOREIGN KEY (job) REFERENCES tbljobs(id)
);
COMMENT ON TABLE tblemployees IS 'Contiene la informacion de todos los empleados de todas las instituciones';

CREATE TABLE tblinstitutions
(
	id 				serial,
	director		int,
	country			varchar,
	department		varchar,
	city			varchar,
	name			varchar,
	adress			varchar,
	phone			varchar,
	mail			varchar,
	nit				varchar,
	state			varchar,
	PRIMARY KEY (id)
);
COMMENT ON TABLE tblinstitutions IS 'Contiene la  lista de instituciones que realizan reprocesado';
--  ******************** fin DDL **************