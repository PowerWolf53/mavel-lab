package by.bsuir.maven.lab.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsuir.maven.lab.service.AuthenticationService;
import by.bsuir.maven.lab.service.exception.ServiceException;

/**
 * Servlet implementation class AuthenticationServlet
 */
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AuthenticationService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationServlet() {
        super();
        service = new AuthenticationService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			service.authenticate(name, password);
		} catch (ServiceException e) {
			RequestDispatcher dd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("error", e.getMessage());
	        dd.forward(request, response);
		}
		RequestDispatcher dd = request.getRequestDispatcher("main.jsp");
        dd.forward(request, response);
	}

}
