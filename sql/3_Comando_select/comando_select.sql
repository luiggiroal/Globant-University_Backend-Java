use mi_bd;

/*
	##########################
	Ejercicios DML
	##########################
*/

-- 1) Inserta un nuevo producto en la tabla "productos" con el nombre "Teléfono móvil" y un precio de 450.00.
insert into productos
values (null, 'Teléfono móvil', 450.00);

-- 2) Inserta un nuevo cliente en la tabla "clientes" con el nombre "María García" y la dirección "Constitución 456, Luján".
insert into clientes
values (null, 'María García', 'Constitución 456, Luján');

-- 3) Modifica la columna correo_electronico de la tabla empleados para que se genere automáticamente concatenado el nombre, apellido y el string “@mail.com”.
alter table empleados
modify correo_electronico varchar(100) generated always as (concat(nombre, apellido, '@mail.com')) stored;

-- 4) Inserta un nuevo empleado en la tabla "empleados" con el nombre "Luis” y apellido “Fernández", edad 28, salario 2800.00 y que pertenezca al departamento “ventas”.
insert into empleados(nombre, apellido, edad, salario, departamento_id)
values ('Luis', 'Fernández', 28, 2800.00, (select id from departamentos where nombre = 'Ventas'));

-- 5) Actualiza el precio del producto "Laptop" a 1350.00 en la tabla "productos".
update productos
set precio = 1350.00
where nombre = 'Laptop';

-- 6) Modifica la dirección del cliente "Juan Pérez" a "Alberti 1789, Mar del Plata" en la tabla "clientes".
update clientes
set direccion = 'Alberti 1789, Mar del Plata'
where nombre = 'Juan Pérez';

-- 7) Incrementa el salario de todos los empleados en un 5% en la tabla "empleados".
update empleados
set salario = salario * 1.05;

-- 8) Inserta un nuevo producto en la tabla "productos" con el nombre "Tablet" y un precio de 350.00.
insert into productos(nombre, precio)
values ('Tablet', 350.00);

-- 9) Inserta un nuevo cliente en la tabla "clientes" con el nombre "Ana López" y la dirección "Beltrán 1452, Godoy Cruz".
insert into clientes(nombre, direccion)
values ('Ana López', 'Beltrán 1452, Godoy Cruz');

-- 10) Inserta un nuevo empleado en la tabla "empleados" con el nombre "Marta", apellido "Ramírez", edad 32, salario 3100.00 y que pertenezca al departamento “ventas”.
insert into empleados(nombre, apellido, edad, salario, departamento_id)
values ('Marta', 'Ramírez', 32, 3100.00, (select id from departamentos where nombre = 'Ventas'));

-- 11) Actualiza el precio del producto "Teléfono móvil" a 480.00 en la tabla "productos".
update productos
set precio = 480.00
where nombre = 'Teléfono móvil';

-- 12) Modifica la dirección del cliente "María García" a "Avenida 789, Ciudad del Este" en la tabla "clientes".
update clientes
set direccion = 'Avenida 789, Ciudad del Este'
where nombre = 'María García';

-- 13) Incrementa el salario de todos los empleados en el departamento de "Ventas" en un 7% en la tabla "empleados".
update empleados
set salario = salario * 1.07
where departamento_id = (select id from departamentos where nombre = 'Ventas');

-- 14) Inserta un nuevo producto en la tabla "productos" con el nombre "Impresora" y un precio de 280.00.
insert into productos(nombre, precio)
values ('Impresora', 280.00);

-- 15) Inserta un nuevo cliente en la tabla "clientes" con el nombre "Carlos Sánchez" y la dirección "Saavedra 206, Las Heras".
insert into clientes(nombre, direccion)
values ('Carlos Sánchez', 'Saavedra 206, Las Heras');

