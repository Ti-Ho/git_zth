package team.controller.task;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.dao.fix.Fix;
import team.service.task.TaskService;
import team.service.task.TaskServiceImpl;


@WebServlet("/SearchTaskServlet")
public class SearchTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SearchTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String number = request.getParameter("number");
		TaskService taskService = new TaskServiceImpl();
		Fix fix = taskService.searchTask(number);
		request.setAttribute("fix", fix);
		request.getRequestDispatcher("WEB-INF/task/search_result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
