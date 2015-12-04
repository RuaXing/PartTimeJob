package com.fmt.parttime.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.fmt.parttime.action.CommitAction;
import com.fmt.parttime.model.Commit;
import com.fmt.parttime.model.Message;

/**
 * 处理用户反馈
 */
public class CommitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); 
		response.setCharacterEncoding("utf-8"); 
		
		String action = request.getParameter("action") == null ? "" : request 
				.getParameter("action"); 
		int commitID = request.getParameter("commitID") == null ? 0 : Integer.parseInt(request.getParameter("commitID")); 
		String commitDesc = request.getParameter("commitDesc") == null ? "" : request.getParameter("commitDesc").trim();
		int usersID = request.getParameter("usersID") == null ? 0 : Integer.parseInt(request.getParameter("usersID")); 
		CommitAction op = new CommitAction(); 
		Commit commit = new Commit(); 
		commit.commitID = commitID; 
		commit.commitDesc = commitDesc; 
		commit.usersID = usersID; 
		
		if(action.equals("add")){
			int id = op.add(commit);
			JSONObject jsonObject = null;
			Message message = null;
			
			if(id >0){
				message = new Message(1,"反馈成功!","");
			}else{
				message = new Message(0,"反馈失败!","");
			}
			
			jsonObject = JSONObject.fromObject(message);
			response.getWriter().print(jsonObject.toString());
		}
	}

}
