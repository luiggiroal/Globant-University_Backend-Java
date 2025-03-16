use mi_bd;
/* Insertion of new data

INSERT INTO empleados (nombre, apellido, edad, salario, departamento_id)
VALUES
  ('Laura', 'Sánchez', 27, 3300.00, 1),
  ('Javier', 'Pérez', 29, 3100.00, 1),
  ('Camila', 'Gómez', 26, 3000.00, 1),
  ('Lucas', 'Fernández', 28, 3200.00, 1),
  ('Valentina', 'Rodríguez', 30, 3500.00, 1);
  
INSERT INTO productos (nombre, precio)
VALUES
  ('Cámara Digital', 420.00),
  ('Smart TV 55 Pulgadas', 1200.00),
  ('Auriculares Bluetooth', 80.00),
  ('Reproductor de Blu-ray', 120.00),
  ('Lavadora de Ropa', 550.00),
  ('Refrigeradora Doble Puerta', 800.00),
  ('Horno de Microondas', 120.00),
  ('Licuadora de Alta Potencia', 70.00),
  ('Silla de Oficina Ergonómica', 150.00),
  ('Escritorio de Madera', 200.00),
  ('Mesa de Comedor', 250.00),
  ('Sofá de Tres Plazas', 350.00),
  ('Mochila para Portátil', 30.00),
  ('Reloj de Pulsera Inteligente', 100.00),
  ('Juego de Utensilios de Cocina', 40.00),
  ('Set de Toallas de Baño', 20.00),
  ('Cama King Size', 500.00),
  ('Lámpara de Pie Moderna', 70.00),
  ('Cafetera de Goteo', 40.00),
  ('Robot Aspirador', 180.00);
  
INSERT INTO clientes (nombre, direccion)
VALUES
  ('Alejandro López', 'Calle Rivadavia 123, Buenos Aires'),
  ('Sofía Rodríguez', 'Avenida San Martín 456, Rosario'),
  ('Joaquín Pérez', 'Calle Belgrano 789, Córdoba'),
  ('Valeria Gómez', 'Calle Mitre 101, Mendoza'),
  ('Diego Martínez', 'Avenida 9 de Julio 654, Buenos Aires');
  
INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES
  (1, 6, 3, 1350.00, 1),
  (5, 8, 5, 420.00, 9),
  (10, 2, 2, 800.00, 6),
  (14, 7, 1, 200.00, 5),
  (20, 4, 4, 20.00, 6),
  (4, 5, 5, 280.00, 1),
  (9, 5, 3, 550.00, 1),
  (13, 3, 4, 150.00, 5),
  (19, 6, 2, 40.00, 1),
  (2, 9, 5, 480.00, 1);
  
INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES
  (3, 9, 1, 350.00, 1),
  (6, 7, 4, 1200.00, 1),
  (7, 6, 3, 80.00, 1),
  (12, 9, 5, 70.00, 1),
  (16, 8, 2, 350.00, 6),
  (23, 9, 4, 180.00, 1),
  (18, 4, 3, 100.00, 7),
  (11, 3, 2, 120.00, 5),
  (15, 5, 4, 250.00, 6),
  (8, 8, 1, 120.00, 7);
  
INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES
  (17, 3, 2, 30.00, 5),
  (21, 9, 5, 500.00, 6),
  (22, 2, 3, 70.00, 6),
  (24, 9, 2, 180.00, 1),
  (5, 1, 2, 1350.00, 1),
  (9, 6, 4, 550.00, 9),
  (13, 8, 3, 150.00, 7),
  (3, 1, 5, 350.00, 1),
  (18, 9, 1, 100.00, 6),
  (10, 5, 2, 800.00, 1);
  
INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES
  (7, 4, 3, 80.00, 6),
  (2, 5, 1, 480.00, 6),
  (8, 7, 4, 120.00, 7),
  (1, 3, 5, 1350.00, 5),
  (4, 6, 2, 280.00, 5),
  (12, 1, 1, 70.00, 1),
  (19, 4, 3, 40.00, 6),
  (15, 3, 4, 250.00, 5),
  (6, 8, 2, 1200.00, 7),
  (11, 2, 3, 120.00, 5);*/


