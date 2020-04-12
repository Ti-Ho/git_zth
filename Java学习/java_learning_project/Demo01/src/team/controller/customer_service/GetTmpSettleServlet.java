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


@WebServlet("/GetTmpSettleServlet")
public class GetTmpSettleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetTmpSettleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		ClientService clientService = new ClientServiceImpl();
		List<String> lists = clientService.getTmpSettle();
		String json = new GetJsonUtils(0, "", lists.size(), lists).toJson();
		System.out.println(json);
		response.getWriter().write(json);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
