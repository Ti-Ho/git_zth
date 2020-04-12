package team.controller.customer_service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.dao.repair.Repair;
import team.service.customer_service.ClientService;
import team.service.customer_service.ClientServiceImpl;
import team.utils.GetNowTime;
import team.utils.GetRepairNumber;


@WebServlet("/AddRepairServlet")
public class AddRepairServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddRepairServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		ClientService clientService = new ClientServiceImpl().getInstance();
		String number = new GetRepairNumber().getRepairNumber();
		String id_number = request.getParameter("id_number");
		if (id_number == null || id_number == "") {
			request.getRequestDispatcher("WEB-INF/customer_service/add_repair.jsp").forward(request, response);
			return;
		}
		String client_number = clientService.getNumberOfClient(id_number);
		String product_type = request.getParameter("product_type");
		String fault_phenomena = request.getParameter("fault_phenomena");
		String fault_type = request.getParameter("fault_type");
		String time = new GetNowTime().getNowTime();
		String status = "1";	
		System.out.println(number + " " + client_number + " " + product_type + " " + fault_phenomena + " " + fault_type + " " + time);
		boolean flag = clientService.insertRepair(new Repair(number, client_number, product_type, fault_phenomena, fault_type, time, status));
		if (flag == true) {
			request.setAttribute("msg", "添加成功");
		} else {
			request.setAttribute("msg", "添加失败，不存在此用户");
		}
		request.getRequestDispatcher("WEB-INF/customer_service/add_repair.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
