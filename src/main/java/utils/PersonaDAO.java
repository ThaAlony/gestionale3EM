package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Persona;

public class PersonaDAO {
	
	
	public static void inserisci(Persona p) {
		try {
			Connection conn = Connessione.getConnessione();
			PreparedStatement sql = conn.prepareStatement("INSERT INTO `persona`(`nome`, `cognome`, `eta`) VALUES (?,?,?)");
			sql.setString(1, p.getNome());
			sql.setString(2, p.getCognome());
			sql.setInt(3, p.getEta());
			
			sql.executeUpdate();
			
			System.out.print("yo yo yo yoooo");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<Persona> getUtenti() {
		Connection conn = Connessione.getConnessione();
		
		List<Persona> ls = new ArrayList<>();
		try {
			ResultSet rs =  conn.createStatement().executeQuery("SELECT * FROM `persona` WHERE 1");
			while(rs.next()) {
				Persona p = new Persona(rs.getString("nome"), rs.getString("cognome"), rs.getInt("eta"));
				ls.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ls;
	}
	
	
	public static void cancella() {
		
	}
}
