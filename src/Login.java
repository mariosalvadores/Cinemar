import java.sql.ResultSet;
import java.sql.SQLException;

/* Login de usuarios
 * 
 * */

public class Login {
	private String email;
	private String password;
	
	public Login(String email, String password) {
		
		this.email = email;
		this.password = password;
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
	
	public Usuario ingresar() throws SQLException {
		
		Usuario user = null;
		Conexion conexion =  new Conexion();
		
		String consulta = "select * from usuario where email_usuario = "+"'"+this.email
				+"'"+" and password_usuario = "+"'"+this.password+"'";
		ResultSet rs = conexion.devuelveConsulta(consulta);
		
		while(rs.next()) {
			System.out.println("Ingreso exitoso!");
			
			int id_user = rs.getInt("id_usuario");
			String nombre = rs.getString("nombre_usuario");
			String apellido = rs.getString("apellido_usuario");
			String email = rs.getString("email_usuario");
			String passuser = rs.getString("password_usuario");
			int tipouser = rs.getInt("tipo_usuario");
			Boolean tarjetauser = rs.getBoolean("tarjeta_usuario");
			Boolean estadouser = rs.getBoolean("estado_usuario");
			user = new Usuario(id_user,nombre,apellido,email,passuser,tipouser,tarjetauser,estadouser);
			//System.out.println("Bienvenido/a : "+nombre);
			return user;
					
		}
		System.out.println("No existe el usuario !!");
		return user;
	}
	
}
