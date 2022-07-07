import java.sql.SQLException;
import java.util.Scanner;

public class testregistro {

	public static void main(String[] args) throws SQLException {
		//String email="";
		Scanner teclado = new Scanner(System.in);
		/*Checkemail checkemail = new Checkemail(email);
		
		do {
			System.out.println("Ingrese email: ");
			email = teclado.nextLine();
		
			checkemail = new Checkemail(email);
				
			}
		while (! checkemail.sintaxemail());
		checkemail.existemail();
	}*/
		Registro registro = new Registro(0, null, null, null, null, 0, false, false);
		registro.cargardatos();
	}
}