use mi_bd;

-- Turning off the safe update mode
set sql_safe_updates = 0;
-- Checking whether safe update mode is activated or not
show variables like 'sql_safe_updates';

-- Creating 'estudiantes' table
CREATE TABLE IF NOT EXISTS estudiantes (
    nombre VARCHAR(50),
    fecha_nacimiento DATE
);

-- Creating 'empleados' table
CREATE TABLE IF NOT EXISTS empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    edad TINYINT UNSIGNED,
    salario DECIMAL(10 , 2 ),
    fecha_contratacion DATE
);

-- To check the name of the foreign key from 'empleados' table
SELECT 
    constraint_name,
    table_name,
    column_name,
    referenced_table_name,
    referenced_column_name
FROM
    information_schema.key_column_usage
WHERE
    referenced_table_name IS NOT NULL
        AND table_name = 'empleados';

/*
	##########################
	Actividad : Aplicando DDL 
	##########################
*/

-- 1) Modifica la columna "edad" para que no pueda tener valores nulos.
alter table empleados modify edad int not null;

-- 2) Modifica la columna "salario" para que tenga un valor predeterminado de
--    0 en lugar de nulo.
alter table empleados modify salario decimal(10, 2) default 0;

-- 3) Agrega una columna llamada "departamento" de tipo VARCHAR(50) para
--    almacenar el departamento al que pertenece cada empleado.
alter table empleados add departamento varchar(50);


-- 4) Agrega una columna llamada "correo_electronico" de tipo VARCHAR(100)
--    para almacenar las direcciones de correo electrónico de los empleados.
alter table empleados add correo_electronico varchar(100);

-- 5) Elimina la columna "fecha_contratacion" de la tabla "empleados".
alter table empleados drop fecha_contratacion;

-- 6) Vuelve a crear la columna "fecha_contratacion" de la tabla 
--    "empleados" pero con un valor por default que sea la fecha actual.
--    Para eso puedes usar las funciones “CURRENT_DATE” o “NOW()”.
alter table empleados add fecha_contratacion date default (current_date);

-- 7) Crea una nueva tabla llamada "departamentos" con las siguientes columnas:
--    	id (clave primaria, tipo INT AUTO_INCREMENT)
-- 		nombre (tipo VARCHAR(50))
create table if not exists departamentos (
	id int auto_increment primary key,
    nombre varchar(50)
);

-- 8) Agrega una nueva columna llamada "departamento_id" en la tabla "empleados"
--    que servirá como clave foránea para hacer referencia al departamento al que pertenece cada empleado.
alter table empleados add departamento_id int;

-- 9) Modifica la tabla “empleados” y establece una restricción de clave foránea en la columna 
--    "departamento_id" para que haga referencia a la columna "id" en la tabla "departamentos".
alter table empleados add foreign key (departamento_id) references departamentos(id);

-- 10) Elimina el campo “departamentos” de la tabla empleados, ahora usaremos la clave foránea para poder 
--     relacionar ambas tablas
alter table empleados drop departamento;


/*
	##########################
	Actividad : Aplicando DML 
	##########################
*/

-- 1) Inserta un departamento llamado "Ventas" en la tabla "departamentos".
insert into departamentos
values (null, 'Ventas');

-- 2) Inserta un departamento llamado "Recursos Humanos" en la tabla "departamentos".
insert into departamentos
values (null, 'Recursos Humanos');

-- 3,4,5,6) Inserta varios empleados en la tabla "empleados".
insert into empleados
values
	(null, 'Ana', 'Rodríguez', 28, 3000.00, 'anarodriguez@mail.com', current_date(), 1),
    (null, 'Carlos', 'López', 32, 3200.50, 'carloslopez@mail.com', current_date(), 2),
    (null, 'Laura', 'Pérez', 26, 2800.75, 'lauraperez@mail.com', current_date(), 1),
    (null, 'Martín', 'González', 30, 3100.25, 'martingonzalez@mail.com', current_date(), 2);

-- 7) Actualiza el salario del empleado con nombre "Ana" para aumentarlo en un 10%.
update empleados
set salario = salario * 1.1
where nombre = 'Ana';

-- 8) Crea un departamento llamado “Contabilidad”. 
insert into departamentos
values (null, 'Contabilidad');

