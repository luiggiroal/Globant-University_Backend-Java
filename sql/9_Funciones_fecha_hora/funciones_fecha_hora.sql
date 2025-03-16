use mi_bd;

/*
	##########################
	Ejercicios  Subconsultas All y Any
	##########################
*/

-- Crea una tabla llamada "envios" con cuatro columnas: "id" de tipo INT como clave primaria y autoincremental, "fecha_envio" de tipo DATETIME,  "fecha_entrega" de tipo DATETIME y "codigo_producto" de tipo VARCHAR(10). Luego, inserta siete filas en la tabla "envios" con los siguientes datos:

	-- Fecha Envío: '2022-01-15 08:00:00', Fecha Entrega: '2022-01-20 12:30:00', Código Producto: 'ABC123'.

	-- Fecha Envío: '2022-02-10 10:15:00', Fecha Entrega: '2022-02-15 14:45:00', Código Producto: 'XYZ789'.

	-- Fecha Envío: '2022-03-05 09:30:00', Fecha Entrega: '2022-03-10 13:20:00', Código Producto: 'PQR456'.

	-- Fecha Envío: '2022-04-20 11:45:00', Fecha Entrega: '2022-04-25 15:10:00', Código Producto: 'LMN001'.

	-- Fecha Envío: '2022-05-12 07:55:00', Fecha Entrega: '2022-05-17 10:25:00', Código Producto: 'DEF777'.

	-- Fecha Envío: '2022-06-08 08:20:00', Fecha Entrega: '2022-06-13 12:40:00', Código Producto: 'GHI888'.

	-- Fecha Envío: '2022-07-03 10:05:00', Fecha Entrega: '2022-07-08 14:15:00', Código Producto: 'JKL999'.
create table envios (
	id int auto_increment primary key,
    fecha_envio datetime,
    fecha_entrega datetime,
    codigo_producto varchar(10)
);

INSERT INTO envios (fecha_envio, fecha_entrega, codigo_producto) VALUES 
('2022-01-15 08:00:00','2022-01-20 12:30:00','ABC123'),
('2022-02-10 10:15:00','2022-02-15 14:45:00','XYZ789'),
('2022-03-05 09:30:00','2022-03-10 13:20:00','PQR456'),
('2022-04-20 11:45:00','2022-04-25 15:10:00','LMN001'),
('2022-05-12 07:55:00','2022-05-17 10:25:00','DEF777'),
('2022-06-08 08:20:00','2022-06-13 12:40:00','GHI888'),
('2022-07-03 10:05:00','2022-07-08 14:15:00','JKL999')
;

-- Utilizando la función DATE_ADD, calcula la fecha de entrega programada para un envío con código de producto 'ABC123' cuando se le añaden 5 días a la fecha de envío.
select date_add(fecha_envio, interval 5 day) 'Fecha de entrega'
from envios
where codigo_producto = 'ABC123';

-- Utilizando la función ADDTIME, encuentra la hora estimada de entrega para un envío con código de producto 'XYZ789' si se suma 4 horas y 30 minutos a la hora de entrega. 
select addtime(fecha_entrega, '04:30:00') 'Hora estimada de entrega'
from envios
where codigo_producto = 'XYZ789';

-- Utilizando la función CONVERT_TZ, convierte la fecha de envío de un envío con código de producto 'PQR456' de la zona horaria 'UTC' (+00:00) a la zona horaria de Argentina GMT-3 (-03:00).
select convert_tz(fecha_envio, '+00:00', '-03:00') 'Fecha de envio (Argentina GMT-3)'
from envios
where codigo_producto = 'PQR456';

-- Calcula la diferencia en días entre la fecha de entrega y la fecha de envío para el envío con código de producto 'LMN001' utilizando la función DATEDIFF.
select codigo_producto 'Código de producto', datediff(fecha_entrega, fecha_envio) 'Diferencia días entre fecha_entrega y fecha_envio' 
from envios
where codigo_producto = 'LMN001';