/*
	##########################
	Ejercicios cláusula IN
	##########################
*/

--  Encuentra los empleados cuyos IDs son 1, 3 o 5.
SELECT 
    *
FROM
    empleados
WHERE
    id IN (1 , 3, 5);

-- Busca los productos con IDs 2, 4 o 6 en la tabla de productos.
SELECT 
    *
FROM
    productos
WHERE
    id IN (2 , 4, 6);

--  Encuentra las ventas que tienen los clientes con IDs 1, 3 o 5.
SELECT 
    *
FROM
    ventas
WHERE
    cliente_id IN (1 , 3, 5);

/*
	##########################
	Ejercicios cláusula LIKE
	##########################
*/


--  Encuentra los empleados cuyos nombres comienzan con "L".
SELECT 
    *
FROM
    empleados
WHERE
    nombre LIKE 'L%';

-- Busca los productos cuyos nombres contengan la palabra "Teléfono".
SELECT 
    *
FROM
    productos
WHERE
    nombre LIKE '%Teléfono%';

-- Encuentra los clientes cuyas direcciones contienen la palabra "Calle".
SELECT 
    *
FROM
    clientes
WHERE
    direccion LIKE '%Calle%';


/*
	##########################
	Ejercicios cláusula ORDER BY
	##########################
*/


-- Ordena los empleados por salario de manera ascendente.
SELECT 
    *
FROM
    empleados
ORDER BY salario;

-- Ordena los productos por nombre de manera descendente.
SELECT 
    *
FROM
    productos
ORDER BY nombre DESC;

-- Ordena las ventas por cantidad de manera ascendente y luego por precio_unitario de manera descendente.
SELECT 
    *
FROM
    ventas
ORDER BY cantidad , precio_unitario DESC;


/*
	##########################
	Ejercicios LIMIT
	##########################
*/


-- Muestra los 5 productos más caros de la tabla "productos".
SELECT 
    *
FROM
    productos
ORDER BY precio DESC
LIMIT 5;

-- Muestra los 10 primeros empleados en orden alfabético por apellido.
SELECT 
    *
FROM
    empleados
ORDER BY apellido
LIMIT 10;

-- Muestra las 3 ventas con el monto total más alto.
SELECT 
    *
FROM
    ventas
ORDER BY monto_total DESC
LIMIT 3;


/*
	##########################
	Ejercicios AS
	##########################
*/


-- Crea una consulta que muestre el salario de los empleados junto con el salario aumentado en un 10% nombrando a la columna como “Aumento del 10%”.
SELECT 
    salario, (salario * 1.1) AS 'Aumento del 10%'
FROM
    empleados;

-- Crea una consulta que calcule el monto total de las compras realizadas por cliente y que la columna se llame “Monto total gastado”.
SELECT 
    cliente_id, SUM(monto_total) AS 'Monto total gastado'
FROM
    ventas
GROUP BY cliente_id;

-- Muestra los nombres completos de los empleados concatenando los campos "nombre" y "apellido" y que la columna se llame “Nombre y apellido”.
SELECT 
    CONCAT(nombre, ' ', apellido) AS 'Nombre y apellido'
FROM
    empleados;


/*
	##########################
	Ejercicios CASE
	##########################
*/


-- Crea una consulta que muestre el nombre de los productos y los categorice como "Caro" si el precio es mayor o igual a $500, "Medio" si es mayor o igual a $200 y menor que $500, y "Barato" en otros casos.
SELECT 
    nombre,
    CASE
        WHEN precio >= 500.00 THEN 'Caro'
        WHEN precio >= 200.00 AND precio < 500.00 THEN 'Medio'
        ELSE 'Barato'
    END AS 'Categoria de precio'
FROM
    productos;

