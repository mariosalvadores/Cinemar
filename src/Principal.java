import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws SQLException {
	// Flujo Principal del programa
		
	// Menu principal de ingreso
	
	Scanner teclado = new Scanner(System.in);
	System.out.println("Sistema de reservas ---- CINEMAR");
	System.out.println("Selecciones una opcion");
	System.out.println("1 --> Ingresar");
	System.out.println("2 --> Registro");
	System.out.println("9 --> Salir");
	int opcion = teclado.nextInt();
	
	switch (opcion)
	
	{
		
		case 1:
			//Login de usuario
			System.out.println("Ingrese email: ");
			String email = teclado.next();
			System.out.println("Ingrese password: ");
			String password = teclado.next();
			Login login = new Login(email,password);
			Usuario user = login.ingresar();
			while(user!=null) {
				
				if(user.getTipousr() == 1)
					System.out.println("Acceso a menu de administracion");
					else
						System.out.println("Acceso a menu de usuarios");
			}
			break;
			
		case 2:
			//Registro de usario
			Registro registro = new Registro(0, null, null, null, null, 0, false, false);
			registro.cargardatos();
			break;
			
		case 9:
			break;
	}
		

	}
}

