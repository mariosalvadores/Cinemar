import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws SQLException {
	
	// Menu principal de ingreso
	
	Scanner teclado = new Scanner(System.in);
	int opcion =0;
	
	do {
		System.out.println("Sistema de reservas ---- CINEMAR");
		System.out.println("Selecciones una opcion");
		System.out.println("1 --> Ingresar");
		System.out.println("2 --> Registro");
		System.out.println("9 --> Salir");
		opcion = teclado.nextInt();
		
		switch (opcion)	{
			
			case 1:
				//Login de usuario
				System.out.print("Ingrese email: ");
				String email = teclado.next();
				System.out.print("Ingrese password: ");
				String password = teclado.next();
				Login login = new Login(email,password);
				Usuario user = login.ingresar();
				while(user!=null) {
					System.out.println(user.getTipousr());
					if(user.getTipousr() == 1) {
						
						System.out.println("Acceso a menu de administracion");
						Menuadmin nuevoadmin = new Menuadmin(user,null);
						nuevoadmin.mostrarmenu();
					}
						
						else
						System.out.println("Acceso a menu de usuarios");
						Menuuser nuevousuario = new Menuuser(user, null);
						nuevousuario.mostrarmenu();
				}
				break;
			
			case 2:
				//Registro de usario
				Registro registro = new Registro(0, null, null, null, null, 0, false, false);
				registro.cargardatos();
				break;
		
			case 9:
				System.out.println("Cinemar le da las gracias por su preferencia,"
						+ "lo esperamos pronto");
				System.exit(0);
				break;
			default:
				System.out.println("Opcion no valida !!");
				opcion = 0;
		}
		
	} while(opcion !=9 );
	}
}

