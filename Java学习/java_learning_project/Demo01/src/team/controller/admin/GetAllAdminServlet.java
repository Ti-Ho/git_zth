package team.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import team.service.admin.AdminServiceImpl;
import team.utils.GetJsonUtils;

@WebServlet("/GetAllAdminServlet")
public class GetAllAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public GetAllAdminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		String role = request.getParameter("role");
		System.out.println(role);
		AdminServiceImpl adminService = new AdminServiceImpl();
		List<String> lists = new ArrayList<String>();
		String json = null;
		if (role == null || role == "") {
			lists =adminService.getAllUsers();
			
		} else {
			lists = adminService.getUserByRole(role);
		}
		json = new GetJsonUtils(0, "", lists.size(), lists).toJson();
		System.out.println(json);
		response.getWriter().println(json);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
