/*
	##########################
	Actividades: Consultas base de datos
	##########################
*/

-- Mostrar el nombre y peso de los diez jugadores que sean pivots (‘C’) y que pesen más de 200 libras, ordenados por peso.
select Nombre, Peso
from jugadores
where Posicion like '%C%' and Peso > 200
order by Peso desc
limit 10;

-- Mostrar el nombre de los equipos del este (East).
select Nombre 'Equipos Conferencia Este'
from equipos
where Conferencia = 'East';

-- Mostrar los equipos donde su ciudad empieza con la letra ‘c’, ordenados por nombre.
select *
from equipos
where Ciudad like 'c%'
order by Nombre;

-- Mostrar los puntos por partido del jugador ‘Pau Gasol’ en la temporada ’04/05′.
select j.Nombre 'Jugador', e.Puntos_por_partido 'Puntos por partido'
from jugadores j
left join estadisticas e
	on j.codigo = e.jugador
where j.Nombre = 'Pau Gasol' and e.temporada = '04/05';

-- Mostrar los diez jugadores con más puntos en toda su carrera con un redondeo de dos decimales.
select j.Nombre 'Jugador', round(sum(e.Puntos_por_partido), 2) 'Total puntos anotados'
from jugadores j 
left join estadisticas e
	on j.codigo = e.jugador
group by j.codigo
order by sum(e.Puntos_por_partido) desc
limit 10;

-- Mostrar el nombre del equipo, conferencia y división del jugador más alto de la NBA.
select e.Nombre 'Equipo', e.Conferencia 'Conferencia', e.Division 'Division', j.Nombre 'Jugador', j.Altura 'Altura'
from jugadores j
left join equipos e
	on j.Nombre_equipo = e.Nombre
group by j.codigo
order by j.Altura desc
limit 1

-- Mostrar los 10 partidos (equipo_local, equipo_visitante y diferencia) con mayor diferencia de puntos.

-- Muestra el nombre del equipo con la mayor diferencia de puntos totales de la temporada temporada "00/01".

-- Encuentra el nombre de los diez equipos que mejor porcentaje de victorias tengan en la temporada "98/99". El número de porcentaje debe estar escrito del 1 al 100 con hasta dos decimales y acompañado por el símbolo “%”.

-- Calcula el promedio de puntos por partido de los jugadores que son pivotes ('C') y tienen más de 7 pies de altura, y redondea el resultado a dos decimales.

-- Muestra el nombre del jugador que ha registrado el mayor número de asistencias en un solo partido.

-- Encuentra el total de partidos en los que el equipo local anotó más de 100 puntos y el equipo visitante anotó menos de 90 puntos.

-- Calcula la diferencia de puntos promedio en todos los partidos de la temporada “00/01” y redondea el resultado a dos decimales.

-- Encuentra el nombre del equipo que ha tenido al menos un jugador que ha promediado más de 10 rebotes por partido en la temporada “97/98”.