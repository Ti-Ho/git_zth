package team.controller.tech;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import team.dao.fix.Fix;
import team.service.tech.TechService;
import team.service.tech.TechServiceImpl;


@WebServlet("/GetAllTechServlet")
public class GetAllTechServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAllTechServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        
        String number = request.getParameter("number");
        System.out.println("number: " + number);
        String fix_people = request.getParameter("fix_people");
        System.out.println("fix_people: " + fix_people);
        String page = request.getParameter("page");
        int p = Integer.parseInt(page);
        String limit = request.getParameter("limit");
        int l = Integer.parseInt(limit);
        
        if(number==""||number==null){
        	TechService techService = new TechServiceImpl();
	        List<Fix> list = techService.getAllFix(fix_people);
	        List<Fix> newlist = new ArrayList<Fix>();
			int size =list.size();
			
			for(int i = (p-1)*l ;  i<p*l&&i<list.size() ; i++){
				newlist.add(list.get(i));
			}
			JsonArray jsonArray = new com.google.gson.Gson().toJsonTree(newlist, new TypeToken<List<Fix>>(){}.getType()).getAsJsonArray();
			String json="{"+"\"code\":0,\"msg\":\"\",\"count\":"+String.valueOf(size)+",\"data\":"+jsonArray.toString()+"}";
			out.println(json);
			out.flush();
			out.close();
        }else{
        	TechService techService = new TechServiceImpl();
	        List<Fix> list = techService.getFixByNumber(number, fix_people);
	        List<Fix> newlist = new ArrayList<Fix>();
			int size =list.size();
        	HttpSession session = request.getSession();
			session.setAttribute("count", size);
        	JsonArray jsonArray = new com.google.gson.Gson().toJsonTree(list, new TypeToken<List<Fix>>(){}.getType()).getAsJsonArray();
			String json = "{"+"\"code\":0,\"msg\":\"\",\"count\":"+String.valueOf(size)+",\"data\":"+jsonArray.toString()+"}";
			out.println(json);
			out.flush();
			out.close();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
