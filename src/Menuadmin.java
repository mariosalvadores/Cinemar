import java.util.Scanner;

public class Menuadmin {
	private Usuario user;
	private Conexion conexion;
	public Menuadmin(Usuario user, Conexion conexion) {
		
		this.user = user;
		this.conexion = conexion;
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
	
	public void mostrarmenu() {
		
		Scanner teclado = new Scanner(System.in);
		int opcion =0;
		do {
			 System.out.println("Bienvenido/a "+this.user.getNombre());
			 System.out.println("Seleccione una opcion: ");
			 System.out.println("1 --> Crear una sala");
			 System.out.println("2 --> Modificar una sala");
			 System.out.println("3 --> Eliminar una sala");
			 System.out.println("3 --> Modificar un descuento");
			 System.out.println("3 --> Editar un usuario");
			 System.out.println("3 --> Ver reservas");
			 System.out.println("9 --> Menu anterior");
			 opcion = teclado.nextInt();
			 switch (opcion) {
			 case 1:
				 //Crear Sala
				 
				 break;
			 case 2:
				 //Modificar sala
				 
				 break;
			 case 3:
				 //Eliminar sala
				 
				 
				 break;
			 case 4:
				 //Editar un usuario
				 
				 
				 break;
			 case 5:
				 //Ver reservas
				 
				 
				 
				 
				 break;
			 default:
				 System.out.println("Opcion no valida !!");
				 opcion = 0;
				
				 
			 
			 
			 
			 
			 }
		
		
		
		
		
		
		
		
		} while(opcion!=9);
	}
}
