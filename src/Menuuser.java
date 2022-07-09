import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Scanner;

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
			 System.out.println("9 --> Menu anterior");
			 opcion = teclado.nextInt();
		 
			 switch (opcion) {
			 	
			 	case 1:
			 		// Mostrar peliculas
			 		System.out.println("Seleccione una pelicula para reservar");
			 		String sql = "select id_pelicula,titulo_pelicula, resumen_pelicula from pelicula";
			 		ResultSet rs = conexion.devuelveConsulta(sql);
					
					while(rs.next()) {

						int id_pelicula = rs.getInt("id_pelicula");
						String titulo = rs.getString("titulo_pelicula");
						String resumen = rs.getString("resumen_pelicula");
						//Time horario = rs.getTime("horario_pelicula");
						
						
						System.out.println("ID: "+id_pelicula+"--> Titulo: "+
								titulo+"\r\nResumen: "+resumen+
								"\r\nHorario: ");
						}
					
					break;
				
			 	case 2: 
			 		//Nueva reserva
			 	
			 		
			 		break;
			 		
			 	case 3:
			 		//Historial reservas
			 		
			 		
			 		break;
			 		
				default:
					System.out.println("Opcion no valida !!");
					opcion = 0;
					
					
			 } 
		 	 
		}while(opcion !=9);
		
		
	}





}
