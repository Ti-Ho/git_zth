package team.controller.customer_service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.service.customer_service.ClientService;
import team.service.customer_service.ClientServiceImpl;

@WebServlet("/SubmitFixServlet")
public class SubmitFixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SubmitFixServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String number = request.getParameter("number");
		ClientService clientService = new ClientServiceImpl();
		clientService.submitFix(number);
		response.getWriter().write("ok");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
