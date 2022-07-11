import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * Menu de opciones para el Administrador
 * 
 */
public class Menuadmin {
	private Usuario user;
	private Conexion conexion;
	
	public Menuadmin(Usuario user, Conexion conexion) {
		
		this.user = user;
		this.conexion = new Conexion();
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public Conexion getConexion() {
		return conexion;
	}
	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
	
	public void mostrarmenu() throws SQLException {
		
		Scanner teclado = new Scanner(System.in);
		String sql;
		String nombresala;
		int tiposala;
		int estadosala;
		int idsala;
		int iddescuento;
		int porcentajedto;
		
		int opcion =0;
		do {
			 System.out.println("Bienvenido/a "+this.user.getNombre());
			 System.out.println("Seleccione una opcion: ");
			 System.out.println("1 --> Crear una sala");
			 System.out.println("2 --> Modificar una sala");
			 System.out.println("3 --> Eliminar una sala");
			 System.out.println("4 --> Modificar un descuento");
			 System.out.println("5 --> Ver todas las reservas");
			 System.out.println("6 --> Ver reservas de un cliente");
			 System.out.println("9 --> Salir");
			 opcion = teclado.nextInt();
			 switch (opcion) {
			 case 1:
				 //Crear Sala 
				 System.out.print("Ingrese nuevo nombre de la sala: ");
				 nombresala = teclado.next();
				 System.out.print("Ingrese nuevo tipo de sala (0-> 2D, 1-> 3D: ");
				 tiposala = teclado.nextInt();
				 System.out.print("Ingrese nuevo estado de sala (0-> inactiva, 1-> activa: ");
				 estadosala = teclado.nextInt();
				 sql= "insert into sala values(null,null,"+tiposala+",'"+nombresala+"',"+estadosala+")";
				 conexion.realizaConsulta(sql);
				 
				 break;
			 case 2:
				 //Modificar sala 
				 
				 System.out.print("Ingrese ID sala a modificar: ");
				 idsala = teclado.nextInt();
				 sql = "select * from sala where id_sala = "+idsala;
				 ResultSet rs = conexion.devuelveConsulta(sql);
				 while(rs.next()) {
					 System.out.print("ID --> "+rs.getInt("id_sala")+" Nombre --> "+rs.getString("nombre_sala")+" Tipo --> "+
						rs.getInt("tipo_sala")+" Estado --> ");
					 if (rs.getBoolean("estado_sala"))
						 System.out.println("Activa");
					 else
						 System.out.println("Inactiva");
				 }
				 System.out.print("Ingrese nuevo nombre de la sala: ");
				 nombresala = teclado.next();
				 System.out.print("Ingrese nuevo tipo de sala (0-> 2D, 1-> 3D: ");
				 tiposala = teclado.nextInt();
				 System.out.print("Ingrese nuevo estado de sala (0-> inactiva, 1-> activa: ");
				 estadosala = teclado.nextInt();
				 sql= "update sala set nombre_sala = '"+nombresala+"' , tipo_sala = '"
						 +tiposala+"', estado_sala = "+estadosala;
				 conexion.realizaConsulta(sql);
				 
				 
				 
				 break;
			 case 3:
				 //Eliminar sala 
				 
				 System.out.println("Listado de salas");
				 sql = "select id_sala,nombre_sala,tipo_sala,estado_sala from sala";
				 rs = conexion.devuelveConsulta(sql);
				 while(rs.next()) {
					 System.out.println("ID --> "+rs.getInt("id_sala")+" Nombre --> "+rs.getString("nombre_sala")+" Tipo --> "+
						rs.getInt("tipo_sala")+" Estado --> ");
					 if (rs.getBoolean("estado_sala"))
						 System.out.println("Activa");
					 else
						 System.out.println("Inactiva");
				 }
				 System.out.print("Ingrese ID sala a eliminar: ");
				 idsala = teclado.nextInt();
				 sql = "delete from sala where id_sala = "+idsala;
				 conexion.realizaConsulta(sql);
				 
				 
				 
				 break;
			 
				 
				 
			 case 4:
				 //Modificar un descuento
				 
				 System.out.println("Listado de descuentos");
				 sql = "select id_descuento,porcentaje_descuento from descuento";
				 rs = conexion.devuelveConsulta(sql);
				 while(rs.next()) {
					 System.out.println("ID --> "+rs.getInt("id_descuento")+" Porcentaje --> "+rs.getInt("porcentaje_descuento")+"%");
					
				 }
				 
				 System.out.print("Ingrese ID de descuento a modificar: ");
				 iddescuento= teclado.nextInt();
				 System.out.print("Ingrese el porcentaje de descuento: ");
				 porcentajedto = teclado.nextInt();
				 sql = "update descuento set porcentaje_descuento = "+porcentajedto+" where id_descuento = "+iddescuento;
				 conexion.realizaConsulta(sql);
				 
				 
				 
				 break;
			 case 5:
				 //Ver todas las reservas
				 System.out.println("Historial de reservas");
			 	 sql = "select titulo_pelicula,horario_pelicula,cant_butacas,reserva.id_usuario,reserva.id_sala from reserva "
							+ "join pelicula on reserva.id_pelicula = pelicula.id_pelicula ";
			 	 rs = conexion.devuelveConsulta(sql);
				 while(rs.next()) {
					 
				 
					 System.out.println("--> "+rs.getString("titulo_pelicula")+" --> "+rs.getString("horario_pelicula")
				 		+" --> "+rs.getInt("cant_butacas")+" --> "+rs.getInt("id_usuario")+" --> "+rs.getInt("id_sala"));
				 }
				 
				 
				 break;
			 case 6:
				 //Ver reservas de un cliente
				 
				 System.out.print("ingrese ID del cliente");
				 int idcliente = teclado.nextInt();
			 	 sql = "select titulo_pelicula,horario_pelicula,cant_butacas,reserva.id_sala from reserva "
							+ "join pelicula on reserva.id_pelicula = pelicula.id_pelicula "
							+ "where reserva.id_usuario = "+idcliente;
			 	 rs = conexion.devuelveConsulta(sql);
				 while(rs.next()) {
					 
				 
					 System.out.println("--> "+rs.getString("titulo_pelicula")+" --> "+rs.getString("horario_pelicula")
				 		+" --> "+rs.getInt("cant_butacas")+" --> "+rs.getInt("id_sala"));
				 }
				 
				 
				 break;
			 case 9:
				 System.out.println("Cinemar le da las gracias por su preferencia,"
							+ " lo esperamos pronto");
				 System.exit(0);
				 break;
				 default:
					 System.out.println("Opcion no valida !!");
					 opcion = 0;

			 
			 }

		} while(opcion!=9);
		return;
	}
}
