package webprojeweb;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webproje.Equipe;
import webproje.Joueur;
import webproje.dao.projectDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/")
/**
 * Servlet implementation class SportServlet
 */
public class SportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private projectDao projectDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		projectDao =  new projectDao() ;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		String action= request.getServletPath();
		switch(action) {
		case "/new":
			showNewForm(request,response);
			break;
		case "/insert":
			try {
				insertJoueur(request,response);
				insertEquipe(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deleteJoueur(request,response);
				deleteEquipe(request,response);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/edit":
			showNewForm(request,response);
			break;
		case "/update":
			try {
				updateJoueur(request,response);
				updateEquipe(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		  default:
			  
			try {
				listJoueur(request,response);
				listEquipe(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				  
				  break;
				
		}
		
		
		}
		private void showNewForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/projet-list.jsp");
			dispatcher.forward(request, response);
	 	
	}
		// insert joueur
	private void insertJoueur(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {	 
		
		int Numero = Integer.parseInt(request.getParameter("numero"));
		String Nom = request.getParameter(" Nom");
		String Poste = request.getParameter("Poste");
		String Nationalite = request.getParameter("Nationalite");
		int Salaire= Integer.parseInt(request.getParameter("salaire"));
		Joueur newJoueur = new Joueur(Numero, Nom, Poste ,Nationalite,Salaire);
		projectDao.insertjoueur(newJoueur);
		response.sendRedirect("list");

	}	
	
	
	
	

	// insert Equipe
private void insertEquipe(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {	 
	
	
	String NomEquipe  = request.getParameter("NomEquipe ");
	String Pays = request.getParameter("Pays");
	Equipe newEquipe = new Equipe();
	projectDao.insertEquipe(newEquipe);
	response.sendRedirect("list");

}	
	//delete joueur 
	
	private void deleteJoueur(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {	 
		int ID = Integer.parseInt(request.getParameter("ID"));
		try {
			projectDao.deleteJoueur(ID);} catch(Exception e) {
				e.printStackTrace();
			
				
			}
		response.sendRedirect("list");	}
	
	
	
	private void deleteEquipe(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {	 
		int IDEquipe = Integer.parseInt(request.getParameter("IDEquipe"));
		try {
			projectDao.deleteJoueur(IDEquipe);} catch(Exception e) {
				e.printStackTrace();
			
				
			}
		response.sendRedirect("list");	}
	
	
	
	
	

	//update 
	private  void updateJoueur(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException  
	{
		int ID = Integer.parseInt(request.getParameter("ID"));
		
		int Numero = Integer.parseInt(request.getParameter("numero"));
		String Nom = request.getParameter(" Nom");
		String Poste = request.getParameter("Poste");
		String Nationalite = request.getParameter("Nationalite");
		int Salaire= Integer.parseInt(request.getParameter("salaire"));
		Joueur Joueur = new Joueur(Numero, Nom, Poste ,Nationalite,Salaire);
	
		projectDao.updateJoueur(Joueur);
		response.sendRedirect("list");	
	
}	 
	
	
		//update 
		private  void updateEquipe(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException  
		{
			int IDEquipe = Integer.parseInt(request.getParameter("IDEquipe"));
			
			String NomEquipe= request.getParameter("NomEquipe");
			String Pays = request.getParameter("Pays");
			
			Equipe Equipe = new Equipe( IDEquipe,NomEquipe ,Pays);
			projectDao.updateEquipe(Equipe);
			response.sendRedirect("list");	
		
	}	 

	//default 
		private void listJoueur(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException, IOException  
		{
			try {
		List<Joueur> listJoueur = projectDao.selectAllJoueur();
		 request.setAttribute("listJoueur", listJoueur);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/projet-list.jsp");
        
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();}
			
		}
		

		//default 
			private void listEquipe(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException, IOException  
			{
				try {
			List<Equipe> listEquipe= projectDao.selectAllEquipe();
			 request.setAttribute("listEquipe", listEquipe);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/projet-list.jsp");
	        
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();}
				
			}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
