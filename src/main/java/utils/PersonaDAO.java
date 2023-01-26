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
				Persona p = new Persona();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setCognome(rs.getString("cognome"));
				p.setEta(rs.getInt("eta"));
				ls.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("111");
		return ls;
	}
	
	
	public static void cancella(int ID) {
		Connection conn = Connessione.getConnessione();
		
		try {
			PreparedStatement sql = conn.prepareStatement("DELETE FROM `persona` WHERE id=?");
			sql.setInt(1, ID);
		
			System.out.print("yoo");
			sql.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
	public static void modifica(Persona p) {
		Connection conn = Connessione.getConnessione();
		try {
			PreparedStatement sql = conn.prepareStatement("UPDATE `persona` SET	nome=?,cognome=?,eta=? WHERE id=?");
			sql.setString(1, p.getNome());
			sql.setString(2, p.getCognome());
			sql.setInt(3, p.getEta());
			sql.setInt(4, p.getId());
		
			System.out.print("yoo");
			sql.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
