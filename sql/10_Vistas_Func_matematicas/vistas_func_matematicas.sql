use mi_bd;

/*
	##########################
	Ejercicios vistas y funciones matemáticas
	##########################
*/

-- Crea una tabla triangulos_rectangulos con dos columnas: longitud_lado_adyacente y longitud lado_opuesto, ambos de tipo INT.
create table if not exists triangulos_rectangulos (
	id int auto_increment primary key,
    longitud_lado_adyacente int,
    longitud_lado_opuesto int
);

-- Rellena la tabla triangulos_rectangulos con 10 filas con enteros aleatorios entre 1 y 100
insert into triangulos_rectangulos(longitud_lado_adyacente, longitud_lado_opuesto)
values
	(FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100)),
    (FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100)),
    (FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100)),
    (FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100)),
    (FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100)),
    (FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100)),
    (FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100)),
    (FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100)),
    (FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100)),
    (FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100))
;

-- Crea una vista donde agregues la columna “hipotenusa” calculándola a partir de los otros dos lados. Utiliza el teorema de Pitágoras para realizar el cálculo: Siendo el lado adyacente “A” y el opuesto “B” y la hipotenusa “C” la fórmula quedaría de la siguiente forma:
	-- C =A2+B2
create view view_triangulos_rectangulos as
select 
	longitud_lado_adyacente,
    longitud_lado_opuesto,
    sqrt(pow(longitud_lado_adyacente, 2), pow(longitud_lado_opuesto, 2)) hipotenusa
from triangulos_rectangulos;

-- CREATE VIEW view_triangulos_rectangulos AS 
-- SELECT longitud_lado_adyacente, longitud_lado_opuesto, SQRT(pow(longitud_lado_adyacente,2) + pow(longitud_lado_opuesto,2)) AS hipotenusa
-- FROM triangulos_rectangulos;

-- Reemplaza la vista y ahora agrégale dos columnas para calcular el ángulo α en radianes y grados. Aquí tienes dos fórmulas:
	-- En radianes: =arcsen(BC) =arccos(AC) = arctan(BA)  

create or replace view view_triangulos_rectangulos as
select 
	longitud_lado_adyacente,
	longitud_lado_opuesto, 
    SQRT(pow(longitud_lado_adyacente,2) + pow(longitud_lado_opuesto,2)) AS hipotenusa, 	  atan(longitud_lado_opuesto / longitud_lado_adyacente) as 'Angulo en radianes', 
    degrees(atan(longitud_lado_opuesto / longitud_lado_adyacente)) as 'Angulo en grados'
from triangulos_rectangulos;

select * from view_triangulos_rectangulos;

-- Reemplaza la vista y ahora agrégale dos columnas para calcular el ángulo β en radianes y grados. Aquí tienes dos fórmulas:
	-- En radianes: β =arccos(BC)=arcsen(AC) = arctan(AB)  
create or replace view view_triangulos_rectangulos as
select 
	longitud_lado_adyacente,
	longitud_lado_opuesto, 
    SQRT(pow(longitud_lado_adyacente,2) + pow(longitud_lado_opuesto,2)) AS hipotenusa, 	  atan(longitud_lado_opuesto / longitud_lado_adyacente) as 'Angulo en radianes (α)', 
    degrees(atan(longitud_lado_opuesto / longitud_lado_adyacente)) as 'Angulo en grados (α)',
    atan(longitud_lado_adyacente / longitud_lado_opuesto) as 'Angulo en radianes (β)', 
    degrees(atan(longitud_lado_adyacente / longitud_lado_opuesto)) as 'Angulo en grados (β)'
from triangulos_rectangulos;

-- Reemplaza la vista y ahora agrégale dos columnas para calcular el ángulo γ en radianes y grados. Como se trata de triángulos rectángulos, el ángulo es de 90°, pero aplica una fórmula de igual manera, usa la regla de que la suma de los ángulos de un triángulo suma 180°.
create or replace view view_triangulos_rectangulos as
select 
	*,
    SQRT(pow(longitud_lado_adyacente,2) + pow(longitud_lado_opuesto,2)) AS hipotenusa, 	  atan(longitud_lado_opuesto / longitud_lado_adyacente) as α_rad, 
    degrees(atan(longitud_lado_opuesto / longitud_lado_adyacente)) as α_grad,
    atan(longitud_lado_adyacente / longitud_lado_opuesto) as β_rad, 
    degrees(atan(longitud_lado_adyacente / longitud_lado_opuesto)) as β_grad,
	(pi() - (atan(longitud_lado_opuesto / longitud_lado_adyacente) + atan(longitud_lado_adyacente / longitud_lado_opuesto))) as g_rad,
    (180 - (degrees(atan(longitud_lado_opuesto / longitud_lado_adyacente)) + degrees(atan(longitud_lado_adyacente / longitud_lado_opuesto)))) as g_grad
from triangulos_rectangulos;

-- Crea una tabla triangulos_rectangulos_2 con dos columnas: angulo_alfa y una hipotenusa ambos de tipo INT.

-- Rellena la tabla triangulos_rectangulos_2 con 10 filas con enteros aleatorios entre 1 y 89 para angulo_alfa y enteros aleatorios entre 1 y 100 para la columna hipotenusa.

-- Crea una vista donde agregues la columna lado_adyacente donde calcules su longitud.

-- Agrega a la vista la columna lado_opuesto donde calcules su longitud.

-- Agrega a la vista la columna angulo_beta donde calcules su valor en grados.

-- Agrega a la vista la columna angulo_gamma donde calcules su valor en grados.

-- Redondea todos los valores con hasta dos números decimales.