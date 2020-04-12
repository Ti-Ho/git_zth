package team.controller.store;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.dao.backup.Backup;
import team.service.store.StoreService;
import team.service.store.StoreServiceImpl;

/**
 * Servlet implementation class CheckStoreServlet
 */
@WebServlet("/CheckStoreServlet")
public class CheckStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckStoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		List<Backup> lists = new ArrayList<Backup>();
		StoreService storeService = new StoreServiceImpl();
		lists = storeService.getBackupsByNameAndType(name, type);
		request.setAttribute("list", lists);
		request.getRequestDispatcher("WEB-INF/store/check-result.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
