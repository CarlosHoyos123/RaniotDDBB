DROP TABLE IF EXISTS registros			 CASCADE;
DROP TABLE IF EXISTS servicios			 CASCADE;
DROP TABLE IF EXISTS protocolo			 CASCADE;
DROP TABLE IF EXISTS empleados			 CASCADE;
DROP TABLE IF EXISTS cargos				 CASCADE;
DROP TABLE IF EXISTS institucion		 CASCADE;
DROP TABLE IF EXISTS usuario			 CASCADE;
DROP TABLE IF EXISTS modelo				 CASCADE;
DROP TABLE IF EXISTS equipos_IoT		 CASCADE;
DROP TABLE IF EXISTS ingresos			 CASCADE;
DROP TABLE IF EXISTS tags_endoscopios	 CASCADE;
DROP TABLE IF EXISTS empresas_mtto_DM	 CASCADE;
DROP TABLE IF EXISTS tags_empleados		 CASCADE;

-- ***************** TIMEZONE ******************
SET TIMEZONE='AMERICA/BOGOTA';
select CURRENT_DATE;
-- *************** FIN TIMEZONE ****************

-- ***************** DDL ******************
CREATE TABLE cargos
(
	id_cargo		serial,
	nombre_cargo	varchar,
	descripcion		varchar,
	PRIMARY KEY (id_cargo)
);
COMMENT ON TABLE cargos IS 'Contiene la informacion sobre si se los roles o cargos implicados en el reprocesado';

CREATE TABLE empleados
(
	id_empleado			serial,
	institucion			int,
	nombre				varchar,
	direccion			varchar,
	telefono			varchar,
	correo				varchar,
	edad				varchar,
	sexo				varchar,
	fecha_ingreso		Date default CURRENT_DATE,
	fecha_retiro		Date,
	es_instructor		bool,
	cargo				smallint,
	PRIMARY KEY (id_empleado),
	FOREIGN KEY (cargo) REFERENCES cargos(id_cargo)
);
COMMENT ON TABLE empleados IS 'Contiene la informacion de todos los empleados de todas las instituciones';

CREATE TABLE institucion
(
	id_inst 		serial,
	director		int,
	pais			varchar,
	departamento	varchar,
	municipio		varchar,
	razon_social	varchar,
	direccion		varchar,
	telefono		varchar,
	correo			varchar,
	nit				varchar,
	estado			varchar,
	PRIMARY KEY (id_inst),
	FOREIGN KEY (director) REFERENCES empleados(id_empleado)
);
COMMENT ON TABLE institucion IS 'Contiene la  lista de instituciones que realizan reprocesado';


CREATE TABLE modelo
(
	id_modelo	serial,
	modelo		varchar,
	fecha_cracion	DATE,
	PRIMARY KEY (id_modelo)
);
COMMENT ON TABLE modelo IS 'Contiene la informacion de los modelos para los equipos de tecnologia IoT usados';

CREATE TABLE equipos_IoT
(
	serie 				varchar,
	modelo				int,
	institucion			int,
	fecha_fabricacion 	DATE,
	instalo				varchar,
	PRIMARY KEY (serie),
	FOREIGN KEY (modelo) REFERENCES modelo(id_modelo),
	FOREIGN KEY (institucion) REFERENCES institucion(id_inst)
);
COMMENT ON TABLE equipos_IoT IS 'Contiene la lista de todos los equipos IoT instalados';

CREATE TABLE empresas_mtto_DM
(
	id_nit			varchar,
	razon_social 	varchar,
	ciudad			varchar,
	direccion		varchar,
	telefono		varchar,
	PRIMARY KEY (id_nit)
);
COMMENT ON TABLE empresas_mtto_DM IS 'Contiene las empresas que realizan el mantenimiento de los endoscopios en cada institucion';

CREATE TABLE tags_endoscopios
(
	UID				varchar,
	modelo			varchar,
	institucion		int,
	empresa_mtto	varchar,
	equipo_IoT		varchar,
	PRIMARY KEY (UID),
	FOREIGN KEY (institucion) REFERENCES institucion(id_inst),
	FOREIGN KEY (empresa_mtto) REFERENCES empresas_mtto_DM(id_nit),
	FOREIGN KEY (equipo_IoT) REFERENCES equipos_IoT(serie)
);
COMMENT ON TABLE tags_endoscopios IS 'Contiene la lista de tags llaveros asignados en EEPROM de los equipos IoT para endoscopios';

CREATE TABLE tags_empleados
(
	UID			varchar,
	equipo_IoT	varchar,
	empleado	int,
	PRIMARY KEY (UID),
	FOREIGN KEY (equipo_IoT) REFERENCES equipoS_IoT(serie),
	FOREIGN KEY (empleado) REFERENCES empleados(id_empleado)
);
COMMENT ON TABLE tags_empleados IS 'Contiene la lista de tags targetas asignados en EEPROM de los equipos profesionales implicados en reprocesado';