-- Crea una consulta que muestre el nombre de los empleados y los categorice como "Joven" si tienen menos de 30 años, "Adulto" si tienen entre 30 y 40 años, y "Mayor" si tienen más de 40 años.
SELECT 
    nombre,
    edad,
    CASE
        WHEN edad < 30 THEN 'Joven'
        WHEN edad >= 30 AND edad < 40 THEN 'Adulto'
        ELSE 'Mayor'
    END AS 'Grado etario'
FROM
    empleados;

-- Crea una consulta que muestre el ID de la venta y los categorice como "Poca cantidad" si la cantidad es menor que 3, "Cantidad moderada" si es igual o mayor que 3 y menor que 6, y "Mucha cantidad" en otros casos.
SELECT 
    id,
    cantidad,
    CASE
        WHEN cantidad < 3 THEN 'Poca cantidad'
        WHEN cantidad >= 3 AND cantidad < 6 THEN 'Cantidad moderada'
        ELSE 'Mucha cantidad'
    END AS 'Categoría de cantidad'
FROM
    ventas;

-- Crea una consulta que muestre el nombre de los clientes y los categorice como "Comienza con A" si su nombre comienza con la letra 'A', "Comienza con M" si comienza con 'M' y "Otros" en otros casos.
SELECT 
    nombre,
    CASE
        WHEN nombre LIKE 'A%' THEN 'Comienza con A'
        WHEN nombre LIKE 'M%' THEN 'Comienza con M'
        ELSE 'Otros'
    END AS 'Primera letra de nombre'
FROM
    clientes;
 
-- Crea una consulta que muestre el nombre de los empleados y los categorice como "Salario alto" si el salario es mayor o igual a $3500, "Salario medio" si es mayor o igual a $3000 y menor que $3500, y "Salario bajo" en otros casos.
SELECT 
    nombre,
    CASE
        WHEN salario >= 3500 THEN 'Salario alto'
        WHEN salario >= 3000 AND salario < 3500 THEN 'Saladio medio'
        ELSE 'Salario bajo'
    END AS 'Nivel de salario'
FROM
    empleados;


/*
	##########################
	Ejercicios Función MAX() 
	##########################
*/

-- Encuentra el salario máximo de todos los empleados.
SELECT 
    MAX(salario)
FROM
    empleados;

-- Encuentra la cantidad máxima de productos vendidos en una sola venta.
SELECT 
    MAX(cantidad)
FROM
    ventas;

-- Encuentra la edad máxima de los empleados.
SELECT 
    MAX(edad)
FROM
    empleados;
    
/*
	##########################
	Ejercicios Función MIN()
	##########################
*/

-- Encuentra el salario mínimo de todos los empleados.
SELECT 
    MIN(salario)
FROM
    empleados;

-- Encuentra la cantidad mínima de productos vendidos en una sola venta.
SELECT 
    MIN(cantidad)
FROM
    ventas;

-- Encuentra la edad mínima de los empleados.
SELECT 
    MIN(edad)
FROM
    empleados;

/*
	##########################
	Ejercicios de la Función COUNT()
	##########################
*/

-- Cuenta cuántos empleados hay en total.
SELECT 
    COUNT(*)
FROM
    empleados;

-- Cuenta cuántas ventas se han realizado.
SELECT 
    COUNT(*)
FROM
    ventas;

-- Cuenta cuántos productos tienen un precio superior a $500.
SELECT 
    COUNT(*)
FROM
    productos
WHERE
    precio > 500;

/*
	##########################
	Ejercicios de la Función SUM()
	##########################
*/

-- Calcula la suma total de salarios de todos los empleados.
SELECT 
    SUM(salario) AS 'Suma total de salarios'
FROM
    empleados;

-- Calcula la suma total de montos vendidos en todas las ventas.
SELECT 
    SUM(monto_total) AS 'Total de montos vendidos'
FROM
    ventas;

-- Calcula la suma de precios de productos con ID par.
SELECT 
    SUM(precio) AS 'Total de precios de productos'
FROM
    productos
WHERE
    id % 2 = 0;

/*
	##########################
	Ejercicios Función AVG()
	##########################
*/

-- Calcula el salario promedio de todos los empleados.
SELECT 
    AVG(salario) AS 'Salario promedio'
FROM
    empleados;

