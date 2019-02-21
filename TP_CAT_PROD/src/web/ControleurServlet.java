package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import Dao.ClientDaoIMP;
import Dao.IclientDao;
import Dao.IproduitDao;
import Dao.ProduitDaoIMP;
import metier.entities.Client;
import metier.entities.Produit;

/**
 * Servlet implementation class ControleurServlet
 */
@WebServlet(name="cs",urlPatterns= {"*.php"})
public class ControleurServlet extends HttpServlet {
	private IproduitDao metier;
	private IclientDao metierClient;
	private static final long serialVersionUID = 1L;
       
	
   @Override
public void init() throws ServletException {
	metier =new ProduitDaoIMP();
	metierClient =new ClientDaoIMP();
}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if(path.equals("/index.php")) {
		request.getRequestDispatcher("produit.jsp").forward(request, response);
	}
		else if(path.equals("/chercher.php")) {
			String monCle=request.getParameter("monCle");
			ProduitModel model=new ProduitModel();
			model.setMonCle(monCle);
			List<Produit> produits=metier.getProduitParMC(monCle);
			model.setProd(produits);
			request.setAttribute("model", model);
			request.getRequestDispatcher("produit.jsp").forward(request, response);
		}else if(path.equals("/saisie.php")) {
			request.setAttribute("pro", new Produit());
			request.getRequestDispatcher("SaisieProduit.jsp").forward(request, response);
		}else if(path.equals("/saisieClient.php")) {
			request.setAttribute("cli", new Client());
			request.getRequestDispatcher("SaisieClient.jsp").forward(request, response);
			
		}else if(path.equals("/SaisieProduit.php")&& (request.getMethod().equals("POST"))) {
			String des=request.getParameter("Designiation");
			double prix=Double.parseDouble(request.getParameter("Prix"));
			int quantite=Integer.parseInt(request.getParameter("Quantite"));
			Produit p=metier.save(new Produit(des, prix, quantite));
			request.setAttribute("produit", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		}else if(path.equals("/AjouterClient.php")) {
			String nom=request.getParameter("nom");
			String prenom=request.getParameter("prenom");
			String adresse=request.getParameter("adresse");
			String email=request.getParameter("email");
			String tele=request.getParameter("tele");
			String motPass=request.getParameter("motPass");
			Client c=metierClient.saveClient(new Client(nom, prenom, adresse, email, tele, motPass));
			request.setAttribute("cli", c);
			request.getRequestDispatcher("SaisieClient.jsp").forward(request, response);
		}
		
		
		else if(path.equals("/UpdateProduit.php")&& (request.getMethod().equals("POST"))) {
			    Long id=Long.parseLong(request.getParameter("id_prod"));
				String des=request.getParameter("Designiation");
				double prix=Double.parseDouble(request.getParameter("Prix"));
				int quantite=Integer.parseInt(request.getParameter("Quantite"));
				Produit p=new Produit(des, prix, quantite);
				p.setId_prod(id);
				metier.UpdatProduit(p);
				request.setAttribute("produit", p);
				request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		}else if(path.equals("/Supprimer.php")) {
			Long id=Long.parseLong(request.getParameter("id_prod"));
			metier.deleteProduit(id);
			//request.getRequestDispatcher("produit.jsp").forward(request, response);
			response.sendRedirect("chercher.php?monCle=");
		}else if(path.equals("/Edit.php")) {
			Long id=Long.parseLong(request.getParameter("id_prod"));
			Produit p=metier.getProduit(id);
			request.setAttribute("Editproduits", p);
			request.getRequestDispatcher("EditProduit.jsp").forward(request, response);
		}
		else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