-- 16) Inserta un nuevo empleado en la tabla "empleados" con el nombre "Lorena", apellido "Guzmán", edad 26, salario 2600.00 y que pertenezca al departamento “ventas”.
insert into empleados(nombre, apellido, edad, salario, departamento_id)
values ('Lorena', 'Guzmán', 26, 2600.00, (select id from departamentos where nombre = 'Ventas'));

-- 17) Haz una consulta simple de los datos de la tabla empleados
select * from empleados;

/* FYI: Resettting auto-increment to a number greater than the current maximum 'id'.

select max(id) from empleados; -- Output: 7
alter table empleados auto_increment = 8;

*/

-- 18) Haz una consulta simple de los datos de la tabla clientes
select * from clientes;

-- 19) Haz una consulta simple de los datos de la tabla productos
select * from productos;


/*
	##########################
	Actividad: Ejercicios Complementarios
	##########################
*/


-- 1) Inserta una venta en la tabla "ventas" donde el cliente "Juan Pérez" compra una "Laptop" con una cantidad de 2 y el vendedor tiene el nombre "Ana" y apellido "Rodríguez".
insert into ventas(producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
values 
	((select id from productos where nombre = 'Laptop'),
    (select id from clientes where nombre = 'Juan Pérez'),
    2,
    (select precio from productos where nombre = 'Laptop'),
    (select id from empleados where nombre = 'Ana' and apellido = 'Rodríguez'));

-- 2) Inserta una venta en la tabla "ventas" donde el cliente "María García" compra un "Teléfono móvil" con una cantidad de 3 y el vendedor tiene el nombre "Carlos" y apellido "López".
insert into ventas(producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
values 
	((select id from productos where nombre = 'Teléfono móvil'),
    (select id from clientes where nombre = 'María García'),
    3,
    (select precio from productos where nombre = 'Teléfono móvil'),
    (select id from empleados where nombre = 'Carlos' and apellido = 'López'));

-- 3) Crea una venta en la tabla "ventas" donde el cliente "Carlos Sánchez" compra una "Impresora" con una cantidad de 1 y el vendedor tiene el nombre "Marta" y apellido "Ramírez".
insert into ventas(producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
values 
	((select id from productos where nombre = 'Impresora'),
    (select id from clientes where nombre = 'Carlos Sánchez'),
    1,
    (select precio from productos where nombre = 'Impresora'),
    (select id from empleados where nombre = 'Marta' and apellido = 'Ramírez'));

-- 4) Inserta una venta en la tabla "ventas" donde el cliente "Ana López" compra una "Laptop" con una cantidad de 1 y el vendedor tiene el nombre "Carlos" y apellido "López".
insert into ventas(producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
values 
	((select id from productos where nombre = 'Laptop'),
    (select id from clientes where nombre = 'Ana López'),
    1,
    (select precio from productos where nombre = 'Laptop'),
    (select id from empleados where nombre = 'Carlos' and apellido = 'López'));

-- 5) Crea una venta en la tabla "ventas" donde el cliente "Juan Pérez" compra una "Tablet" con una cantidad de 2 y el vendedor tiene el nombre "Luis" y apellido "Fernández".
insert into ventas(producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
values 
	((select id from productos where nombre = 'Tablet'),
    (select id from clientes where nombre = 'Juan Pérez'),
    2,
    (select precio from productos where nombre = 'Tablet'),
    (select id from empleados where nombre = 'Luis' and apellido = 'Fernández'));

-- 6) Inserta una venta en la tabla "ventas" donde el cliente "María García" compra un "Teléfono móvil" con una cantidad de 1 y el vendedor tiene el nombre "Marta" y apellido "Ramírez".
insert into ventas(producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
values 
	((select id from productos where nombre = 'Teléfono móvil'),
    (select id from clientes where nombre = 'María García'),
    1,
    (select precio from productos where nombre = 'Teléfono móvil'),
    (select id from empleados where nombre = 'Marta' and apellido = 'Ramírez'));

-- 7) Crea una venta en la tabla "ventas" donde el cliente "Carlos Sánchez" compra una "Impresora" con una cantidad de 2 y el vendedor tiene el nombre "Lorena" y apellido "Guzmán".
insert into ventas(producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
values 
	((select id from productos where nombre = 'Impresora'),
    (select id from clientes where nombre = 'Carlos Sánchez'),
    2,
    (select precio from productos where nombre = 'Impresora'),
    (select id from empleados where nombre = 'Lorena' and apellido = 'Guzmán'));

-- 8) Haz una consulta simple de los datos de la tabla ventas
select * from ventas;