-- 9) Cambia el departamento del empleado con nombre "Carlos" de "Recursos Humanos"
--    a "Contabilidad"
update empleados
set departamento_id = 3
where nombre = 'Carlos' limit 100;

-- 10) Elimina al empleado con nombre "Laura"
delete from empleados
where nombre = 'Laura';

-- 11) Haz una consulta simple de los datos de la tabla empleados.
select * from empleados;

-- 12) Haz una consulta simple de los datos de la tabla departamentos
select * from departamentos;

/*
	##########################
	Actividad : Práctica Avanzada
	##########################
*/

-- 1) Crea una tabla llamada "clientes" con columnas para el "id" (entero 
--   autoincremental), "nombre" (cadena de hasta 50 caracteres), y "direccion" 
--   (cadena de hasta 100 caracteres).
create table clientes (
	id int auto_increment primary key,
    nombre varchar(50),
    direccion varchar(100)
);

-- 2) Crea una tabla llamada "productos" con columnas para el "id" (entero 
--    autoincremental), "nombre" (cadena de hasta 50 caracteres), y "precio" 
--    (decimal con 10 dígitos, 2 decimales).
create table productos (
	id int auto_increment primary key,
    nombre varchar(50),
    precio decimal(10, 2)
);

-- 3) Crea una tabla llamada "ventas" con columnas para "id" (entero 
--    autoincremental), "producto_id" (entero), "cliente_id" (entero), 
--    "cantidad" (entero), “precio_unitario” (decimal con 10 dígitos, 
--    2 decimales), "monto_total" (decimal con 10 dígitos, 2 decimales), 
--    y "empleado_id" (entero).
create table ventas (
	id int auto_increment primary key,
    producto_id int,
    cliente_id int,
    cantidad int,
    precio_unitario decimal(10, 2),
    monto_total decimal(10, 2),
    empleado_id int
);

-- 4) En la tabla creada Ventas, establece restricciones de clave foránea en
--    las columnas "producto_id," "cliente_id," y "empleado_id" para hacer 
--    referencia a las tablas correspondientes. 
alter table ventas
add foreign key (producto_id)
references productos(id);

alter table ventas
add foreign key (cliente_id)
references clientes(id);

alter table ventas
add foreign key (empleado_id)
references empleados(id);

-- 5) Inserta un nuevo cliente en la tabla "clientes" con el nombre "Juan Pérez" 
--    y la dirección "Libertad 3215, Mar del Plata"
insert into clientes
values (null, 'Juan Pérez', 'Libertad 3215, Mar del Plata');

-- 6) Inserta un nuevo producto en la tabla "productos" con el nombre "Laptop" 
--    y un precio de 1200.00 .
insert into productos
values (null, 'Laptop', 1200.00);

-- 7) Modifica la columna monto_total de la tabla ventas para que por defecto 
--    sea el resultado de multiplicar la cantidad por el precio del producto_id
alter table ventas
modify monto_total decimal(10, 2) generated always as (cantidad * precio_unitario) stored;

-- 8) Crea una venta en la tabla "ventas" donde el cliente "Juan Pérez" compra 
--    "Laptop" por una cantidad de 2 unidades y el vendedor tenga el nombre “Ana"
--    y apellido "Rodriguez”. Ten en cuenta que debes “tener” los ID y valores 
--    correspondientes previamente, luego aprenderemos a recuperarlos con 
--    subconsultas.
insert into ventas(producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
values (1, 1, 2, 1200.00, 1);

-- 9) Haz una consulta simple de los datos de la tabla ventas
select * from ventas;

/*
create table if not exists empleados2 (
	id int auto_increment primary key,
    nombre varchar(50),
    apellido varchar(50),
    departamento_id smallint,
    salario decimal(10, 2)
);

insert into empleados2
values
	(null, 'Ana', 'Rodriguez', 1, 1000.00),
    (null, 'Carlos', 'Lopez', 3, 2000.00),
    (null, 'Martin', 'Gonzalez', 2, 1500.00),
    (null, 'Luis', 'Fernandez', 1, 1200.00),
    (null, 'Marta', 'Ramirez', 1, 1400.00),
    (null, 'Lorena', 'Guzman', 1, 1800.00);

-- delete from empleados2 where id between 7 and 12;

update empleados2
set salario = salario * 1.07 where departamento_id = 1 limit 100;

select * from empleados2;*/