-- Calcula el precio unitario promedio de todos los productos.
SELECT 
    AVG(precio) AS 'Precio unitario promedio'
FROM
    productos;

-- Calcula la edad promedio de los empleados.
SELECT 
    AVG(edad) AS 'Edad promedio'
FROM
    empleados;

/*
	##########################
	Ejercicios GROUP BY()
	##########################
*/

-- Agrupa las ventas por empleado y muestra la cantidad total de ventas realizadas por cada empleado.
SELECT 
    empleado_id,
    SUM(monto_total) AS 'Total de ventas realizadas'
FROM
    ventas
GROUP BY empleado_id;

-- Agrupa los productos por precio y muestra la cantidad de productos con el mismo precio.
SELECT 
    COUNT(*) AS 'Cantidad de productos con mismo precio', precio
FROM
    productos
GROUP BY precio; 

-- Agrupa los empleados por departamento y muestra la cantidad de empleados en cada departamento.
SELECT 
    COUNT(*) AS 'Cantidad de empleados por departamento',
    (SELECT 
            nombre
        FROM
            departamentos
        WHERE
            id = departamento_id) AS 'Departamento'
FROM
    empleados
GROUP BY departamento_id;

/*
	##########################
	Ejercicios HAVING 
	##########################
*/

-- Encuentra los departamentos con un salario promedio de sus empleados superior a $3,000.
select (select nombre from departamentos where e.departamento_id = id) as 'Departamentos con salario promedio > $3000', avg(e.salario) as 'Salario promedio'
from empleados e
group by e.departamento_id
having avg(e.salario) > 3000;

-- Encuentra los productos que se han vendido al menos 5 veces.
select p.nombre
from productos p, ventas v
where p.id = v.producto_id
group by p.nombre
having count(*) >= 5;

-- Selecciona los empleados que tengan una “o” en su nombre o apellido y agrúpalos por departamento y muestra los que tengan el salario máximo.
select d.nombre, max(e.salario)
from empleados e, departamentos d
where e.departamento_id = d.id and (e.nombre like '%o%' or e.apellido like '%o%')
group by d.nombre
having max(e.salario) = max(e.salario);

/*
	##########################
	EJERCICIOS CON CLÁUSULA IN
	##########################
*/

-- Busca los empleados que trabajan en los departamentos 2 o 3.
select concat(nombre, ' ', apellido) 'Empleado', departamento_id
from empleados
where departamento_id in (2, 3);

-- Trae a los clientes que no tengan los IDs 2, 4 o 6.
select id, nombre
from clientes
where id not in (2, 4, 6);

-- Busca los productos cuyos precios son 350.00, 480.00 o 800.00.
select nombre, precio
from productos
where precio in (350, 480, 800);

/*
	##########################
	EJERCICIOS CON CLÁUSULA LIKE
	##########################
*/

-- Busca los empleados cuyos correos electrónicos terminan en "mail.com".
select concat(nombre, ' ', apellido) 'Empleado', correo_electronico
from empleados
where correo_electronico like '%mail.com';

-- Encuentra los productos cuyos nombres tengan exactamente 6 caracteres.
select nombre
from productos
where nombre like '______';

-- Busca los clientes cuyos nombres tengan una "a" en la tercera posición 
select nombre
from clientes
where nombre like '__a%';

/*
	##########################
	EJERCICIOS CON CLÁUSULA ORDER BY
	##########################
*/

-- Ordena los clientes por nombre de manera ascendente y luego por dirección de manera descendente.
select *
from clientes
order by nombre, direccion desc;

-- Ordena los empleados por fecha_contratación de manera descendente.
select *
from empleados
order by fecha_contratacion desc;

-- Ordena los productos por precio de manera ascendente.
select *
from productos
order by precio;

/*
	##########################
	EJERCICIOS CON FUNCIÓN MAX()
	##########################
*/

-- Encuentra el precio máximo de un producto.
select max(precio) 'Precio máximo'
from productos;

-- Encuentra el monto total máximo de una venta.
select max(monto_total) 'Monto total máximo'
from ventas;

