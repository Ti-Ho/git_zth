package team.controller.customer_service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.service.customer_service.ClientService;
import team.service.customer_service.ClientServiceImpl;



@WebServlet("/DeleteClientServlet")
public class DeleteClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String ID_number = request.getParameter("ID_number");
		System.out.println(ID_number);
		ClientService clientService = new ClientServiceImpl();
		boolean flag = clientService.deleteClient(ID_number);
		if (flag) {
			response.getWriter().write("ok");
		} else {
			response.getWriter().write("false");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
