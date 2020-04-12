package team.controller.customer_service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.dao.settlement.Settlement;
import team.service.customer_service.ClientService;
import team.service.customer_service.ClientServiceImpl;

/**
 * Servlet implementation class AddSettleServlet
 */
@WebServlet("/AddSettleServlet")
public class AddSettleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSettleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String fix_number = request.getParameter("fix_number");
		String fix_money = request.getParameter("fix_money");
		String material_money = request.getParameter("material_money");
		String total_money = request.getParameter("total_money");
		String settle_time = request.getParameter("settle_time");
		
		ClientService clientService = new ClientServiceImpl();
		clientService.completeSettle(new Settlement(fix_number, fix_money, material_money, total_money, settle_time));
		response.getWriter().write("ok");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
