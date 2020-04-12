package team.controller.store;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.service.backupflow.BackupFlowService;
import team.service.backupflow.BackupFlowServiceImpl;
import team.utils.GetNowTime;

/**
 * Servlet implementation class OutStoreServlet
 */
@WebServlet("/OutStoreServlet")
public class OutStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OutStoreServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String fixNumber = request.getParameter("fix_number");
		String amount = request.getParameter("amount");
		String outTime = GetNowTime.getNowTime();
		System.out.println("name" + name+ ", type: " + type + ", fix_number: " + fixNumber + ", amount: " + amount + ", outTime: " + outTime);
		BackupFlowService backupFlowService = new BackupFlowServiceImpl();
		int flag = backupFlowService.insertBackupFlow(name, type, fixNumber, amount, outTime);
		
		if (flag == -1) {
			request.setAttribute("msg", "找不到此备件");
		} else if (flag == 0) {
			request.setAttribute("msg", "此备件库存量不足");
		} else {
			request.setAttribute("msg", "出库成功!");
		}
		
		request.getRequestDispatcher("WEB-INF/store/out-store.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
