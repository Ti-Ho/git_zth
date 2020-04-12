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

@WebServlet("/ShowSearchStoreServlet")
public class ShowSearchStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowSearchStoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		List<Backup> lists = new ArrayList<Backup>();
		StoreService storeService = new StoreServiceImpl();
		lists = storeService.getAllBackups();
		request.setAttribute("list", lists);
		request.getRequestDispatcher("WEB-INF/store/search-store.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
