use mi_bd;

/*
	##########################
	Ejercicios Prácticos con Tablas Temporales
	##########################
*/

-- Utiliza TABLE para consultar la tabla productos de manera simple, ordenando los productos de forma descendente por precio y solo 10 filas.
table productos
order by precio desc
limit 10;

-- Crea una tabla temporal de los empleados donde unifiques su nombre y apellido en una sola columna.

drop temporary table if exists nombre_apellido_e;
create temporary table nombre_apellido_e as
select concat(nombre, ' ', apellido) 'Nombre empleado'
from empleados;
-- table nombre_apellido_e;

-- Crea una tabla temporal de la tabla clientes donde solo tengas la columna nombre.
create temporary table nombre_clientes as
select nombre 'Nombre cliente'
from clientes;
-- table nombre_clientes;

-- Realiza la unión entre las tablas temporales de empleados y clientes usando TABLE.
table nombre_apellido_e union table nombre_clientes;

-- Crea una tabla temporal escuela primaria que tenga las siguientes columnas: id(int), nombre(varchar), apellido(varchar), edad(int) y grado(int). Y que tenga los siguientes valores:

	-- ID: 1, Nombre: Alejandro, Apellido: González, Edad: 11, Grado: 5

	-- ID: 2, Nombre: Isabella, Apellido: López, Edad: 10, Grado: 4

	-- ID: 3, Nombre: Lucas, Apellido: Martínez, Edad: 11, Grado: 5 

	-- ID: 4, Nombre: Sofía, Apellido: Rodríguez, Edad: 10, Grado: 4 

	-- ID: 5, Nombre: Mateo, Apellido: Pérez, Edad: 12, Grado: 6 

	-- ID: 6, Nombre: Valentina, Apellido: Fernández, Edad: 12, Grado: 6

	-- ID: 7, Nombre: Diego, Apellido: Torres, Edad: 10, Grado: 4

	-- ID: 8, Nombre: Martina, Apellido: Gómez, Edad: 11, Grado: 5

	-- ID: 9, Nombre: Joaquín, Apellido: Hernández, Edad: 10, Grado: 4

	-- ID: 10, Nombre: Valeria, Apellido: Díaz, Edad: 11, Grado: 5
    
create temporary table escuela_primaria (
	id int auto_increment primary key,
    nombre varchar(50),
    apellido varchar(50), 
    edad int,
    grado int
);

insert into escuela_primaria(nombre, apellido, edad, grado)
values 
	('Alejandro', 'González', 11, 5),
    ('Isabella', 'Lopez', 10, 4),
    ('Lucas', 'Martinez', 11, 5),
    ('Sofía', 'Rodríguez', 10, 4),
    ('Mateo', 'Perez', 12, 6),
    ('Valentina', 'Fernandez', 12, 6),
    ('Diego', 'Torres', 10, 4),
    ('Martina', 'Gomez', 11, 5),
    ('Joaquín', 'Hernandez', 10, 4),
    ('Valeria', 'Diaz', 11, 5);

-- table escuela_primaria;
    
/*
	##########################
	Ejercicios Complementarios con Tablas Temporales 
	##########################
*/

-- Agrega un cliente nuevo con el nombre “Ana Rodríguez” y con dirección en “San Martín 2515, Mar del Plata”. Luego realiza la intersección entre la tabla temporal de empleados y clientes.
-- [💡 Debes volver a crear la tabla temporal de clientes para actualizar esa tabla].

-- Realiza la excepción entre la tabla temporal de clientes y la de empleados.

-- Crea una tabla temporal escuela secundaria que tenga las siguientes columnas: id(int), nombre(varchar), apellido(varchar), edad(int) y grado(int). Y que tenga los siguientes valores:

	-- ID: 1, Nombre: Eduardo, Apellido: Sánchez, Edad: 16, Grado: 10

	-- ID: 2, Nombre: Camila, Apellido: Martín, Edad: 17, Grado: 11

	-- ID: 3, Nombre: Manuel, Apellido: Gutiérrez, Edad: 15, Grado: 9

	-- ID: 4, Nombre: Laura, Apellido: García, Edad: 16, Grado: 10

	-- ID: 11, Nombre: Pablo, Apellido: Ortega, Edad: 17, Grado: 11

	-- ID: 12, Nombre: Carmen, Apellido: Ramírez, Edad: 15, Grado: 9

	-- ID: 13, Nombre: Carlos, Apellido: Molina, Edad: 16, Grado: 10

	-- ID: 14, Nombre: Ana, Apellido: Ruiz, Edad: 17, Grado: 11

	-- ID: 15, Nombre: Luis, Apellido: Fernández, Edad: 15, Grado: 9

	-- ID: 16, Nombre: María, Apellido: López, Edad: 16, Grado: 10

-- Realiza la intersección de la escuela primaria y escuela secundaria con el nombre y apellido de los alumnos para saber quienes fueron a ambas escuelas.

-- Realiza la excepción de la escuela primaria con la secundaria para saber quienes no siguieron cursando en dicha escuela secundaria.

-- Realiza la excepción de la escuela secundaria con la primaria para saber quienes no siguieron cursando en dicha escuela secundaria.

-- Realiza la unión de la escuela primaria y secundaria con la columna grado para saber cuáles son los grados que abarcan ambas escuelas, y ordénalos de forma descendente.

/*
	##########################
	Ejercicios  Subconsultas All y Any 
	##########################
*/

