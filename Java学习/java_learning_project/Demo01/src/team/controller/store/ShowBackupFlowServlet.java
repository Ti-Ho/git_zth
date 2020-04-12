package team.controller.store;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.dao.backupflow.BackupFlow;
import team.service.backupflow.BackupFlowService;
import team.service.backupflow.BackupFlowServiceImpl;

@WebServlet("/ShowBackupFlowServlet")
public class ShowBackupFlowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowBackupFlowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		List<BackupFlow> lists = new ArrayList<BackupFlow>();
		BackupFlowService backupFlowService = new BackupFlowServiceImpl();
		
		lists = backupFlowService.getAllBackupFlows();
		request.setAttribute("list", lists);
		request.getRequestDispatcher("WEB-INF/store/search-backupflow.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