-- Encuentra el ID de cliente con el valor máximo.
select max(id) 'ID máximo'
from clientes;

/*
	##########################
	EJERCICIOS CON FUNCIÓN MIN()
	##########################
*/

-- Encuentra el precio mínimo de un producto.
select min(precio) 'Precio mínimo de producto'
from productos;

-- Encuentra el monto total mínimo de una venta.
select min(monto_total) 'Monto total mínimo'
from ventas;

-- Encuentra el ID de cliente con el valor mínimo.
select min(id) 'ID mínimo de cliente'
from clientes;

/*
	##########################
	EJERCICIOS CON FUNCIÓN  COUNT()
	##########################
*/

-- Cuenta cuántos clientes tienen la palabra "López" en su nombre.
select count(*) '# clientes con "López"'
from clientes
where nombre like '%López%';

-- Cuenta cuántas ventas fueron realizadas por el empleado con el id 9 .
select count(*) '# ventas de empleado con id 9'
from ventas
where empleado_id = 9;

-- Cuenta cuántos productos tienen un nombre que contiene la palabra "Digital".
select count(*) '# productos con la palabra "Digital"'
from productos
where nombre like '%Digital%';

/*
	##########################
	EJERCICIOS CON FUNCIÓN  SUM()
	##########################
*/

-- Calcula la suma de cantidades de productos vendidos por empleado.
select concat(e.nombre, ' ', e.apellido) 'Empleado', sum(cantidad) 'Total productos vendidos'
from ventas v, empleados e
where v.empleado_id = e.id
group by empleado_id;

-- Calcula la suma de salarios de empleados en el Departamento 1.
select sum(salario) 'Total salarios de empleados del Dpto. 1 (Ventas)' 
from empleados
where departamento_id = 1;

-- Calcula la suma de precios de productos vendidos al cliente con id 2.
select sum(precio_unitario) 'Suma de precios unitarios de productos vendidos al cliente con id 2'
from ventas
where cliente_id = 2;

/*
	##########################
	EJERCICIOS CON FUNCIÓN  AVG()
	##########################
*/

-- Calcula el precio promedio de productos con un precio superior a $200.
select avg(precio) 'Precio promedio de productos > $200'
from productos
where precio > 200;

-- Calcula el salario promedio de los empleados en el Departamento 1.
select avg(salario) 'Salario promedio de empleados del Dpto. 1 (Ventas)'
from empleados
where departamento_id = 1;

-- Calcula la cantidad promedio de productos vendidos por empleado.
select concat(e.nombre, ' ', e.apellido) 'Empleado', avg(cantidad) 'Cantidad promedio de productos vendidos'
from ventas v, empleados e
where e.id = v.empleado_id
group by empleado_id;

/*
	##########################
	EJERCICIOS CON FUNCIÓN  GROUP BY()
	##########################
*/

-- Agrupa las ventas por cliente y muestra el monto total gastado por cada cliente.
select c.nombre 'Cliente', sum(v.monto_total) 'Monto total gastado' 
from ventas v, clientes c
where v.cliente_id = c.id
group by c.id;

-- Encuentra el salario máximo por departamento.
select d.nombre 'Departamento', max(e.salario) 'Salario máximo'
from empleados e, departamentos d
where e.departamento_id = d.id
group by d.id;

-- Encuentra el salario mínimo por departamento.
select d.nombre 'Departamento', min(e.salario) 'Salario mínimo'
from empleados e, departamentos d
where e.departamento_id = d.id
group by d.id;
	
-- Obtén la suma total de salarios por departamento.
select d.nombre 'Departamento', sum(e.salario) 'Suma total de salarios'
from empleados e, departamentos d
where e.departamento_id = d.id
group by d.id;

-- Encuentra la cantidad total de productos vendidos por empleado.
select concat(e.nombre, ' ', e.apellido) 'Empleado', sum(v.cantidad) 'Cantidad total de productos vendidos'
from ventas v, empleados e
where v.empleado_id = e.id
group by e.id;

/*
	##########################
	EJERCICIOS CON FUNCIÓN  HAVING()
	##########################
*/