CREATE TABLE registros
(
	id_registro SERIAL,
	fecha		DATE,
	hora		TIME,
	endoscopio  VARCHAR,
	encargado	VARCHAR,
	D1			VARCHAR,
	D2			VARCHAR,
	D3			VARCHAR,
	D4			VARCHAR,
	D5			VARCHAR,
	D6			VARCHAR,
	D7			VARCHAR,
	Limp_previa 	VARCHAR(3),
	PH_Enzimatico	decimal(4,2),
	PH_Desinfectante decimal(4,2),
	novedad		VARCHAR,
	equipo_IoT	VARCHAR,
	PRIMARY KEY (id_registro),
	FOREIGN KEY (endoscopio) 	REFERENCES tags_endoscopios(UID),
	FOREIGN KEY (encargado) 	REFERENCES tags_empleados(UID),
	FOREIGN KEY (equipo_IoT) 	REFERENCES equipos_IoT(serie)
);
COMMENT ON TABLE registros IS 'Contiene los registros enviados desde los equipos IoT';

CREATE TABLE protocolo
(
	id_protocolo 				serial,
	tiempo_enzimatico			int,
	tiempo_desinfectante		int,
	concentracion_enzimatico	decimal(4,2),
	concentracion_desifectante	decimal(4,2),
	comentarios 				TEXT,
	PRIMARY KEY (id_protocolo)
);
COMMENT ON TABLE protocolo IS 'Contiene los parametros de los protocolos de reprocesado aceptables';

CREATE TABLE servicios
(
	id_servicio 	serial,
	director		int,
	recibe_alertas	int,
	institucion		int,
	Fecha_apertura	varchar,
	equipo_IoT		varchar,
	protocolo		int,
	PRIMARY KEY (id_servicio),
	FOREIGN KEY (director) REFERENCES empleados(id_empleado),
	FOREIGN KEY (recibe_alertas) REFERENCES empleados(id_empleado),
	FOREIGN KEY (institucion) REFERENCES institucion(id_inst),
	FOREIGN KEY (equipo_IoT) REFERENCES equipos_IoT(serie),
	FOREIGN KEY (protocolo) REFERENCES protocolo(id_protocolo)
);
COMMENT ON TABLE servicios IS 'Contiene la lista de servicios en reprocesado';

CREATE TABLE usuario
(
	id_usuario 		serial,
	empleado		int,
	usuario			varchar,
	contraseña		varchar,
	fecha_creacion	timestamp default CURRENT_DATE,
	activo			bool,
	PRIMARY KEY (id_usuario),
	FOREIGN KEY (empleado) REFERENCES empleados(id_empleado)
);
COMMENT ON TABLE usuario IS 'Contiene los usuarios para ingresar a la aplicacion';

CREATE table reprocessLogs
(
	
);

CREATE TABLE ingresos
(
	id_login	serial,
	usuario		int,
	fecha		date,
	hora		time,
	PRIMARY KEY (id_login),
	FOREIGN KEY (usuario) REFERENCES usuario(id_usuario)
);
COMMENT ON TABLE ingresos IS 'Registra los ingresos de los usuarios a la aplicacion';

ALTER TABLE empleados
	ADD
	FOREIGN KEY (institucion) REFERENCES institucion(id_inst);

--  ******************** fin DDL **************

--  ******************** PLPGSQL **************

CREATE OR REPLACE FUNCTION newReprocess () RETURNS registros%rowtype AS

DECLARE
	default_table := registros;
	FECHA := $1;
	HORA :=  $2;
	ENCARGADO := $3;
	ENDOSCOPIO := $4;
	LP :=  $5;
	D1 :=  $6;
	D2 :=  $7;
	D3 :=  $8;
	D4 :=  $9;
	D5 :=  $10;
	D6 :=  $11;
	D7 :=  $12;
	PHJE := $13;
	PHDES :=  $14;
	EQUIPO :=  $15;
$BODY$
BEGIN
	INSERT INTO fecha,hora,encargado,endoscopio,Limp_previa,D1,D2,D3,D4,D5,D6,D7,PH_Enzimatico,PH_Desinfectante,equipo_IoT 
		VALUES (FECHA,HORA,ENCARGADO,ENDOSCOPIO,LP,D1,D2,D3,D4,D5,D6,D7,PHJE,PHDES,EQUIPO);
	EXCEPTION
		WHEN OTHERS THEN
			RAISE EXCEPTION 'No se pudo ingresar el nuevo registro';
END
$BODY$
LANGUAGE PLPGSQL

--  ******************** fin PLPGSQL **************

--  ******************** TRIGGERS **************

CREATE TRIGGER registry after

--  ******************** fin TRIGGERS **************