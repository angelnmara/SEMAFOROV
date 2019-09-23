-- Database: SEMAFOROV

-- DROP DATABASE "SEMAFOROV";

/*
CREATE DATABASE "SEMAFOROV"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
*/

begin transaction;

drop table if exists tbDatosGeneraRutas;
drop table if exists tbUsuarios;
DROP TABLE IF EXISTS tbPasos;
DROP TABLE IF EXISTS tbRutas;

create table if not exists tbDatosGeneraRutas(fiIdDatosGeneraRutas serial primary key,
								fcDescDatosGeneraRutas varchar(200),
							   fdoEndLocationLat float8 not null,
							   fdoEndLocationLng float8 not null,
							   fdoStartLocationLat float8 not null,
							   fdoStartLocationLng float8 not null,
											 fcYek varchar(1000),
											 fcToken varchar(100));

create table if not exists tbRutas (fiIdRuta serial primary key,
					  fcDistance varchar(50),
					  fiDistance integer,
					  fcDuration varchar(50),
					  fiDuration integer,
					 fcEndAddress varchar(500) not null,
					 fdoEndLocationLat float8 not null,
					 fdoEndLocationLng float8 not null,
					  fcStartAddress varchar(500) not null,
					 fdoStartLocationLat float8 not null,
					 fdoStartLocationLng float8 not null);

create table if not exists tbPasos (fiIdPaso serial primary key,
					  fiIdRuta integer references tbRutas(fiIdRuta),
					 fcDistancia varchar(50) not null,
					  fiDistancia integer,
					 fcDuracion varchar(50) not null,
					  fiDuracion integer,
					 fdoEndLocationLat float8 not null,
					 fdoEndLocationLng float8 not null,
					 fdoStartLocationLat float8 not null,
					 fdoStartLocationLng float8 not null,
					 fcPolyLine varchar(1000));
					 
create table if not exists tbUsuarios(fiIdUsuario serial primary key,
									 fiIdPaso integer references tbPasos(fiIdPaso),
									 fcFleet varchar(50),
									 fiMagvar int,
									 fnInscale boolean,
									 fiMod int,
									 fiAddon int,
									 fiPing int,
									 fdoLocationLat float8,
									 fdoLocationLng float8,
									 fcId varchar(100),
									 fcUserName varchar(200),
									 fdoSpeed float8,
									 fnIngroup boolean);
					 
insert into tbDatosGeneraRutas(fcDescDatosGeneraRutas,
							fdoEndLocationLat,
							   fdoEndLocationLng,
							   fdoStartLocationLat,
							   fdoStartLocationLng,
							  fcYek, 
							  fcToken)
							   values('Indios verdes - Universidad',
								   		19.2800339, 
									  -99.17037160000001, 
									  19.4950119, 
									  -99.11960449999998, 
									 'AIzaSyDkeEm6iunIM2P4qFZbYmxaxhItMUsY_h0', 
									 '130434');
									 
					 
commit transaction;

begin transaction;
	insert into tbRutas (fcDistance,
					  fiDistance,
					  fcDuration,
					  fiDuration,
						fcEndAddress,
					 fdoEndLocationLat,
					 fdoEndLocationLng,
					  fcStartAddress,
					 fdoStartLocationLat,
					 fdoStartLocationLng)values(
						 '33.5 km',
						 33543,
						 '50 min',
						 2999,
						 'Av de los Insurgentes Sur 4415, Tlalcoligia, 14430 Ciudad de México, CDMX, México',
						 19.2800359,
						 -99.17047029999999,
						 'Indios Verdes, Residencial Zacatenco, 07369 Santa Isabel Tola, CDMX, México',
						 19.4950569,
						 -99.11982119999999
					 );
	 select currval(pg_get_serial_sequence('tbrutas','fiidruta'));
	insert into tbPasos (fiIdRuta,
					 fcDistancia,
					fiDistancia,
					 fcDuracion,
					fiDuracion,
					 fdoEndLocationLat,
					 fdoEndLocationLng,
					 fdoStartLocationLat,
					 fdoStartLocationLng,
					 fcPolyLine)values(
						 currval(pg_get_serial_sequence('tbrutas','fiidruta')), 
						 '3.2 km',
						 3241,
						 '3 min',
						 202,
						 19.471264,
						 -99.1371211,
						 19.4950119,
						 -99.11982119999999,
						 'cs~uBzi~{QjAPh@FTB`@Dv@Df@FZDd@FVDNBLBJBrBb@@?zA^d@Jb@L\\JXJJDJDLDPHXLDBPHLFPHLH\\RZPDDFDJHNJZV~AnAFDHFVPp@h@vAhAb@Z|C`C^XlA|@f@b@t@j@z@t@`Ax@NNfAz@TPl@d@PLf@`@tA`Al@b@rBxAr@j@PJn@f@`@Zz@p@JFZVLHrAbAl@d@pDrCnA`Al@f@n@d@dDfC|AnA|BnBnDpCr@h@b@\\dAv@HDZT\\THFh@`@`@X|@p@`E~CrEdDl@b@pB~A^Z`EjD'
					 );
					 
					 	insert into tbUsuarios(fiIdPaso,
						fcFleet,
						fiMagvar,
						fnInscale,
						fiMod,
						fiAddon,
						fiPing,
						fdoLocationLat,
						fdoLocationLng,
						fcId,
						fcUserName,
						fdoSpeed,
						fnIngroup) values (1,
										   'none',
										  0,
										  true,
										  49,
										  0,
										  1,
										  -99.077,
										  19.4525,
										  'user-1952783957',
										  'guest',
										  12.216255542664635,
										  false);								 


					 
select *
from tbRutas;

select *
from tbPasos;			

select *
from tbDatosGeneraRutas

select *
from tbUsuarios

rollback transaction;

begin transaction;
insert into tbPasos (fiIdRuta, fcDistancia, fiDistancia, fcDuracion, fiDuracion, fdoEndLocationLat, fdoEndLocationLng, fdoStartLocationLat, fdoStartLocationLng, fcPolyLine)values(1, '1.5 km', 1487,'3 min', 173, 19.459642, -99.162841, 19.457236, -99.148897,'wfwuBr_d|QEd@Mj@GZKf@ERCPGl@KdAObBMfAMbAE\Id@CRGb@Gx@Eb@SlBMvAEn@A?CZ?FAFI~@AHARGl@a@jE?NARAV?HCb@It@IdAa@zEc@zEMlAWjCw@lIO|AKjA');
rollback transaction;



