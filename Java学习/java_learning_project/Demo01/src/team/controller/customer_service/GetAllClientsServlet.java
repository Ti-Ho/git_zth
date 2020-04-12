package team.controller.customer_service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.service.customer_service.ClientService;
import team.service.customer_service.ClientServiceImpl;
import team.utils.GetJsonUtils;


@WebServlet("/GetAllClientsServlet")
public class GetAllClientsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetAllClientsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String ID_number = request.getParameter("ID_number");
		ClientService clientService = new ClientServiceImpl();
		List<String> lists = clientService.getAllClients();
		System.out.println(ID_number);
		if (ID_number == null || ID_number == "") {
			lists = clientService.getAllClients();
			
		} else {
			lists = clientService.getClientByIDNumber(ID_number);
		}
		String json = new GetJsonUtils(0, "", lists.size(), lists).toJson();
		response.getWriter().println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
