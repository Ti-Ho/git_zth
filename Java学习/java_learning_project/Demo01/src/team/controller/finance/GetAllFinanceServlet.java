package team.controller.finance;

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

import team.dao.settlement.Settlement;
import team.service.finance.FinanceService;
import team.service.finance.FinanceServiceImpl;
import team.utils.GetJsonUtils;

@WebServlet("/GetAllFinanceServlet")
public class GetAllFinanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public GetAllFinanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        
        String fix_number = request.getParameter("fix_number");
        //System.out.println(number);
        
        String page = request.getParameter("page");
        int p = Integer.parseInt(page);
        String limit = request.getParameter("limit");
        int l = Integer.parseInt(limit);
        
        if(fix_number==""||fix_number==null){
        	FinanceServiceImpl financementservice = new FinanceServiceImpl();
	        List<Settlement> list = financementservice.getAllSettlement();
	        ArrayList<Settlement> newlist = new ArrayList<Settlement>();
	        //System.out.println(list);
			int size =list.size();
			//System.out.println(list.get(1).getSettle_time());
			for(int i = (p-1)*l ;  i<p*l&&i<list.size() ; i++){
				newlist.add(list.get(i));
			}
			JsonArray jsonArray = new com.google.gson.Gson().toJsonTree(newlist, new TypeToken<List<Settlement>>(){}.getType()).getAsJsonArray();
			String json="{"+"\"code\":0,\"msg\":\"\",\"count\":"+String.valueOf(size)+",\"data\":"+jsonArray.toString()+"}";
			out.println(json);
			out.flush();
			out.close();
        }else{
        	FinanceServiceImpl financementservice = new FinanceServiceImpl();
        	List<Settlement> list = financementservice.getSettlementByNumber(fix_number);
        	
        	int size = list.size();
        	HttpSession session = request.getSession();
			session.setAttribute("count", size);
        	JsonArray jsonArray = new com.google.gson.Gson().toJsonTree(list, new TypeToken<List<Settlement>>(){}.getType()).getAsJsonArray();
			String json = "{"+"\"code\":0,\"msg\":\"\",\"count\":"+String.valueOf(size)+",\"data\":"+jsonArray.toString()+"}";
			out.println(json);
			out.flush();
			out.close();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
