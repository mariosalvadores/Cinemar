USE	 Cinemar;

/*Datos tabla Usuarios*/
INSERT INTO usuario VALUES
	(null,"admin","admin","admin@gmail.com",1234,1,false,true);
INSERT INTO usuario VALUES
	(null,"Pedro","Alvares","pedroalvarez@gmail.com",1234,2,true,true);
INSERT INTO usuario VALUES
	(null,"Marta","Sanchez","martasanchez@gmail.com",1234,2,true,true);
 INSERT INTO usuario VALUES
	(null,"pppp","pepe","p@p.com",1234,2,false,true);


/*Datos Peliculas*/
INSERT INTO pelicula VALUES
	(null,"La fuga del paralitico",1,1,"Se piro el rengo ...","01:30:00","14:00:00",true,30);
INSERT INTO pelicula VALUES
	(null,"La cuadratura del circulo",1,1,"Vayuno a saber","01:10:00","16:00:00",true,30);
INSERT INTO pelicula VALUES
	(null,"Quisi io",1,1,"Guena peli","01:45:00","18:00:00",true,30);

/*Datos Sala*/
INSERT INTO sala VALUES
	(null,null,false,"Sala 1",true);
INSERT INTO sala VALUES
	(null,null,false,"Sala 2",true);
INSERT INTO sala VALUES
	(null,null,true,"Sala 3",false);

/*Datos Descuento*/
INSERT INTO descuento VALUES
	(null,null,15);
INSERT INTO descuento VALUES
	(null,null,20);
INSERT INTO descuento VALUES
	(null,null,25);
    




    