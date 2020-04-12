package team.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.service.admin.AdminServiceImpl;

@WebServlet("/DeleteAdminServlet")
public class DeleteAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		System.out.println(account);
		System.out.println(account);
		AdminServiceImpl adminService = new AdminServiceImpl();
		adminService.deleteUser(account);
		response.getWriter().write("ok");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
