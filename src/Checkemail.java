import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
 * Check email para verificar si exsiste y si esta correctamente 
 * ingresado
 *  
 */

public class Checkemail {
	private String email;

	public Checkemail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean existemail () throws SQLException {
		boolean exem = false;
		
		Conexion conexion =  new Conexion();
		
		String consulta = "select * from usuario where email_usuario = "+"'"+this.email+"'";
		ResultSet rs = conexion.devuelveConsulta(consulta);
		System.out.println(rs.getString("nombre_usuario"));
		if (rs == null) 
			exem=true;
		else	
			System.out.println("--> el email ya existe ingrese uno diferente !!");
			
		return exem;
	}
	
	public boolean sintaxemail() {
		Scanner teclado = new Scanner(System.in);
		boolean flsintax = false;
		do {
			Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])"
				+ "+[a-zA-Z]{2,6}$");
			Matcher matcher = pattern.matcher(email);
			System.out.println("-- > email invalido !!");
			System.out.println("Ingrese email: ");
			this.email = teclado.next();
			flsintax = matcher.matches();
		}
		while (!flsintax);
		return flsintax;
		
	}

}
