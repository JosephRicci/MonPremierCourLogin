package com.login;

//

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	public LoginServlet() {
//		super();
//	}
//
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("In the service method");
//		super.service(req, resp);
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("In the doGet");
//		String login = request.getParameter("txtLogin");
//		String password = request.getParameter("txtPassword");
//		if (login == null || !login.equals("Bond"))
//			login = "";
//		if (password == null || !password.equals("007"))
//			password = "";
//		else if (login == "Bond")
//			login = "Bond";
//		if (!login.equals("Bond") && !password.equals("007")) {
//			login = "";
//			password = "";
//		}
//		response.setContentType("text/html"); // choisir type de r�ponse
//		try (PrintWriter out = response.getWriter()) {
//			out.println("<!DOCTYPE html>");
//			out.println("<html>");
//			out.println("    <head>");
//			out.println("        <title>Veuillez vous identifier</title>");
//			out.println("        <link rel='stylesheet' type='text/css' href='styles.css' />");
//			out.println("    </head>");
//			out.println("    <body>");
//			out.println("        <h1>Veuillez vous identifier</h1>");
//			out.println("        <h2> " + new Date() + "</h2>");
//			out.println("        <form method='POST' action='login'>");
//			out.println("            <label for='txtLogin'>Login :</label>");
//			out.println("            <input id='txtLogin' name='txtLogin' type='text' value='" + login
//					+ "' autofocus /><br/>");
//			out.println("            <label for='txtPassword'>Password :</label>");
//			out.println("            <input name='txtPassword' type='password' value='" + password + "' /><br/>");
//			out.println("            <br/>");
//			out.println("            <input name='btnConnect' type='submit' value='Se connecter' /><br/>");
//			out.println("        </form>");
//			out.println("    </body>");
//			out.println("</html>");
//		}
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)

//			throws ServletException, IOException {
//		String login = request.getParameter("txtLogin");
//		String password = request.getParameter("txtPassword");
//		// j'ai donc mon login et mon Mot de passe
//		System.out.println("in the doPost");
//		if (login.equals("Bond") && password.equals("007")) {
//			response.setContentType("text/html");
//			try (PrintWriter out = response.getWriter()) {
//				out.println("<h1>Vous etes connect� Bond!</h1>");
//				out.println("<a href='/premierCourLogin/login'/>Retour</a>");
//			}
//		} else {
//			doGet(request, response);
//		}
//	}
//}

@WebServlet("/login") // => annotation qui decrit notre classe Login pour dire que c une servlet
//("/login") le paramettre de @WebServlet pour decrir l'URL de la servlet
public class Login extends HttpServlet { // ma classe Login h�rite de la classe HttpServlet (pour dire que c une
											// servlet)
	private static final long serialVersionUID = 1L;

	// dans chaque servlet on a des methodes par d�fault app�l�es (ex : doGet(),
	// doPost(), init(), service() etc...)
	// doGet() prend en paramettre deux objets un objet HttpServletRequest et un
	// objet HttpServletResponse
	// HttpServletResponse represente la r�ponse HTTP
	// HttpServletRequest represente la requette HTTP
	// est la m�thode qui renvoie la r�ponse au client (navigateur) apr�s avoir re�u
	// la requete du client
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// veut dire que la m�thode doGet() est vuln�rable et peut declencher les
		// exceptions ServletException IOException
		String login = request.getParameter("txtLogin");
		// chaque appel de la doGet()je d�clare un String login
		// qui accede � la request pass�e par le client
		// et accede au paramettre "txtLogin" (JSP)=> <input id='txtLogin'
		// name='txtLogin' type='text' value='${login}' autofocus />
		String password = request.getParameter("txtPassword");
		// chaque appel de la doGet()je d�clare un String password
		// qui accede � la requette pass�e par le client
		// et accede au paramettre "txtPassword" (JSP)=> <input name='txtPassword'
		// type='password' value='${password}' /> <br/>
		if (login == null)
			login = "";
		if (password == null)
			password = "";
		// Si je me connecte � ma servlet Login pour la premiere fois login et password
		// (les deux String qui represente
		// les paramettres de la requette de client) seront == � null
		// SI il sont null je leur donne la valeur d'une String vide
		HttpSession session = request.getSession(true);
		// session est un objet de type HttpSession qui va acceder � la requette du
		// client (request)
		// essayer d'acceder � la session de request (requette de client)
		// (true) si il trouve pas une session existante il cr�e une nouvelle session
		// je declare un attribut de session appel� login qui prend la valeur de String
		// login
		session.setAttribute("login", login);
		// je declare un attribut de session appel� password qui prend la valeur de
		// String password
		session.setAttribute("password", password);
		// par la m�thode getRequestDispatcher appliqu� sur ma request et qui prend en
		// paramettre ma JSP ( "/Login.jsp" )
		// j'obtiens un objet de type RequestDispatcher peut appel� la m�thode forward
		// qui prends en paramettres
		// une requette et une r�ponse HTTP et envoie cette paire � la JSP Login.jsp
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
	}
}