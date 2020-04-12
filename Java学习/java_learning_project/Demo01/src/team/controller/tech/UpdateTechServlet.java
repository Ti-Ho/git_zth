package team.controller.tech;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.dao.fix.Fix;
import team.service.tech.TechService;
import team.service.tech.TechServiceImpl;

/**
 * Servlet implementation class UpdateTechServlet
 */
@WebServlet("/UpdateTechServlet")
public class UpdateTechServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTechServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
        //response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        String number = request.getParameter("number");
		String fix_people = request.getParameter("fix_people");
		String detection_record = request.getParameter("detection_record");
		String fix_record = request.getParameter("fix_record");
		String workload = request.getParameter("workload");
		String status = request.getParameter("status");
		
		TechService techService = new TechServiceImpl();
		techService.updateFix(new Fix(number, fix_people, detection_record, fix_record, workload, status));
		out.write("ok");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
