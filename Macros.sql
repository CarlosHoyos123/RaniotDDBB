'esta macro realiza la conversion de la informacion en tablas de excel para generar la instrccion SQL para la tabla de instituciones
Sub insert_intituciones()

Dim pronpt As String
Dim departamento As String
Dim municipio As String
Dim razon_social As String
Dim direccion As String
Dim telefono As String
Dim correo As String
Dim nit As String

prompt = "INSERT INTO `institucion`(`departamento`, `municipio`, `razon_social`, `direccion`, `telefono`, `correo`, `nit`) VALUES "

For i = 801 To 893

departamento = Cells(i, 2).Value
municipio = Cells(i, 3).Value
razon_social = Cells(i, 4).Value
direccion = Cells(i, 5).Value
telefono = Cells(i, 6).Value
correo = Cells(i, 7).Value
nit = Cells(i, 8).Value

valuesxFila = "('" + departamento + "' , '" + municipio + "' , '" + razon_social + "' , '" + direccion + "' , '" + telefono + "' , '" + correo + "' , '" + nit + "'), "

prompt = prompt + valuesxFila

Next

Worksheets("Hoja1").Cells(5, 10).Value = prompt
MsgBox prompt

End Sub
-- *****************************************************************

INSERT INTO cargos(nombre_cargo, descripcion) 
	VALUES
	('Reprocesador', 'Persona encargada de realizar el reprocesado manual del DM'),
	('Director', 'Persona de rol administrativo que gerencia el servicio a cargo del reprocesado'),
	('Gastroenterologo', 'medico especialista'),
    	('Tecnico RANIOT','Cargo para el personal de RANIOT que tiene acceso a la aplicacion');
-- *****************************************************************
INSERT INTO modelo(modelo, fecha_cracion) 
	VALUES 
	('ENDO-01','2022-03-24'),
	('PCB','2022-03-24');
-- *****************************************************************
INSERT INTO protocolo(tiempo_enzimatico, tiempo_desinfectante, concentracion_enzimatico, concentracion_desifectante, comentarios) 
	VALUES 
		(7,10,7.5,8.2,'Esta linea correspnde a los tiempos para pruebas sin tener en cuenta ninguna protocolo aplicado o presente en la literatura');
-- *****************************************************************
INSERT INTO cargos(nombre_cargo, descripcion) 
	VALUES 
    	('Reprocesador','Persona encargada de realizar el reprocesado manual del DM'),
        ('Director','Persona de rol administrativo que gerencia el servicio a cargo del reprocesado'),
        ('Gastroenterologo','medico especialista');
-- ***********'hasta aqui no hay problema'******************************************************




INSERT INTO institucion(director, pais, departamento, municipio, razon_social, direccion, telefono, correo, nit) 
	VALUES 
		(int,'Carlos Hoyos','Colombia','Antioquia','Medellin','RANIOT','Calle 78 b 85 A 28','3107203038','clinica@raniot.tech','0000');

	PRIMARY KEY (id_inst),
	FOREIGN KEY (director) REFERENCES empleados(id_empleado)




INSERT INTO empleados(institucion, nombre, direccion, telefono, correo, edad, sexo, fecha_ingreso, fecha_retiro, es_instructor, cargo) 
	VALUES 
    	(895,'Carlos Andres Hoyos Rodriguez','Calle 78 B 85 A 28','3107203038','chrodriguez.bmdc@gmail.com','31','Masculino','2022/1/1',null,true,4);
-- *****************************************************************
INSERT INTO usuario(empleado, usuario, contraseña, fecha_creacion, activo) 
	VALUES 
		(1,'carlos.hoyos','ye03RbL','2022/03/24',true);
-- *****************************************************************
INSERT INTO equipos_IoT(serie, modelo, institucion, fecha_fabricacion, instalo) 
	VALUES 
    	('TestSerie','2','895','2022/1/1','Carlos Hoyos'),
	('2114112',1,895,'2021/10/01','Carlos Hoyos'),
	('2114111',1,895,'2021/10/01','Carlos Hoyos'),
	('2114113',1,895,'2021/10/01','Carlos Hoyos');
-- *****************************************************************

INSERT INTO tags_empleados(UID,equipo_IoT) 
	VALUES 
    	('06845754',	'2114111'),
	('66f95854',	'2114113'),
	('c96b1ebd',	'2114112');
-- *****************************************************************
INSERT INTO tags_endoscopios(equipo_IoT,UID) 
	VALUES 
    ('2114111'	,'da44e31e'),
	('2114111'	,'da6ba91e'),
	('2114111'	,'dab5ae1e'),
	('2114111'	,'dac4ad1e'),
	('2114111'	,'ea0e591e'),
	('2114111'	,'ea2ec51e'),
	('2114111'	,'ea33991e'),
	('2114111'	,'ea4c181e'),
	('2114112'	,'ea3a971e'),
	('2114112'	,'da9cb51e'),
	('2114112'	,'ea4c3d1e'),
	('2114112'	,'dade7b1e'),
	('2114112'	,'ea66491e'),
	('2114112'	,'ea063f1e'),
	('2114112'	,'dacf951e'),
	('2114112'	,'ea61831e'),
	('2114113'	,'da2fab1e'),
	('2114113'	,'dac4071e'),
	('2114113'	,'ea3ab21e'),
	('2114113'	,'daf6101e'),
	('2114113'	,'da36f41e'),
	('2114113'	,'ea423b1e'),
	('2114113'	,'dae83d1e'),
	('2114113'	,'daa6971e');