-- Utiliza la función CURDATE para obtener la fecha actual y, a continuación, obtener la diferencia en días entre la fecha de entrega con código de producto 'DEF777' y la fecha actual.
select codigo_producto 'Código producto', curdate() 'Fecha actual', fecha_entrega 'Fecha entrega', datediff(curdate(), fecha_entrega) 'Diferencia días entre fecha actual y fecha_entrega' 
from envios
where codigo_producto = 'DEF777';

-- Utilizando la función CURTIME, obtén la hora actual del sistema.
select curtime() 'Hora actual del sistema';

-- Utiliza la función DATE para extraer la fecha de envío del envío con ID 3.
select id 'ID producto', date(fecha_envio) 'Fecha de envío'
from envios
where id = 3;

-- Utiliza la función DATE_ADD para calcular la fecha de entrega programada para el envío con código de producto 'XYZ789' si se le agregan 3 días a la fecha de envío.
select codigo_producto 'Código producto', date_add(fecha_envio, interval 3 day) 'Fecha estimada de entrega'
from envios
where codigo_producto = 'XYZ789';

-- Utiliza la función DATE_FORMAT para mostrar la fecha de envío del envío con ID 6 en el formato 'DD-MM-YYYY'.
select id 'ID producto', date_format(fecha_envio, '%d-%m-%Y') 'Fecha de envío formateada', date(fecha_envio) 'Fecha de envío. Formato original'
from envios
where id = 6;

-- Utiliza la función DATE_SUB para calcular la fecha de envío del envío con ID 4 si se le restan 2 días.
select id 'ID producto', date_sub(fecha_envio, interval 2 day) 'Nueva fecha de envio'
from envios
where id = 4;

-- Utiliza la función DATEDIFF para calcular la diferencia en días entre la fecha de envío y la fecha de entrega programada para el envío con código de producto 'PQR456'.
select codigo_producto 'Código producto', datediff(fecha_entrega, fecha_envio) 'Diferencia de días entre fecha_entrega y fecha_envio'
from envios
where codigo_producto= 'PQR456';

-- Utiliza la función DAY para obtener el día del mes en que se realizó el envío con ID 2.
select id 'ID producto', day(fecha_envio) 'Día del mes del envío'
from envios
where id = 2;

-- Utiliza la función DAYNAME para obtener el nombre del día de la semana en que se entregará el envío con código de producto 'DEF777'.
select codigo_producto 'Código producto', dayname(fecha_entrega)  'Día de la semana de la fecha de entrega'
from envios
where codigo_producto = 'DEF777';

-- Utiliza la función DAYOFMONTH para obtener el día del mes en que se entregará el envío con código de producto 'GHI888'.
select codigo_producto 'Código producto', dayofmonth(fecha_entrega) 'Día del mes de fecha_entrega'
from envios
where codigo_producto = 'GHI888';

/*
	##########################
	Ejercicios funciones de  fecha y hora
	##########################
*/

-- Utiliza la función PERIOD_ADD para agregar un período de 3 meses al año-mes '2022-07'.

-- Utiliza la función PERIOD_DIFF para calcular el número de meses entre los períodos '2022-03' y '2022-12'.

-- Utiliza la función QUARTER para obtener el trimestre de la fecha de entrega del envío con código de producto 'PQR456'.

-- Utiliza la función SEC_TO_TIME para convertir 3665 segundos en formato 'hh:mm:ss'.

-- Utiliza la función SECOND para obtener los segundos de la hora de envío del envío con ID 2.

-- Utiliza la función STR_TO_DATE para convertir la cadena '2022()08()15' en una fecha.

-- Utiliza la función SUBDATE (o DATE_SUB) para restar 5 días a la fecha de entrega del envío con código de producto 'GHI888'.

-- Utiliza la función SUBTIME para restar 2 horas y 15 minutos a la hora de envío del envío con ID 7.

-- Utiliza la función TIME para extraer la porción de tiempo de la fecha de envío del envío con ID 1.

-- Utiliza la función TIME_FORMAT para formatear la hora de envío del envío con ID 2 en 'hh:mm:ss'.

