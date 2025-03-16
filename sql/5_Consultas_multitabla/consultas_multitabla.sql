use mi_bd;

/*
	##########################
	Ejercicios consultas multitabla  - Parte 1 
	##########################
*/

-- Une las tablas de empleados con departamentos y solo muestra las columnas nombre, apellido, edad, salario de empleados y la columna nombre de departamentos.
select e.nombre, e.apellido, e.edad, e.salario, d.nombre
from empleados e, departamentos d
where e.departamento_id = d.id;

-- Une las tablas ventas con la tabla empleados donde se muestren todas las columnas de ventas exceptuando la columna empleado_id y en su lugar muestres el nombre y apellido de la tabla empleados.
select v.id, v.producto_id, v.cliente_id, v.cantidad, v.precio_unitario, v.monto_total, concat(e.nombre, ' ', e.apellido) 'Empleado'
from ventas v, empleados e
where v.empleado_id = e.id;

-- Une las tablas ventas con la tabla productos donde se muestren todas las columnas de ventas exceptuando la columna producto_id y en su lugar muestres la columna nombre de la tabla productos.
select v.id, p.nombre 'Producto', v.cliente_id, v.cantidad, v.precio_unitario, v.monto_total, v.empleado_id
from ventas v, productos p
where v.producto_id = p.id;

-- Une las tablas ventas con la tabla clientes donde se muestren todas las columnas de ventas exceptuando la columna cliente_id y en su lugar muestres la columna nombre de la tabla clientes.
select v.id, v.producto_id, c.nombre 'Cliente', v.cantidad, v.precio_unitario, v.monto_total, v.empleado_id
from clientes c, ventas v
where c.id = v.cliente_id;

-- Une las tablas ventas con la tablas empleados y departamentos donde se muestren todas las columnas de ventas exceptuando la columna empleado_id y en su lugar muestres el nombre y apellido de la tabla empleados y además muestres la columna nombre de la tabla departamentos.
select v.id, v.producto_id, v.cliente_id, v.cantidad, v.precio_unitario, v.monto_total, concat(e.nombre, ' ', e.apellido) 'Empleado', d.nombre 'Departamento'
from ventas v, empleados e, departamentos d
where v.empleado_id = e.id and e.departamento_id = d.id;

-- Une las tablas ventas, empleados, productos y clientes donde se muestren las columnas de la tabla ventas reemplazando sus columnas de FOREIGN KEYs con las respectivas columnas de “nombre” de las otras tablas.
select v.id, p.nombre 'Producto', c.nombre 'Cliente' , v.cantidad, v.precio_unitario, v.monto_total, concat(e.nombre, ' ', e.apellido) 'Empleado' 
from ventas v, empleados e, productos p, clientes c
where v.empleado_id = e.id and v.producto_id = p.id and v.cliente_id = c.id;

-- Calcular el salario máximo de los empleados en cada departamento y mostrar el nombre del departamento junto con el salario máximo.
select d.nombre 'Departamento', max(e.salario) 'Salario máximo'
from empleados e, departamentos d
where e.departamento_id = d.id
group by d.id;

/*
	##########################
	Ejercicios consultas multitabla - Parte 2  
	##########################
*/

-- Calcular el monto total de ventas por departamento y mostrar el nombre del departamento junto con el monto total de ventas.
select d.nombre 'Departamento', sum(v.monto_total) 'Total de ventas'
from ventas v, empleados e, departamentos d
where v.empleado_id = e.id and e.departamento_id = d.id
group by d.id;

-- Encontrar el empleado más joven de cada departamento y mostrar el nombre del departamento junto con la edad del empleado más joven.
select d.nombre 'Departamento', min(e.edad) 'Edad del empleado más joven'
from empleados e, departamentos d
where e.departamento_id = d.id
group by d.id;




-- Calcular el volumen de productos vendidos por cada producto (por ejemplo, menos de 5 “bajo”, menos 8 “medio” y mayor o igual a 8 “alto”) y mostrar la categoría de volumen junto con la cantidad y el nombre del producto.
select p.nombre 'Producto', sum(v.cantidad) 'Cantidad total vendida',
	case
		when sum(v.cantidad) < 5 then 'Bajo'
        when sum(v.cantidad) < 8 then 'Medio'
        else 'Alto'
	end 'Categoría de cantidad total vendida'
from ventas v, productos p
where v.producto_id = p.id
group by p.id;

-- Encontrar el cliente que ha realizado el mayor monto total de compras y mostrar su nombre y el monto total.
select c.nombre 'Cliente', max(v.monto_total) 'Monto total'
from ventas v, clientes c
where v.cliente_id = c.id
group by c.id
order by max(v.monto_total) desc
limit 1;

-- Calcular el precio promedio de los productos vendidos por cada empleado y mostrar el nombre del empleado junto con el precio promedio de los productos que ha vendido.
select concat(e.nombre, ' ', e.apellido) 'Empleado', avg(v.precio_unitario) 'Precio promedio de productos vendidos'
from empleados e, ventas v
where v.empleado_id = e.id
group by e.id;

