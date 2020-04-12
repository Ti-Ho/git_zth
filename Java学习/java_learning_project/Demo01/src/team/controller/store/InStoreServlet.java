package team.controller.store;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.dao.backup.Backup;
import team.service.store.StoreService;
import team.service.store.StoreServiceImpl;
import team.utils.GetNowTime;


@WebServlet("/InStoreServlet")
public class InStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InStoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String price = request.getParameter("price");
		String amount = request.getParameter("amount");
		String in_time = GetNowTime.getNowTime();
		String deadline = request.getParameter("deadline");
		String status = null;
		int now_amount = Integer.parseInt(amount), now_deadline = Integer.parseInt(deadline);
		if (now_amount > now_deadline) status = "正常";
		else if (now_amount == now_deadline) status = "临界";
		else if (now_amount > 0) status = "警示";
		else status = "缺货";
		System.out.println("name: " + name + ", type: " + type + ", price: " + price + ", amount: " + amount + "time: " + in_time + ", deadline: " + deadline + ", status: " + status );
		Backup backup = new Backup(name, type, price, amount, in_time, deadline, status);
		StoreService storeService = new StoreServiceImpl();
		storeService.inStore(backup);
		request.setAttribute("msg", "入库成功!");
		request.getRequestDispatcher("WEB-INF/store/in-store.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
