import java.util.Scanner;
import java.sql.SQLException;

/*
 * Registro de usuarios
 * 
 */

public class Registro {

	private int id_user;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private int tipouser;
	private boolean tarjetauser;
	private boolean estadouser;
	
	public Registro (int id_user, String nombre, String apellido, String email, String password, int tipouser,
			boolean tarjetauser, boolean estadouser) {
		
		this.id_user = id_user;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.tipouser = tipouser;
		this.tarjetauser = tarjetauser;
		this.estadouser = estadouser;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTipouser() {
		return tipouser;
	}
	public void setTipouser(int tipouser) {
		this.tipouser = tipouser;
	}
	public boolean isTarjetauser() {
		return tarjetauser;
	}
	public void setTarjetauser(boolean tarjetauser) {
		this.tarjetauser = tarjetauser;
	}
	public boolean isEstadouser() {
		return estadouser;
	}
	public void setEstadouser(boolean estadouser) {
		this.estadouser = estadouser;
	}
	
	public void cargardatos () throws SQLException {
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese Nombre: ");
		this.nombre = teclado.next();
		
		System.out.println("Ingrese Apellido: ");
		this.apellido = teclado.next();

		System.out.println("Ingrese email: ");
		this.email = teclado.next();
		
/*		Checkemail checkemail = new Checkemail(this.email);
		boolean flemail = true;
		do {
			
			if (checkemail.sintaxemail() && checkemail.sintaxemail()) flemail = false;

		}
		while (flemail);*/
		
		
		
		System.out.println("Ingrese Contraseña: ");
		this.password = teclado.next();
		
		this.tipouser =1;
		this.tarjetauser = false;
		this.estadouser = true;
		
		String consulta;
		consulta = "insert into usuario values (null,"+"'"+this.nombre+"','"+this.apellido+"','"+
				this.email+"','"+this.password+"',2,false,true)";
		Conexion conexion = new Conexion();
		conexion.realizaConsulta(consulta);
		
				
	}
	
}