-- Encuentra los departamentos con al menos 2 empleados con una edad menor de 30 años.
select d.nombre 'Departamento con al menos 2 empleados menores a 30 años'
from departamentos d, empleados e
where d.id = e.departamento_id and e.edad < 30
group by d.id
having count(e.id) >= 2;

-- Muestra los clientes que han gastado más de $2,000 en total en compras.
select c.nombre 'Cliente que gastó más de $2000 en total', sum(v.monto_total) 'Gasto total'
from clientes c, ventas v 
where c.id = v.cliente_id
group by c.id
having sum(v.monto_total) > 2000;

/*
	##########################
	EJERCICIOS CON FUNCIÓN  AS()
	##########################
*/

-- Crea una consulta que muestre la edad de los empleados junto con la edad aumentada en 5 años y que esta nueva columna se llame “Edad en 5 años”.
select edad, (edad + 5) 'Edad en 5 años'
from empleados;

-- Muestra el monto total de ventas junto con el monto total aumentado en un 21%  y que esta nueva columna se llame “Precio + IVA”.
select monto_total, (monto_total * 1.21) 'Precio + IVA'
from ventas;

--  Crea una consulta que muestre el nombre del producto y su precio unitario precedido con el signo “$ ” y que esta nueva columna se llame “precio con formato”.
select nombre, concat('$', precio) 'Precio con formato'
from productos;

/*
	##########################
	EJERCICIOS CON FUNCIÓN  LIMIT()
	##########################
*/


-- Muestra los 5 clientes con los IDs más bajos.
select *
from clientes
order by id limit 5;

-- Muestra los 3 productos más vendidos.
select p.nombre 'Productos más vendidos', sum(v.cantidad) 'Cantidad total'
from productos p, ventas v 
where p.id = v.producto_id
group by p.id
order by sum(v.cantidad) desc
limit 3; 

-- Muestra los 5 empleados más jóvenes.
select concat(nombre, ' ', apellido) 'Empleado', edad 'Edad'
from empleados
order by edad
limit 5;

/*
	##########################
	EJERCICIOS CON FUNCIÓN  CASE()
	##########################
*/

-- Crea una consulta que muestre el nombre de los productos y los categorice como "Laptop" si el nombre contiene la palabra "Laptop", "Teléfono" si contiene la palabra "Teléfono", y "Otros" en otros casos.
select nombre,
	case
		when nombre like '%Laptop%' then 'Laptop'
        when nombre like '%Teléfono%' then 'Teléfono'
        else 'Otros'
	end 'Categoría de nombre'
from productos;

-- Crea una consulta que muestre el ID del producto y los clasifique en categorías según la cantidad total de ventas de cada producto en la tabla 'ventas'. Utilizando una instrucción 'CASE', establece las siguientes categorías: 

	-- 	Si la suma de la cantidad de ventas (SUM(cantidad)) es mayor o igual a 9, la categoría es 'Alto Volumen'. 

	-- 	Si la suma de la cantidad de ventas está entre 4 y 8 (inclusive), la categoría es 'Medio Volumen'.

	-- 	En otros casos, la categoría es 'Bajo Volumen'.

-- Recuerda agrupar por producto_id y mostrar el resultado en orden descendente por la suma de la cantidad de ventas.
select producto_id, sum(cantidad) 'Cantidad total de productos vendidos',
	case
		when sum(cantidad) >= 9 then 'Alto Volumen'
        when sum(cantidad) > 4 and sum(cantidad) <= 8 then 'Medio Volumen'
        else 'Bajo Volumen'
	end 'Categoria por cantidad vendida'
from ventas
group by producto_id
order by sum(cantidad) desc;

-- Crea una consulta que muestre el ID de la venta y los categorice como "Venta pequeña" si el monto total es menor que $500, "Venta mediana" si es mayor o igual a $500 y menor que $1500, y "Venta grande" en otros casos.
select id 'ID de venta',
	case
		when monto_total < 500 then 'Venta pequeña'
        when monto_total >= 500 and monto_total < 1500 then 'Venta mediana'
		else 'Venta grande'
	end 'Categoria de venta'
