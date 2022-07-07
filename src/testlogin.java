import java.sql.SQLException;

public class testlogin {

	public static void main(String[] args) throws SQLException {
	
		Login login = new Login("admin@gmail.com","1234");
		Usuario user = login.ingresar();

	}

}
