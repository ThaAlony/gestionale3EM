package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Persona;
import utils.PersonaDAO;

/**
 * Servlet implementation class Cerca
 */
@WebServlet("/Cerca")
public class Cerca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cerca() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Persona> ls = new ArrayList<>();
		Integer id = null;
		Integer eta = null;
		try {
			id = Integer.valueOf(request.getParameter("id"));
		} catch(NumberFormatException e) {
			id = null;
		}
		
		try {
			eta = Integer.valueOf(request.getParameter("eta"));
		} catch(NumberFormatException e) {
			eta = null;
		}
		
		ls = PersonaDAO.cerca(id, request.getParameter("nome"), request.getParameter("cognome"), eta);
		
		request.setAttribute("ls", ls);
		request.setAttribute("nome", request.getParameter("nome"));
		request.setAttribute("cognome", request.getParameter("cognome"));
		request.setAttribute("eta", eta);
		request.setAttribute("id", id);
		request.getRequestDispatcher("select.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