from ventas;

-- Crea una consulta que muestre el nombre de los clientes y los categorice como "Dirección larga" si la longitud de su dirección es mayor o igual a 30 caracteres, "Dirección mediana" si es mayor o igual a 20 y menor que 30 caracteres, y "Dirección corta" en otros casos.
select nombre 'Cliente', direccion,
	case
		when length(direccion) >= 30 then 'Dirección larga'
        when length(direccion) >= 20 and length(direccion) < 30 then 'Dirección mediana'
        else 'Dirección corta'
	end 'Categoría de dirección'
from clientes;

--  Crea una consulta que muestre el nombre de los empleados y los categorice como "Ventas" si pertenecen al departamento 1, "Recursos Humanos" si pertenecen al departamento 2, y "Contabilidad"  si pertenecen al departamento 3.
select concat(nombre, ' ', apellido) 'Empleado',
	case
		when departamento_id = 1 then 'Ventas'
        when departamento_id = 2 then 'Recursos Humanos'
        else 'Contabilidad'
	end 'Departamento'
from empleados;

-- Crea una consulta que muestre el nombre de los productos y los categorice de la siguiente manera:

	-- Si el nombre del producto está en la lista ('Laptop', 'Reloj de Pulsera Inteligente', 'Reproductor de Blu-ray', 'Auriculares Bluetooth', 'Smart TV 55 Pulgadas', 'Cámara Digital', 'Impresora', 'Tablet', 'Teléfono móvil') y el precio es mayor o igual a 1000, la categoría es 'Tecnología cara'.

	-- 	Si el nombre del producto está en la lista anterior y el precio está entre 500 y 999 (inclusive), la categoría es 'Tecnología gama media'.

	-- 	Si el nombre del producto está en la lista anterior y el precio es menor a 500, la categoría es 'Tecnología barata'.

	-- 	Si el precio es mayor o igual a 1000 y el nombre del producto no está en la lista, la categoría es 'Caro'.

	-- 	Si el precio está entre 500 y 999 (inclusive) y el nombre del producto no está en la lista, la categoría es 'Medio'.

	-- 	Si el precio es menor a 500 y el nombre del producto no está en la lista, la categoría es 'Barato'.
select nombre, precio,
	case
		when nombre in ('Laptop', 'Reloj de Pulsera Inteligente', 'Reproductor de Blu-ray', 'Auriculares Bluetooth', 'Smart TV 55 Pulgadas', 'Cámara Digital', 'Impresora', 'Tablet', 'Teléfono móvil') and precio >= 1000 then 'Tecnología cara'
        when nombre in ('Laptop', 'Reloj de Pulsera Inteligente', 'Reproductor de Blu-ray', 'Auriculares Bluetooth', 'Smart TV 55 Pulgadas', 'Cámara Digital', 'Impresora', 'Tablet', 'Teléfono móvil') and precio >= 500 and precio <= 999 then 'Tecnología gama media'
        when nombre in ('Laptop', 'Reloj de Pulsera Inteligente', 'Reproductor de Blu-ray', 'Auriculares Bluetooth', 'Smart TV 55 Pulgadas', 'Cámara Digital', 'Impresora', 'Tablet', 'Teléfono móvil') and precio < 500 then 'Tecnología barata'
        when precio >= 1000 and nombre not in ('Laptop', 'Reloj de Pulsera Inteligente', 'Reproductor de Blu-ray', 'Auriculares Bluetooth', 'Smart TV 55 Pulgadas', 'Cámara Digital', 'Impresora', 'Tablet', 'Teléfono móvil') then 'Caro'
        when precio >= 500 and precio <= 999 and nombre not in ('Laptop', 'Reloj de Pulsera Inteligente', 'Reproductor de Blu-ray', 'Auriculares Bluetooth', 'Smart TV 55 Pulgadas', 'Cámara Digital', 'Impresora', 'Tablet', 'Teléfono móvil') then 'Medio'
        else 'Barato'
	end 'Categoría de precio'
from productos;