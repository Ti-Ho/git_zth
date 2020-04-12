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
import team.utils.GetClientNumber;


@WebServlet("/AddClientServlet")
public class AddClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddClientServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String number = GetClientNumber.getClientNumber();
		String ID_number = request.getParameter("ID_number");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		System.out.println(number);
		ClientService clientService = new ClientServiceImpl();
		clientService.insertClient(new Client(number, ID_number, phone, email));
		response.getWriter().write("ok");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