-- Utiliza la función TIME_TO_SEC para convertir la hora de envío del envío con ID 3 en segundos.

-- Utiliza la función TIMEDIFF para calcular la diferencia de horas entre las fechas de envío y entrega del envío con ID 4.

-- Utiliza la función SYSDATE para obtener la hora exacta en la que se ejecuta la función en la consulta. Para comprobar esto invoca SYSDATE, luego la función SLEEP durante 5 segundos y luego vuelve a invocar la función SYSDATE, y verifica la diferencia entre ambas invocaciones con TIMEDIFF.

-- Crea una consulta que utilice la función TIMESTAMP para obtener todos los valores de fecha_envio sumandole 12 horas.

-- Utiliza la función TIMESTAMPADD para agregar 3 horas a la fecha de entrega del envío con código de producto 'XYZ789'.

/*
	##########################
	Ejercicios  Complementarios
	##########################
*/

-- Utiliza la función DAYOFWEEK para obtener el número del día de la semana en que se realizó el envío con ID 7.

-- Utiliza la función DAYOFYEAR para obtener el día del año en que se entregará el envío con código de producto 'JKL999'.

-- Utiliza la función EXTRACT para obtener el año de la fecha de envío del envío con código de producto 'LMN001'.

-- Utiliza la función FROM_DAYS para obtener la fecha correspondiente a 737402 días a partir del año 0.

--  Utiliza la función FROM_UNIXTIME para saber que fecha sería si pasaron 1.617.799.784 segundos desde 1970.

-- Utiliza la función GET_FORMAT para obtener el formato de fecha “EUR” para formatear la fecha de entrega del envío con código de producto 'XYZ789'.

-- Utiliza la función HOUR para extraer la hora de la fecha de envío del envío con ID 1.

-- Utiliza la función LAST_DAY para obtener el último día del mes de la fecha de entrega programada para el envío con código de producto 'XYZ789'.

-- Utiliza la función LOCALTIME para obtener la hora y la fecha local actual del servidor.

-- Utiliza la función MAKEDATE para crear una fecha correspondiente al año 2023 y al día del año 180.

-- Utiliza la función MAKETIME para crear una hora con 3 horas, 30 minutos y 15 segundos.

-- Utiliza la función MICROSECOND para obtener los microsegundos de la fecha de entrega del envío con ID 3.

-- Utiliza la función MINUTE para obtener el minuto de la hora de envío del envío con ID 4.

-- Utiliza la función MONTH para obtener el mes de la fecha de envío del envío con ID 5.

-- Utiliza la función MONTHNAME para obtener el nombre del mes de la fecha de envío del envío con ID 6.

-- Utiliza la función NOW para obtener la fecha y hora actual.

-- Utiliza la función TIMESTAMPDIFF para calcular la diferencia en días entre la fecha de envío del envío con ID 5 y la fecha de entrega del envío con ID 6.

-- Utiliza la función TO_DAYS para convertir la fecha de envío del envío con ID 7 en días.

-- Utiliza la función TO_SECONDS para convertir la fecha de entrega del envío con código de producto 'JKL999' en segundos desde el Año 0.

-- Utiliza la función UNIX_TIMESTAMP para obtener una marca de tiempo Unix de la fecha de envío del envío con ID 1.

-- Utiliza la función UTC_DATE para obtener la fecha UTC actual.

-- Utiliza la función UTC_TIME para obtener la hora UTC actual.

-- Utiliza la función UTC_TIMESTAMP para obtener la fecha y hora UTC actual.

-- Utiliza la función WEEK para obtener el número de semana de la fecha de envío del envío con ID 2.

-- Utiliza la función WEEKDAY para obtener el índice del día de la semana de la fecha de envío del envío con ID 3.

-- Utiliza la función WEEKOFYEAR para obtener la semana del calendario de la fecha de entrega del envío con ID 4.

-- Utiliza la función YEAR para obtener el año de la fecha de envío del envío con ID 5.

Utiliza la función YEARWEEK para obtener el año y la semana de la fecha de envío del envío con ID 6.

