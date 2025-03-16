use mi_bd;

/*
	##########################
	Ejercicios JOIN Parte 1
	##########################
*/

-- Encuentra el nombre y apellido de los empleados junto con la cantidad total de ventas que han realizado.
select concat(e.nombre, ' ', e.apellido) 'Empleado', ifnull(sum(v.cantidad), 0) 'Cantidad total de ventas'
from empleados e
left join ventas v
on e.id = v.empleado_id
group by e.id;

-- Calcula el monto total vendido a cada cliente y muestra el nombre del cliente, su dirección y el monto total.
select c.nombre 'Cliente', c.direccion 'Dirección', ifnull(sum(v.monto_total), 0)  'Monto total comprado'
from clientes c
left join ventas v
on c.id = v.cliente_id
group by c.id;

-- Encuentra los productos vendidos por cada empleado en el departamento de "Ventas" y muestra el nombre del empleado junto con el nombre de los productos que han vendido.
select distinct concat(e.nombre, ' ' , e.apellido) 'Empleado de Ventas', ifnull(p.nombre, '(Sin venta)') 'Producto vendido'
from empleados e
left join ventas v
	on e.id = v.empleado_id
left join productos p
	on v.producto_id = p.id
left join departamentos d
 	on e.departamento_id = d.id where d.nombre = 'Ventas';

-- Encuentra el nombre del cliente, el nombre del producto y la cantidad comprada de productos con un precio superior a $500.
select c.nombre 'Cliente', p.nombre 'Producto', sum(v.cantidad) 'Cantidad'
from clientes c
left join ventas v
	on c.id = v.cliente_id
left join productos p
	on p.id = v.producto_id where p.precio > 500
group by c.id, p.id;
	
/*
	##########################
	Ejercicios JOIN Parte 2
	##########################
*/

-- Calcula la cantidad de ventas por departamento, incluso si el departamento no tiene ventas.
select d.nombre 'Departamento', count(v.id) 'Cantidad de ventas'
from departamentos d
left join empleados	e
	on d.id = e.departamento_id
left join ventas v
	on e.id = v.empleado_id
group by d.id;

-- Encuentra el nombre y la dirección de los clientes que han comprado más de 3 productos distintos y muestra la cantidad de productos comprados.
select c.nombre 'Cliente', c.direccion 'Dirección', count(distinct v.producto_id) 'Cantidad de Productos distintos comprados'
from clientes c
left join ventas v
	on c.id = v.cliente_id
group by c.id
having count(distinct v.producto_id) > 3;

-- Calcula el monto total de ventas realizadas por cada departamento y muestra el nombre del departamento junto con el monto total de ventas.
select d.nombre 'Deparmento', ifnull(sum(v.monto_total), 0) 'Monto total de ventas'
from departamentos d
left join empleados e
	on d.id = e.departamento_id
left join ventas v
	on e.id = v.empleado_id
group by d.id;
	

/*
	##########################
	Actividad: Ejercicios Complementarios
	##########################
*/

-- Muestra el nombre y apellido de los empleados que pertenecen al departamento de "Recursos Humanos" y han realizado más de 5 ventas.


-- Muestra el nombre y apellido de todos los empleados junto con la cantidad total de ventas que han realizado, incluso si no han realizado ventas.

-- Encuentra el empleado más joven de cada departamento y muestra el nombre del departamento junto con el nombre y la edad del empleado más joven.

-- Calcula el volumen de productos vendidos por cada producto (por ejemplo, menos de 5 como "bajo", entre 5 y 10 como "medio", y más de 10 como "alto") y muestra la categoría de volumen junto con la cantidad y el nombre del producto.