/*
	##########################
	Ejercicios: Cláusula DISTINCT
	##########################
*/

-- 1) Lista los nombres de los empleados sin duplicados
select distinct nombre from empleados;

-- 2) Obtén una lista de correos electrónicos únicos de todos los empleados.
select distinct correo_electronico from empleados;

-- 3) Encuentra la lista de edades distintas entre los empleados.
select distinct edad from empleados;


/*
	##########################
	Ejercicios: Operadores relacionales
	##########################
*/


-- 1) Muestra los nombres de los empleados que tienen un salario superior a $3200.
select nombre from empleados where salario > 3200;

-- 2) Obtén una lista de empleados que tienen 28 años de edad.
select id, concat(nombre,' ', apellido) as 'Empleados que tienen 28 años' from empleados where edad = 28;

-- 3) Lista a los empleados cuyos salarios sean menores a $2700.
select id, concat(nombre, ' ', apellido) as 'Empleados con salarios menores a $2700', salario from empleados where salario < 2700;

-- 4) Encuentra todas las ventas donde la cantidad de productos vendidos sea mayor que 2.
select * from ventas where cantidad > 2;

-- 5) Muestra las ventas donde el precio unitario sea igual a $480.00.
select * from ventas where precio_unitario = 480.00;

-- 6) Obtén una lista de ventas donde el monto total sea menor que $1000.00.
select * from ventas where monto_total < 1000.00;

-- 7) Encuentra las ventas realizadas por el empleado con el ID 1.
select * from ventas where empleado_id = 1;


/*
	##########################
	Ejercicios: Operadores lógicos
	##########################
*/


-- 1) Muestra los nombres de los empleados que trabajan en el Departamento 1 y tienen un salario superior a $3000.
select nombre from empleados where departamento_id = 1 and salario > 3000;

-- 2) Lista los empleados que tienen 32 años de edad o trabajan en el Departamento 3.
select * from empleados where edad = 32 or departamento_id = 3;

-- 3) Lista las ventas donde el producto sea el ID 1 y la cantidad sea mayor o igual a 2.
select * from ventas where producto_id = 1 and cantidad >= 2;

-- 4) Muestra las ventas donde el cliente sea el ID 1 o el empleado sea el ID 2.
select * from ventas where cliente_id = 1 or empleado_id = 2;

-- 5) Obtén una lista de ventas donde el cliente sea el ID 2 y la cantidad sea mayor que 2.
select * from ventas where cliente_id = 2 and cantidad > 2;

-- 6) Encuentra las ventas realizadas por el empleado con el ID 1 y donde el monto total sea mayor que $2000.00.
select * from ventas where empleado_id = 1 and monto_total > 2000.00;


/*
	##########################
	Ejercicios: Cláusula BETWEEN
	##########################
*/


-- 1) Encuentra a los empleados cuyas edades están entre 29 y 33 años. Muestra el nombre y la edad de los registros que cumplan esa condición. 
select nombre, edad from empleados where edad between 29 and 33;

-- 2) Encuentra las ventas donde la cantidad de productos vendidos esté entre 2 y 3.
select * from ventas where cantidad between 2 and 3;

-- 3) Muestra las ventas donde el precio unitario esté entre $300.00 y $500.00.
select * from ventas where precio_unitario between 300.00 and 500.00;