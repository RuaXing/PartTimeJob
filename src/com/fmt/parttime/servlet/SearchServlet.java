package com.fmt.parttime.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.fmt.parttime.action.SearchjobAction;
import com.fmt.parttime.model.Message;
import com.fmt.parttime.model.Searchjob;

/**
 * 处理搜索
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action") == null ? "" : request 
				.getParameter("action"); 
		
		SearchjobAction op = new SearchjobAction();
		
		if(action.equals("view")){
			//获得相应的分页列表
			List<Searchjob> list = op.findAll();
			
			List<String> searchlists = new ArrayList<>();
			
			for(Searchjob jc : list){
				searchlists.add(jc.getSearchName());
			}
			System.out.println(searchlists.toString());
			//将List转换成Json数组
			JSONArray jsonArray = JSONArray.fromObject(searchlists);
			
			String data = jsonArray.toString();
			Message message = new Message(1,"", data);
			//将json数据返回给客户端
			JSONObject jsonObject = JSONObject.fromObject(message);
		
			//返回收藏列表
			response.getWriter().print(jsonObject.toString());
		}
	}

}
