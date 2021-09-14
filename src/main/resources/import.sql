--truncate programas cascade;
--truncate areas cascade;
--truncate empleados cascade;
--truncate sedes cascade;
--truncate facultades cascade;
--truncate ciudades cascade;
--truncate departamentos cascade;
--truncate paises cascade;

insert into paises (codigo,nombre) values (57, 'COLOMBIA');
insert into departamentos (codigo,nombre, cod_pais) values (1, 'ANTIOQUIA', 57);
insert into ciudades (codigo,nombre, cod_dpto) values (1, 'MEDELLIN', 1);
insert into ciudades (codigo,nombre, cod_dpto) values (2, 'BELLO', 1);
insert into ciudades (codigo,nombre, cod_dpto) values (3, 'RIONEGRO', 1);
insert into ciudades (codigo,nombre, cod_dpto) values (4, 'APARTADÓ', 1);

insert into facultades (codigo,nombre,ubicacion,nro_telefono) values (1,'INGENIERIA', 'P38-203','3197906');

insert into sedes (codigo,nombre,cod_ciudad) values (1, 'POBLADO', 1);
insert into sedes (codigo,nombre,cod_ciudad) values (2, 'BELLO', 2);
insert into sedes (codigo,nombre,cod_ciudad) values (3, 'RIONEGRO', 3);
insert into sedes (codigo,nombre,cod_ciudad) values (4, 'APARTADÓ', 4);

insert into empleados (identificacion,nombres,apellidos,email,tipo_contratacion,tipo_empleado,cod_facultad,codigo_sede,lugar_nacimiento) values (10,'LUZ','LOPEZ','LMLOPEZ@ELPOLI.EDU.CO','CARRERA ADMINISTRATIVA','ADMINISTRATIVO', 1,1,1);
insert into empleados (identificacion,nombres,apellidos,email,tipo_contratacion,tipo_empleado,cod_facultad,codigo_sede,lugar_nacimiento) values (11,'JOSE LEONARDO','RAMIREZ','JOSERAMIREZ@ELPOLI.EDU.CO','LIBRE NOMBRAMIENTO','ADMINISTRATIVO', 1,1,1);

insert into areas (codigo,nombre,codigo_facultad, id_coordinador) values (1, 'APIT', 1, 10);
insert into programas (codigo,nombre,codigo_area) values (15,'INGENIERIA INFORMATICA', 1);