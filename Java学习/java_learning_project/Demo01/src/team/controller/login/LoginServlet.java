package team.controller.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import team.service.login.UserServiceImpl;
import team.dao.user.*;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		System.out.println(account + " " + password + " " + role);
		UserServiceImpl userService = new UserServiceImpl().getInstance();
		
		if ("管理员".equals(role) && "admin".equals(account) && "admin".equals(password)) {
			//request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);
			out.write("4");
		} else if (userService.confirmLogin(new User(account, password, role)) == true) {
			if ("客服".equals(role)) {
				//request.getRequestDispatcher("WEB-INF/customer_service/main.jsp").forward(request, response);
				out.write("0");
			} else if ("任务调度人员".equals(role)) {
				//request.getRequestDispatcher("/ShowAllTasksServlet").forward(request, response);
				out.write("1");
			} else if ("技术工程师".equals(role)) {
				//request.getRequestDispatcher("").forward(request, response);
				out.write("2");
			} else if ("库管".equals(role)) {
				//request.getRequestDispatcher("WEB-INF/store/main.jsp").forward(request, response);
				out.write("3");
			} else if("财务".equals(role)) {
//				request.getRequestDispatcher("WEB-INF/finance/main.jsp").forward(request, response);
				out.write("5");
			}
		}else {
			//request.setAttribute("msg", "你输入的账号或密码不正确,请重新输入!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
