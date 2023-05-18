DROP TABLE IF EXISTS registros			 ;
DROP TABLE IF EXISTS servicios			 ;
DROP TABLE IF EXISTS protocolo			 ;
DROP TABLE IF EXISTS empleados			 ;
DROP TABLE IF EXISTS cargos		 	 ;
DROP TABLE IF EXISTS institucion		 ;
DROP TABLE IF EXISTS usuario			 ;
DROP TABLE IF EXISTS modelo			 ;
DROP TABLE IF EXISTS equipos_IoT		 ;
DROP TABLE IF EXISTS ingresos			 ;
DROP TABLE IF EXISTS tags_endoscopios	 	 ;
DROP TABLE IF EXISTS empresas_mtto_DM	 	 ;
DROP TABLE IF EXISTS tags_empleados		 ;

-- ***************** TIMEZONE ******************
SET TIMEZONE='AMERICA/BOGOTA';
select CURRENT_DATE;
-- *************** FIN TIMEZONE ****************

-- ***************** DDL ******************
CREATE TABLE cargos
(
	id_cargo		int(3) AUTO_INCREMENT PRIMARY KEY,
	nombre_cargo		varchar(50),
	descripcion		varchar(100)
)COMMENT 'Contiene la informacion sobre si se los roles o cargos implicados en el reprocesado';

CREATE TABLE empleados
(
	id_empleado			smallint AUTO_INCREMENT	PRIMARY KEY,
	institucion			int,
	nombre				varchar(50),
	direccion			varchar(30),
	telefono			varchar(15),
	correo				varchar(30),
	edad				varchar(3),
	sexo				varchar(10),
	fecha_ingreso			Date,
	fecha_retiro			Date,
	es_instructor			varchar(3),
	cargo				int(3),
	FOREIGN KEY (cargo) REFERENCES cargos(id_cargo) ON DELETE CASCADE
) COMMENT'Contiene la informacion de todos los empleados de todas las instituciones';

CREATE TABLE institucion
(
	id_inst 		SMALLINT AUTO_INCREMENT PRIMARY KEY,
	director		smallint,
	pais			varchar(15),
	departamento		varchar(15),
	municipio		varchar(30),
	razon_social		varchar(50),
	direccion		varchar(30),
	telefono		varchar(15),
	correo			varchar(15),
	nit			varchar(15),
	estado			varchar(10),
	FOREIGN KEY (director) REFERENCES empleados(id_empleado) ON DELETE CASCADE
)COMMENT 'Contiene la  lista de instituciones que realizan reprocesado';

CREATE TABLE modelo
(
	id_modelo		SMALLINT	AUTO_INCREMENT PRIMARY KEY,
	modelo			varchar(15),
	fecha_cracion		DATE
)COMMENT 'Contiene la informacion de los modelos para los equipos de tecnologia IoT usados';

CREATE TABLE equipos_IoT
(
	serie 				varchar(15) PRIMARY KEY,
	modelo				SMALLINT,
	institucion			SMALLINT,
	fecha_fabricacion 		DATE,
	instalo				varchar(50),
	FOREIGN KEY (modelo) REFERENCES modelo(id_modelo) ON DELETE CASCADE,
	FOREIGN KEY (institucion) REFERENCES institucion(id_inst) ON DELETE CASCADE
) COMMENT 'Contiene la lista de todos los equipos IoT instalados';

CREATE TABLE empresas_mtto_DM
(
	id_nit				varchar(15) PRIMARY KEY,
	razon_social 			varchar(50),
	ciudad				varchar(30),
	direccion			varchar(30),
	telefono			varchar(15)
)COMMENT 'Contiene las empresas que realizan el mantenimiento de los endoscopios en cada institucion';

CREATE TABLE tags_endoscopios
(
	UID				varchar(12) PRIMARY KEY,
	modelo				varchar(15),
	institucion			smallint,
	empresa_mtto			varchar(15),
	equipo_IoT			varchar(15),
	FOREIGN KEY (institucion) REFERENCES institucion(id_inst),
	FOREIGN KEY (empresa_mtto) REFERENCES empresas_mtto_DM(id_nit),
	FOREIGN KEY (equipo_IoT) REFERENCES equipos_IoT(serie) ON DELETE CASCADE
)COMMENT 'Contiene la lista de tags llaveros asignados en EEPROM de los equipos IoT para endoscopios';

