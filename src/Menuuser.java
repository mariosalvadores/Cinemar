import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Scanner;

/*
 * Menu de opciones para el Usuario
 *   
 */
public class Menuuser {
	private Usuario user;
	private Conexion conexion;
	
	public Menuuser(Usuario user, Conexion conexion) {
		
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

	public void mostrarmenu () throws SQLException {
		
		Scanner teclado = new Scanner(System.in);
		int opcion =0;
		do {
			 System.out.println("Bienvenido/a "+this.user.getNombre());
			 System.out.println("Seleccione una opcion: ");
			 System.out.println("1 --> Nueva reserva");
			 System.out.println("2 --> Ver reservas");
			 System.out.println("3 --> Historial de reservas");
			 System.out.println("9 --> Salir");
			 opcion = teclado.nextInt();
		 
			 switch (opcion) {
			 	
			 	case 1:
			 		// Mostrar peliculas
			 		
			 		System.out.println("Seleccione una pelicula para reservar");
			 		String sql = "select id_pelicula,titulo_pelicula,resumen_pelicula"
			 				+ ",horario_pelicula from pelicula";
			 		ResultSet rs = conexion.devuelveConsulta(sql);
					
					while(rs.next()) {

						int id_pelicula = rs.getInt("id_pelicula");
						String titulo = rs.getString("titulo_pelicula");
						String resumen = rs.getString("resumen_pelicula");
						String horario = rs.getString("horario_pelicula");
						
						
						System.out.println("ID: "+id_pelicula+"--> Titulo: "+
								titulo+"\r\nResumen: "+resumen+
								"\r\nHorario: "+horario);
						}
					//Menu seleccionar pelicula
					
					System.out.print("Seleccione una pelicula: ");
					int id_peli = teclado.nextInt();
					sql = "select butacas_pelicula from pelicula where id_pelicula = '"+id_peli+"'";
					rs = conexion.devuelveConsulta(sql);
					rs.next();
					int cantbutacas= rs.getInt("butacas_pelicula");
					System.out.println("Cantidad de butacas disponibles: "+cantbutacas);
					System.out.print("Ingrese la cantidad de butcas a reservar: ");
					int selcantbutacas = teclado.nextInt();
					cantbutacas = cantbutacas - selcantbutacas;
					sql ="UPDATE pelicula SET butacas_pelicula = '"+cantbutacas+"' WHERE id_pelicula = '"+id_peli+"'";
					conexion.realizaConsulta(sql);
					sql ="INSERT INTO reserva VALUES (null,1,"+id_peli+","+this.user.getId_usuario()+","+selcantbutacas+")";
					// puse fijo sala 1 recordar modificar esto
					conexion.realizaConsulta(sql);
					
					
					break;
				
			 	case 2: 
			 		//Ver reserva
			 		System.out.println("");
			 	
			 		
			 		break;
			 		
			 	case 3:
			 		//Historial reservas
			 		
			 		System.out.println("Historial de reservas");
			 		sql = "select titulo_pelicula,horario_pelicula,cant_butacas,reserva.id_sala from reserva "
							+ "join pelicula on reserva.id_pelicula = pelicula.id_pelicula "
							+ "where reserva.id_usuario ="+this.user.getId_usuario();
			 		rs = conexion.devuelveConsulta(sql);
					while(rs.next()) 
						System.out.println("--> "+rs.getString("titulo_pelicula")+" --> "+rs.getString("horario_pelicula")
								+" --> "+rs.getInt("cant_butacas")+" --> "+rs.getInt("id_sala"));
			 		
			 		
			 		break;
			 	case 9:
			 		System.out.println("Cinemar le da las gracias por su preferencia,"
							+ " lo esperamos pronto");
			 		System.exit(0);
			 		
				default:
					System.out.println("Opcion no valida !!");
					opcion = 0;
					
					
			 } 
		 	 
		}while(opcion !=9);
		
		
	}





}