-- Encontrar el departamento con el salario mínimo más bajo entre los empleados y mostrar el nombre del departamento junto con el salario mínimo más bajo.
select d.nombre 'Departamento' , min(e.salario) 'Salario mínimo'
from empleados e, departamentos d
where e.departamento_id = d.id
group by d.id
order by min(e.salario)
limit 1;

-- Encuentra el departamento con el salario promedio más alto entre los empleados mayores de 30 años y muestra el nombre del departamento junto con el salario promedio. Limita los resultados a mostrar solo los departamentos con el salario promedio mayor a 3320.
select d.nombre 'Departamento', avg(e.salario) 'Salario promedio'
from empleados e, departamentos d
where e.departamento_id = d.id and e.edad > 30
group by d.id
having avg(e.salario) > 3320;

/*
	##########################
	Actividad: Ejercicios Complementarios 
	##########################
*/

-- Encontrar la cantidad de productos vendidos por cada empleado y mostrar el nombre del empleado junto con la cantidad de productos vendidos.
select concat(e.nombre, ' ', e.apellido) 'Empleado', sum(v.cantidad) 'Total de productos vendidos'
from ventas v, empleados e
where v.empleado_id = e.id
group by e.id;

-- Calcular el monto total de ventas por cada cliente y mostrar el nombre del cliente junto con el monto total de sus compras.
select c.nombre 'Cliente', sum(v.monto_total) 'Monto total comprado'
from ventas v, clientes c 
where v.cliente_id = c.id
group by c.id;

-- Encontrar el producto más caro vendido y mostrar su nombre y precio.
select p.nombre 'Producto', p.precio 'Precio'
from ventas v, productos p
where v.producto_id = p.id
group by p.id
order by p.precio desc
limit 1;

-- Calcular el salario promedio de los empleados en cada departamento y mostrar el nombre del departamento junto con el salario promedio.
select d.nombre 'Departamento', avg(e.salario) 'Salario promedio'
from empleados e, departamentos d
where e.departamento_id = d.id
group by d.id;

-- Encontrar la cantidad total de ventas realizadas por cada empleado y mostrar el nombre y apellido del empleado junto con la cantidad total de ventas.
select concat(e.nombre, ' ', e.apellido) 'Empleado', sum(v.monto_total) 'Cantidad total de ventas'
from ventas v, empleados e
where v.empleado_id = e.id
group by e.id;

-- Encuentra la cantidad de ventas realizadas por cada empleado y muestra el nombre y apellido del empleado junto con la cantidad total de ventas. Limita los resultados a mostrar solo a los empleados que hayan realizado más de 5 ventas y ordenarlos de forma descendente con respecto a la cantidad de ventas.
select concat(e.nombre, ' ', e.apellido) 'Empleado', count(*) 'Total de ventas'
from ventas v, empleados e
where v.empleado_id = e.id
group by e.id
having count(*) > 5
order by count(*) desc;

-- Calcula el monto total vendido por cada empleado y muestra el nombre del empleado junto con el monto total. Usa la cláusula HAVING para filtrar a aquellos empleados que hayan vendido más de 10 productos en total. Muestra el resultado en orden descendente según el monto total vendido.
select concat(e.nombre, ' ', e.apellido) 'Empleado', sum(v.monto_total) 'Monto total vendido'
from ventas v, empleados e
where v.empleado_id = e.id
group by e.id
having sum(v.cantidad) > 10
order by sum(v.monto_total) desc;

-- Encuentra el monto total vendido a cada cliente y muestra el nombre del cliente junto con el monto total. Usa la cláusula HAVING para filtrar a aquellos clientes cuyo monto total promedio en sus compras sea superior a $1500. Muestra el resultado en orden descendente según el monto total vendido.
select c.nombre 'Cliente', sum(v.monto_total) 'Monto total comprado'
from ventas v, clientes c
where v.cliente_id = c.id
group by c.id
having avg(v.monto_total) > 1500
order by sum(v.monto_total) desc;

-- Calcula la cantidad total de ventas realizadas a cada cliente y muestra el nombre del cliente junto con la cantidad total de ventas. Limita los resultados a mostrar solo a los clientes que hayan realizado más de 3 ventas ordénalos de forma descendente según la cantidad de ventas.
select c.nombre 'Cliente', count(*) 'Total de ventas realizadas'
from ventas v, clientes c
where v.cliente_id = c.id
group by c.id
having count(*) > 3
order by count(*) desc;

-- Encuentra los productos más caros vendidos (precio mayor a 1000), muestra su nombre y precio y ordenarlos de forma descendente por precio.
select p.nombre 'Producto', p.precio 'Precio'
from ventas v, productos p
where v.producto_id = p.id and p.precio > 1000
group by p.id
order by p.precio desc;