-- Encuentra los nombres de los clientes que han realizado compras de productos con un precio superior a la media de precios de todos los productos.
	
    /* FYI: Aggregate functions (AVG, SUM, MAX, etc) can't 
	be used directly in a WHERE clause. Try using the aggregate
    function in a subquery where it's allowed. */
select c.nombre 'Nombre de Cliente'
from clientes c
where c.id = any(
	select distinct v.cliente_id
    from ventas v
    where v.precio_unitario > (
		select avg(p.precio)
        from productos p
	)
);

	/* Alternative solution using joins.*/
select distinct c.nombre 'Nombre de Cliente'
from clientes c
left join ventas v
	on c.id = v.cliente_id
left join productos p
	on v.producto_id = p.id
    where v.precio_unitario > (
		select avg(p.precio)
        from productos p
	);

-- Encuentra los empleados cuyo salario sea mayor que al menos uno de los salarios de los empleados del departamento de "Ventas".
select concat_ws(' ', e.nombre, e.apellido) 'Empleado'
from empleados e
where e.salario > any(
	select e2.salario
    from empleados e2
    where e2.departamento_id = any(
		select d.id
        from departamentos d
        where d.nombre = 'Ventas'
    )
);

	/* Alternative solution using 'inner join'.*/
select concat_ws(' ', e.nombre, e.apellido) 'Cliente'
from empleados e
where e. salario > any(
	select e2.salario
    from empleados e2
    inner join departamentos d
		on e2.departamento_id = d.id
	where d.nombre = 'Ventas'
);

-- Encuentra los productos cuyos precios sean mayores que todos los precios de los productos con la palabra "Móvil" en su nombre.
select p.nombre 'Producto', p.precio 'Precio'
from productos p
where p.precio > all(
	select p2.precio
    from productos p2
    where p2.nombre like '%Móvil%'
);

-- Muestra la información de los clientes que realizaron la compra con el monto total más alto, incluyendo su nombre, dirección y el monto total de compra.

	/* FYI: When data from 2 or more tables is asked to show, it's more 
    advisable to use joins instead of subqueries. */
select c.nombre 'Nombre', c.direccion 'Dirección', max(v.monto_total) 'Monto total de compra'
from clientes c, ventas v
where c.id = v.cliente_id and c.id = any(
	select v.cliente_id
    from ventas v
    where v.monto_total = (
		select max(v2.monto_total)
        from ventas v2
    ) 
)
group by c.nombre, c.direccion;

	/* Alternative solution using 'inner join'. This is the advisable 
	solution. */
SELECT c.nombre "Cliente", c.direccion "Dirección",
MAX(v.monto_total) "Monto Total de Compra"
FROM clientes c INNER JOIN ventas v ON c.id = v.cliente_id
GROUP BY c.id
ORDER BY MAX(v.monto_total) DESC
LIMIT 1;

-- Para cada departamento, encuentra el empleado con el salario más alto. Muestra el nombre del departamento junto con el nombre del empleado y su salario

	/* Using the concept of Correlated Subquery which is a subquery that 
    references columns from the outer query. This pattern is common for 
    finding per-group max/min values. */
select d.nombre 'Departamento', concat_ws(' ', e.nombre, e.apellido) 'Empleado', e.salario 'Salario'
from departamentos d
inner join empleados e
	on d.id = e.departamento_id
where e.salario = (
	select max(e2.salario)
    from empleados e2
    where e2.departamento_id = d.id
);

/*
	##########################
	Ejercicios  Subconsultas All y Any
	##########################
*/

-- Encuentra los empleados que ganan más que el salario promedio de los empleados del departamento de "Contabilidad".

-- Encuentra los productos que tienen un precio superior al precio de al menos uno de los productos vendidos al cliente con nombre "Juan Pérez".

-- Encuentra los departamentos en los que al menos hay un empleado menor de 30 años.

-- Muestra la información del empleado más joven, que esté entre los 3 empleados con más cantidad de productos vendidos, incluyendo su nombre, apellido y edad.

-- Para cada cliente, encuentra el empleado que realizó la venta con el monto total más alto. Muestra el nombre del cliente junto con el nombre del empleado y el monto total.

/*
	##########################
	Ejercicios Complementarios 
	##########################
*/

-- Encuentra los clientes que no han realizado ninguna compra. Muestra el nombre y la dirección de estos clientes.

-- Muestra el nombre de los productos que se han vendido más veces que cualquier producto con un precio superior a 500.

-- Encuentra los empleados cuya edad sea menor que la edad de al menos un empleado del departamento de "Recursos Humanos".

-- Encuentra los productos cuyos precios sean menores o iguales a todos los precios de los productos con la palabra "Cámara" en su nombre.

-- Muestra el nombre y el salario de los empleados con salarios superiores al promedio de salarios de todos los empleados.

-- Encuentra el nombre y el salario de los empleados con salarios inferiores al promedio de salarios de todos los empleados del departamento de "Ventas".

-- Encuentra los clientes que han realizado compras de productos con un precio_unitario inferior al precio promedio de todos los productos.

-- Encuentra los empleados que tienen un salario igual al salario de al menos un empleado del departamento de "Recursos Humanos".

-- Encuentra los productos cuyo precio es mayor o igual a todos los precios de los productos con la palabra "Refrigeradora" en su nombre.

-- Muestra el nombre, apellido y salario del empleado con el salario más alto que esté por debajo del promedio salarial de los empleados.