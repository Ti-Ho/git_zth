package team.controller.customer_service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.dao.client.Client;
import team.service.customer_service.ClientService;
import team.service.customer_service.ClientServiceImpl;


@WebServlet("/UpdateClientServlet")
public class UpdateClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateClientServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number = request.getParameter("number");
		String ID_number = request.getParameter("ID_number");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		System.out.println(number + " "  + ID_number + " " + phone + " " + email);
		ClientService clientService = new ClientServiceImpl();
		clientService.updateClient(new Client(number, ID_number, phone, email));
		response.getWriter().write("ok");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
