package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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
			PreparedStatement sql = conn.prepareStatement("UPDATE `persona` SET	nome=?,cognome=?,eta=?,id=? WHERE id=?");
			sql.setString(1, p.getNome());
			sql.setString(2, p.getCognome());
			sql.setInt(3, p.getEta());
			sql.setInt(4, p.getId());
			sql.setInt(5, p.getId());
		
			System.out.print("y0y0");
			sql.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static List<Persona> cerca(Integer id, String nome, String cognome, Integer eta) {
			
		List<Persona> ls = new ArrayList<>();
		
		Connection conn = Connessione.getConnessione();
		if(id != null) {
			ls = PersonaDAO.getByID(id);
			
			if (nome != "") {
				ls = PersonaDAO.getByNome(nome, ls);
				
				if (cognome != "") {
					ls = PersonaDAO.getByCognome(cognome, ls);
					
					if (eta != null) {
						ls = PersonaDAO.getByEta(eta, ls);
					}
				} else if (eta != null) {
					ls = PersonaDAO.getByEta(eta, ls);
				}
				
			} else if (cognome != "") {
				ls = PersonaDAO.getByCognome(cognome, ls);
				
				if (eta != null) {
					ls = PersonaDAO.getByEta(eta, ls);
				}
				
			} else if (eta != null) {
				ls = PersonaDAO.getByEta(eta, ls);
			}
			
			
		} else if (nome != "") {
			ls = PersonaDAO.getByNome(nome);
			
			if (cognome != "") {
				ls = PersonaDAO.getByCognome(cognome, ls);
				
				if (eta != null) {
					ls = PersonaDAO.getByEta(eta, ls);
				}
			} else if (eta != null) {
				ls = PersonaDAO.getByEta(eta, ls);
			}
			
		} else if (cognome != "") {
			ls = PersonaDAO.getByCognome(cognome);
			
			if (eta != null) {
				
				ls = PersonaDAO.getByEta(eta, ls);
			}
			
		} else if (eta != null) {
			ls = PersonaDAO.getByEta(eta);
		} else {
			ls = PersonaDAO.getUtenti();
			}
		
		System.out.print("\nLISTA FINALE: " + ls);
		return ls;
	}
	
	public static List<Persona> getByID(int id) {
		Connection conn = Connessione.getConnessione();
		
		List<Persona> ls = new ArrayList<>();
		
		try {
			ResultSet rs =  conn.createStatement().executeQuery("SELECT * FROM `persona` WHERE id="+id);
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
		System.out.print("\nLISTA ID : " + ls);
		return ls;
	}
	
	public static List<Persona> getByNome(String nome) {
		Connection conn = Connessione.getConnessione();
		
		List<Persona> ls = new ArrayList<>();
		
		try {
			ResultSet rs =  conn.createStatement().executeQuery("SELECT * FROM `persona` WHERE nome='"+nome+"'");
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
		
		System.out.print("\nLISTA Nome1:" + ls);
		return ls;
	}

	public static List<Persona> getByNome(String nome, List<Persona> l) {
		
		List<Persona> ls = new ArrayList<>();
		
		Iterator<Persona> i = l.iterator();
		
		while(i.hasNext()) {
			Persona p = i.next();
			if(p.getNome().equals(nome)) ls.add(p);
		}
		
		System.out.print("\nLISTA Nome2:" + ls);
		return ls;
	}
	
	public static List<Persona> getByCognome(String cognome) {
		Connection conn = Connessione.getConnessione();
		
		List<Persona> ls = new ArrayList<>();
		
		try {
			ResultSet rs =  conn.createStatement().executeQuery("SELECT * FROM `persona` WHERE cognome='"+cognome+"'");
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
		
		System.out.print("\nLISTA Cognome:" + ls);
		return ls;
	}
	
	public static List<Persona> getByCognome(String cognome, List<Persona> l) {
		
		List<Persona> ls = new ArrayList<>();
		
		Iterator<Persona> i = l.iterator();
		
		while(i.hasNext()) {
			Persona p = i.next();
			if(p.getCognome().equals(cognome)) ls.add(p);
		}
		
		System.out.print("\nLISTA Cognome:" + ls);
		return ls;
	}
	
	public static List<Persona> getByEta(int eta) {
		Connection conn = Connessione.getConnessione();
		
		List<Persona> ls = new ArrayList<>();
		
		try {
			ResultSet rs =  conn.createStatement().executeQuery("SELECT * FROM `persona` WHERE eta='"+eta+"'");
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
		
		System.out.print("\nLISTA Eta:" + ls);
		return ls;
	}
	
	public static List<Persona> getByEta(int eta, List<Persona> l) {
		
		List<Persona> ls = new ArrayList<>();
		
		Iterator<Persona> i = l.iterator();
		
		while(i.hasNext()) {
			Persona p = i.next();
			if(p.getEta() == eta) ls.add(p);
		}
		System.out.print("\nLISTA Eta:" + ls);
		return ls;
	}
	
	
}
