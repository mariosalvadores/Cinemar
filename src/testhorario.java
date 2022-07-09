import java.sql.ResultSet;
import java.sql.SQLException;

public class testhorario {

	public static void main(String[] args) throws SQLException {
		
		Conexion conexion = new Conexion();
		String sql= "select id_pelicula,titulo_pelicula, resumen_pelicula from pelicula";
		ResultSet rs = conexion.devuelveConsulta(sql);
		String titulo = rs.getString("titulo_pelicula");
		System.out.println(titulo);
		
		
	}

}