CREATE TABLE tags_empleados
(
	UID			varchar(12) PRIMARY KEY,
	equipo_IoT		varchar(15),
	empleado		smallint,
	FOREIGN KEY (equipo_IoT) REFERENCES equipos_IoT(serie) ON DELETE CASCADE,
	FOREIGN KEY (empleado) REFERENCES empleados(id_empleado) ON DELETE CASCADE
)COMMENT 'Contiene la lista de tags targetas asignados en EEPROM de los equipos profesionales implicados en reprocesado';

CREATE TABLE registros
(
	id_registro 		INT AUTO_INCREMENT PRIMARY KEY,
	fecha			DATE,
	hora			TIME,
	endoscopio  		VARCHAR(12),
	encargado		VARCHAR(12),
	D1			SMALLINT,
	D2			SMALLINT,
	D3			SMALLINT,
	D4			SMALLINT,
	D5			SMALLINT,
	D6			SMALLINT,
	D7			SMALLINT,
	Limp_previa     VARCHAR(3),	
	PH_Enzimatico		decimal(4,2),
	PH_Desinfectante 	decimal(4,2),
	novedad			VARCHAR(12),
	equipo_IoT		VARCHAR(15),
	FOREIGN KEY (endoscopio) 	REFERENCES tags_endoscopios(UID) ON DELETE CASCADE,
	FOREIGN KEY (encargado) 	REFERENCES tags_empleados(UID) ON DELETE CASCADE,
	FOREIGN KEY (equipo_IoT) 	REFERENCES equipos_IoT(serie) ON DELETE CASCADE
)COMMENT 'Contiene los registros enviados desde los equipos IoT';

CREATE TABLE protocolo
(
	id_protocolo 				SMALLINT AUTO_INCREMENT PRIMARY KEY,
	tiempo_enzimatico			SMALLINT,
	tiempo_desinfectante			SMALLINT,
	concentracion_enzimatico		decimal(4,2),
	concentracion_desifectante		decimal(4,2),
	comentarios				varchar(150
) COMMENT'Contiene los parametros de los protocolos de reprocesado aceptables';

CREATE TABLE servicios
(
	id_servicio 			SMALLINT AUTO_INCREMENT PRIMARY KEY,
	director			smallint,
	recibe_alertas			smallint,
	institucion			smallint,
	Fecha_apertura			date,
	equipo_IoT			varchar(15),
	protocolo			smallint,
	FOREIGN KEY (director) REFERENCES empleados(id_empleado) ON DELETE CASCADE,
	FOREIGN KEY (recibe_alertas) REFERENCES empleados(id_empleado) ON DELETE CASCADE,
	FOREIGN KEY (institucion) REFERENCES institucion(id_inst) ON DELETE CASCADE,
	FOREIGN KEY (equipo_IoT) REFERENCES equipos_IoT(serie) ON DELETE CASCADE,
	FOREIGN KEY (protocolo) REFERENCES protocolo(id_protocolo) ON DELETE CASCADE
) COMMENT 'Contiene la lista de servicios en reprocesado';

CREATE TABLE usuario
(
	id_usuario 		SMALLINT AUTO_INCREMENT PRIMARY KEY,
	empleado		smallint,
	usuario			varchar(12),
	contraseña		varchar(10),
	fecha_creacion	Date default CURRENT_DATE,
	activo			bit,
	FOREIGN KEY (empleado) REFERENCES empleados(id_empleado) ON DELETE CASCADE
) COMMENT'Contiene los usuarios para ingresar a la aplicacion';

CREATE TABLE ingresos
(
	id_login	mediumint AUTO_INCREMENT PRIMARY KEY,
	usuario		varchar(12),
	fecha		date,
	hora		time
) COMMENT 'Registra los ingresos de los usuarios a la aplicacion';

ALTER TABLE empleados
	ADD
	FOREIGN KEY (institucion) REFERENCES institucion(id_inst) ON DELETE CASCADE;

--  ******************** fin DDL **************